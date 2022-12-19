package ch08;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/pcontrol") //ProductController 실행창!
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService service;
	
    /* 오버라이딩 할 때 init(ServletConfig) 선택 */
	// service를 실행하기 위해 최초 한번 실행이 되고  그 이후는 service를 이용해 공유함
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//서블릿이 초기화 될 때 ProductService객체를 생성
		service = new ProductService();
	}

    //클라이언트에서 request가 오면 service가 실행된다.
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); //action파라메터의 값을 얻어온다.
		String view = "";
		
		if(action == null) {
			getServletContext().getRequestDispatcher("/pcontrol?action=list").forward(request, response);
		} else {
			switch(action) {
			case "list" : view = list(request, response);
			break;
			case "info" : view = info(request, response);
			break;
			}
			
			// "/ch08/"경로에 있는 (List, Info)jsp파일을 사용자에게 화면으로 제공하면서 요청값과 나한테 저장되어있는 응답값을 넘겨줌
			getServletContext().getRequestDispatcher("/ch08/" + view).forward(request, response);
		}
	}

	//productList에서
	//<td><a href="/jsp_study/pcontrol?action=info&id=${p.id}">${p.name}</a></td>
	//id=${p.id}를 이용해 info메소드 실행
	private String info(HttpServletRequest request, HttpServletResponse response) {
		//한가지 상품만 가져온다.
		Product p = service.find(request.getParameter("id"));
		request.setAttribute("p", p);
		return "productInfo.jsp";
	}
	
	private String list(HttpServletRequest request, HttpServletResponse response) {
		//모든 상품을 가져온다.
		List<Product> plist = service.findAll();
		request.setAttribute("products", plist);
		return "productList.jsp";
	}

}
