package com.self.boot_blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.self.boot_blog.entity.Article;
import com.self.boot_blog.dao.ArticleDao;

@Service
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Transactional
	public List<Article> getArticles() {
		return this.articleDao.getArticles();
	}
	
	@Transactional
	public Article saveArticle(Article article) {
		this.articleDao.saveArticle(article);
		return article;
	}
}
