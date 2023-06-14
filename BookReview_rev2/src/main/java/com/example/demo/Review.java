package com.example.demo;

public class Review{
	public int id;
	public String title;
	public String author;
	public String body;
	public String image_name;
//	public DateTime created_at;
	
	public Review(int id, String title, String author, String body, String image_name){
		this.id = id;
		this.title = title;
		this.author = author;
		this.body = body;
		this.image_name = image_name;
	}
}