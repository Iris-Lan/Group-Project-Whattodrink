package _07_Others.model;

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
@Table(name = "sugar_limit")
public class SugarLimitBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sl_sql;
	
	private Integer product_id;
	
	private Integer sugar_id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "FK_TempLevelBean_sugar_id")
	private SugarLevelBean sugarLevelBean;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "FK_DrinkBean_product_id")
	private DrinkBean drinkBean;


	public SugarLimitBean() {
		super();
	}


	public SugarLimitBean(Integer sl_sql, Integer product_id, Integer sugar_id, SugarLevelBean sugarLevelBean,
			DrinkBean drinkBean) {
		super();
		this.sl_sql = sl_sql;
		this.product_id = product_id;
		this.sugar_id = sugar_id;
		this.sugarLevelBean = sugarLevelBean;
		this.drinkBean = drinkBean;
	}


	public Integer getSl_sql() {
		return sl_sql;
	}


	public void setSl_sql(Integer sl_sql) {
		this.sl_sql = sl_sql;
	}


	public Integer getProduct_id() {
		return product_id;
	}


	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}


	public Integer getSugar_id() {
		return sugar_id;
	}


	public void setSugar_id(Integer sugar_id) {
		this.sugar_id = sugar_id;
	}


	public SugarLevelBean getSugarLevelBean() {
		return sugarLevelBean;
	}


	public void setSugarLevelBean(SugarLevelBean sugarLevelBean) {
		this.sugarLevelBean = sugarLevelBean;
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
		builder.append("SugarLimitBean [sl_sql=");
		builder.append(sl_sql);
		builder.append(", product_id=");
		builder.append(product_id);
		builder.append(", sugar_id=");
		builder.append(sugar_id);
		builder.append(", sugarLevelBean=");
		builder.append(sugarLevelBean);
		builder.append(", drinkBean=");
		builder.append(drinkBean);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
}
