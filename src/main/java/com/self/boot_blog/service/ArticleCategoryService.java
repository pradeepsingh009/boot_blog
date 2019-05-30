package com.self.boot_blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.self.boot_blog.entity.ArticleCategory;
import com.self.boot_blog.dao.ArticleCategoryDao;


@Service
public class ArticleCategoryService {
	
	@Autowired
	private ArticleCategoryDao articleCategoryDao;
	
	@Transactional
	public List<ArticleCategory> getArticleCategories(){
		return articleCategoryDao.getArticleCategories();
	}
	
	@Transactional
	public ArticleCategory getArticleCategory(int catId) {
		return articleCategoryDao.getArticleCategory(catId);
	}

}
