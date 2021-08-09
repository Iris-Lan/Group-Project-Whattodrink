package _04_ShoppingCart.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import _01_Register.b_01_register.model.CompanyBean;
import _03_ListDrinks.model.ToppingBean;

@Entity
@Table(name = "item_topping")
public class ItemToppingBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer i_t_seq;

	
 	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_ItemBean_item_id")
	private ItemBean itemBean;
 	
 	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_ToppingBean_topping_id")
	private ToppingBean toppingBean;

 	
 	
	public ItemToppingBean() {
		super();
	}


	public ItemToppingBean(Integer i_t_seq, ItemBean itemBean, ToppingBean toppingBean) {
		super();
		this.i_t_seq = i_t_seq;
		this.itemBean = itemBean;
		this.toppingBean = toppingBean;
	}



	public Integer getI_t_seq() {
		return i_t_seq;
	}



	public void setI_t_seq(Integer i_t_seq) {
		this.i_t_seq = i_t_seq;
	}




	public ItemBean getItemBean() {
		return itemBean;
	}



	public void setItemBean(ItemBean itemBean) {
		this.itemBean = itemBean;
	}



	public ToppingBean getToppingBean() {
		return toppingBean;
	}



	public void setToppingBean(ToppingBean toppingBean) {
		this.toppingBean = toppingBean;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemToppingBean [i_t_seq=");
		builder.append(i_t_seq);
		builder.append(", itemBean=");
		builder.append(itemBean);
		builder.append(", toppingBean=");
		builder.append(toppingBean);
		builder.append("]");
		return builder.toString();
	}



 	
}
