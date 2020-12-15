package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.post;

public class PostDao {

	//①DBアクセスに必要な情報の定数を定義

		//接続先DBのURL(jdbc:mysql://[ホスト名orIPアドレス]:[ポート番号]/[データベース名]?serverTimezone=JST)
		private static final String url = "jdbc:mysql://localhost:3306/application?serverTimezone=JST";
		//ユーザ
		private static final String user = "root";
		//パスワード
		private static final String pw = "44237";


		public static String contents;
		public static String img;
		public static String tags;
		public static String address;
		public static String create_at;
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


				//String migi⇒int......ここわざわざ数値に直す必要あるかな？？

//				int Tags_Id = Integer.parseInt(s.getTags_Id());
//				int Account_Id = Integer.parseInt(s.getAccount_Id());

				//⑤SQL文の元を作成する
				//?をプレースホルダと言います。
				//後の手順で?に値を設定します。
				String sql = "INSERT INTO post(contents, img, tags_id, account_id, address, create_at) VALUE(?, ?, ?, ?, ?, ?)";

				//⑥SQLを実行するための準備(構文解析)
				pstmt = con.prepareStatement(sql);

				//⑦プレースホルダに値を設定
				//第1引数→何番目の?に設定するか(1から数える)
				//第2引数→?に設定する値

				pstmt.setString(1, s.getContents());
				pstmt.setString(2, s.getImg());
				pstmt.setString(3, s.getTags_Id());
				pstmt.setString(4, s.getAccount_Id());
				pstmt.setString(5, s.getAddress());
				pstmt.setString(6, s.getCreate_At());


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
		public static post searchPost(String SearchText){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			post result = null;

			try {
				// ②JDBCドライバをロードする
				Class.forName("com.mysql.cj.jdbc.Driver");

				// ③DBMSとの接続を確立する
				con = DriverManager.getConnection(url,user,pw);
				// ④SQL文を作成する
				String sql = "SELECT * FROM post WHERE acount_id = ?;";
				// ⑤SQL文を実行するための準備を行う
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, SearchText);

				// ⑥SQL文を実行してDBMSから結果を受信する
				rs = pstmt.executeQuery();

				// ⑦実行結果を含んだインスタンスからデータを取り出す
				rs.next();

				contents = rs.getString("contents");
				tags = rs.getString("tags_id");

				result = new post(contents,tags);
			} catch (ClassNotFoundException e) {
				System.out.println("JDBCドライバが見つかりません。");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
			} finally {
				// ⑧DBMSから切断する
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e.printStackTrace();
				}
				try {
					if (pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e.printStackTrace();
				}
				try {
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e.printStackTrace();
				}
			}
			return result;
		}
//		検索要素（account_id）　全件検索
		//全件検索するSELECT文を実行するメソッドのサンプル
		public static ArrayList<post> allPost(){
			//アクセスに必要な変数の初期化
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try{
				//JDBCドライバをロードする
				Class.forName("com.mysql.cj.jdbc.Driver");

				//データベースと接続する(コネクションを取ってくる)
				//第1引数→接続先URL
				//第2引数→ユーザ名
				//第3引数→パスワード
				con = DriverManager.getConnection(url, user, pw);

				//SQL文の元を作成する
				String sql = "SELECT * FROM post;";

				//SQLを実行するための準備(構文解析)
				pstmt = con.prepareStatement(sql);

				//SQLを実行し、DBから結果を受領する
				rs = pstmt.executeQuery();

				//return用のArrayList生成
				ArrayList<post> list = new ArrayList<post>();

				//next()の戻り値がfalseになるまでResultSetから
				//データを取得してArrayListに追加していく
				while( rs.next() ){
					contents = rs.getString("contents");
					img = rs.getString("img");
					tags = rs.getString("tags_id");
					address = rs.getString("address");
					create_at = rs.getString("create_at");
					post result = new post(contents,img,tags,address,create_at);
					list.add(result);
				}
				//中身の詰まったArrayListを返却する
				System.out.println(list);
				return list;

			}  catch (SQLException e){
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} finally {
				//⑫DBとの切断処理
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

			//途中でExceptionが発生した時はnullを返す。
			return null;
		}
}
