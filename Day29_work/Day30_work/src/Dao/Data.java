package dao;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dao.util.JdbcUtil;
import java.sql.Connection;
import java.sql.SQLException;

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

    public  User    Query(User user) {
        String url="select * from user where=?";
        Connection connection = JdbcUtil.getConnection();

        User query = null;
        try {
            query = qr.query(
                    connection, url, new BeanHandler<User>(User.class), user.getUsername()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }



}
