package _04_ShoppingCart.dao.daoImpl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _00_init.utils.GlobalService;
import _00_init.utils.HibernateUtils;
import _01_Register.b_01_register.model.CompanyBean;
import _01_Register.c_01_register.model.CustomerBean;
import _04_ShoppingCart.dao.OrderDao;
import _04_ShoppingCart.model.OrderBean;

public class OrderDaoImpl implements OrderDao{
	
	private static Logger log = LoggerFactory.getLogger(OrderDaoImpl.class);
	
	SessionFactory factory;
	
	
	public OrderDaoImpl() {
		factory = HibernateUtils.getSessionFactory();		
	}

	
	
	@Override
	public void save(OrderBean orderBean) {
		log.info("儲存訂單(OrderDaoImpl)之Dao: ");
		Session session = factory.getCurrentSession();
		session.persist(orderBean);
	}

	@Override
	public OrderBean findById(String orderId) {
		log.info("依照orderId編號讀取特定一筆訂單的所有資料之Dao, orderId=" + orderId);
		Session session = factory.getCurrentSession();
		OrderBean ob = session.get(OrderBean.class, orderId);
		return ob;
	}

	@Override
	public List<OrderBean> findByCustomerAccount(String customer_account) {		
		log.info("依照customer_account編號讀取特定會員的所有訂單之Dao, customer_account=" + customer_account);
		Session session = factory.getCurrentSession();
		String hql = "FROM CustomerBean c WHERE c.customer_account = :account";
		CustomerBean cb = session.createQuery(hql, CustomerBean.class)
						         .setParameter("account", customer_account)
			  	   		         .getSingleResult();
		
		String hql2 = "FROM OrderBean o WHERE o.customer_id = :id";
		List<OrderBean> beans = session.createQuery(hql2, OrderBean.class)
								       .setParameter("id", cb.getCustomer_id())
					  	   		       .getResultList();
		return beans;
	}



	@Override
	public List<OrderBean> findByCompanyId(String companyId) {
		log.info("依照companyId編號讀取特定公司的所有訂單之Dao, companyId=" + companyId);
		Session session = factory.getCurrentSession();	
		String hql = "FROM OrderBean o WHERE o.company_id = :id";
		List<OrderBean> beans = session.createQuery(hql, OrderBean.class)
									   .setParameter("id", companyId)
									   .getResultList();
								
		return beans;
	}



	@Override
	public void deleteOrderById(String orderId) {
		log.info("依照orderId編號刪除特定訂單之Dao, orderId=" + orderId);
		Session session = factory.getCurrentSession();	
		String hql = "DELETE FROM OrderBean o WHERE o.order_id = :id";			
		session.createQuery(hql).setParameter("id", orderId).executeUpdate();		
	}



	@Override
	public void updateOrderStatus(OrderBean orderBean, String orderStatus) {
		log.info("依照orderBean與orderStatus更新此筆訂單之Dao, orderBean=" + orderBean + ", orderStatus=" + orderStatus);
		Session session = factory.getCurrentSession();
		String hql = "UPDATE OrderBean o SET o.orderStatus = :status WHERE o.order_id = :id";		
		session.createQuery(hql).setParameter("status", orderStatus)
								.setParameter("id", orderBean.getOrder_id())
								.executeUpdate();
		
		
		
		String hqlAddPickUpDate = "UPDATE OrderBean o SET o.pickup_date = :pickup WHERE o.order_id = :id";
		if(orderStatus == "已領取") {
			session.createQuery(hqlAddPickUpDate).setParameter("pickup", new Timestamp(System.currentTimeMillis()))
												 .setParameter("id", orderBean.getOrder_id())
												 .executeUpdate();
		}
	}



	@Override
	public String getOrderIdByCompanyName(String companyName) {
		log.info("依照companyName產生該訂單OrderId之Dao, companyName=" + companyName);
		String orderId = "";
		Session session = factory.getCurrentSession();
	
		ProcedureCall query = session.createStoredProcedureCall("getOrderNo");
		query.registerParameter("companyId", String.class, ParameterMode.IN).bindValue(GlobalService.getCompanyId(companyName));
		query.registerParameter("orderId", String.class, ParameterMode.OUT);
		ProcedureOutputs  procedureOutputs  = query.getOutputs();
		orderId = (String) procedureOutputs.getOutputParameterValue("orderId");
	
		return orderId;
	}



	@Override
	public List<OrderBean> findByCustomerId(int customerId) {
		log.info("依照customerId編號讀取特定會員的所有訂單之Dao, customerId=" + customerId);
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderBean o WHERE o.customer_id = :account";
		List<OrderBean> beans = session.createQuery(hql, OrderBean.class)
								       .setParameter("account", customerId)
					  	   		       .getResultList();
		return beans;
	}

}
