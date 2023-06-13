package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BookReviewController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * ホーム画面表示
	 * 
	 * @param model モデル
	 * @return ホーム画面
	 */
	@GetMapping("/index")
	public String index(Model model) {
		List<Map<String, Object>> records = jdbcTemplate
				.queryForList("SELECT id, title, author, body, image_name FROM reviews");
		List<Review> reviews = new ArrayList();
		for (Map<String, Object> record : records) {
			reviews.add(
					new Review(
							(int) record.get("id"),
							(String) record.get("title"),
							(String) record.get("author"),
							(String) record.get("body"),
							(String) record.get("image_name")));
		}
		model.addAttribute("Reviews", reviews);
		return "index";
	}

	/**
	 * 書評登録画面表示
	 * 
	 * @param boardForm つぶやきフォーム
	 * @param model     モデル
	 * @return つぶやき登録画面
	 */
	@GetMapping("/new")
	public String create(Model model) {
		// つぶやき登録画面呼び出し
		return "new";
	}
}
