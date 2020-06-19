package dao;

import java.util.*;
import org.hibernate.*;
import pojo.User;
import util.HibernateUtil;

public class DAOuser {
    public void addUser(User user) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(user);
            trans.commit();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error!" + e);
        }
    }
    
    public List<User> getBy(String uName, String uPass) {
        User u = new User();
        List<User> user = new ArrayList();
        
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM User WHERE username= :uName AND password= :uPass");
            query.setString("uName", uName);
            query.setString("uPass", uPass);
            u = (User) query.uniqueResult();
            user = query.list();
            
            trans.commit();
        }
        catch(Exception e) {
            System.out.println("Error: "+e);
        }
        return user;
    }
    
    public void deleteUser(int idUser) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            User user = (User) session.load(User.class, new Integer(idUser));
            session.delete(user);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!" + e);
        }
    }
    
    public List<User> getbyID(int idUser) {
        User user = new User();
        List<User> luser = new ArrayList();
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM User WHERE id = :id");
            query.setInteger("id", idUser);
            user = (User) query.uniqueResult();
            luser = query.list();
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!" + e);
        }
        return luser;
    }
    
    public List<User> retrieveUser() {
        List list = new ArrayList();
        User user = new User();
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM User");
            list = query.list();
            list.add(user.getUsername());
            list.add(user.getPassword());
            list.add(user.getName());
            list.add(user.getPhone());
            list.add(user.getEmail());
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!" + e);
        }
        return list;
    }
    
    public void updateUser(User user) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(user);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!" + e);
        }
    }
    
}
