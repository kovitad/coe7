package com.coe7.managebean;

import java.io.IOException;
import java.util.Collection;

import javax.annotation.Resource;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.coe7.domain.User;
import com.coe7.service.MemberService;
import com.coe7.service.UserService;

@Component
public class UserManagedBean {

	private static final Logger LOG = LoggerFactory
			.getLogger(UserManagedBean.class);

	UserService userService = new UserService();

	private String username;
	private String password;
	private String searchUser;
	private Collection<User> searchUsersResults;
	private User selectedUser;

	@Resource
	private MemberRegistrationBean memberBean;

	@Resource
	private MemberService memberService;

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

	public User getSelectedUser() {
		if (selectedUser == null) {
			selectedUser = new User();
		}
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public Collection<User> getSearchUsersResults() {
		return searchUsersResults;
	}

	public void setSearchUsersResults(Collection<User> searchUsersResults) {
		this.searchUsersResults = searchUsersResults;
	}

	public String getSearchUser() {
		return searchUser;
	}

	public void setSearchUser(String searchUser) {
		this.searchUser = searchUser;
	}

	// This one need to use in phase listener
	public String login() throws IOException, ServletException {
		dispathRequest("/signup");
		return null;
	}

	public String openidLogin() throws IOException, ServletException {
		dispathRequest("/j_spring_openid_security_check");
		return null;
	}

	public String logout() throws IOException, ServletException {
		dispathRequest("/logout");
		return null;
	}

	public String authenticate() {
		boolean success = memberService.authenticate(username, password);
		if (success) {
			LOG.info("Success");
		} else {
			LOG.error("Failed");
		}
		return null;
	}

	public String gotoRegisterPage() {
		memberBean.init();
		return "register";
	}

	public String searchUser() {
		String username = (this.searchUser == null) ? "" : this.searchUser
				.trim();
		this.searchUsersResults = userService.searchUsers(username);
		System.out.println(searchUsersResults);
		return "home";
	}

	public String updateUser() {
		userService.update(this.selectedUser);
		return "home";
	}

	public void onUserSelect(SelectEvent event) {
		selectedUser = (User) event.getObject();
		System.out.println("selectedUser = " + selectedUser);
	}

	public void onUserUnselect(UnselectEvent event) {
		selectedUser = null;
	}

	private void dispathRequest(final String path) throws IOException,
			ServletException {

		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();

		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
				.getRequestDispatcher(path);

		dispatcher.forward((ServletRequest) context.getRequest(),
				(ServletResponse) context.getResponse());
		FacesContext.getCurrentInstance().responseComplete();

	}
}
