package Dao;

import Dao.util.JdbcUtil;
import net.sf.json.JSONArray;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import sun.org.mozilla.javascript.internal.json.JsonParser;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Data {
    private QueryRunner qr = new QueryRunner();



    public  void   Update(String username,String password) throws SQLException {
        String sql=" insert into user values(?,?)";
        Connection connection = JdbcUtil.getConnection();
         qr.update(
                 connection,sql,username, password
        );

JdbcUtil.close(connection);
    }

    public   String  Query(String username,String password) throws SQLException {
        String url="select * from user";
        Connection connection = JdbcUtil.getConnection();
        List<User> users = qr.query(
                connection, url, new BeanListHandler<User>(User.class)
        );

        for (int i =0;i<users.size();i++){
            if (users.get(i).getUsername().equals(username)&&users.get(i).getPassword().equals(password)){
                return "success";
            }

        }
        return null;
    }


}
