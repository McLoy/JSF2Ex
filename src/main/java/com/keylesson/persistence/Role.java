package com.keylesson.persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.persistence.*;

//@Entity
//@Table(name = "role_table")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int roleId;
	private String code;
	private String label;
//	@ManyToOne(fetch = FetchType.LAZY, optional = true)
//	@JoinTable(name = "user_table", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("/home/user/Dev/Java_projects/TestTasks/JSF/JSFEx/src/main/webapp/WEB-INF/spring-security.xml");
//		UserDAO bean = ctx.getBean(UserDAO.class);
		System.out.println();
	}
}
