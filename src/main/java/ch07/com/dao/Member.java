package ch07.com.dao;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

public class Member {
	private String email;
	private String phone;
	
//	 Pattern pattern1 = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
//	 Pattern pattern2 = Pattern.compile("(02\010)-\\d{3,4}-\\d{4}");
	
	static String pattern1 = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
	static String pattern2 = "(02|010)-\\d{3,4}-\\d{4}";
	
	public String result() {
		String answer = "";
		
//		Matcher matcher = pattern1.matcher(email);
//		Matcher matcher2 = pattern2.matcher(phone);
		
//		boolean a = email.matches(pattern1);
//		boolean b = phone.matches(pattern2);
		
		if(email.matches(pattern1) && phone.matches(pattern2)) {
			answer = "환영합니다.";
		} else {
			answer = "유효성 검사에 통과하지 못했습니다.";
		}
		
		return answer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
