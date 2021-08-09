package _07_Others.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import _01_Register.b_01_register.model.CompanyBean;
import _01_Register.c_01_register.model.CustomerBean;

@Entity
@Table(name = "favorite")
public class FavoriteBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer f_seq;
	
	
	
 	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_CompanyBean_Company_id")
	private CompanyBean companyBean;
 	
 	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_CustomerBean_customer_id")
	private CustomerBean customerBean;

 	
 	
	public FavoriteBean() {
		super();
	}



	public FavoriteBean(Integer f_seq, CompanyBean companyBean, CustomerBean customerBean) {
		super();
		this.f_seq = f_seq;
		this.companyBean = companyBean;
		this.customerBean = customerBean;
	}


	
	

	public Integer getF_seq() {
		return f_seq;
	}



	public void setF_seq(Integer f_seq) {
		this.f_seq = f_seq;
	}



	public CompanyBean getCompanyBean() {
		return companyBean;
	}



	public void setCompanyBean(CompanyBean companyBean) {
		this.companyBean = companyBean;
	}



	public CustomerBean getCustomerBean() {
		return customerBean;
	}



	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FavoriteBean [f_seq=");
		builder.append(f_seq);
		builder.append(", companyBean=");
		builder.append(companyBean);
		builder.append(", customerBean=");
		builder.append(customerBean);
		builder.append("]");
		return builder.toString();
	}
 	
 	
 	
 	
}
