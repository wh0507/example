package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;
import model.HealthCheckLogic;
import model.HealthDAO;

/**
 * オートインデントを使いました
 */
@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//DBからデータを取得
		HealthDAO dao = new HealthDAO();
		List<Health> healthList = dao.findAll();

		//アプリケーションスコープにデータを保存
		ServletContext application = this.getServletContext();
		application.setAttribute("healthList", healthList);

		//フォワード
		String fwPath = "WEB-INF/jsp/healthCheck.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(fwPath);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータを取得
		String name = request.getParameter("name"); //氏名
		String age = request.getParameter("age"); //年齢
		String height = request.getParameter("height"); //身長
		String weight = request.getParameter("weight"); //体重

		//入力値をプロパティに設定
		Health health = new Health();
		health.setName(name);
		health.setAge(Integer.parseInt(age));
		health.setHeight(Double.parseDouble(height));
		health.setWeight(Double.parseDouble(weight));

		//健康診断を実行し結果を設定
		HealthCheckLogic healthCheckLogic = new HealthCheckLogic();
		healthCheckLogic.execute(health);

		//DBへ保存
		HealthDAO dao = new HealthDAO();
		dao.create(health);

		//リクエストスコープ保存
		request.setAttribute("health", health);

		//フォワード
		String fwPath = "WEB-INF/jsp/healthCheckResult.jsp"; //WEB-INF/jsp/healthCheckResult.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher(fwPath);
		dispatcher.forward(request, response);

	}

}
