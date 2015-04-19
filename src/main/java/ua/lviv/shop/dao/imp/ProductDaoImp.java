package ua.lviv.shop.dao.imp;

import java.util.List;

import org.hibernate.Session;

import ua.lviv.shop.dao.ProductDao;
import ua.lviv.shop.domain.Product;
import util.HibernateUtil;

public class ProductDaoImp implements ProductDao {

	private Session session = null;

	public void addProduct(Product product) {

		try {
			beginTransaction();
			session.save(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSesion();
		}
	}

	public void delleteProduct(Product product) {

		try {
			beginTransaction();
			session.delete(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSesion();
		}
	}

	public Product getProduct(int id) {
		Product product = null;

		try {
			beginTransaction();
			product = (Product) session.get(Product.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSesion();
		}
		return product;
	}

	public Product getProduct(String name) {
		Product product = null;

		try {
			beginTransaction();
			product = (Product) session.get(Product.class, name);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSesion();
		}
		return product;
	}

	public List<Product> getAll() {
		List<Product> products = null;

		try {
			beginTransaction();
			products = session.createCriteria(Product.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSesion();
		}
		return products;
	}

	public void updateProduct(Product product) {
		try {
			beginTransaction();
			session.update(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSesion();
		}

	}

	private void beginTransaction() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	}

	private void closeSesion() {
		if (session != null && session.isOpen())
			session.close();
	}

}
