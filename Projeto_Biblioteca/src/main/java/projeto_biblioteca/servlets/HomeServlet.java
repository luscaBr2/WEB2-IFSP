package projeto_biblioteca.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import projeto_biblioteca.dao.LivroDAO;
import projeto_biblioteca.model.Livro;
import projeto_biblioteca.model.Usuario;
import projeto_biblioteca.utils.DataSourceSearcher;

import jakarta.servlet.http.HttpSession;

@WebServlet("/homeServlet")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// puxa todos os livros do banco
		
		LivroDAO livroDAO = new LivroDAO(DataSourceSearcher.getInstance().getDataSource());
		Optional<List<Livro>> optional = livroDAO.getAllBooks();
		
		List<Livro> livros = optional.orElse(null); // Caso o Optional esteja vazio, retorna null
		req.setAttribute("livros", livros);

		// verifica se existe mas não cria sessão se não existir
		HttpSession session = req.getSession(false);

		// se a sessão for nula
		if (session != null) {
			
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			
		    if (usuario != null) {
		        req.setAttribute("usuarioLogado", usuario);
		    }
		}
 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
	}
}

