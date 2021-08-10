package _04_ShoppingCart.model;

import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import _01_Register.b_01_register.model.CompanyBean;
import _01_Register.c_01_register.model.CustomerBean;
import _07_Others.model.CommentBean;

//前端頁面沒有 "receipt" 欄位 加了沒用
//前端頁面沒有 "order_text" 欄位 加了沒用 (傳情小貼紙欄位在items裡
//前端頁面有 "訂單狀態" 欄位 我先加上 歷史紀錄需要存


@Entity
@Table(name = "orders")
public class OrderBean {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer order_seq;
	private String order_id;
	
	private Integer customer_id;
	
	private Timestamp order_date;
	
	private Timestamp pickup_date;
	
	private String company_id;
	
	private Integer order_quantity;
	
	private Integer order_total;
	
	private String payment;
	
	private String orderStatus;
	 
	private String receipt;
	
	private String order_text;
	
 	
	@OneToMany(mappedBy="orderBean", cascade=CascadeType.ALL)
	private Set<ItemBean> items = new LinkedHashSet<>();

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_CustomerBean_customer_id")
	private CustomerBean customerBean;
	
	
 	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_CompanyBean_Company_id")
	private CompanyBean companyBean;
 	
 	
	@OneToMany(mappedBy = "orderBean")
	private Set<CommentBean> comments = new LinkedHashSet<>();
 	


	public OrderBean() {
		super();
	}

	

//預設建構子
	public OrderBean(String order_id, Integer customer_id, Timestamp order_date, Timestamp pickup_date,
			String company_id, Integer order_quantity, Integer order_total, String payment, String orderStatus,
			String receipt, String order_text) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.order_date = order_date;
		this.pickup_date = pickup_date;
		this.company_id = company_id;
		this.order_quantity = order_quantity;
		this.order_total = order_total;
		this.payment = payment;
		this.orderStatus = orderStatus;
		this.receipt = receipt;
		this.order_text = order_text;
	}



//包含相關bean建構子
	public OrderBean(String order_id, Timestamp order_date, Timestamp pickup_date, Integer order_quantity,
			Integer order_total, String payment, String orderStatus, String receipt, String order_text,
			CustomerBean customerBean, CompanyBean companyBean) {
		super();
		this.order_id = order_id;
		this.order_date = order_date;
		this.pickup_date = pickup_date;
		this.order_quantity = order_quantity;
		this.order_total = order_total;
		this.payment = payment;
		this.orderStatus = orderStatus;
		this.receipt = receipt;
		this.order_text = order_text;
		this.customerBean = customerBean;
		this.companyBean = companyBean;
	}


	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Timestamp getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}

	public Timestamp getPickup_date() {
		return pickup_date;
	}

	public void setPickup_date(Timestamp pickup_date) {
		this.pickup_date = pickup_date;
	}

	public Integer getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(Integer order_quantity) {
		this.order_quantity = order_quantity;
	}

	public Integer getOrder_total() {
		return order_total;
	}

	public void setOrder_total(Integer order_total) {
		this.order_total = order_total;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}


	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public String getReceipt() {
		return receipt;
	}


	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}



	public String getOrder_text() {
		return order_text;
	}


	public void setOrder_text(String order_text) {
		this.order_text = order_text;
	}



	public Set<ItemBean> getItems() {
		return items;
	}


	public void setItems(Set<ItemBean> items) {
		this.items = items;
	}

	public CustomerBean getCustomer_id() {
		return customerBean;
	}

	public void setCustomer_id(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}

	public CompanyBean getCompanyBean() {
		return companyBean;
	}

	public void setCompanyBean(CompanyBean companyBean) {
		this.companyBean = companyBean;
	}


	public Set<CommentBean> getComments() {
		return comments;
	}

	public void setComments(Set<CommentBean> comments) {
		this.comments = comments;
	}






	public String getCompany_id() {
		return company_id;
	}




	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}




	public CustomerBean getCustomerBean() {
		return customerBean;
	}




	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}




	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderBean [order_id=");
		builder.append(order_id);
		builder.append(", customer_id=");
		builder.append(customer_id);
		builder.append(", order_date=");
		builder.append(order_date);
		builder.append(", pickup_date=");
		builder.append(pickup_date);
		builder.append(", company_id=");
		builder.append(company_id);
		builder.append(", order_quantity=");
		builder.append(order_quantity);
		builder.append(", order_total=");
		builder.append(order_total);
		builder.append(", payment=");
		builder.append(payment);
		builder.append(", orderStatus=");
		builder.append(orderStatus);
		builder.append(", receipt=");
		builder.append(receipt);
		builder.append(", order_text=");
		builder.append(order_text);
		builder.append(", customerBean=");
		builder.append(customerBean);
		builder.append(", companyBean=");
		builder.append(companyBean);
		builder.append("]");
		return builder.toString();
	}





}
