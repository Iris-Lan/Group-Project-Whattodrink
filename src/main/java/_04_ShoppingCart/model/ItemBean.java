package _04_ShoppingCart.model;

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
import _03_ListDrinks.model.DrinkBean;
import _07_Others.model.SugarLevelBean;
import _07_Others.model.TempLevelBean;

@Entity
@Table(name = "item")
public class ItemBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer item_id;
	
	private String capacity;
	private Integer item_cal;
	private Integer price;
	private String note;
	private Boolean add_to_health;
	private String itemStatus;
	
	
 	@OneToMany(mappedBy="itemBean", cascade=CascadeType.ALL)
	private Set<ItemToppingBean> itemToppings = new LinkedHashSet<>();
 	
 	
 	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "FK_OrderBean_order_id")
 	private OrderBean orderBean;
 	
 	
 	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "FK_DrinkBean_product_id")
 	private DrinkBean drinkBean;
 	
 	
 	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "FK_TempLevelBean_temp_id")	
 	private TempLevelBean tempLevelBean;
 	
 	
 	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "FK_SugarLevelBean_sugar_id")	
 	private SugarLevelBean sugarLevelBean;


	public ItemBean() {
		super();
	}





	public ItemBean(Integer item_id, String capacity, Integer item_cal, Integer price, String note,
			Boolean add_to_health, String itemStatus, OrderBean orderBean, DrinkBean drinkBean,
			TempLevelBean tempLevelBean, SugarLevelBean sugarLevelBean) {
		super();
		this.item_id = item_id;
		this.capacity = capacity;
		this.item_cal = item_cal;
		this.price = price;
		this.note = note;
		this.add_to_health = add_to_health;
		this.itemStatus = itemStatus;
		this.orderBean = orderBean;
		this.drinkBean = drinkBean;
		this.tempLevelBean = tempLevelBean;
		this.sugarLevelBean = sugarLevelBean;
	}





	public Integer getItem_id() {
		return item_id;
	}


	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}


	public String getCapacity() {
		return capacity;
	}


	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}


	public Integer getItem_cal() {
		return item_cal;
	}


	public void setItem_cal(Integer item_cal) {
		this.item_cal = item_cal;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public Boolean getAdd_to_health() {
		return add_to_health;
	}


	public void setAdd_to_health(Boolean add_to_health) {
		this.add_to_health = add_to_health;
	}

	

	public String getItemStatus() {
		return itemStatus;
	}


	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}



	public Set<ItemToppingBean> getItemToppings() {
		return itemToppings;
	}


	public void setItemToppings(Set<ItemToppingBean> itemToppings) {
		this.itemToppings = itemToppings;
	}


	public OrderBean getOrderBean() {
		return orderBean;
	}


	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}


	public DrinkBean getDrinkBean() {
		return drinkBean;
	}


	public void setDrinkBean(DrinkBean drinkBean) {
		this.drinkBean = drinkBean;
	}


	public TempLevelBean getTempLevelBean() {
		return tempLevelBean;
	}


	public void setTempLevelBean(TempLevelBean tempLevelBean) {
		this.tempLevelBean = tempLevelBean;
	}


	public SugarLevelBean getSugarLevelBean() {
		return sugarLevelBean;
	}


	public void setSugarLevelBean(SugarLevelBean sugarLevelBean) {
		this.sugarLevelBean = sugarLevelBean;
	}





	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemBean [item_id=");
		builder.append(item_id);
		builder.append(", capacity=");
		builder.append(capacity);
		builder.append(", item_cal=");
		builder.append(item_cal);
		builder.append(", price=");
		builder.append(price);
		builder.append(", note=");
		builder.append(note);
		builder.append(", add_to_health=");
		builder.append(add_to_health);
		builder.append(", itemStatus=");
		builder.append(itemStatus);
		builder.append(", itemToppings=");
		builder.append(itemToppings);
		builder.append(", orderBean=");
		builder.append(orderBean);
		builder.append(", drinkBean=");
		builder.append(drinkBean);
		builder.append(", tempLevelBean=");
		builder.append(tempLevelBean);
		builder.append(", sugarLevelBean=");
		builder.append(sugarLevelBean);
		builder.append("]");
		return builder.toString();
	}



 	
 	
 	
 	
}
