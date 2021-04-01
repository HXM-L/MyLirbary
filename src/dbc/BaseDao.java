package dbc;

import java.sql.Connection;
import java.lang.reflect.Field;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
/*
 * 数据库的连接与关闭
 * */
	public Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=mylibrary","sa", "HXM13411756");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public void closeConn(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean upadte(String sql,List<Object> lp) {
		boolean isFlag=false;
		BaseDao bs=new BaseDao();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=getConnection();
		if(conn!=null) {
			try {
				pstmt=conn.prepareStatement(sql);
				if(lp.size()>0) {
					for(int i=0;i<lp.size();i++) {
						pstmt.setObject(i+1, lp.get(i));
					}
				}
				int num=pstmt.executeUpdate();
				if(num>0) {
					isFlag=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				bs.closeConn(conn, pstmt, rs);
			}
		}
		return isFlag;
	}
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	public <T>List<T> query(String sql,List<Object> lp,Class clazz){
		/*
		 * 通用的查询方法
		 * */
		List<T> list=new ArrayList<T>();
		BaseDao bs=new BaseDao();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=getConnection();
		if(conn!=null) {
			try {
				pstmt=conn.prepareStatement(sql);
				if(lp.size()>0) {
					for(int i=0;i<lp.size();i++) {
						pstmt.setObject(i+1,lp.get(i));
					}
				}
				rs=pstmt.executeQuery();
				ResultSetMetaData rm=rs.getMetaData();
				int num=rm.getColumnCount();
				while(rs.next()) {
					Object obj=clazz.newInstance();
					for(int i=1;i<=num;i++) {
						String name=rm.getColumnName(i);//拿到列的名称
						Field f=clazz.getDeclaredField(name);
						Object o=rs.getObject(i);
						f.setAccessible(true);
						f.set(obj,o);
					}
					list.add((T)obj);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				bs.closeConn(conn, pstmt, rs);
			}
			
		}
		return list;
	}
}
