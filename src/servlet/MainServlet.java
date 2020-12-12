package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.account;
import dao.AccountDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String View;
	private static int count=0;
	private static String name;
	private static String pass;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String value = request.getParameter("value");
		//ログイン時に受け取る情報
		name=request.getParameter("name");
		pass=request.getParameter("password");
		//login(name,pass);
		Judgment(count);
		//ｊｓｐへ送るデータ
		request.setAttribute("getname",AccountDao.getname);
		request.setAttribute("accountid", AccountDao.getid);
		//画面遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher(View);
		dispatcher.forward(request, response);
	}
	public static void login(String name,String pass) {
		account result = AccountDao.searchDao(name,pass);
		//パスワードと名前が一致した場合
		if (name.equals(AccountDao.getname)&&pass.equals(AccountDao.getpassword)) {
			View = "/WEB-INF/view/hinagata.jsp";
			System.out.println("ログインフォームで　取得したユーザ名："+name+"  取得したパスワード："+pass);
			System.out.println("ユーザ名とパスワードが一致しました。");
			System.out.println("データベースから　取得したユーザ名：　"+AccountDao.getname+"  取得したパスワード：　"+AccountDao.getpassword+" 取得したID"+AccountDao.getid);
		}else if (name.equals(AccountDao.getname)) {
			System.out.println("ユーザ名は一致：パスワードが不一致");
			count+=1;
			System.out.println(count);
			View = "/WEB-INF/view/login.jsp";
		}else if(pass.equals(AccountDao.getpassword)) {
			System.out.println("パスワードは一致：ユーザ名が不一致");
			count+=1;
			System.out.println(count);
			View = "/WEB-INF/view/login.jsp";
		}else {
			System.out.println("ユーザ名.パスワード両方不一致");
			count+=1;
			System.out.println(count);
			View = "/WEB-INF/view/login.jsp";
		}
	}
	public static void Judgment(int count) {
		if (count<6) {
			login(name, pass);
		}else if (count>=6) {
			View = "forgetpass.jsp";
		}
	}

}