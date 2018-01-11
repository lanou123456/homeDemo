package order.dao;

import book.domain.Book;
import order.domain.Order;
import order.domain.Orderltem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import user.uti.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    private QueryRunner qr= new QueryRunner();
public void addOrder(Order order) throws SQLException {
    Connection connection = JdbcUtil.getConnection();
    String sql="insert into orders value(?,?,?,1,?,?)";
    int update = qr.update(connection, sql,
            order.getOid(), order.getOrdertime(), order.getPrice(), order.getUid(),"xxx");

}

    public void addOrderitrm(List<Orderltem> list) {
    Connection connection = JdbcUtil.getConnection();
        try {
            connection.setAutoCommit(false);
        String sql="insert into orderitem value(?,?,?,?,?)";
        Object [][] params = new Object[list.size()][];
        for (int i = 0; i < params.length; i++) {
            params[i]=new Object[]{
            list.get(i).getIid(),
            list.get(i).getCount(),
            list.get(i).getSubtotal(),
            list.get(i).getOid(),
            list.get(i).getBid()
             };
        }

            qr.batch(connection,sql,params);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            try {

                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }


    }


    public List<Order> findByUid( String uid) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        String sql="select * from orders where uid = ?";
        List<Order> query = qr.query(connection, sql, new BeanListHandler<Order>(Order.class),uid);
        return query;

    }

    public List<Orderltem> findByOid(String oid) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        String sql="select * from orderitem where oid = ?";
        List<Orderltem> query = qr.query(connection, sql, new BeanListHandler<Orderltem>(Orderltem.class),oid);
        return query;

    }


    public Book findBybid(String bid) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        String sql="select * from book where bid = ?";
        Book query = qr.query(connection, sql, new BeanHandler<Book>(Book.class), bid);
        return query;

    }


    public Order findOrderOid(String oid) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        String sql="select * from orders where oid = ?";
        Order query = qr.query(connection, sql, new BeanHandler<Order>(Order.class), oid);
        return query;
    }



    public Integer getStateByOid(String oid) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        String sql="select state from orders where oid = ?";
        Integer query = qr.query(connection, sql, new ScalarHandler<Integer>(), oid);
        return query;

    }


    public void UpdateState(String oid) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        String sql="update orders set state=4  where oid = ?";
        qr.update(connection, sql, oid);

    }


}
