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
 * Servlet implementation class Update
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//メインjspからアカウントIDを取得し、アカウントIDをもとに行検索をかける。
		String id=request.getParameter("id");
		System.out.println("取得ID"+id);
		account result = AccountDao.searchDao2(id);
		String getid=AccountDao.getid;
		String getname=AccountDao.getname;
		String getpass=AccountDao.getpassword;
		String getmail=AccountDao.getmail;
		String getbirthday=AccountDao.getbirthday;
		String gettell=AccountDao.gettell;
		String getupdate_at=AccountDao.getupdate_at;
		System.out.println(getid+"|"+getname+"|"+getpass+"|"+getmail+"|"+getbirthday+"|"+gettell+"|"+getupdate_at);
		request.setAttribute("id",getid);
		request.setAttribute("name",getname);
		request.setAttribute("pass",getpass);
		request.setAttribute("mail",getmail);
		request.setAttribute("birthday",getbirthday);
		request.setAttribute("tell",gettell);
		request.setAttribute("update_at",getupdate_at);

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

}
