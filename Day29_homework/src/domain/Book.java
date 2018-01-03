package domain;

public class Book {
    private String bkname;
    private String author;
    private  long money;

    @Override
    public String toString() {
        return "Book{" +
                "bkname='" + bkname + '\'' +
                ", author='" + author + '\'' +
                ", money=" + money +
                '}';
    }

    public Book() {
    }

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }
}
