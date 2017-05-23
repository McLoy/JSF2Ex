package com.keylesson.dao;

import com.keylesson.model.UserModel;
import com.keylesson.persistence.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Transactional("transactionManager")
public class UserDAO {

	@Inject
	private SessionFactory sessionFactory;

	@Autowired
	private PasswordEncoder encoder;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addUser(UserModel model) {
		User user = new User();
		user.setLogin(model.getLogin());
		user.setName(model.getName());
		String pwd = encoder.encode(model.getPwd());
		user.setPwd(pwd);
		user.setEnabled(true);
		user.getRoles().add("ROLE_USER");
		sessionFactory.getCurrentSession().save(user);
	}

}
