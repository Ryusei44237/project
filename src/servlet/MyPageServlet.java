package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.account;
import Bean.post;
import dao.AccountDao;
import dao.PostDao;

/**
 * Servlet implementation class Update
 */
@WebServlet("/UpdateServlet")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	このservlet上で使用する変数
	private static String id;

    public MyPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//メインjspからアカウントIDを取得し、アカウントIDをもとに行検索をかける。
		id=request.getParameter("account_id");
//		投稿内容表示処理 (アカウントIDを取得し、アカウントIDが一致する投稿を全件取得する）
		post(id);
//		登録情報更新処理 （アカウントIDで照会し、一致するアカウント登録情報を取得）
		account(id);
		System.out.println("main.jspから　取得した名前　"+AccountDao.getname);
		request.setAttribute("id",AccountDao.getid);
		request.setAttribute("name",AccountDao.getname);
		request.setAttribute("pass",AccountDao.getpassword);
		request.setAttribute("mail",AccountDao.getmail);
		request.setAttribute("birthday",AccountDao.getbirthday);
		request.setAttribute("tell",AccountDao.gettell);
		request.setAttribute("update_at",AccountDao.getupdate_at);

		/*ここにmypage.jspへの遷移コードを書く｛mypage.jsp｝*/
		String view = "/WEB-INF/view/mypage.jsp";
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
	public static void account(String id) {
		account result = AccountDao.searchDao2(id);
	}
	public static void post(String id) {
		post result = PostDao.searchPost(id);

	}

}
