package _04_ShoppingCart.dao;

import _04_ShoppingCart.model.ItemBean;

public interface OrderItemDao {
	
	
	double findItemAmount(ItemBean oib);

	void updateProductStock(ItemBean ob);
	

}
