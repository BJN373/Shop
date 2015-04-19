package ua.lviv.general;

import ua.lvivl.shop.dao.BasketDao;
import ua.lvivl.shop.dao.ProductDao;
import ua.lvivl.shop.dao.UserDao;
import ua.lvivl.shop.dao.imp.BasketDaoImp;
import ua.lvivl.shop.dao.imp.ProductDaoImp;
import ua.lvivl.shop.dao.imp.UserDaoImp;

public class Factory {

	private UserDao userDao;
	private ProductDao productDao;
	private BasketDao basketDao;

	private Factory() {
	}

	public static Factory getInstance() {
		return InstalFactory.instance;
	}

	private static class InstalFactory {
		private static Factory instance = new Factory();

		private InstalFactory() {

		}

	}

	public UserDao getUserDao() {
		if (userDao == null)
			userDao = new UserDaoImp();
		return userDao;
	}

	public ProductDao getProductDao() {
		if (productDao == null) {
			productDao = new ProductDaoImp();

		}
		return productDao;
	}

	public BasketDao getBasketDao() {
		if (basketDao == null) {
			basketDao = new BasketDaoImp();
		}
		return basketDao;
	}
}
