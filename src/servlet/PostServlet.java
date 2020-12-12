package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.post;
import dao.PostDao;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 変数初期化
		String PostContents=null;
		String PostImg =null;
		String PostTags_Id=null;
		String PostAccount_Id=null;
		String PostAddress=null;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(timestamp);
		PostContents = request.getParameter("PostContents");
		PostImg = request.getParameter("uploadFile");
		PostTags_Id = request.getParameter("PostTags");
		PostAccount_Id = request.getParameter("accountid");
		String PostCreate_at = time;
		post s = new post(PostContents, PostImg, PostTags_Id, PostAccount_Id, PostAddress, PostCreate_at);
		System.out.println("投稿内容　"+PostContents+"投稿画像　"+PostImg+"ポストタグ　"+PostTags_Id+"投稿アカウントID　"+PostAccount_Id+"投稿場所　"+PostAddress+"作成日　"+PostCreate_at);
		post result = PostDao.insertPost(s);
		if (true) {
			String view ="/WEB-INF/view/hinagata.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}

	}


}
