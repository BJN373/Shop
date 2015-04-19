package ua.lviv.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.lviv.shop.domain.Basket;
import ua.lviv.shop.domain.Product;
import ua.lviv.shop.domain.User;
import ua.lvivl.shop.dao.BasketDao;
import ua.lvivl.shop.dao.ProductDao;
import ua.lvivl.shop.dao.UserDao;
import ua.lvivl.shop.dao.imp.BasketDaoImp;

;

public class App {
	public static void main(String[] args) {
		Factory factory = Factory.getInstance();
		ProductDao productDao = factory.getProductDao();
		UserDao userDao = factory.getUserDao();
		BasketDao basketDao = factory.getBasketDao();
		
		
		//add some user to table
		// userDao.addUser(new User("Yuriy", "Anax@gmail.com"));
		// userDao.addUser(new User("Anax", "blabla@gmail.com")); 
		// userDao.addUser(new User("IGOR", "blabla@gmail.com"));
		// userDao.addUser(new User("Vitman", "vit@ukr.net"));

		// show all users
		// List<User> users = userDao.getAllUsers();
		// for (User u : users) { 
		// System.out.println(u);
		// }

		// add some products to table
		// productDao.addProduct(new Product("pen", "black pen", 22.3));
		// productDao.addProduct(new Product("book", "Main Kampf", 123.65)); 
		// productDao.addProduct(new
		// Product("htc M7","Very good phone",5555.55));

		// show all products
		// List<Product> products = productDao.getAll();
		// for (Product product : products) {
		// System.out.println(product);
		// }
		
		Basket basket = new Basket();
		
		

	}
}