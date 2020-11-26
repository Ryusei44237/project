package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String time = sdf.format(timestamp);
		//挿入したい値をjsp空引っ張ってきた
	    		String id = null;
				String name=request.getParameter("name");//アカウントネーム

				 try {
				      byte[] byteData = name.getBytes("ISO_8859_1");
				      name = new String(byteData, "UTF-8");
				    }catch(UnsupportedEncodingException e){
				    }

				String mail=request.getParameter("mail");//メールアドレス
				String password=request.getParameter("password");//パスワード・ハッシュかける処理を作成
				//ハッシュ化

				//ハッシュ化ここまで
				//生年月日は個別で得たものを合体させbirthdayとして登録する
				String year = request.getParameter("AcountYear");//年
				String month = request.getParameter("AcountMonth");//月
				String day = request.getParameter("AcountDay");//日
				String birthday=year+month+day;//ここでdate型に入れれる形に直す
				//ここまで
				String tell=request.getParameter("tell");//電話番号
				String token=request.getParameter("token");//セッショントークン
				String create_at=time;//作成日
				String update_at=null;//更新日
				//取得した値をCLIに表示させる
				System.out.println("登録された値｜　名前　"+name+"|メールアドレス　"+mail+"|パスワード　"+password+"|生年月日　"+birthday+"|電話番号　"+tell+"|トークン　"+token+"|作成日　"+create_at+"|更新日　"+update_at);
				//Daoから値を引っ張ってきた
				account s = new account(id,name,mail,password,birthday,tell,token,create_at,update_at);
				account result = dao.AccountDao.inserAccount(s);
		System.out.println("login.jspへ遷移します");
		/*ここにlogin.jspへの遷移コードを書く｛login.jsp｝*/
		String view = "/WEB-INF/view/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
