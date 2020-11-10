package manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//挿入したい値をjsp空引っ張ってきた
		String id = request.getParameter("id");
		String name=request.getParameter("name");
		String mail=request.getParameter("mail");
		String password=request.getParameter("password");
		String birthday=request.getParameter("birthday");
		String tell=request.getParameter("tell");
		String token=request.getParameter("token");
		String create_at=request.getParameter("create_at");
		String update_at=request.getParameter("update_at");
		System.out.println(id+"|"+name+"|"+mail+"|"+password+"|"+birthday+"|"+tell+"|"+token+"|"+create_at+"|"+update_at);
		//Daoから値を引っ張ってきた
		manager s = new manager(id,name,mail,password,birthday,tell,token,create_at,update_at);
		manager result = ManagerDao.InsertPost(s);


		//取得した値をリクエストスコープへ保存
		request.setAttribute("Manager", result);

		String view = "/WEB-INF/view/manager.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
