package disanmeng.github.cn.handle;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import disanmeng.github.cn.connection.ConnectionForNoPassword;

/**
 * @Description document 相当于 mysql 的 table 中 数据
 * @author disanmeng
 * @date 2017年9月25日 下午5:30:36
 */

public class MongHandleDocument {
    public static void main(String args[]) {

        MongoDatabase mongoDatabase = ConnectionForNoPassword.MongoConnection();
        
        //collection相当于mysql中table
        MongoCollection<Document> collection = mongoDatabase.getCollection("test");

        deleteDocument(collection);
    }
    
    /**
     * @Description 1. 获取迭代器FindIterable<Document> 2. 获取游标MongoCursor<Document> 3.通过游标遍历检索出的文档集合
     * @Param
     * @Return void
     */
    public static void findDocument(MongoCollection<Document> collection) {
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
    }
    
    /**
     *  1. 创建文档 org.bson.Document 参数为key-value的格式
     *  2. 创建文档集合List<Document> 
     *  3. 将文档集合插入数据库集合中mongoCollection.insertMany(List<Document>) 
     *  4. 插入单个文档可以用mongoCollection.insertOne(Document)
     * @Param
     * @Return void
     */
    public static void insertDocument(MongoCollection<Document> collection) {
        Document document = new Document("title", "MongoDB").append("description", "database").append("likes", 100)
                .append("by", "Fly");
        List<Document> documents = new ArrayList<Document>();
        documents.add(document);

        collection.insertMany(documents);
    }
    
    /**
     * @Description 删除元素
     * deleteOne 删除符合条件的第一个文档
     * deleteMany 删除所有符合条件的文档
     * @Param MongoCollection<Document>
     * @Return void
     */
    public static void deleteDocument(MongoCollection<Document> collection) {
        //collection.deleteOne(Filters.eq("likes", 200));
        collection.deleteMany(Filters.eq("likes", 200));
        
        findDocument(collection);
    }
    
    /**
     * @Description 更新文档
     * @Param
     * @Return void
     */
    public static void updateDocument(MongoCollection<Document> collection) {
        collection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes", 200)));
    }
}
