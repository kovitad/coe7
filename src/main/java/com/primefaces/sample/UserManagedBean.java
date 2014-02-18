package com.primefaces.sample;

import java.util.Collection;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import java.util.List;

import localdomain.localhost.domain.Product;

@ManagedBean
@ApplicationScoped
public class UserManagedBean
{
    UserService userService = new UserService();
    
    private String username;
    private String password;
    private String searchUser;
    private Collection<User> searchUsersResults;
    private User selectedUser;
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("localdomain.localhost" );
    
	
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public User getSelectedUser()
    {
        if(selectedUser == null){
            selectedUser = new User();
        }
        return selectedUser;
    }
    
    public void setSelectedUser(User selectedUser)
    {
        this.selectedUser = selectedUser;
    }
    public Collection<User> getSearchUsersResults()
    {
        return searchUsersResults;
    }
    public void setSearchUsersResults(Collection<User> searchUsersResults)
    {
        this.searchUsersResults = searchUsersResults;
    }
    public String getSearchUser()
    {
        return searchUser;
    }
    public void setSearchUser(String searchUser)
    {
        this.searchUser = searchUser;
    }
    
    public String login()
    {
    	EntityManager em = factory.createEntityManager();
    	StringBuilder test = new StringBuilder();
    	
    	 Query query = em.createQuery("SELECT p FROM localdomain.localhost.domain.Product p");
         List<Product> products = query.getResultList();
    	
    	for(Product a : products) {
    		test.append(a.getName()).append(",");
    	}
    	
        if("test".equalsIgnoreCase(getUsername()) && "test".equals(getPassword()))
        {
            return "home";
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("username", new FacesMessage("test:"+test.toString()));
            return "login";
        }
    }
    
    public String searchUser()
    {
        String username = (this.searchUser == null)? "":this.searchUser.trim();        
        this.searchUsersResults = userService.searchUsers(username);
        System.out.println(searchUsersResults);
        return "home";
    }
    
    public String updateUser()
    {
        userService.update(this.selectedUser);
        return "home";
    }
    
    public void onUserSelect(SelectEvent event)
    { 
    	selectedUser =  (User)event.getObject();
    	System.out.println("selectedUser = "+selectedUser);
    }
    public void onUserUnselect(UnselectEvent event)
    {
    	selectedUser =  null;
    }
}
