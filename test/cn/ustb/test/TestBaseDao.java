package cn.ustb.test;

import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ustb.oa.domain.Book;
import cn.ustb.oa.service.IBookService;

public class TestBaseDao {

	/*
	 * 测试findAll操作
	 */
	@Test
	public void test6() {
		//初始化spring
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService = (IBookService) ctx.getBean("bookServiceImpl");
		
		List<Book> booklist = bookService.findAll();
		for(Book book : booklist) {
			System.out.println(book);
		}
	}
	
	
	/*
	 * 测试getById操作------别忘了加@Test
	 */
	@Test
	public void test4() {
		//初始化spring
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService = (IBookService) ctx.getBean("bookServiceImpl");
		
		Long[] ids = new Long[]{2L,3L,4L};
		List<Book> booklist = bookService.getByIds(ids);
		for(Book book : booklist) {
			System.out.println(book);
		}
		
	}
	
	
	/*
	 * 测试update操作-----别忘了加@Test!!!
	 */
	@Test
	public void test3() {
		//初始化spring
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService = (IBookService) ctx.getBean("bookServiceImpl");
		
		Book book = new Book();
		book.setId(2L);
		book.setName("c#");
		
		bookService.update(book);
		
	}
	
	
	/*
	 * 测试delete操作
	 */
	@Test
	public void test2() {
		//初始化spring
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService = (IBookService) ctx.getBean("bookServiceImpl");
		
		bookService.delete(7L);	//删除id为6的记录，注意L说明是Long型
	}
	
	
	
	/*
	 * 测试save操作
	 */
	@Test
	public void test1() {
		//初始化spring
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService = (IBookService) ctx.getBean("bookServiceImpl");
		
		Book book = new Book();
		book.setName("c++");
		
		bookService.save(book);
		
	}
	
	
	
}
