package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException  {
		//フォワード先

		String forwardPath = null;

		//サーブレットクラスの動作を決定する「action」の値を
		//リクエストパラメータから取得

		String action = request.getParameter("action");

		//「登録の開始」をリクエストされたときの処理
		if (action == null) {
			//フォワード
			forwardPath = "/WEB-INF/jsp/registerForm.jsp";
		}

		//リクエストされた時の処理（登録実行）
		else if (action.equals("done")) {

			//セクションスコープに保存された「登録ユーザー」を取得
			HttpSession session = request.getSession();
			User registerUser = (User) session.getAttribute("registerUser");

			//登録処理の呼び出し
			RegisterUserLogic logic = new RegisterUserLogic();
			logic.execute(registerUser);

			//不要となったセクションインスタンス削除
			session.removeAttribute("registerUser");

			forwardPath = "/WEB-INF/jsp/registerDone.jsp";
		}

		//設定後のフォワード先にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		String msg = "";

		if (!name.equals("姜又熙") || name != null) {
			msg = "名前が「姜又熙」ではありません。";
			request.setAttribute("msg", msg);
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/RegisterUser");
			dispatcher.forward(request, response);
//			response.sendRedirect("/RegisterUser");
			return;
		}


		//登録するユーザー情報を設定
		User registerUser = new User(id, name, pass);

		//セッションスコープに登録ユーザーを保存
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(request, response);

	}

}
