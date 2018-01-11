package order.service;

import book.domain.Book;
import cart.daomain.CartItem;
import order.dao.OrderDao;
import order.domain.Order;
import order.domain.Orderltem;
import order.service.exception.OrderStateException;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;


public class OrderService {


    private OrderDao orderDao = new OrderDao();

    public  String oid(){
        UUID id= UUID.randomUUID();
        String[] oid=id.toString().split("-");
        return oid[0];
    }


    public  String iid(){
        UUID id= UUID.randomUUID();
        String[] idd=id.toString().split("-");
        return idd[0];
    }

    public  String time() {


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }


    public void addItem(Map map,String oid) throws SQLException {
        Iterator iterator = map.entrySet().iterator();
        List<Orderltem> list = new ArrayList();
        while(iterator.hasNext()){
            String iid = iid();
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            String bid = (String) entry.getKey();
            CartItem cartItem = (CartItem) entry.getValue();
            String count1 = cartItem.getCount();
            int count =Integer.parseInt(count1);
            double price = cartItem.getBook().getPrice();
            double decimal = price*count;
                      Orderltem order = new Orderltem(iid,count,decimal,oid,bid);
           list.add(order);

        }
        orderDao.addOrderitrm(list);

    }


public  void  add(Order order) throws SQLException {
  orderDao.addOrder(order);

}


public List<Order> findByUid(String uid) throws SQLException {

    List<Order> byUid = orderDao.findByUid(uid);
    Iterator iterator = byUid.iterator();
    while(iterator.hasNext()) {
        Order next = (Order) iterator.next();
        String oid = next.getOid();
        List<Orderltem> byOid = orderDao.findByOid(oid);
        Iterator iterator1 = byOid.iterator();
        while(iterator1.hasNext()) {
            Orderltem next1 = (Orderltem) iterator1.next();
            String bid = next1.getBid();
            Book bybid = orderDao.findBybid(bid);
           next1.setBook(bybid);
        }
        next.setOrList(byOid);
    }
return byUid;
}



public Order findOrderByOid(String oid) throws SQLException {
    Order orderOid = orderDao.findOrderOid(oid);
    List<Orderltem> byOid = orderDao.findByOid(oid);
    Iterator iterator = byOid.iterator();
    while(iterator.hasNext()) {
        Orderltem next1 = (Orderltem) iterator.next();
        String bid = next1.getBid();
        Book bybid = orderDao.findBybid(bid);
       next1.setBook(bybid);
    }

    orderOid.setOrList(byOid);

    return orderOid;
}



public void  getStateByOid(String oid) throws SQLException, OrderStateException {

    Integer stateByOid = orderDao.getStateByOid(oid);
    if (stateByOid==3){
   orderDao.UpdateState(oid);
    }else {

        throw  new OrderStateException();
    }



}




}
