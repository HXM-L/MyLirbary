package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookType;
import dao.BookTypeDao;
import dao.impl.BookTypeDaoImpl;
import framework.Action;

public class BookTypeAddAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		BookTypeDao typeDao=new BookTypeDaoImpl();
		List<BookType> typeList=typeDao.findAllType();
		System.out.println(typeList.get(0).getName());
		req.getSession().setAttribute("typeList", typeList);
		return "editBookType.jsp";
	}

}
