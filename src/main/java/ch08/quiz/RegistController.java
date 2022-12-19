package ch08.quiz;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistController
 */
@WebServlet("/rcontrol")
public class RegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegistService service;
	
       
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = new RegistService();
	}
    

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String view = "";
		
		if(action == null) {
			getServletContext().getRequestDispatcher("/rcontrol?action=list").forward(request, response);
		} else {
			switch(action) {
			case "list" : view = list(request, response);
			break;
			case "info" : view = info(request, response);
			break;
			case "confirm" :view = confirm(request, response);
			break;
			}
			
			// "/ch08_quiz/"경로에 있는 (List, Info)jsp파일을 사용자에게 화면으로 제공하면서 요청값과 나한테 저장되어있는 응답값을 넘겨줌
			getServletContext().getRequestDispatcher("/ch08_quiz/" + view).forward(request, response);
		}
	}
	
	private String list(HttpServletRequest request, HttpServletResponse response) {
		List<Regist> rlist = service.findAll();
		request.setAttribute("regists", rlist);
		return "registList.jsp";
	}
	
	private String info(HttpServletRequest request, HttpServletResponse response) {
		Regist r = service.find(request.getParameter("id"));
		request.setAttribute("r", r);
		return "registInfo.jsp";
	}
	
	private String confirm(HttpServletRequest request, HttpServletResponse response) {
		List<Regist> rlist = service.findAll();
		request.setAttribute("regists", rlist);
		return "registConfirm.jsp";
	}

}
