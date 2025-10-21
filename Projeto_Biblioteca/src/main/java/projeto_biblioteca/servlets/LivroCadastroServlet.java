package projeto_biblioteca.servlets;

import projeto_biblioteca.model.Livro;
import projeto_biblioteca.model.Usuario;
import projeto_biblioteca.dao.LivroDAO;
import projeto_biblioteca.dao.UsuarioDAO;
import projeto_biblioteca.utils.DataSourceSearcher;
import projeto_biblioteca.utils.PasswordEncoder;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LivroCadastroServlet")
public class LivroCadastroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LivroCadastroServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String titulo = req.getParameter("titulo");
		String autor = req.getParameter("autor");
		Integer anoPublicacao = Integer.parseInt(req.getParameter("ano_publicacao"));
		String isbn = req.getParameter("isbn");
		Integer quantidade = Integer.parseInt(req.getParameter("quantidade"));
		String categoria = req.getParameter("categoria");
		String imageURL = req.getParameter("imageURL");

		Livro livro = new Livro();
		
		livro.setTitulo(titulo);
		livro.setAno_publicacao(anoPublicacao);
		livro.setAutor(autor);
		livro.setCategoria(categoria);
		livro.setIsbn(isbn);
		livro.setQuantidade(quantidade);
		livro.setImageURL(imageURL);
		
		LivroDAO livroDAO = new LivroDAO(DataSourceSearcher.getInstance().getDataSource());
		
		RequestDispatcher dispatcher = null;

		// salva no banco, se retornar "true" se deu tudo certo, se não, retorna o motivo do erro
		String resultadoSave = livroDAO.save(livro);
		
		if (resultadoSave == "true") {
			req.setAttribute("result", "true");
			req.setAttribute("resultMessage", "Livro \""+titulo+"\" cadastrado com sucesso!");
			dispatcher = req.getRequestDispatcher("/homeServlet");
		} else {
			req.setAttribute("result", "false");
			req.setAttribute("resultMessage", "Erro ao cadastrar livro | " + resultadoSave);
			dispatcher = req.getRequestDispatcher("/homeServlet");
		}

		dispatcher.forward(req, resp);
	}

}
