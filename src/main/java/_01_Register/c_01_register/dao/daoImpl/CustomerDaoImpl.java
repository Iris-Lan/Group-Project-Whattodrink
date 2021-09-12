package _01_Register.c_01_register.dao.daoImpl;

import javax.persistence.NoResultException;

import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _00_init.utils.HibernateUtils;
import _01_Register.c_01_register.dao.CustomerDao;
import _01_Register.c_01_register.model.CustomerBean;

public class CustomerDaoImpl implements CustomerDao {

	private static Logger log = LoggerFactory.getLogger(CustomerDaoImpl.class);

	SessionFactory factory;

	public CustomerDaoImpl() {
		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	// 儲存CustomerBean物件，將參數companyBean新增到customer表格內。
	public void saveCustomer(CustomerBean customerBean) {
		log.info("顧客會員-註冊功能-DAO: 儲存顧客會員資料");
		Session session = factory.getCurrentSession();
		session.save(customerBean);
		log.info("顧客會員-註冊功能-DAO-新增成功: customerBean = " + customerBean);
	}

	// 判斷參數（顧客帳號）是否已經被使用，如果是傳回true(此id不能使用)，否則傳回false(此id可使用)。
	@Override
	public boolean existsByCustomerAccount(String customer_account) {
		log.info("顧客會員-註冊功能-DAO: 檢查顧客會員輸入的帳號名稱是否已被使用");
		boolean exist = false;
		String hql = "FROM CustomerBean c WHERE c.customer_account = :account ";
		Session session = factory.getCurrentSession();
		try {
			CustomerBean bean = (CustomerBean) session.createQuery(hql).setParameter("account", customer_account)
					.getSingleResult();
			if (bean != null) {
				exist = true;
			}
		} catch (NoResultException e) {
			exist = false;
		} catch (NonUniqueResultException e) {
			exist = true;
		}
		log.info("顧客會員-註冊功能-DAO: 檢查顧客會員輸入的帳號名稱是否已被使用, exist = " + exist);
		return exist;
	}

	// 由參數（顧客帳號）到customer表格中 取得某個會員的所有資料，傳回值為一個CustomerBean物件，
	// 如果找不到對應的會員資料，傳回值為null。
	@Override
	public CustomerBean findByCustomerAccount(String customer_account) {
		log.info("顧客會員-註冊功能-DAO: 檢查帳號/密碼");
		CustomerBean customerBean = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM CustomerBean c WHERE c.customer_account = :account ";
		try {
			customerBean = (CustomerBean) session.createQuery(hql).setParameter("account", customer_account)
					.getSingleResult();
		} catch (NoResultException e) {
			customerBean = null;
		}
		log.info("顧客會員-註冊功能-DAO: 取得某個顧客會員的資料, customerBean = " + customerBean);
		return customerBean;
	}

	// 檢查使用者在登入時輸入的帳號與密碼是否正確。如果正確，傳回該帳號所對應的CustomerBean物件，否則傳回 null。
	@Override
	public CustomerBean findByCustomerAccountAndPassword(String customer_account, String customer_password) {
		CustomerBean customerBean = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM CustomerBean c WHERE c.customer_account = :account AND c.customer_password = :password";
		try {
			customerBean = (CustomerBean) session.createQuery(hql).setParameter("account", customer_account)
					.setParameter("password", customer_password).getSingleResult();
		} catch (NoResultException e) {
			customerBean = null;
		}
		log.info("顧客會員-註冊功能-DAO: 檢查帳號/密碼結果: " + (customerBean != null ? "帳號/密碼正確" : "帳號/密碼錯誤"));
		return customerBean;
	}
	
	@Override
	public CustomerBean findByCustomerVerification(String customer_account, String customer_verification) {
		CustomerBean customerBean = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM CustomerBean c WHERE c.customer_account = :account AND c.customer_verification = :customer_verification";
		try {
			customerBean = session.createQuery(hql, CustomerBean.class).setParameter("account", customer_account)
																	.setParameter("customer_verification", customer_verification)
																	.getSingleResult();
		} catch (NoResultException e) {
			customerBean = null;
		}
		log.info("顧客會員-註冊功能-DAO: 驗證碼核對 " + (customerBean != null ? "驗證碼正確" : "驗證碼錯誤"));
		return customerBean;
	}

	public void updateCustomer(CustomerBean customerBean) {
		Session session = factory.getCurrentSession();
		session.update(customerBean);
		log.info("顧客會員-註冊功能-DAO: 修改customerBean：" + (customerBean != null ? "驗證碼正確" : "驗證碼錯誤"));
	}
	public void forOrderServletUpdateCustomer(CustomerBean customerBean) {
		Session session = factory.getCurrentSession();
		session.update(customerBean);
	}

	@Override
	public boolean existsByCustomerEmail(String email) {
		log.info("顧客會員-註冊功能-DAO: 檢查顧客會員輸入的email是否已被使用");
		boolean exist = false;
		String hql = "FROM CustomerBean c WHERE c.email = :email ";
		Session session = factory.getCurrentSession();
		try {
			CustomerBean bean = (CustomerBean) session.createQuery(hql).setParameter("email", email).getSingleResult();
			if (bean != null) {
				exist = true;
			}
		} catch (NoResultException e) {
			exist = false;
		} catch (NonUniqueResultException e) {
			exist = true;
		}
		log.info("顧客會員-註冊功能-DAO: 檢查顧客會員輸入的email是否已被使用, exist = " + exist);
		return exist;
	}

	@Override
	public boolean checkInvited(String customer_account) {
		log.info("顧客會員DAO: 檢查顧客會員是否有好友邀請碼");
		boolean exist = false;
		String hql = "SELECT c.invited_by FROM CustomerBean c WHERE c.customer_account = :account ";
		Session session = factory.getCurrentSession();
		try {
			String invited_by = session.createQuery(hql, String.class).setParameter("account", customer_account)
					.getSingleResult();
			if (invited_by != null && invited_by.length() > 0) {
				exist = true;
			}
		} catch (NoResultException e) {
			exist = false;
		} catch (NonUniqueResultException e) {
			exist = true;
		}
		log.info("顧客會員-DAO: 檢查顧客會員是否有好友邀請碼, exist= " + exist);
		return exist;
	}

	@Override
	 public boolean existsByInvitation(String invitation) {
	  boolean exist = false;
	  String hql = "FROM CustomerBean c WHERE c.invitation = :invitation";
	  Session session = factory.getCurrentSession();
	  exist = !session.createQuery(hql)
	         .setParameter("invitation", invitation)
	         .getResultList()
	         .isEmpty();
	  return exist;
	 }


	@Override
	public CustomerBean findByCustomerId(int customer_id) {
		log.info("顧客會員-DAO: findByCustomerId");
		CustomerBean customerBean = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM CustomerBean c WHERE c.customer_id = :id ";
		try {
			customerBean = (CustomerBean) session.createQuery(hql).setParameter("id", customer_id)
					.getSingleResult();
		} catch (NoResultException e) {
			customerBean = null;
		}
		log.info("顧客會員-DAO: findByCustomerId, customerBean = " + customerBean);
		return customerBean;
	}

	
	@Override
	public CustomerBean findByInvitation(String invitation) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CustomerBean c WHERE c.invitation = :invitation";
		CustomerBean customerBean = session.createQuery(hql, CustomerBean.class)
										   .setParameter("invitation", invitation)
										   .getResultList()
										   .get(0);
		return customerBean;
	}

	@Override
	public void updateCustomers(CustomerBean... customerBean) {
		for (CustomerBean cb : customerBean) {
			Session session = factory.getCurrentSession();
			session.update(cb);
		}
	}

}
