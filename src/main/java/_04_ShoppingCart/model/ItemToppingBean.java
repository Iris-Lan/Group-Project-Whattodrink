package _04_ShoppingCart.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import _01_Register.b_01_register.modal.CompanyBean;

@Entity
@Table(name = "item_topping")
public class ItemToppingBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer i_t_seq;
	
	
 	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_CompanyBean_Company_id")
	private CompanyBean companyBean;
}
