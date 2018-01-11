package order.domain;


import book.domain.Book;

import java.util.List;

public class Order {

    private String oid;
    private String ordertime;
    private String price;
    private String uid;
    private String address;
    private List<Orderltem> orList;
    private List<Book> books;



    public Order(String oid, String ordertime, String price, String uid) {
        this.oid = oid;
        this.ordertime = ordertime;
        this.price = price;
        this.uid = uid;

    }



    public Order() {
    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Orderltem> getOrList() {
        return orList;
    }

    public void setOrList(List<Orderltem> orList) {
        this.orList = orList;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
