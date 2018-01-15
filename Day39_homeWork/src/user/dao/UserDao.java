package user.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import user.domain.User;
import user.util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
private QueryRunner qr= new QueryRunner();
    public User findByUname (String username) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql="select * from username where username=?";
        User query = qr.query(connection, sql, new BeanHandler<User>(User.class), username);
        return query;
    }

    public  void  add(User user) throws SQLException {
        Connection connection = C3P0Util.getConnection();
String sql="insert into user value(?,?,?)";
            qr.update(connection,sql,user.getUid(),user.getUsername(),user.getPassword());

    }




}
