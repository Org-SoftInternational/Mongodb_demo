package disanmeng.github.cn.connection;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * @author disanmeng
 * @date 2017年9月25日 下午4:14:20
 */

public class ConnectionForNoPassword {

    public static void main(String[] args) {
        
        MongoConnection();
    }

    /**
     * @Description 无密码数据库连接
     * @Param 
     * @Return MongoDatabase
     */
    @SuppressWarnings({ "resource" })
    public static MongoDatabase MongoConnection() {
        try {
            MongoClient client = new MongoClient("localhost", 27017);

            return client.getDatabase("yang");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }

        return null;
    }
}
