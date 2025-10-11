package projeto_biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import javax.sql.DataSource;
import projeto_biblioteca.model.Usuario;
import projeto_biblioteca.utils.PasswordEncoder;

public class UsuarioDAO {
	private DataSource dataSource;

	public UsuarioDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public String save(Usuario user){
		
		// verificar se existe um usuário com o mesmo e-mail e impede se existir
		Optional<Usuario> optional = getUserByEmail(user.getEmail());
		if(optional.isPresent()) {
			return "Email ja cadastrado";
		}
		
		String sql = "insert into usuarios (nome, email, senha, telefone, tipo_usuario) values (?,?,?,?,?)";
		
		try(Connection conn = dataSource.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, user.getNome());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getSenha());
			ps.setString(4, String.valueOf(user.getTelefone()));
			ps.setString(5, String.valueOf(user.getTipo_usuario()));
			
			ps.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException("Erro durante a escrita no BD", e);
		}
		return "true";
	}
	
	public Optional<Usuario> getUserByEmail(String email) {
		
		String sql = "select id,email,nome from usuarios where email='"+email+"'";
		
		Optional<Usuario> optional = Optional.empty();
		
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Usuario user = new Usuario();
					user.setId(rs.getInt(1));
					user.setEmail(rs.getString(2));
					user.setNome(rs.getString(3));
					optional = Optional.of(user);
				}
			}
			return optional;
		} catch (SQLException sqlException) {
			throw new RuntimeException("Erro durante a consulta" + " SQL = "+ sql, sqlException);
		}
	}
	
public Optional<Usuario> getUserByEmailAndPassword(String email, String senha) {
		
		String sql = "select id,email,nome,tipo_usuario from usuarios where email='"+email+"' and senha='"+senha+"'";
		
		Optional<Usuario> optional = Optional.empty();
		
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Usuario user = new Usuario();
					user.setId(rs.getInt(1));
					user.setEmail(rs.getString(2));
					user.setNome(rs.getString(3));
					user.setTipo_usuario(rs.getInt(4));
					
					optional = Optional.of(user);
				}
			}
			return optional;
		} catch (SQLException sqlException) {
			throw new RuntimeException("Erro durante a consulta" + " SQL = "+ sql, sqlException);
		}
	}
	/*
	public Optional<Usuario> getUserByEmailAndPassword(String email, String password) {
		String sql = "select id,name,email from user where email=? and password=?";
		Optional<Usuario> optional = Optional.empty();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, email);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setId(rs.getLong(1));
					user.setName(rs.getString(2));
					user.setEmail(rs.getString(3));
					optional = Optional.of(user);
				}
			}
			return optional;
		} catch (SQLException sqlException) {
			throw new RuntimeException("Erro durante a consulta no BD", sqlException);
		}
	}
	*/
}
