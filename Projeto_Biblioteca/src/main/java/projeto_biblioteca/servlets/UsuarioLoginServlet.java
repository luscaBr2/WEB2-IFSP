package projeto_biblioteca.servlets;

import java.io.IOException;
import java.util.Optional;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import projeto_biblioteca.dao.UsuarioDAO;
import projeto_biblioteca.model.Usuario;
import projeto_biblioteca.utils.DataSourceSearcher;
import projeto_biblioteca.utils.PasswordEncoder;

import jakarta.servlet.http.HttpSession;

@WebServlet("/UsuarioLoginServlet")
public class UsuarioLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioLoginServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		UsuarioDAO usuarioDAO = new UsuarioDAO(DataSourceSearcher.getInstance().getDataSource());

		Optional<Usuario> optional = usuarioDAO.getUserByEmailAndPassword(email, PasswordEncoder.encode(senha));
		
		Usuario usuarioLogado = optional.isPresent() ? optional.get() : null;
				
		if(usuarioLogado != null) {
			
			// deu certo o login
			req.setAttribute("result", "true");
			req.setAttribute("resultMessage", "Usuario Logado com sucesso");
			//req.setAttribute("usuarioLogado", usuarioLogado);
			
			HttpSession session = req.getSession(true); // cria a sessão
			session.setMaxInactiveInterval(1440);
			session.setAttribute("usuario", usuarioLogado);
		} else {
			req.setAttribute("result", "false");
			req.setAttribute("resultMessage", "Email e senha não encontrados, revise os campos");
		}
		
		// volta pro index de qualquer jeito, porém com o resultMessage
		RequestDispatcher dispatcher = req.getRequestDispatcher("/homeServlet");
		dispatcher.forward(req, resp);

	}
}
