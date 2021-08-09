package _03_ListDrinks.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import _01_Register.b_01_register.model.CompanyBean;
import _04_ShoppingCart.model.ItemToppingBean;

@Entity
@Table(name = "topping")
public class ToppingBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer topping_id;
	
	
 	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_CompanyBean_Company_id")
	private CompanyBean companyBean;
 	
	
 	@OneToMany(mappedBy="toppingBean", cascade=CascadeType.ALL)
	private Set<ItemToppingBean> itemToppings = new LinkedHashSet<>();
}
