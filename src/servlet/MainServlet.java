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
		int count=0;

		//
		/*login.jspで入力された値をloginDaoを使用し一致しているか調べる*/
		String name=request.getParameter("name");
		String pass=request.getParameter("password");

		/*CLIでデータ内容確認用コード*/
		System.out.println("取得したユーザ名："+name+"  取得したパスワード："+pass);
		/*ここまで*/

		//データベースから値を取得
		account result = AccountDao.searchDao(name);
		//AcountDaoからgetNameという変数を引っ張ってきてメイン画面のタイトルにアカウント名を表示させる
		String getname=AccountDao.getname;
		String getid=AccountDao.getid;
		String getpass=AccountDao.getpassword;
		//ここまで
		System.out.println("取得した名前：　"+getname+"  取得したパスワード：　"+getpass);
		//login.jspに入力された名前とパスワードがデータベースから取り出したデータ（名前とパスワード）と完全一致していれば次のページへ遷移する
		if (name.equals(getname)&&pass.equals(getpass)) {
			//ページ遷移
			String view = "/WEB-INF/view/main.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}else if (count<6) {
			//変数judgementにfalseを格納し、jspに引き渡す。jspではこの値を使用し、失敗したときにアラート（のような物）を出させる。
			String Judgement= "false";
			request.setAttribute("judgement",Judgement );
			//ページ遷移
			String view = "/WEB-INF/view/login.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}else {
			//6回以上間違えた場合はパスワードを再登録するための画面へ遷移させる
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
////取得した値をリクエストスコープへ保存
//request.setAttribute("account", result);
//request.setAttribute("getname", getname);
//request.setAttribute("getid", getid);