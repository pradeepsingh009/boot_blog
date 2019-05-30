package com.self.boot_blog.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.self.boot_blog.entity.ArticleAuthor;
import com.self.boot_blog.service.ArticleAuthorService;

@RestController
@RequestMapping("/api")
public class AuthorController {

	@Autowired
	private ArticleAuthorService articleAuthorService;
	
	@GetMapping("/authors")
	public List<ArticleAuthor> getAuthors(){
		return this.articleAuthorService.getAuthors();
	}
	
	@PostMapping("/authors")
	public ArticleAuthor addAuthor(@RequestBody ArticleAuthor author) {
		author.setId(0);
		this.articleAuthorService.saveAuthor(author);
		return author;
	}
	
	@PutMapping("/authors")
	public ArticleAuthor updateAuthor(@RequestBody ArticleAuthor author) {
		this.articleAuthorService.saveAuthor(author);
		return author;		
	}
}
