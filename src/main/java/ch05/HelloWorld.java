package ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 * @WebServlet: 현재 클래스가 서블릿 클래스라는걸 알리기 위해 사용
 * "/hello": URLpatterns -> URL경로, 어떤 요청에 의해 서블릿을 호출할 것인지 결정, url mapping 
 */
@WebServlet("/hello")
public class HelloWorld extends HttpServlet { //상속
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() { //생성자
        super(); //부모생성자를 호출
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * doGet(): HTTP GET 요청을 처리하기 위한 메소드
	 * request, response: doGet(), doPost() 메소드에서 파라미터로 사용
	 * 서블릿컨테이너가 클라이언트 요청과 응답을 처리할 수 있도록 서블릿에 제공되는 객체
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append("<!doctype html><html><head><title>Hello World Servlet</title></head><body>")
		.append("<h2>Hello World !!</h2><hr>")
		.append("현재 날짜와 시간은: "+java.time.LocalDateTime.now())
		.append("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * doPost(): HTTP POST요청을 처리하기 위한 메소드
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
