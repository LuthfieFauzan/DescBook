package dao;

import util.HibernateUtil;
import java.util.*;
import org.hibernate.*;
import pojo.Book;

public class DAObook {
    public void addBook(Book book) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(book);
            trans.commit();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error" + e);
        }
    }
    
    public void deleteBook(int idBook) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Book book = (Book) session.load(Book.class, new Integer(idBook));
            session.delete(book);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!" + e);
        }
    }
    
    public List<Book> getbyID(int idBook) {
        Book book = new Book();
        List<Book> lbook = new ArrayList();
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM Book WHERE id = :id");
            query.setInteger("id", idBook);
            book = (Book) query.uniqueResult();
            lbook = query.list();
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!" + e);
        }
        return lbook;
    }
    
    public List<Book> retrieveBook() {
        List list = new ArrayList();
        Book book = new Book();
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM Book");
            list = query.list();
            list.add(book.getId());
            list.add(book.getTitle());
            list.add(book.getAuthor());
            list.add(book.getLanguage());
            list.add(book.getPublisher());
            list.add(book.getPublishYear());
            list.add(book.getPublishCountry());
            list.add(book.getCategory());
            list.add(book.getTotalPages());
            list.add(book.getEstPrice());
            list.add(book.getImgCover());
            list.add(book.getUrlBuyBook());
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!" + e);
        }
        return list;
    }
    
    public List<Book> lbook(){
        Transaction trans = null;
        Session session =  HibernateUtil.getSessionFactory().openSession();
        List booklist = new ArrayList();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Book");
            booklist = query.list();
            trans.commit();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error!" + e);
        }
        return booklist;
    }

    public void updateBook(Book book) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(book);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!" + e);
        }
    }
    
}
