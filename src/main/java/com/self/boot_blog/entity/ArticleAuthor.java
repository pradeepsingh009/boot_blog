package com.self.boot_blog.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="article_author")
@JsonPropertyOrder({"id","fName","lName"})
public class ArticleAuthor {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="fname")
	private String fName;
	
	@Column(name="lname")
	private String lName;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="address_id")
	private ArticleAuthorAddress address;
	
	@OneToMany(mappedBy="author",cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Article> articles;
	
	public ArticleAuthor() {
		
	}
	
	public ArticleAuthor(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public ArticleAuthorAddress getAddress() {
		return address;
	}

	public void setAddress(ArticleAuthorAddress address) {
		this.address = address;
	}

	@JsonIgnore
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "ArticleAuthor [fName=" + fName + ", lName=" + lName + "]";
	}
	
}
