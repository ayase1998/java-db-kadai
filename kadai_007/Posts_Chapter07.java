package kadai_007;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Posts_Chapter07 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
	
		String url = "jdbc:mysql://localhost/challenge_java";
		
		
		//データベースに接続
		try {
            //(1)データベースに接続
            con = DriverManager.getConnection(
                url,
                "root",
                "Ayase0611"
            );

            System.out.println("データベース接続成功：" + url);
            
            //(2) SQLクエリを準備投稿データを追加するメソッド
            stmt = con.createStatement();
            String sql = "INSERT INTO posts (user_id, posted_at, post_content, likes) VALUES"
            		+ "(1003, '2023-02-08', '昨日の夜は徹夜でした・・', 13), "
                    + "(1002, '2023-02-08', 'お疲れ様です！', 12), "
                    + "(1003, '2023-02-09', '今日も頑張ります！', 18), "
                    + "(1001, '2023-02-09', '無理は禁物ですよ！', 17), "
                    + "(1002, '2023-02-10', '明日から連休ですね！', 20)";
            
            		     
            //(3)　SQLクエリを実行（DBMSに送信）
            int rowCnt = stmt.executeUpdate(sql);
            System.out.println("レコードの追加を実行します");
            System.out.println(rowCnt + "件のレコードが追加されました");
            
            //(4)投稿データを検索する
            String sql2 = "SELECT * FROM posts WHERE user_id = 1002; ";
            ResultSet result = stmt.executeQuery(sql2);
            //(5)検索結果を抽出、表示
            System.out.println("ユーザーIDが1002のレコードを検索しました");
            while(result.next()) {
            	Date postedAt = result.getDate("posted_at");
                String postContent = result.getString("post_content");
                int likes =result.getInt("likes");
                System.out.println(result.getRow() 
                		+ "件目：投稿日時=" + postedAt
                		+ "／投稿内容=" + postContent 
                		+ "／いいね数=" + likes);
            }
            
        } catch(SQLException e) {
            System.out.println("エラー発生：" + e.getMessage());
        } finally {
        	 // 使用したオブジェクトを解放
            if( stmt != null ) {
                try { stmt.close(); } catch(SQLException ignore) {}
            }
            if( con != null ) {
                try { con.close(); } catch(SQLException ignore) {}
            }
        }

	}

}
