package user.dao;

import org.apache.commons.dbutils.handlers.ScalarHandler;
import user.daomain.User;
import user.uti.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    private QueryRunner qr = new QueryRunner();

    public User findByUsername(String username) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        String sql="select * from user where  username =? ";
        User query = qr.query(connection, sql, new BeanHandler<User>(User.class), username);
        return query;
    }

public User findEmail(String email) throws SQLException {
    Connection connection = JdbcUtil.getConnection();
    String sql = "select * from user where email=?";
    User query = qr.query(connection, sql, new BeanHandler<User>(User.class), email);
return query;

}

public void add(User user) throws SQLException {
    int count=1;
    Connection connection = JdbcUtil.getConnection();
    String sql="insert into user value(?,?,?,?,?,0)";
    int update = qr.update(connection, sql, count,user.getUsername(), user.getPassword(),user.getEmail(),user.getCode());

}


public User FindByCode(String uuid) throws SQLException {
    Connection connection = JdbcUtil.getConnection();
    String sql="select * from user where code=?";
    User query = qr.query(connection, sql, new BeanHandler<User>(User.class), uuid);
    return query;
}

public void  updateState(String uuid) throws SQLException {
    Connection connection = JdbcUtil.getConnection();
    String sql="update user  set state='1' where code=? ";
    int update = qr.update(connection, sql, uuid);


}


    public String findUidByName(User user) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        String sql="select uid from user where username=?";
        String query = qr.query(connection, sql, new ScalarHandler<String>(), user.getUsername());
        return query;
    }


}
