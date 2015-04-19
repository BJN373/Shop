package ua.lviv.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "product_id", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;

	@Column(name = "title", unique = true, nullable = false, length = 100)
	private String title;

	@Column(name = "description", length = 100)
	private String description;

	@Column(name = "price", nullable = false)
	private double price;

	@ManyToOne
	@JoinColumn(name = "basket_id")
	private Basket basket;

	public Product() {

	}

	public Product(String title, double price) {
		this.title = title;
		this.price = price;
	}

	public Product(String title, String description, double price) {
		this.title = title;
		this.description = description;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", title=" + title
				+ ", description=" + description + ", price=" + price
				+ ", basket=" + basket + "]";
	}

}
