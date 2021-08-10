package _04_ShoppingCart.main;


import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import _01_Register.b_01_register.model.CompanyBean;
import _01_Register.b_01_register.service.CompanyService;
import _01_Register.b_01_register.service.serviceImpl.CompanyServiceImpl;
import _01_Register.c_01_register.model.CustomerBean;
import _04_ShoppingCart.model.OrderBean;
import _04_ShoppingCart.service.OrderService;
import _04_ShoppingCart.service.serviceImpl.OrderServiceImpl;

public class OrderTest_AllMethods {

	public static void main(String[] args) {

//SaveOrder
//		CompanyService companyService = new CompanyServiceImpl();
//		OrderService orderService = new OrderServiceImpl();
//		
//		
//		String 	      order_id 	      = orderService.getOrderIdByCompanyName("五十嵐");
//		Timestamp     order_date 	  = new Timestamp(System.currentTimeMillis());
//		Timestamp 	  pickup_date 	  = null;
//		Integer 	  order_quantity  = 5;
//		Integer 	  order_total 	  = 500;
//		String 		  payment 		  = "現金支付";
//		String 		  orderStatus 	  = "確認訂單中";
//		String 		  company_id      = companyService.getCompanyId("五十嵐");
//		Integer 	  customer_id     = null;
//		String 		  receipt		  = null;
//		String 		  order_text      = null;
//		CustomerBean  customerBean    = null;
//		CompanyBean   companyBean     = companyService.findById(company_id);
//		

//預設建構子		
//		OrderBean orderBean = new OrderBean(order_id, customer_id, order_date, pickup_date, company_id, order_quantity, order_total, payment, orderStatus, receipt, order_text);
		
//包含bean建構子		
//		OrderBean orderBean = new OrderBean(order_id, order_date, pickup_date, order_quantity, order_total, payment, orderStatus, receipt, order_text, customerBean, companyBean);
		
		
		
//		orderBean.setItems(null);
//		orderBean.setCompanyBean(companyBean);
//		orderBean.setComments(null);
//		orderBean.setCustomerBean(null);

//		orderService.save(orderBean);
		
		
		
		
		
		
		
		
		
		
		
		
		
//DeleteByOrderId
//		OrderService orderService = new OrderServiceImpl();
//		orderService.deleteOrderById("A0120210810007");
		

//FindOrderBeanByCompanyBean => null (因為存Order時沒存CompanyBean，只存companyId，就無法用CompanyBean 去get多方的訂單資訊 companyBean.getOrders)
//		CompanyService companyService = new CompanyServiceImpl();
//		CompanyBean cb = companyService.findById("A01");
//		Set<OrderBean> list = cb.getOrders();
//		for(OrderBean ob : list) {
//			System.out.println(ob);
//		}
		
		
//FindOrderByCompanyId
		OrderService orderService = new OrderServiceImpl();

		List<OrderBean> list = orderService.findByCompanyId("A01");
		for(OrderBean ob : list) {
			System.out.println(ob); 			
		}
	
		
//FindOrderByCustomerId
//		OrderService orderService = new OrderServiceImpl()
//		List<OrderBean> list = orderService.findByCustomerId(1);
//		for(OrderBean ob : list) {
//			System.out.println(ob); 			
//		}
		
		
		
//UpdateOrderStatus
//		OrderService orderService = new OrderServiceImpl();
//		OrderBean orderBean = orderService.findById("A0120210810004");
//		orderService.updateOrderStatus(orderBean, "已領取");
		
		

		
		
	}

}
