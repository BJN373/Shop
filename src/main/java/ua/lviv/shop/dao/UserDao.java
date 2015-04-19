package ua.lviv.shop.dao;

import java.util.List;

import ua.lviv.shop.domain.User;

public interface UserDao {

	public void addUser(User user);

	public void deleteUser(User user);

	public User getUser(int id);

	public User getUser(String name);

	public List<User> getAllUsers();

	public void updateUser(User user);

}