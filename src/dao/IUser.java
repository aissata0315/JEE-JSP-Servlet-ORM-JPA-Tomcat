package dao;

import entities.User;

public interface IUser {
	public int add(User user);
	public User login(String email, String password);

}
