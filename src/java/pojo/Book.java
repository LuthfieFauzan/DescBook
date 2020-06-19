package pojo;

import dao.DAObook;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped

public class Book implements java.io.Serializable {

    private Integer id;
    private String title;
    private String author;
    private String language;
    private String publisher;
    private String publishYear;
    private String publishCountry;
    private String category;
    private int totalPages;
    private String estPrice;
    private String imgCover;
    private String urlBuyBook;
    private Integer selectedID;

    public Book() {
    }

    public Integer getSelectedID() {
        return selectedID;
    }

    public void setSelectedID(Integer selectedID) {
        this.selectedID = selectedID;
    }

    public Book(String title, String author, String language, String publisher, String publishYear, String publishCountry, String category, int totalPages, String estPrice, String imgCover, String urlBuyBook) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.publishCountry = publishCountry;
        this.category = category;
        this.totalPages = totalPages;
        this.estPrice = estPrice;
        this.imgCover = imgCover;
        this.urlBuyBook = urlBuyBook;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getPublishCountry() {
        return this.publishCountry;
    }

    public void setPublishCountry(String publishCountry) {
        this.publishCountry = publishCountry;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getEstPrice() {
        return this.estPrice;
    }

    public void setEstPrice(String estPrice) {
        this.estPrice = estPrice;
    }

    public String getImgCover() {
        return this.imgCover;
    }

    public void setImgCover(String imgCover) {
        this.imgCover = imgCover;
    }

    public String getUrlBuyBook() {
        return urlBuyBook;
    }

    public void setUrlBuyBook(String urlBuyBook) {
        this.urlBuyBook = urlBuyBook;
    }

    public String save() {
        DAObook book = new DAObook();
        book.addBook(this);
        return "booklist";
    }

    public String delete() {
        DAObook book = new DAObook();
        List<Book> lbook = book.getbyID(id);

        if (!lbook.isEmpty()) {
            book.deleteBook(id);
            return "booklist";
        } else {
        return "editbook";
        }
    }

    public String getbyID() {
        DAObook book = new DAObook();
        List<Book> lbook = book.getbyID(id);
        if (!lbook.isEmpty()) {
            id = lbook.get(0).id;
            title = lbook.get(0).title;
            author = lbook.get(0).author;
            language = lbook.get(0).language;
            publisher = lbook.get(0).publisher;
            publishYear = lbook.get(0).publishYear;
            publishCountry = lbook.get(0).publishCountry;
            category = lbook.get(0).category;
            totalPages = lbook.get(0).totalPages;
            estPrice = lbook.get(0).estPrice;
            imgCover = lbook.get(0).imgCover;
            urlBuyBook = lbook.get(0).urlBuyBook;
            return "index";
        }
        return "index";
    }

    public List<Book> getAllRecords() {
        DAObook book = new DAObook();
        List<Book> lb = book.lbook();
        return lb;
    }

    public String update() {
        DAObook book = new DAObook();
        List<Book> lbook = book.getbyID(id);
        if (!lbook.isEmpty()) {
            book.updateBook(this);
            return "booklist";
        } else {
            return "editbook";
        }
    }

    public String newid(int a) {
        DAObook book = new DAObook();
        List<Book> lbook = book.getbyID(a);
        if (!lbook.isEmpty()) {
            id = a;
            title = lbook.get(0).title;
            author = lbook.get(0).author;
            language = lbook.get(0).language;
            publisher = lbook.get(0).publisher;
            publishYear = lbook.get(0).publishYear;
            publishCountry = lbook.get(0).publishCountry;
            category = lbook.get(0).category;
            totalPages = lbook.get(0).totalPages;
            estPrice = lbook.get(0).estPrice;
            imgCover = lbook.get(0).imgCover;
            urlBuyBook = lbook.get(0).urlBuyBook;
        }
        return "editbook";
    }
    
    public String newid2(int a) {
        DAObook book = new DAObook();
        List<Book> lbook = book.getbyID(a);
        if (!lbook.isEmpty()) {
            id = a;
            title = lbook.get(0).title;
            author = lbook.get(0).author;
            language = lbook.get(0).language;
            publisher = lbook.get(0).publisher;
            publishYear = lbook.get(0).publishYear;
            publishCountry = lbook.get(0).publishCountry;
            category = lbook.get(0).category;
            totalPages = lbook.get(0).totalPages;
            estPrice = lbook.get(0).estPrice;
            imgCover = lbook.get(0).imgCover;
            urlBuyBook = lbook.get(0).urlBuyBook;
        }
      return "bookdetail";
    }
}
