package action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookType;
import dao.BookTypeDao;
import dao.impl.BookTypeDaoImpl;
import framework.Action;

public class BookTypeAddAction implements Action {	//���ͼ������

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		BookTypeDao typeDao=new BookTypeDaoImpl();
		BookType bookType=new BookType();
		List<BookType> typeList=typeDao.findAllType();
		boolean flag=false;
		bookType.setTypeId(Integer.parseInt(req.getParameter("typeid")));
		try {
			bookType.setName(new String(req.getParameter("typename").getBytes("iso-8859-1"), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(typeList.get(0).getName());
		req.getSession().setAttribute("typeList", typeList);
		for(BookType item:typeList) {
			if(item.getTypeId()==Integer.parseInt(req.getParameter("typeid"))) {
				flag=true;
				break;
			}
		}
		if(flag) {
			req.setAttribute("updateFlag", "������ֵ�Ѵ���,����������");
		}else {
			if(typeDao.doBookType(bookType)) {
				req.setAttribute("updateFlag", "ͼ��������ӳɹ�");
			}else {
				req.setAttribute("updateFlag", "ͼ���������ʧ��");
			}
		}
		return "editBookType.jsp";
	}

}
