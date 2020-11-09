package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.account;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
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
				//生年月日は個別で得たものを合体させbirthdayとして登録する
				String year = request.getParameter("AcountYear");
				String month = request.getParameter("AcountMonth");
				String day = request.getParameter("AcountDay");
				String birthday=year+month+day;
				String tell=request.getParameter("tell");
				String token=request.getParameter("token");
				String create_at=request.getParameter("create_at");
				String update_at=request.getParameter("update_at");
				System.out.println(id+"|"+name+"|"+mail+"|"+password+"|"+birthday+"|"+tell+"|"+token+"|"+create_at+"|"+update_at);
				//Daoから値を引っ張ってきた
				account s = new account(id,name,mail,password,birthday,tell,token,create_at,update_at);
				account result = dao.AccountDao.InsertPost(s);
		System.out.println("login.jspへ遷移します");
		/*ここにlogin.jspへの遷移コードを書く｛login.jsp｝*/
		String view = "/WEB-INF/view/login.jsp";
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
