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
	private static Bean.post s;

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
		String name=request.getParameter("name");
		String pass=request.getParameter("password");
		login(name,pass);
		request.setAttribute("getname",AccountDao.getname);
		request.setAttribute("accountid", AccountDao.getid);
		//投稿時に受け取る情報
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String time = sdf.format(timestamp);
//		String PostContents = request.getParameter("PostContents");
//		String PostImg = request.getParameter("uploadFile");
//		String PostTags_Id = request.getParameter("PostTags");
//		String PostAccount_Id = request.getParameter("accountid");
//		String PostAddress = "null";
//		String PostCreate_at = time;
//		System.out.println(PostContents+PostImg+PostTags_Id+PostAccount_Id+PostAddress+PostCreate_at);
//		s = new post(PostContents, PostImg, PostTags_Id, PostAccount_Id, PostAddress, PostCreate_at);
//		post(s);

		RequestDispatcher dispatcher = request.getRequestDispatcher(View);
		dispatcher.forward(request, response);


	}
	public static void login(String name,String pass) {
		account result = AccountDao.searchDao(name);
		//パスワードと名前が一致した場合
		if (name.equals(AccountDao.getname)&&pass.equals(AccountDao.getpassword)) {
			View = "/WEB-INF/view/hinagata.jsp";
			System.out.println("ログインフォームで　取得したユーザ名："+name+"  取得したパスワード："+pass);
			System.out.println("ユーザ名とパスワードが一致しました。");
			System.out.println("データベースから　取得したユーザ名：　"+AccountDao.getname+"  取得したパスワード：　"+AccountDao.getpassword+" 取得したID"+AccountDao.getid);
		}else {
			//パスワードと名前が一致しなかった場合
			System.out.println("ユーザ名とパスワードが一致しませんでした。");
			View = "/WEB-INF/view/login.jsp";
		}
	}

}