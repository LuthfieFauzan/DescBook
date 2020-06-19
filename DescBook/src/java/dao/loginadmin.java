package dao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "login", eager = true)
@RequestScoped

public class loginadmin {
    public String username, password, message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String login() {
        if(username.equals("admin") && password.equals("admin123"))
        {
            return "booklist";
        }
        else
        {
            message = "Incorrect Username or Password!";
            return "loginadmin";
        }
    }
    
}
