package disanmeng.github.cn.handle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import disanmeng.github.cn.connection.ConnectionForNoPassword;

/**
 * @author disanmeng
 * @date 2017年9月25日 下午4:14:20
 */

public class MongoCreateCollection {

    MongoDatabase mongoDatabase = null;

    @Before
    public void before() {
        mongoDatabase = ConnectionForNoPassword.MongoConnection();
    }

    @Test
    //创建 collection，即table
    public void test() {
        mongoDatabase.createCollection("test");
    }
    
    @Test
    public void closeMongo() {
        MongoClient client = new MongoClient("localhost", 27017);
        client.close();
    }
    
    @After
    public void after() {
        
    }
}
