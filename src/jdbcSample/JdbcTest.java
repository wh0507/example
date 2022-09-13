package jdbcSample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JdbcTest")
public class JdbcTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		//データベースへ接続文字列を使って接続
		try (Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/mydb",
				"myuser",
				"password")) {
			//SQLの準備
			String sql = "SELECT ID,NAME FROM TEST";
			//SQLを実行する準備
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SQLを実行
			ResultSet rs = pStmt.executeQuery();
			//取得結果を一行ずつ処理する
			while (rs.next()) {
				//取得したデータを表示する
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				out.println("ID=" + id + " NAME= " + name);
			}
			//テーブルの行を追加する
			sql = "INSERT INTO TEST(ID,NAME)VALUES(?,?)";
			pStmt = conn.prepareStatement(sql);
			//パラメータを追加する
			//IDから追加する
			pStmt.setInt(1, 13); //１番目のパラメータ　→ ５に設定
			pStmt.setString(2, "name"); //2番目のパラメータ　→ 追加！！！！！に設定
			pStmt.executeUpdate(); //INSERT, UPDATE, DELETEを使う場合
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
