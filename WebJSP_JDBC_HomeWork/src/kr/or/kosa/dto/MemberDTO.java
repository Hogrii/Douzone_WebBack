package kr.or.kosa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	private String id;
	private String pwd;
	private String name;
	private int age;
	private char gender;
	private String email;
	private String ip;
}