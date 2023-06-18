package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import dto.Member;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(final Member member) { //회원 추가
		KeyHolder keyHolder= new GeneratedKeyHolder();
		jdbcTemplate.update(
				new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) 
						throws SQLException{
						PreparedStatement pstmt= con.prepareStatement(
								"INSERT into MEMBER (userName, userId, password, position) values (?, ?, ?, ?)",
								new String[] {"ID"});
						pstmt.setString(1,  member.getUserName());
						pstmt.setString(2,  member.getUserId());
						pstmt.setString(3,  member.getPassword());
						pstmt.setString(3,  member.getPosition());
						return pstmt;
						}
					}, keyHolder);
		}
	
	public Member selectByUserId(String userId) { //회원 아이디 검색
		String sql = "SELECT * FROM MEMBER WHERE UserId = ?";
		
		List<Member> result = jdbcTemplate.query(sql, (rs, rowNum) -> mapMember(rs), userId);
		
		return result.isEmpty() ? null : result.get(0);
	}
	
	public Member selectByUserName(String userName) { //회원 이름 검색
		String sql = "SELECT * FROM PRODUCT WHERE userName = ?";
		
		List<Member> result = jdbcTemplate.query(sql, (rs, rowNum) -> mapMember(rs), userName);
		
		return result.isEmpty() ? null : result.get(0);
	}
	
	public List<Member> selectAllMembers(){
		String sql = "SELECT * FROM  Member";
		
		List<Member> result = jdbcTemplate.query(sql, (rs, rowNum) -> mapMember(rs));
		
		return result;
	}
	
	public void deleteMember(int memberId) { //회원 삭제
		String sql = "DELETE FROM Orders WHERE memberId = ?";
		
		jdbcTemplate.update(sql, memberId);
	}
	
	private Member mapMember(ResultSet rs) throws SQLException {
	    String userName = rs.getString("userName");
	    String userId = rs.getString("userId");
	    String password = rs.getString("password");
	    String position = rs.getString("position");
	    
	    Member member = new Member(userName, userId, password, position);
	    return member;
	}
}
