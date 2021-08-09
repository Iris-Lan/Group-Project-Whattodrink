package _03_ListDrinks.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import _01_Register.b_01_register.model.CompanyBean;

@Entity
@Table(name = "product")
public class DrinkBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_id;
	
	
	
 	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_CompanyBean_Company_id")
	private CompanyBean companyBean;


 	
 	
}
