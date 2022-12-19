package ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		
		System.out.println("아이디: " + id + " , " + "비밀번호: " + pw);
		
		String result = "";
		
		if(id.equals("person") && pw.equals("1234")) {
			result = id + "님 반갑습니다.";
			//System.out.println(id + "님 반갑습니다.");
		} else {
			result = "로그인실패";
			//System.out.println("로그인실패");
		}
		
//		if(id.equals("person") && pw.equals("1234")) {
//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
//			out.append("<!doctype html><html><head><title>LoginForm Servlet</title></head><body>")
//			.append("<h2>로그인 서블릿</h2>")
//			.append(id + "님 반갑습니다. </body></html>");
//		} else {
//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
//			out.append("<!doctype html><html><head><title>LoginForm Servlet</title></head><body>")
//			.append("<h2>로그인 서블릿</h2>")
//			.append("로그인 실패 </body></html>");
//		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append("<!doctype html><html><head><title>LoginForm Servlet</title></head><body>")
		.append("<h2>로그인 서블릿</h2>")
		.append(result + "</body></html>");
		//.append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
