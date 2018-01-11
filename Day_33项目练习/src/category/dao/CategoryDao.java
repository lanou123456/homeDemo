package category.dao;

import category.domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import user.uti.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    private QueryRunner qr = new QueryRunner();
    public List<Category> cate() throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        String sql="select * from category ";
        List<Category>  query = qr.query(connection, sql, new BeanListHandler<Category>(Category.class));
        return query;


    }


    public void add(String cname,String cid) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        String sql= "insert into category value(?,?) ";
        qr.update(connection,sql,cid,cname);

    }


    public void  delete(String cid) throws SQLException {

        Connection connection = JdbcUtil.getConnection();
            String sql="delete from category where cid=? ";
        qr.update(connection, sql, cid);
    }

public int count(String cid) throws SQLException {
    Connection connection = JdbcUtil.getConnection();
    String sql="select count(bid) from book where cid=?";
    Long query = qr.query(connection, sql, new ScalarHandler<Long>(), cid);

    Number number =query;
    int i =number.intValue();
return i;

}


}
