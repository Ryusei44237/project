//package dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//public class FollowDao {
//
//	//①DBアクセスに必要な情報の定数を定義
//
//	//接続先DBのURL(jdbc:mysql://[ホスト名orIPアドレス]:[ポート番号]/[データベース名]?serverTimezone=JST)
//	private static final String url = "jdbc:mysql://localhost:3306/application?serverTimezone=JST";
//	//ユーザ
//	private static final String user = "root";
//	//パスワード
//	private static final String pw = "Sql39sia";
//
//
//	public void Follow(int account_Id, int follow_Id ) {
//
//		//②アクセスに必要な変数の初期化
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try{
//			//③JDBCドライバをロードする
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			//④データベースと接続する(コネクションを取ってくる)
//			//第1引数→接続先URL
//			//第2引数→ユーザ名
//			//第3引数→パスワード
//			con = DriverManager.getConnection(url, user, pw);
//
//			//⑤SQL文の元を作成する
//			//?をプレースホルダと言います。
//			//後の手順で?に値を設定します。
//			String sql = "INSERT INTO follows (account_id, follow_id) VALUES (?,?)";
//
//			//⑥SQLを実行するための準備(構文解析)
//			pstmt = con.prepareStatement(sql);
//
//			//⑦プレースホルダに値を設定
//			//第1引数→何番目の?に設定するか(1から数える)
//			//第2引数→?に設定する値
//
//			 pstmt.setInt(1, account_Id);
//             pstmt.setInt(2, follow_Id);
//
//
//          // INSERT文を実行
//             int result = pstmt.executeUpdate();
//             if (result != 1) {
//                 throw new RuntimeException("フォローに失敗しました。");
//             }
//
//
//		}  catch (SQLException e){
//			System.out.println("DBアクセスに失敗しました。");
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			System.out.println("DBアクセスに失敗しました。");
//			e.printStackTrace();
//		} finally {
//			//⑨DBとの切断処理
//			try {
//				//nullかチェックしないとNullPointerExceptionが
//				//発生してしまうためチェックしている。
//				if( pstmt != null){
//					pstmt.close();
//				}
//			} catch(SQLException e){
//				System.out.println("DB切断時にエラーが発生しました。");
//				e.printStackTrace();
//			}
//
//			try {
//				if( con != null){
//					con.close();
//				}
//			} catch (SQLException e){
//				System.out.println("DB切断時にエラーが発生しました。");
//				e.printStackTrace();
//			}
//		}
//	}
//
//	// 指定したuser_Id のフォロー数を取得
//    public int getFollowCount(int userId) {
//    	//②アクセスに必要な変数の初期化
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		int followCount = 0;
//
//		try{
//			//③JDBCドライバをロードする
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			//④データベースと接続する(コネクションを取ってくる)
//			//第1引数→接続先URL
//			//第2引数→ユーザ名
//			//第3引数→パスワード
//			con = DriverManager.getConnection(url, user, pw);
//
//			//⑤SQL文の元を作成する
//			//?をプレースホルダと言います。
//			//後の手順で?に値を設定します。
//			String sql = "SELECT COUNT (*) AS FOLLOWCOUNT FROM follows WHERE account_Id = ?";
//
//			//⑥SQLを実行するための準備(構文解析)
//			pstmt = con.prepareStatement(sql);
//
//			//⑦プレースホルダに値を設定
//			//第1引数→何番目の?に設定するか(1から数える)
//			//第2引数→?に設定する値
//
//			pstmt.setInt(1, userId);
//			// SELECTを実行
//            try (ResultSet rs = pstmt.executeQuery()) {
//
//                // 1件しか返って来ないのでif文
//                if (rs.next()) {
//                    followCount = rs.getInt("FOLLOWCOUNT");
//                }
//            }
//
//    		} catch (Exception e) {
//    			throw new RuntimeException(e);
//    		}
//				return followCount;
//    }
//
//    // 指定したuser_Id のフォロワー数を取得
//    public int getFollowerCount(int userId) {
//    	//②アクセスに必要な変数の初期化
//    	Connection con = null;
//    	PreparedStatement pstmt = null;
//
//    	int followerCount = 0;
//
//		try{
//			//③JDBCドライバをロードする
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			//④データベースと接続する(コネクションを取ってくる)
//    		//第1引数→接続先URL
//    		//第2引数→ユーザ名
//    		//第3引数→パスワード
//    		con = DriverManager.getConnection(url, user, pw);
//
//    		//⑤SQL文の元を作成する
//    		//?をプレースホルダと言います。
//    		//後の手順で?に値を設定します。
//    		String sql = "SELECT COUNT (*) AS FOLLOWERCOUNT FROM follow WHERE follow_Id = ?";
//
//    		//⑥SQLを実行するための準備(構文解析)
//    		pstmt = con.prepareStatement(sql);
//
//    		//⑦プレースホルダに値を設定
//    		//第1引数→何番目の?に設定するか(1から数える)
//    		//第2引数→?に設定する値
//
//    		pstmt.setInt(1, userId);
//
//    		// SELECTを実行
//            try (ResultSet rs = pstmt.executeQuery()) {
//
//                if (rs.next()) {
//                    followerCount = rs.getInt("FOLLOWERCOUNT");
//
//                }
//            }
//
//    		} catch (Exception e) {
//    			throw new RuntimeException(e);
//    		}
//    		return followerCount;
//	}
//
//    // 指定したuser_Idのフォロー 一覧の取得
//    public List<FollowViewModel> getFollowList(int userId) {
//        List<FollowViewModel> followList = new ArrayList<FollowViewModel>();
//
//        try (Connection conn = JDBCUtils.getConnection()) {
//
//            // フォローしたユーザーの取得（自分は表示しない）
//            String sql = "SELECT USER.USER_ID AS USER_ID, USER.USER_NAME AS USER_NAME FROM USER "
//                    + "INNER JOIN FOLLOW ON USER.USER_ID = FOLLOW.FOLLOW_ID " + "WHERE FOLLOW.USER_ID = ?";
//
//            try (PreparedStatement pStmt = conn.prepareStatement(sql)) {
//
//                pStmt.setInt(1, userId);
//
//                // SELECTを実行
//                try (ResultSet rs = pStmt.executeQuery()) {
//                    // SELECT文の結果をArrayListに格納
//                    while (rs.next()) {
//                        int followUserId = rs.getInt("USER_ID");
//                        String followUserName = rs.getString("USER_NAME");
//
//                        FollowViewModel follow = new FollowViewModel(followUserId, followUserName);
//                        followList.add(follow);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return followList;
//    }
//}
