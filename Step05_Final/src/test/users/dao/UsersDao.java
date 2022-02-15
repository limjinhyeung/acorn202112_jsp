package test.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.users.dto.UsersDto;
import test.util.DbcpBean;

public class UsersDao {

	private static UsersDao dao;

	// 외부에서 객체 생성할수 없더록
	private UsersDao() {
	}

	// 참조값을 리턴해주는 static 메소드
	public static UsersDao getInstance() {
		if (dao == null) {
			dao = new UsersDao();
		}
		return dao;
	}
	// new UsersDao 가 아니라 UsersDao.getinstance(); 로 받아가라
	// 그러면 dao는 하나만 만들어진다. 객체가

	public boolean updatePwd(UsersDto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DbcpBean().getConn();
			String sql = "update users"
					+ " set pwd=?"
					+ " where id=? and pwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNewPwd());
			pstmt.setNString(2, dto.getId());
			pstmt.setNString(3, dto.getPwd());
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// 인자로 전달된 아이디에 해당하는 가입정보를 리턴해주는 메소드
	public UsersDto getData(String id) {
		// 회원 정보를 담을 UsersDto
		UsersDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DbcpBean().getConn();
			// select 문 작성
			String sql = "SELECT pwd,email,profile,regdate" 
					+ " FROM users" 
					+ " WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩 할게 있으면 여기서 바인딩한다.
			pstmt.setString(1, id);
			// select 문 수행하고 ResultSet 받아오기
			rs = pstmt.executeQuery();
			// while문 혹은 if문에서 ResultSet 으로 부터 data 추출
			if (rs.next()) {
				dto = new UsersDto();
				dto.setId(id);
				dto.setPwd(rs.getString("pwd"));
				dto.setEmail(rs.getString("email"));
				dto.setProfile(rs.getString("profile"));
				dto.setRegdate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return dto;
	}

	// 인자로 절달되는 dto에 있는 id,pwd가 유효한 정보인지 여부를 리턴해주는 메소드
	public boolean isValid(UsersDto dto) {
		// 맞는 정보인지 여부를 담을 지역변수를 선언하고 초기값 false지정
		// 맞는 정보이면 true가 되게 설정하기.
		boolean isValid = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// Connection 객체의 참조값 얻어오기
			conn = new DbcpBean().getConn();
			// 실행할 sql 문 준비
			String sql = "SELECT id,pwd" 
					+ " from users" 
					+ " where id=? and pwd=?";// id와pwd가 맞아야 트루가 될것이다.
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩하기
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			// query 문 수행하고 결과 받아오기
			rs = pstmt.executeQuery();
			if (rs.next()) {// 만일 select된 row가 있기만하면 되니까 출력할게 아니라 상관없다 있다면 true
				isValid = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return isValid;
	}

	// 회원 정보를 저장하는 메소드
	public boolean insert(UsersDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DbcpBean().getConn();
			// 실행할 insert, update, delete 문 구성
			String sql = "INSERT INTO users" 
					+ " (id, pwd, email, regdate)" 
					+ " VALUES(?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩할 내용이 있으면 바인딩한다.
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getEmail());
			flag = pstmt.executeUpdate(); // sql 문 실행하고 변화된 row 갯수 리턴 받기
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
}
