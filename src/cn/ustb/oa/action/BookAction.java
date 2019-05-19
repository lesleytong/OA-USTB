package cn.ustb.oa.action;

import java.util.List;

import org.springframework.stereotype.Controller;

import cn.ustb.oa.base.BaseAction;
import cn.ustb.oa.domain.Book;

@Controller
public class BookAction extends BaseAction<Book>{
	public String execute() throws Exception {
		System.out.println(model);
		
		bookService.save(model);

		List<Book> booklist = bookService.findAll();
		for(Book book : booklist) {
			System.out.println(book);
		}
		
		return NONE;
	}
}
