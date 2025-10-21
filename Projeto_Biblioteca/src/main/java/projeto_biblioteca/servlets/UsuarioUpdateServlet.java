package projeto_biblioteca.servlets;

import java.io.IOException;
import java.util.Optional;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import projeto_biblioteca.dao.UsuarioDAO;
import projeto_biblioteca.model.Usuario;
import projeto_biblioteca.utils.DataSourceSearcher;
import projeto_biblioteca.utils.PasswordEncoder;

@WebServlet("/UsuarioUpdateServlet")
public class UsuarioUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioUpdateServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		String telefone = req.getParameter("telefone");
		
		String emailOriginal = req.getParameter("emailOriginal");

		// se não chegar nada aqui, coloca o padrão como 1 - leitor
		Integer tipo_usuario = Integer
				.parseInt(req.getParameter("tipo_usuario") != null ? req.getParameter("tipo_usuario") : "1");

		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(PasswordEncoder.encode(senha)); // ja seta em MD5
		usuario.setTelefone(telefone);
		usuario.setTipo_usuario(tipo_usuario); // se for nulo, o padrão é 1
		
		UsuarioDAO usuarioDAO = new UsuarioDAO(DataSourceSearcher.getInstance().getDataSource());

		RequestDispatcher dispatcher = null;

		// salva no banco, se retornar "true" se deu tudo certo, se não, retorna o motivo do erro
		String resultadoUpdate = usuarioDAO.update(usuario, emailOriginal);
		
		if (resultadoUpdate == "true") {
			req.setAttribute("result", "true");
			req.setAttribute("resultMessage", "Cadastro editado com sucesso");
			
			HttpSession session = req.getSession(true); // cria a sessão
			session.setMaxInactiveInterval(1440);
			session.setAttribute("usuario", usuario);
			
			dispatcher = req.getRequestDispatcher("/homeServlet");
		} else {
			req.setAttribute("result", "false");
			req.setAttribute("resultMessage", "Erro ao editar usuário | " + resultadoUpdate);
			dispatcher = req.getRequestDispatcher("/homeServlet");
		}

		dispatcher.forward(req, resp);
	}
}
