package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Bean.post;

public class PostDao {

	//①DBアクセスに必要な情報の定数を定義

		//接続先DBのURL(jdbc:mysql://[ホスト名orIPアドレス]:[ポート番号]/[データベース名]?serverTimezone=JST)
		private static final String url = "jdbc:mysql://localhost:3306/application?serverTimezone=JST";
		//ユーザ
		private static final String user = "root";
		//パスワード
		private static final String pw = "Sql39sia";

		public static String getname = null;
		public static String getid=null;
		public static String getmail=null;
		public static String getpassword=null;
		public static String getbirthday=null;
		public static String gettell=null;
		public static String getcreate_at=null;
		public static String getupdate_at=null;


		//INSERT文を実行するメソッドのサンプル
		//引数は登録したい情報が格納されたBean
		public static post insertPost(post s){
			//②アクセスに必要な変数の初期化
			Connection con = null;
			PreparedStatement pstmt = null;

			try{
				//③JDBCドライバをロードする
				Class.forName("com.mysql.cj.jdbc.Driver");

				//④データベースと接続する(コネクションを取ってくる)
				//第1引数→接続先URL
				//第2引数→ユーザ名
				//第3引数→パスワード
				con = DriverManager.getConnection(url, user, pw);

				//⑤SQL文の元を作成する
				//?をプレースホルダと言います。
				//後の手順で?に値を設定します。
				String sql = "INSERT INTO post VALUE(?, ?, ?, ?, ?, ?, ?)";

				//⑥SQLを実行するための準備(構文解析)
				pstmt = con.prepareStatement(sql);

				//⑦プレースホルダに値を設定
				//第1引数→何番目の?に設定するか(1から数える)
				//第2引数→?に設定する値

				pstmt.setInt(1, s.getId());
				pstmt.setString(2, s.getContents());
				pstmt.setString(3, s.getImg());
				pstmt.setInt(4, s.getTags_Id());
				pstmt.setInt(5, s.getAccount_Id());
				pstmt.setString(6, s.getAddress());
				pstmt.setString(7, s.getCreate_At());


				System.out.println("実行できてる");
				//⑧SQLを実行し、DBから結果を受領する
				int result= pstmt.executeUpdate();
				System.out.println(result + "件登録されました。");

			}  catch (SQLException e){
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} finally {
				//⑨DBとの切断処理
				try {
					//nullかチェックしないとNullPointerExceptionが
					//発生してしまうためチェックしている。
					if( pstmt != null){
						pstmt.close();
					}
				} catch(SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}

				try {
					if( con != null){
						con.close();
					}
				} catch (SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}
			}
			return s;
		}


}
