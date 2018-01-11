package cart.daomain;

import book.domain.Book;

public class CartItem {


    private String count;
    private Book book;


    public CartItem(String count, Book book) {
        this.count = count;
        this.book = book;
    }

    public CartItem() {
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
