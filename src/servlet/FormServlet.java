package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//formPageに遷移
		String addPage = "/WEB-INF/jsp/formPage.jsp";
		//リソースに送信するオブジェクトを定義
		RequestDispatcher dispatch = request.getRequestDispatcher(addPage);
		//request, responseをフォワード
		dispatch.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータのname,gender取得
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");

		//リクエストパラメータをチェック
		String errorMsg = "";
		//リクエストパラメータの"name"をチェック
		if (name == null || name.length() == 0) {
			errorMsg += "名前が入力されていません<br>";
		} else if (!name.equals("姜又熙")) {
			errorMsg += "名前が「姜又熙」ではありません。";
		}

		//リクエストパラメータの"gender"をチェック
		if (gender == null || gender.length() == 0) {
			errorMsg += "性別が選択されていません<br>";
		} else {
			if (gender.equals("0")) {
				gender = "男性";
			} else if (gender.equals("1")) {
				gender = "女性";
			}
		}

		//エラーの確認
		if (errorMsg.length() != 0) {
			//HttpSessionインスタンスの取得
			HttpSession session = request.getSession();
			//セッションスコープにインスタンス取得
			session.setAttribute("errorMsg", errorMsg);

			//リダイレクトパス
			String rdPath = "http://localhost:8080/example/redirectPage.jsp";
			//リダイレクト
			response.sendRedirect(rdPath);
		} else {
			//フォワードの結果メッセージ
			String msg = name + "さん(" + gender + ")を登録しました";
			request.setAttribute("msg", msg);

			String fwPath = "/WEB-INF/jsp/forwardPage.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(fwPath);
			dispatch.forward(request, response);
		}

	}

}
