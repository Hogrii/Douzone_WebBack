package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.dto.MemoDTO;
import kr.or.kosa.utils.SingletonHelper;

public class MemoDAO {
	Connection conn = null;

	public MemoDAO() {
		conn = SingletonHelper.getConnection("oracle");
	}

	// 전체 조회
	public List<MemoDTO> getMemoList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemoDTO> memoList = new ArrayList<MemoDTO>();

		try {
			String sql = "select id, email, content from memo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("asdf");
				MemoDTO mdto = new MemoDTO();
				mdto.setId(rs.getString(1));
				mdto.setEmail(rs.getString(2));
				mdto.setContent(rs.getString(3));
				memoList.add(mdto);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		return memoList;
	}

	// 삽입
	// public int insertMemo(String id, String email , String content) parameter 객체
	// ...
	public int insertMemo(MemoDTO m) {

		System.out.println(m.toString());
		int resultrow = 0;

		PreparedStatement pstmt = null;
		String sql = "insert into memo(id,email,content) values(?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getContent());

			resultrow = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SingletonHelper.close(pstmt);
		}

		return resultrow;
	}

	// ID 유무 함수
	public String isCheckById(String id) {
		String ismemoid = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select id from memo where id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 같은 ID 존재
				ismemoid = "false";
			} else {
				// 사용가능한 ID
				ismemoid = "true";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		return ismemoid;
	}
}
