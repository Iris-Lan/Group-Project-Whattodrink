package _04_ShoppingCart.dao;


import java.util.List;

import _04_ShoppingCart.model.OrderBean;



public interface OrderDao {

	void save(OrderBean orderBean);

	OrderBean findById(String orderId);

	List<OrderBean> findByCustomerAccount(String customer_account);

	List<OrderBean> findByCompanyId(String companyId);

	void deleteOrderById(String orderId);

	void updateOrderStatus(OrderBean orderBean, String orderStatus);

	String getOrderIdByCompanyName(String companyName);

	List<OrderBean> findByCustomerId(int customerId);

//	void updateOrder(String orderId);


	
}
