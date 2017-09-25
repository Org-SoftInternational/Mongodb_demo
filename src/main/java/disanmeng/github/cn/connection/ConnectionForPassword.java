package disanmeng.github.cn.connection;

import java.util.ArrayList;
import java.util.List;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

/** 
 * @author disanmeng
 * @date 2017年9月25日 下午4:14:20 
 */

public class ConnectionForPassword {
    @SuppressWarnings({ "resource", "unused" })
    public static void main(String[] args) {
        try {

            // ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress("localhost", 27017);
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            addrs.add(serverAddress);

            // MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            MongoCredential credential = MongoCredential.createScramSha1Credential("disanmeng", "admin", "1234".toCharArray());
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(credential);

            // 通过连接认证获取MongoDB连接
            MongoClient mongoClient = new MongoClient(addrs, credentials);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("yang");
            System.out.println("Connect to database yang successfully");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}