package com.qrot.bookstore.reception.model;

/**
 * 购物车实体类
 * 
 * @author TanZhiHua 2018年8月4日09点01分
 */
public class Cart {

	int userId;
	int bookId;
	int quantity;
	String bookName;
	String bookCover;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

<<<<<<< HEAD
=======
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

<<<<<<< HEAD
>>>>>>> parent of 71117d8... Revert "Merge branch 'master' of https://github.com/Qrot/bookstore"
=======
>>>>>>> parent of 71117d8... Revert "Merge branch 'master' of https://github.com/Qrot/bookstore"
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookCover() {
		return bookCover;
	}

	public void setBookCover(String bookCover) {
		this.bookCover = bookCover;
	}

}
