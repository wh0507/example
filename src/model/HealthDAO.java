package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HealthDAO {

	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/mydb";
	private final String DB_USER = "myuser";
	private final String DB_PASS = "password";

	//データ保存
	public boolean create(Health health) {
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SQLの準備
			String sql = "INSERT INTO health (name, age, height, weight, bmi) VALUES(?,?,?,?,?)";
			//SQLを実行する準備
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//取得したデータ設定
			pStmt.setString(1, health.getName());
			pStmt.setInt(2, health.getAge());
			pStmt.setDouble(3, health.getHeight());
			pStmt.setDouble(4, health.getWeight());
			pStmt.setDouble(5, health.getBmi());
			//SQL実行（INSERT文）
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//
	public List<Health> findAll() {
		List<Health> healthList = new ArrayList<>();

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SQLの準備
			String sql = "SELECT name, age, height, weight, bmi FROM health";
			//SQLを実行する準備
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SQLを実行
			ResultSet rs = pStmt.executeQuery();
			//取得結果を一行ずつ処理する
			while (rs.next()) {
				//取得したデータを表示する
				String name = rs.getString("name");
				int age = rs.getInt("age");
				double height = rs.getDouble("height");
				double weight = rs.getDouble("weight");
				double bmi = rs.getDouble("bmi");
				Health health = new Health(name, age, height, weight, bmi);
				healthList.add(health);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return healthList;
	}

}