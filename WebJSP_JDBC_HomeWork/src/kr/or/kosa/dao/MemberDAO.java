package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.dto.MemberDTO;
import kr.or.kosa.utils.ConnectionHelper;

public class MemberDAO {
	// 로그인
	public int loginMember(String id, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select pwd from koreamember where id = ?";

		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("pwd").equals(pwd)) {
					return 1;
				} else {
					return 2;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return 3;
	}
	
	// 회원리스트 조회
	public List<MemberDTO> listMember() {
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select id, ip from koreamember";
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString(1));
				dto.setIp(rs.getString(2));
				
				memberList.add(dto);
			}
		}catch(Exception e) {
			
		}finally {
			
		}
		
		return memberList;
	}

	// 업데이트 페이지
	public MemberDTO updatePage(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO dto = new MemberDTO();

		String sql = "select id, pwd, name, age, trim(gender), email from koreamember where id = ?";

		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setId(rs.getString(1));
				dto.setPwd(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dto.setGender(rs.getString(5));
				dto.setEmail(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return dto;
	}

	// 상세정보 페이지
	public MemberDTO detailMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO dto = new MemberDTO();

		String sql = "select id, pwd, name, age, gender, email from koreamember where id = ?";
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setId(rs.getString(1));
				dto.setPwd(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dto.setGender(rs.getString(5));
				dto.setEmail(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return dto;
	}

	// 수정
	public void updateMember(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update koreamember set name = ?, age = ?, gender = ?, email = ? where id = ?";

		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, String.valueOf(dto.getGender()));
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getId());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

	// 삽입
	public void joinMember(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into koreaMember(id, pwd, name, age, gender, email, ip) values(?,?,?,?,?,?,?)";

		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setInt(4, dto.getAge());
			pstmt.setString(5, String.valueOf(dto.getGender()));
			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getIp());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

	// 삭제
	public void deleteMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from koreamember where id=?";

		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

	// 검색
	public List<MemberDTO> searchByMemberName(String search) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		String sql = "select id, name, email from koreamember where name like ?";

		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + search + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setEmail(rs.getString(3));
				
				memberList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return memberList;
	}
}
