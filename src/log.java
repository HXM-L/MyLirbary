import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bean.BuyBook;

public class log {
	/*
	 * 1.servlet�İ�Ҫ��
	 * 2.web.xml������Ҫд
	 * 3.�������Զ����ɵ�getset����Ҫ����
	 * 4.el�����Ҫ��
	 	* ��Ҫע����ǣ�EL���ʽ���������.�����������������������ֶΣ�����GET/SET������ȥ��ǰ׺�����֡�
		*���磺getName(),ȡ����ʱӦ��ʹ��name,�ҵ�һ����ĸ��ҪСд��
	*5.���commit and Push��ʾ�������ӵ�Can't connect to any repository: https://github.com/HXM-L/MyLirbʱ,�п����Ƿ��ʲ���github,������cmd����pingһ��
	*����:ping github.com
	*JSP���ĸ������� ��page��request��session��application������
		1.pageָ��ǰҳ����Ч����һ��jspҳ������Ч
		2.request ָ��һ�������ȫ��������Ч������http���󵽷��������������������Ӧ���������̣������HttpServletRequest�����С�����������п���ʹ��forward��ʽ��ת���jsp������Щҳ�����㶼����ʹ�����������
		3.Session���û�ȫ�ֱ������������Ự�ڼ䶼��Ч��ֻҪҳ�治�رվ�һֱ��Ч������ֱ���û�һֱδ����»Ự���ڣ�Ĭ��session����ʱ��Ϊ30���ӣ������HttpSession��invalidate()�������������HttpSession������ 
		4.application�ǳ���ȫ�ֱ�������ÿ���û�ÿ��ҳ�涼��Ч�������ServletContext�����С����Ĵ��ʱ������ģ�����������ֹ�ɾ�������Ǿ�һֱ����ʹ�� 
		5.form�����Զ�ˢ��
	
	 * 
	 * eclipse�ĸ�ʽ����ݼ�������,��ʱ�������������﷨����,�������߼�����
	 * eclipse���л�ѡ��Ŀ�ݼ�һ�㶼������
	 * */
	
	/*���⣺
	 * �޸Ĵ���float�������͵ļ�¼��ʱ�����
	 * java��updateSQL server�� float����������ʾ���������� nvarchar ת��Ϊ float ʱ����
	 * ����취:
	 * ǿ��תΪfloat����
	 * @Override
		public boolean modifyBuyBook(BuyBook buyBook) {
			String sql = "update buybook set bookName=?,price=?,num=?,selfId=?,buyDate=?,sum=? where buyBookId = ?";
			List<Object> lp = new ArrayList<Object>();
			DecimalFormat decimalFormat = new DecimalFormat(".00");	//������λС��
			lp.add(buyBook.getBookName());
			lp.add(decimalFormat.format((float)buyBook.getPrice()));
			lp.add(buyBook.getNum());
			lp.add(buyBook.getSelfId());
			lp.add(buyBook.getBuyDate());
			lp.add(decimalFormat.format((float)buyBook.getSum()));
			lp.add(buyBook.getBuyBookId());
			return this.upadte(sql, lp);
		}
	 * */
	/*
	 * �б��:���ݱ�bookType��tyteID��ΪtypeID
	 * Reserve.java���bookName����
	 * 
	 * */
}
