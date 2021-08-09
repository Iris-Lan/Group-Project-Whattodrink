package _07_Others.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import _03_ListDrinks.model.DrinkBean;

@Entity
@Table(name = "temp_limit")
public class TempLimitBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tl_sql;
	
	private Integer product_id;
	
	private Integer temp_id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "FK_TempLevelBean_temp_id")
	private TempLevelBean tempLevelBean;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "FK_DrinkBean_product_id")
	private DrinkBean drinkBean;


	public TempLimitBean() {
		super();
	}


	public TempLimitBean(Integer tl_sql, Integer product_id, Integer temp_id, TempLevelBean tempLevelBean,
			DrinkBean drinkBean) {
		super();
		this.tl_sql = tl_sql;
		this.product_id = product_id;
		this.temp_id = temp_id;
		this.tempLevelBean = tempLevelBean;
		this.drinkBean = drinkBean;
	}


	public Integer getTl_sql() {
		return tl_sql;
	}


	public void setTl_sql(Integer tl_sql) {
		this.tl_sql = tl_sql;
	}


	public Integer getProduct_id() {
		return product_id;
	}


	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}


	public Integer getTemp_id() {
		return temp_id;
	}


	public void setTemp_id(Integer temp_id) {
		this.temp_id = temp_id;
	}


	public TempLevelBean getTempLevelBean() {
		return tempLevelBean;
	}


	public void setTempLevelBean(TempLevelBean tempLevelBean) {
		this.tempLevelBean = tempLevelBean;
	}


	public DrinkBean getDrinkBean() {
		return drinkBean;
	}


	public void setDrinkBean(DrinkBean drinkBean) {
		this.drinkBean = drinkBean;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TempLimitBean [tl_sql=");
		builder.append(tl_sql);
		builder.append(", product_id=");
		builder.append(product_id);
		builder.append(", temp_id=");
		builder.append(temp_id);
		builder.append(", tempLevelBean=");
		builder.append(tempLevelBean);
		builder.append(", drinkBean=");
		builder.append(drinkBean);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
