package ua.lviv.shop.dao;

import java.util.List;

import ua.lviv.shop.domain.Basket;
import ua.lviv.shop.domain.Product;

public interface BasketDao {

	void addBasket(Basket basketDao);

	public List<Basket> getALL();
	
	public List<Product> getProductsFromBasket (int basketId);

}