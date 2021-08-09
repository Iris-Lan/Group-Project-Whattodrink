package _01_Register.b_01_register.service.serviceImpl;

import java.io.Serializable;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _00_init.utils.GlobalService;
import _00_init.utils.HibernateUtils;
import _01_Register.b_01_register.dao.CompanyDao;
import _01_Register.b_01_register.dao.impl.CompanyDaoImpl;
import _01_Register.b_01_register.model.CompanyBean;
import _01_Register.b_01_register.service.CompanyService;



// 本類別負責讀取資料庫company表格內的紀錄
// 
public class CompanyServiceImpl implements Serializable, CompanyService {
	
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);
	
	SessionFactory factory;
	CompanyDao companyDao;

	public CompanyServiceImpl() {
		factory = HibernateUtils.getSessionFactory();
		companyDao = new CompanyDaoImpl();
	}
	

	
	@Override
	public void save(CompanyBean companyBean) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		
		try {
			 tx = session.beginTransaction();
			 companyDao.save(companyBean);
			 tx.commit();
		}catch(Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		log.info("新增CompanyBean功能之Service: 資料新增成功, CompanyBean=" + companyBean);
	}


	@Override
	public boolean existsByAccount(String account) {
		boolean existsByAccount = false;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		
		try {
			 tx = session.beginTransaction();
			 existsByAccount = companyDao.existsByAccount(account);
			 tx.commit();
		}catch(Exception ex) {
			if(tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(ex.getMessage());
		}
		log.info("商家註冊功能之Service: 檢查商家輸入的帳號是否已被使用: exist=" + existsByAccount);		
		return existsByAccount;
	}



	@Override
	public CompanyBean findByCompanyAccount(String company_account) {
		CompanyBean cb = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		
		try {
			 tx = session.beginTransaction();
			 cb = companyDao.findByCompanyAccount(company_account);
			 tx.commit();
		}catch(Exception ex) {
			if(tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(ex.getMessage());
		}
		log.info("商家註冊功能之Service: 由商家帳號找出對應的CompanyBean");		
		return cb;
	}



	@Override
	public CompanyBean findByCompanyAccountAndPassword(String company_account, String password) {
		CompanyBean cb = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		
		try {
			 tx = session.beginTransaction();
			 cb = companyDao.findByCompanyAccountAndPassword(company_account, password);
			 log.info("會員登入功能之Service: 檢查帳號/密碼結果:" 
						+ (cb != null ? "帳號/密碼正確" : "帳號/密碼錯誤"));
			 tx.commit();
		}catch(Exception ex) {
			if(tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(ex.getMessage());
		}
		return cb;
	}


	@Override
	public void updateCompany(CompanyBean companyBean) {
		log.info("更新商家資料之Service, CompanyBean=" + companyBean);
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			companyDao.updateCompany(companyBean);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}	
	}
	
	
	
	
	
	// --------------------------------------------
	@Override
	public List<CompanyBean> findAll() {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		List<CompanyBean> companyBeans = null;
		try {
			tx = session.beginTransaction();
			companyBeans = companyDao.findAll();
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
		}
		log.info("新增與更新書籍之前置作業之Service#findAll() companyBeans=" + companyBeans);
		return companyBeans;
	}

//	@Override
//	public CompanyBean findById(Integer id) {
//		CompanyBean companyBean = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			companyBean = companyDao.findById(id);
//			tx.commit();
//		}catch(Exception e) {
//			if(tx != null) {
//				tx.rollback();
//			}
//		}
//		
//		log.info("List<CompanyBean> companyBean=" + companyBean);
//		return companyBean;
//	}



	@Override
	public CompanyBean findById(String companyId) {
		CompanyBean companyBean = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			companyBean = companyDao.findById(companyId);
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
		}
		
		log.info("List<CompanyBean> companyBean=" + companyBean);
		return companyBean;
	}



	@Override
	public String getCompanyId(String companyName) {
		String companyId = GlobalService.getCompanyId(companyName);
		return companyId;
	}



//	@Override
//	public String getSelectTag(String tagName, int selected) {
//		String ans = "";
//		List<CompanyBean> cb = findAll();
//		ans += "<SELECT name='" + tagName + "'>";
//		for (CompanyBean bean : cb) {
//			int id = bean.getId();
//			String name = bean.getName().substring(0, 4);
//			if (id == selected) {
//				ans += "<option value='" + id + "' selected>" + name + "</option>";
//			} else {
//				ans += "<option value='" + id + "'>" + name + "</option>";
//			}
//		}
//		ans += "</SELECT>";
//		log.info("新增與更新書籍之前置作業之Service#getSelectTag(), getSelectTag=" + ans);
//		return ans;
//	}
	


}