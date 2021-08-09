package _04_ShoppingCart.main;


import java.sql.Timestamp;
import java.util.List;

import _01_Register.b_01_register.service.CompanyService;
import _01_Register.b_01_register.service.serviceImpl.CompanyServiceImpl;
import _04_ShoppingCart.model.OrderBean;
import _04_ShoppingCart.service.OrderService;
import _04_ShoppingCart.service.serviceImpl.OrderServiceImpl;

public class OrderTest_AllMethods {

	public static void main(String[] args) {

//SaveOrder
		CompanyService companyService = new CompanyServiceImpl();
		OrderService orderService = new OrderServiceImpl();
		
		
		String 	      order_id 	      = orderService.getOrderIdByCompanyName("五十嵐");
		Timestamp     order_date 	  = new Timestamp(System.currentTimeMillis());
		Timestamp 	  pickup_date 	  = null;
		Integer 	  order_quantity  = 5;
		Integer 	  order_total 	  = 500;
		String 		  payment 		  = "現金支付";
		String 		  orderStatus 	  = "確認訂單中";
		String 		  company_id      = companyService.getCompanyId("五十嵐");
		Integer 	  customer_id     = null;
		String 		  receipt		  = null;
		String 		  order_text      = null;

		
		OrderBean orderBean = new OrderBean(order_id, customer_id, order_date, pickup_date, company_id, order_quantity, order_total, payment, orderStatus, receipt, order_text);
//		orderBean.setItems(null);
//		orderBean.setCompanyBean(null);
//		orderBean.setComments(null);
//		orderBean.setCustomerBean(null);

		orderService.save(orderBean);
		
		
		
		
		
		
		
		
		
		
		
		
		
//DeleteByOrderId
//		OrderService orderService = new OrderServiceImpl();
//		orderService.deleteOrderById("B0120210810002");
		
		

		
		
//FindOrderByCompanyId
//		OrderService orderService = new OrderServiceImpl();
//
//		List<OrderBean> list = orderService.findByCompanyId("B01");
//		for(OrderBean ob : list) {
//			System.out.println(ob.getOrder_total()); 			
//		}
	
		
//FindOrderByCustomerId
//		OrderService orderService = new OrderServiceImpl()
//		List<OrderBean> list = orderService.findByCustomerId(1);
//		for(OrderBean ob : list) {
//			System.out.println(ob); 			
//		}
		
		
		
//UpdateOrderStatus
//		OrderService orderService = new OrderServiceImpl();
//		OrderBean orderBean = orderService.findById("A0120210810002");
//		orderService.updateOrderStatus(orderBean, "取消接單");
		
		

		
		
	}

}
