package pojo;



public class Bookmark  implements java.io.Serializable {


     private Integer id;
     private Book book;
     private User user;

    public Bookmark() {
    }

    public Bookmark(Book book, User user) {
       this.book = book;
       this.user = user;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Book getBook() {
        return this.book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }




}


