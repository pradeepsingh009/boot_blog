package com.self.boot_blog.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.self.boot_blog.entity.ArticleCategory;

@Repository
public class ArticleCategoryDao {
	
//	@Autowired
//	private SessionFactory sessionFactory; 
	@Autowired
	private EntityManager entityManager;
	
	public List<ArticleCategory> getArticleCategories() {
	
//		Session currentSession  = sessionFactory.getCurrentSession();
		Session currentSession = entityManager.unwrap(Session.class);

		
		Query<ArticleCategory> query = currentSession.createQuery(" from ArticleCategory order by name ",ArticleCategory.class);
		
		List<ArticleCategory> resultset = query.getResultList();
		
		return resultset;
	}
	
	public ArticleCategory getArticleCategory(int catId) {
//		Session currentSession = sessionFactory.getCurrentSession();
		Session currentSession = entityManager.unwrap(Session.class);

		
		ArticleCategory cat = currentSession.get(ArticleCategory.class, catId);
		
		return cat;
	}

}
