package demo;

import org.junit.Test;

import bean.Book;
import bean.Self;
import dao.AdminDao;
import dao.BookDao;
import dao.BorrowerDao;
import dao.SelfDao;
import dao.impl.AdminDaoImpl;
import dao.impl.BookDaoImpl;
import dao.impl.BorrowerDaoImpl;
import dao.impl.SelfDaoImpl;

public class Demo {
	AdminDao adminDao=new AdminDaoImpl();
	BookDao bookDao=new BookDaoImpl();
	BorrowerDao borrowerDao=new BorrowerDaoImpl();
	SelfDao selfDao=new SelfDaoImpl();
	
	@Test
	public void test01() {
		System.out.println(adminDao.findAdmin(001, "123456").getName());
	}
	@Test
	public void test02() {
		System.out.println(borrowerDao.findBorrower("2021032", "123456", 3).getName());
	}
	@Test
	public void test03() {
		System.out.println(selfDao.findBookBySelfId("01-02-A-05").getBookname());
	}
	@Test
	public void test04() {
		System.out.println(selfDao.doSelf(new Self("01-03-B-06","童年","高尔基","2020.01",60,1,"F:","啦啦啦啦啦啦啦啦绿","清华大学出版社", null)));
		System.out.println(bookDao.doBook(new Book("A-2","01-03-B-06","1")));
	}
	@Test
	public void test05() {
		System.out.println(selfDao.deleteSelf("01-03-B-06"));
	}
	@Test
	public void test06() {
		System.out.println(bookDao.deleteBook("01-03-B-06"));
	}
}
