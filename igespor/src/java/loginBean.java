
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caner
 */
@ManagedBean(name = "login")
@RequestScoped
public class loginBean implements Serializable{
    String username,password;

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
    
    public String girisControl(){        
        Subject currentUser = SecurityUtils.getSubject();        
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);         
        currentUser.login(token);        
        if(currentUser.hasRole("admin"))
        return "/authorization/admin.xhtml?faces-redirect=true";
        else
        return "/index.xhtml?faces-redirect=true";
    }
    
    public String logout() { 
        Subject currentUser = SecurityUtils.getSubject();                
        currentUser.logout();
        username="";
        password="";        
        return "/index.xhtml?faces-redirect=true";
    }
}
