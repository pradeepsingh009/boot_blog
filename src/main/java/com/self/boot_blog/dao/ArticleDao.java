package com.self.boot_blog.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.self.boot_blog.entity.Article;

@Repository
public class ArticleDao {

//	@Autowired
//	private SessionFactory sessionFactory; 
	@Autowired
	private EntityManager entityManager;
	
	public List<Article> getArticles(){
//		Session currentSession = this.sessionFactory.getCurrentSession();
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Article> query = currentSession.createQuery("from Article order by title", Article.class);
		
		List<Article> articles = query.getResultList();
		
		return articles;
		
	}
	
	public Article saveArticle(Article article) {
//		Session currentSession = this.sessionFactory.getCurrentSession();
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(article);
		return article;
	}
}
