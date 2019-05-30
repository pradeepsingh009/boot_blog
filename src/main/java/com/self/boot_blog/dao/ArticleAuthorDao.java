package com.self.boot_blog.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.self.boot_blog.entity.ArticleAuthor;

@Repository
public class ArticleAuthorDao {

//	@Autowired
//	private SessionFactory sessionFactory; 
	@Autowired
	private EntityManager entityManager;
	
	public ArticleAuthor saveAuthor(ArticleAuthor author) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(author);
		
		return author;
	}
	
	public List<ArticleAuthor> getAuthors(){
//		Session currentSession = sessionFactory.getCurrentSession();
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<ArticleAuthor> query = currentSession.createQuery("from ArticleAuthor order by lname", ArticleAuthor.class);
		
		List<ArticleAuthor> resultList = query.getResultList();
		
		return resultList;
	}
}
