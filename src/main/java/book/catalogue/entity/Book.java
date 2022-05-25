package book.catalogue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(name = "book_Name", nullable = false)
	public String bookName;
	
	@Column(name = "isbn_Number")
	public String isbnNumber;
	
	@Column(name = "publish_Date")
	public String publishDate;
	
	@Column(name = "price")
	public double price;
	
	@Column(name = "type")
	public String type;
	
	public Book() {
		
	}
	
	public Book(String bookName, String isbnNumber, String publishDate, double price, String type) {
		super();
		this.bookName = bookName;
		this.isbnNumber = isbnNumber;
		this.publishDate = publishDate;
		this.price = price;
		this.type = type;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getbookName() {
		return bookName;
	}
	public void setbookName(String bookName) {
		this.bookName = bookName;
	}
	public String getisbnNumber() {
		return isbnNumber;
	}
	public void setisbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	public String getpublishDate() {
		return publishDate;
	}
	public void setpublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
