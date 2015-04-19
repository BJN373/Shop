package ua.lvivl.shop.dao;


import java.util.List;

import ua.lviv.shop.domain.Product;

public interface ProductDao {

	public void addProduct(Product product);

	public void delleteProduct(Product product);

	public Product getProduct(int id);
	
	public Product getProduct(String name);

	public List<Product> getAll();

	public void updateProduct(Product product);

}
