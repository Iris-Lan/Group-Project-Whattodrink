package _07_Others.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderNo")
public class CreateOrderId {

	@Id
	private String order_id;
	private String company_id;
	
	
	
	public CreateOrderId() {
		super();
	}
	
	public CreateOrderId(String order_id, String company_id) {
		super();
		this.order_id = order_id;
		this.company_id = company_id;
	}
	
	
	
	
	public String getOrder_id() {
		return order_id;
	}
	
	
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	
	public String getCompany_id() {
		return company_id;
	}
	
	
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	
	
}
