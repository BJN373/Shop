package ua.lviv.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "user_id", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "user_name", nullable = false, length = 100)
	private String name;

	@Column(name = "user_email", nullable = false, length = 64)
	private String email;

	@OneToOne
	@JoinColumn(name = "basket_id")
	private Basket basket;

	
	
	public User() {
		
	}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + getId() + ", name=" + getName() + ", email="
				+ getEmail() + ", basket=" + getBasket() + "]";
	}

}
