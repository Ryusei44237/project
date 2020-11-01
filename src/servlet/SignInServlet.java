package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		/*登録内容を確認する--Daoへデータを転送しテーブルへ登録する*/
		String acountName=request.getParameter("AcountName");
		String acountId=request.getParameter("AcountId");
		String acountEmail=request.getParameter("AcountEmail");
		String acountYear=request.getParameter("AcountYear");
		String acountMonth=request.getParameter("AcountMonth");
		String acountDay=request.getParameter("AcountDay");
		String acountPass=request.getParameter("password");
		String acountTell=request.getParameter("AcountTell");
		System.out.println(acountName+"|"+acountId+"|"+acountEmail+"|"+acountYear+"|"+acountMonth+"|"+acountDay+"|"+acountPass+"|"+acountTell);

		System.out.println("login.jspへ遷移します");
		/*ここにlogin.jspへの遷移コードを書く｛login.jsp｝*/
		String view = "login.jsp";
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
