package projeto_biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

import projeto_biblioteca.model.Livro;

public class LivroDAO {
	private DataSource dataSource;

	public LivroDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public String save(Livro book){
			
		// verificar se existe um livro com o mesmo nome
		Optional<Livro> optional = getBookByName(book.getTitulo());
		if(optional.isPresent()) {
			return "Livro ja cadastrado";
		}
		
		String sql = "INSERT INTO livros (titulo, autor, ano_publicacao, categoria, isbn, quantidade, img) VALUES (?, ?, ?, ?, ?, ?, ?);";
		
		try(Connection conn = dataSource.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, book.getTitulo());
			ps.setString(2, book.getAutor());
			ps.setInt(3, book.getAno_publicacao());
			ps.setString(4, book.getCategoria());
			ps.setString(5, book.getIsbn());
			ps.setInt(6, book.getQuantidade());
			ps.setString(7, book.getImageURL());
			
			ps.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException("Erro durante a escrita no BD", e);
		}
		return "true";
	}
	
	public Optional<List<Livro>> getAllBooks() {
	    String sql = "SELECT id, titulo, autor, ano_publicacao, categoria, isbn, quantidade, img FROM livros";
	    
	    List<Livro> livros = new ArrayList<Livro>();
	    
	    try (Connection con = dataSource.getConnection(); 
	         PreparedStatement ps = con.prepareStatement(sql)) {
	        
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Livro book = new Livro();
	                book.setId(rs.getInt("id"));
	                book.setTitulo(rs.getString("titulo"));
	                book.setAutor(rs.getString("autor"));
	                book.setAno_publicacao(rs.getInt("ano_publicacao"));
	                book.setCategoria(rs.getString("categoria"));
	                book.setIsbn(rs.getString("isbn"));
	                book.setQuantidade(rs.getInt("quantidade"));
	                book.setImageURL(rs.getString("img"));
	                
	                livros.add(book);
	            }
	        }
	        
	        // Retorna a lista de livros, ou Optional.empty() se a lista estiver vazia
	        return livros.isEmpty() ? Optional.empty() : Optional.of(livros);
	        
	    } catch (SQLException sqlException) {
	        throw new RuntimeException("Erro durante a consulta: " + sqlException.getMessage(), sqlException);
	    }
	}

	
	public Optional<Livro> getBookByName(String titulo) {
		
		String sql = "SELECT id, titulo, autor, ano_publicacao, categoria, isbn, quantidade, img FROM livros WHERE titulo = '"+titulo+"'";
		
		Optional<Livro> optional = Optional.empty();
		
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Livro book = new Livro();
					book.setId(rs.getInt(1));
					book.setTitulo(rs.getString(2));
					book.setAutor(rs.getString(3));
					book.setAno_publicacao(rs.getInt(4));
					book.setCategoria(rs.getString(5));
					book.setIsbn(rs.getString(6));
					book.setQuantidade(rs.getInt(7));
					book.setImageURL(rs.getString(8));
					
					optional = Optional.of(book);
				}
			}
			return optional;
		} catch (SQLException sqlException) {
			throw new RuntimeException("Erro durante a consulta" + sqlException);
		}
	}
}
