package test.util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbcpBean {
	private Connection conn;
	
	//생성자
	public DbcpBean() {
		try {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		//DB 연결객체인 connection 객체의 참조값 얻기 
		conn = ds.getConnection();
		System.out.println("Oracle DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	public Connection getConn() {
		return conn;
	};
}
