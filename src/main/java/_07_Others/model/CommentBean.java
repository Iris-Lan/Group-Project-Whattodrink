package _07_Others.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import _01_Register.c_01_register.model.CustomerBean;
import _04_ShoppingCart.model.OrderBean;

@Entity
@Table(name = "comments")
public class CommentBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer comment_id;

	private Integer product_id;
	
	private Timestamp comment_date;
	
	private String 	comment_picpath;
	
	private String 	comment_picname;
	
	private BigDecimal star;
	
	private String feedback;
	
	
 	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_OrderBean_order_id")
	private OrderBean orderBean;
 	
 	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_CustomerBean_customer_id")
	private CustomerBean customerBean;

 	
	public CommentBean() {
		super();
	}


	public CommentBean(Integer comment_id, Integer product_id, Timestamp comment_date, String comment_picpath,
			String comment_picname, BigDecimal star, String feedback, OrderBean orderBean, CustomerBean customerBean) {
		super();
		this.comment_id = comment_id;
		this.product_id = product_id;
		this.comment_date = comment_date;
		this.comment_picpath = comment_picpath;
		this.comment_picname = comment_picname;
		this.star = star;
		this.feedback = feedback;
		this.orderBean = orderBean;
		this.customerBean = customerBean;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommentBean [comment_id=");
		builder.append(comment_id);
		builder.append(", product_id=");
		builder.append(product_id);
		builder.append(", comment_date=");
		builder.append(comment_date);
		builder.append(", comment_picpath=");
		builder.append(comment_picpath);
		builder.append(", comment_picname=");
		builder.append(comment_picname);
		builder.append(", star=");
		builder.append(star);
		builder.append(", feedback=");
		builder.append(feedback);
		builder.append(", orderBean=");
		builder.append(orderBean);
		builder.append(", customerBean=");
		builder.append(customerBean);
		builder.append("]");
		return builder.toString();
	}
 	
 	
 	
 	

}
