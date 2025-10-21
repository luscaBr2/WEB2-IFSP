package projeto_biblioteca.model;

public class Usuario {

	private Integer id;
	private String nome; 
	private String email;
	private String senha; // em MD5
	private String telefone;
	private String endereco; 
	private Integer tipo_usuario; // '1 - Leitor | 2 - Admin'
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(Integer tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
