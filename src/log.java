import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bean.BuyBook;

public class log {
	/*
	 * 1.servlet的包要建
	 * 2.web.xml的配置要写
	 * 3.编译器自动生成的getset方法要看清
	 * 4.el表达是要会
	 	* 需要注意的是：EL表达式点运算符（.）后面跟的属性名不是类的字段，而是GET/SET访问器去掉前缀的名字。
		*比如：getName(),取属性时应当使用name,且第一个字母需要小写。
	*5.点击commit and Push提示不能连接到Can't connect to any repository: https://github.com/HXM-L/MyLirb时,有可能是访问不了github,可以在cmd窗口ping一下
	*输入:ping github.com
	*JSP的四个作用域 ：page、request、session和application的区别
		1.page指当前页面有效。在一个jsp页面里有效
		2.request 指在一次请求的全过程中有效，即从http请求到服务器处理结束，返回响应的整个过程，存放在HttpServletRequest对象中。在这个过程中可以使用forward方式跳转多个jsp。在这些页面里你都可以使用这个变量。
		3.Session是用户全局变量，在整个会话期间都有效。只要页面不关闭就一直有效（或者直到用户一直未活动导致会话过期，默认session过期时间为30分钟，或调用HttpSession的invalidate()方法）。存放在HttpSession对象中 
		4.application是程序全局变量，对每个用户每个页面都有效。存放在ServletContext对象中。它的存活时间是最长的，如果不进行手工删除，它们就一直可以使用 
		5.form表单会自动刷新
	
	 * 
	 * eclipse的格式化快捷键不好用,有时候会引发代码的语法错误,和其他逻辑错误
	 * eclipse的切换选项卡的快捷键一点都不方便
	 * */
	
	/*问题：
	 * 修改带有float数据类型的记录的时候出现
	 * java的updateSQL server的 float类型数据提示从数据类型 nvarchar 转换为 float 时出错。
	 * 解决办法:
	 * 强制转为float类型
	 * @Override
		public boolean modifyBuyBook(BuyBook buyBook) {
			String sql = "update buybook set bookName=?,price=?,num=?,selfId=?,buyDate=?,sum=? where buyBookId = ?";
			List<Object> lp = new ArrayList<Object>();
			DecimalFormat decimalFormat = new DecimalFormat(".00");	//保留两位小数
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
	 * 有变更:数据表bookType的tyteID改为typeID
	 * Reserve.java添加bookName属性
	 * 
	 * */
}
