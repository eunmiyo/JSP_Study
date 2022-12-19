package ch07.com.dao;

public class GuGuDan {
	private int dan;
	
	public String process(int dan) {
		int result =0;
		String result2 ="";
		for(int i=1; i<10; i++) {
			result = dan * i;
			result2 += dan + "*" + i + "=" + result + "</br>";
		}
		return result2;
	}

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}
}
