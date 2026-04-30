package beans;
import java.util.*; 
public class Book {
	int id;
	String bookName;
	String author;
	int price;
	List<Book> data;
	public Book() {
		data=new ArrayList<>();
		data.add(new Book(1,"Java Programming","Mary",500));
		data.add(new Book(2,"C++ Programming","Mary",600));
		data.add(new Book(3,"Python Programming","Mary",300));
	}

	public Book(int id, String bookName, String author, int price) {
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
    public List<Book> addBookList(Book b){
    	    data.add(b);
    	    return data;
    }
    
    public List<Book> getData(){
    	    return data;
    }

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + ", price=" + price + "]";
	}
    
    
}
