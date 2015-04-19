package ua.lvivl.shop.dao.imp;

import java.util.List;
import org.hibernate.Session;
import ua.lviv.shop.domain.Basket;
import ua.lviv.shop.domain.Product;
import ua.lvivl.shop.dao.BasketDao;
import util.HibernateUtil;

public class BasketDaoImp implements BasketDao {

	private Session session = null;

	private void beginTransaction() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	}

	private void closeSession() {
		if (session != null && session.isOpen())
			session.close();
	}

	public List<Product> getProductsFromBasket(int basketId) {
		List<Product> list = null;
		Basket basket = null;
		try {
			beginTransaction();
			basket = (Basket) session.get(Basket.class, basketId);
			list = basket.getProducts();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return list;
	}

	public void addBasket(Basket basketDao) {
		try {
			beginTransaction();
			session.save(basketDao);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}
	}

	public List<Basket> getALL() {
		List<Basket> baskets = null;
		try {
			beginTransaction();
			baskets = session.createCriteria(Basket.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return baskets;
	}

}
