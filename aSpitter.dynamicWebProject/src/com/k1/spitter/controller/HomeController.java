package com.k1.spitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//add controller annotation to help spring find controller
@Controller
public class HomeController {

	// add requestMapping to give link for our method
	// @RequestMapping("/list") - work for all HTTP request methods

	// usual choice
	// GET method - good for debaging, bookmarks,email url
	// limitation on data length near 1000 signs
	// @RequestMapping(path-"/list". method=RequestMethod.GET)
	// same as
	// GetMapping("/list")

	// choice for passwords and files
	// POST method - bad for bookmarks, no limits on data length,
	// also can send binary data(like when u need to save file)
	// @RequestMapping(path-"/list". method=RequestMethod.POST)
	// same as
	// PostMapping("/list")
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}

}

// 1. HQL Select Query Example
// Retrieve a stock data where stock code is 7277.
//
// Query query = session.createQuery("from Stock where stockCode = :code ");
// query.setParameter("code", "7277");
// List list = query.list();
// Query query = session.createQuery("from Stock where stockCode = '7277' ");
// List list = query.list();
// 2. HQL Update Query Example
// Update a stock name to DIALOG1 where stock code is 7277.
//
// Query query = session.createQuery("update Stock set stockName = :stockName" +
// " where stockCode = :stockCode");
// query.setParameter("stockName", "DIALOG1");
// query.setParameter("stockCode", "7277");
// int result = query.executeUpdate();
// Query query = session.createQuery("update Stock set stockName = 'DIALOG2'" +
// " where stockCode = '7277'");
// int result = query.executeUpdate();
// 3. HQL Delete Query Example
// Delete a stock where stock code is 7277.
//
// Query query = session.createQuery("delete Stock where stockCode =
// :stockCode");
// query.setParameter("stockCode", "7277");
// int result = query.executeUpdate();
// Query query = session.createQuery("delete Stock where stockCode = '7277'");
// int result = query.executeUpdate();
// 4. HQL Insert Query Example
// In HQL, only the INSERT INTO  SELECT  is supported; there is no INSERT INTO
//  VALUES. HQL only support insert from another table. For example
//
// "insert into Object (id, name) select oo.id, oo.name from OtherObject oo";
// Insert a stock record from another backup_stock table. This can also called
// bulk-insert statement.
//
// Query query = session.createQuery("insert into Stock(stock_code, stock_name)"
// +
// "select stock_code, stock_name from backup_stock");
// int result = query.executeUpdate();
// The query.executeUpdate() will return how many number of record has been
// inserted, updated or deleted.
