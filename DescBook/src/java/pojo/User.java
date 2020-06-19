package pojo;

import dao.DAOuser;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped

public class User  implements java.io.Serializable {


     private Integer id;
     private String username;
     private String password;
     private String name;
     private int phone;
     private String email;
     private Set bookmarks = new HashSet(0);

    public User() {
    }

	
    public User(String username, String password, String name, int phone, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    public User(String username, String password, String name, int phone, String email, Set bookmarks) {
       this.username = username;
       this.password = password;
       this.name = name;
       this.phone = phone;
       this.email = email;
       this.bookmarks = bookmarks;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public int getPhone() {
        return this.phone;
    }
    
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set getBookmarks() {
        return this.bookmarks;
    }
    
    public void setBookmarks(Set bookmarks) {
        this.bookmarks = bookmarks;
    }

    public void save() {
        DAOuser user = new DAOuser();
        user.addUser(this);
    }

    public void delete() {
        DAOuser user = new DAOuser();
        List<User> luser = user.getbyID(id);
        
        if(!luser.isEmpty()) {
            user.deleteUser(id);
        }
    }

    public String getbyID() {
        DAOuser user = new DAOuser();
        List<User> luser = user.getbyID(id);
        if(!luser.isEmpty()) {
            id = luser.get(0).id;
            username = luser.get(0).username;
            password = luser.get(0).password;
            name = luser.get(0).name;
            phone = luser.get(0).phone;
            email = luser.get(0).email;
             
        }
        return "edituser";
    }
    
    public String homeh() {
        DAOuser user = new DAOuser();
        List<User> luser = user.getbyID(id);
        if(!luser.isEmpty()) {
            id = luser.get(0).id;
            username = luser.get(0).username;
            password = luser.get(0).password;
            name = luser.get(0).name;
            phone = luser.get(0).phone;
            email = luser.get(0).email;
             
        }
        return "index";
    }
    
    public String about() {
        DAOuser user = new DAOuser();
        List<User> luser = user.getbyID(id);
        if(!luser.isEmpty()) {
            id = luser.get(0).id;
            username = luser.get(0).username;
            password = luser.get(0).password;
            name = luser.get(0).name;
            phone = luser.get(0).phone;
            email = luser.get(0).email;
             
        }
        return "about";
    }
    
    public String book() {
        DAOuser user = new DAOuser();
        List<User> luser = user.getbyID(id);
        if(!luser.isEmpty()) {
            id = luser.get(0).id;
            username = luser.get(0).username;
            password = luser.get(0).password;
            name = luser.get(0).name;
            phone = luser.get(0).phone;
            email = luser.get(0).email;
             
        }
        return "bookdetail";
    }
    
    public String test() {
        if(id != null) {
            return username; 
        }
        else{
            
        return "login";
        }
    }
    
    public String test1() {
        if(id != null) {
            return "Edit profile"; 
        }
        return "";
    }
    
    
    public List<User> getallrecords() {
        DAOuser user = new DAOuser();
        List<User> luser = user.retrieveUser();
        return luser;
    }
    
    public String update() {
        DAOuser user = new DAOuser();
        List<User> luser = user.getbyID(id);
        if(!luser.isEmpty()) {
            user.updateUser(this);
            return "index";
        }else{
        return "edituser";
    }}
    
    public String validasiUser() {
    DAOuser u = new DAOuser();
    List<User> lu = u.getBy(username, password);
    if (lu != null) {
        id = lu.get(0).id;
        username = lu.get(0).username;
        password = lu.get(0).password;
        return "index";
    }
    return "loginuser";
}


}


