package _01_Register.b_01_register.dao.impl;

import java.io.Serializable;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _00_init.utils.HibernateUtils;
import _01_Register.b_01_register.dao.CompanyDao;
import _01_Register.b_01_register.modal.CompanyBean;






// 本類別負責讀取資料庫內company表格內的紀錄
// 
public class CompanyDaoImpl implements Serializable, CompanyDao {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(CompanyDaoImpl.class);
	
	SessionFactory factory;

	public CompanyDaoImpl() {
		factory = HibernateUtils.getSessionFactory();
	}
	
	
	//新增一筆紀錄
	@Override
	public void persist(CompanyBean companyBean) {
		Session session = factory.getCurrentSession();
		session.persist(companyBean);
		log.info("儲存CompanyBean功能之Dao: 資料新增成功, CompanyBean=" + companyBean);
	}
	
	
	//新增一筆紀錄
	@Override
	public void save(CompanyBean companyBean) {
		Session session = factory.getCurrentSession();
		session.save(companyBean);
		log.info("儲存CompanyBean功能之Dao: 資料新增成功, CompanyBean=" + companyBean);
	}
	
	//判斷商家帳號是否已存在
	@Override
	public boolean existsByAccount(String account) {
		log.info("商家註冊功能之Dao: 檢查商家輸入的帳號是否已被使用");
		boolean existsByAccount = false;
		String hql = "FROM CompanyBean cb WHERE cb.company_account = :cbAccount";
		Session session = factory.getCurrentSession();
		
		try {
			session.createQuery(hql)
				   .setParameter("cbAccount", account)
				   .getSingleResult();
			
			existsByAccount = true;
		}catch(NoResultException e){
			;
		}catch (NonUniqueResultException e) {
			existsByAccount = true;
		}
		
		log.info("商家註冊功能之Dao: 檢查商家輸入的帳號是否已被使用, existsByAccount=" + existsByAccount);
		return existsByAccount;
	}

	//透過商家帳號，回傳該CompanyBean所有資料
	@Override
	public CompanyBean findByCompanyAccount(String company_account) {
		CompanyBean companyBean = null;
		String hql = "FROM CompanyBean cb WHERE cb.company_account = :cbCompany_account";
		Session session = factory.getCurrentSession();
		
		try {
			companyBean = (CompanyBean) session.createQuery(hql)
											   .setParameter("cbCompany_account", company_account)
											   .getSingleResult();
			
		} catch (NoResultException ex) {
			;
		} catch(NonUniqueResultException ex) {
			;
		}
		log.info("商家XX功能之Dao: 取得某個商家的資料, CompanyBean=" + companyBean);
		return companyBean;
	}

	//修改一筆CompanyBean資料
	@Override
	public void updateCompany(CompanyBean companyBean) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(companyBean);
	
	}

	//透過商家帳號及密碼，回傳該CompanyBean
	@Override
	public CompanyBean findByCompanyAccountAndPassword(String company_account, String password) {
		CompanyBean cb = null;
		String hql = "FROM CompanyBean cb WHERE cb.company_account = :cbCompany_account and cb.company_password = :psw";
		Session session = factory.getCurrentSession();
		List<CompanyBean> beans = session.createQuery(hql, CompanyBean.class)
										 .setParameter("cbCompany_account", company_account)
										 .setParameter("psw", password)
										 .getResultList();
		if(beans.size() > 0) {
			cb = beans.get(0);
		}
		
		log.info("商家登入功能之Dao: 檢查帳號/密碼結果:" 
				+ (cb != null ? "帳號/密碼正確" : "帳號/密碼錯誤"));
		return cb;
	}
	
	
	
	
	
	//透過商家Id，回傳該CompanyBean
	@Override
	public CompanyBean findById(Integer company_id) {
		Session session = factory.getCurrentSession();
		
		CompanyBean companyBean = session.get(CompanyBean.class, company_id);
		log.info("CompanyBean=" + companyBean);
		return companyBean;
	}

	//回傳所有商家的CompanyBean資料
	@Override
	public List<CompanyBean> findAll() {
		Session session = factory.getCurrentSession();
		List<CompanyBean> list = new ArrayList<>();
		String hql = "FROM CompanyBean";
		list = session.createQuery(hql, CompanyBean.class)
					  .getResultList();		
		log.info("回傳所有商家資料之Dao#findAll(), List<CompanyBean>=" + list); 
		return list;
	}


}