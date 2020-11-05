package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Manager {
	//①DBアクセスに必要な情報の定数を定義

	//接続先DBのURL(jdbc:mysql://[ホスト名orIPアドレス]:[ポート番号]/[データベース名]?serverTimezone=JST)
	private static final String url = "jdbc:mysql://localhost:3306/--?serverTimezone=JST";
	//ユーザ
	private static final String user = "root";
	//パスワード
	private static final String pw = "44237";


	//全件検索するSELECT文を実行するメソッドのサンプル
	public Manager(){
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

			//検索をかけたいアカウントの名前を入力
			System.out.println("キーボードから入力してください");
	        Scanner scan = new Scanner(System.in);
	        String Search = scan.next();
			//SQL文の元を作成する
			String sql = "SELECT * FROM  TABLE WHERE NAME=?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Search);

			//SQLを実行し、DBから結果を受領する
			rs = pstmt.executeQuery();
			rs.next();
			String Name=rs.getString("USERNAME");


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
		return;
	}
}
