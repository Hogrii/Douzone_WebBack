package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.dto.EmpDTO;
import kr.or.kosa.utils.SingletonHelper;

public class EmpDAO {	
	// 전체 조회
	public List<EmpDTO> getSelectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<EmpDTO> empList = new ArrayList<EmpDTO>();
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select empno, ename, job, sal, hiredate from emp";
			System.out.println(conn);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					EmpDTO edto = new EmpDTO();
					edto.setEmpno(rs.getInt(1));
					edto.setEname(rs.getString(2));
					edto.setJob(rs.getString(3));
					edto.setSal(rs.getInt(4));
					edto.setHiredate(rs.getDate(5));
					empList.add(edto);
				}while(rs.next());
			}else {
				System.out.println("조회된 데이터가 없습니다.");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}		
		return empList;
	}
}
