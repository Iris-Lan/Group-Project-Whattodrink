package _04_ShoppingCart.service;

import java.util.List;

import _04_ShoppingCart.model.OrderBean;
import _04_ShoppingCart.model.ShoppingCart;

public interface OrderService {

	void save(OrderBean orderBean);

	OrderBean findById(String orderId);

	List<OrderBean> findByCompanyId(String companyId);
	
	List<OrderBean> findByCustomerAccount(String customerAccount);
	
	List<OrderBean> findByCustomerId(int customerId);
	
	void updateOrderStatus(OrderBean orderBean, String orderStatus);
	
//	void updateOrder(String orderId);
	
	void deleteOrderById(String orderId);
	
	String getOrderIdByCompanyName(String companyName);
	
//	void preCheckStock(ShoppingCart shoppingCart);
}
