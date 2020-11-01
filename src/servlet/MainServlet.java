package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		/*login.jspで入力された値をloginDaoを使用し一致しているか調べる*/
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		String testemail="test@mail";
		String testpass="0000";
		/*CLIでデータ内容確認用コード*/
		System.out.println(email+"|"+testemail);
		System.out.println(pass+"|"+testpass);
		/*ここまで*/
		/*条件分岐(一致していた場合メイン画面へ遷移を許可する)*/
		if (email.equals(testemail) && pass.equals(testpass)) {
			System.out.println("main.jspへ遷移します");
			/*ここにmain.jspへの遷移コードを書く｛main.jsp｝*/
			String view = "/WEB-INF/view/main.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			}
		/*一致していなかった場合は再度入力させるためリダイレクトさせる*/
		else {
			count+=1;
			if (count<6) {
				/*リダイレクト文を書く*/
				//ログイン失敗JSPへリダイレクトする。
				//JSPへリダイレクトする場合はWEB-INFへのアクセスは不可
				String view = "failure.jsp";
				response.sendRedirect(view);
			}
			else {
				/*条件の不一致が6回以上続いた場合login.jspにアカウント情報を忘れた場合のアラートを出す*/
			}
		}
		/*条件分岐終了*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
