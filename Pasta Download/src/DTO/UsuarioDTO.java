package DTO;

public class UsuarioDTO {
	
	private int idusuario;

	private String nome;
	
	private int nascimento; 
	
	private String senha;
	
	private int cargo;
	
	private double saldo;
	
	
	public int getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	
	public void setnome (String nome) {
		this.nome = nome;	
	}
	
	
	public String getnome() {
		return nome;
		
	}
	
	
	public int getNascimento() {
		return nascimento;
	}
	
	
	public void setNascimento(int nascimento) {
		this.nascimento = nascimento;
	}
	
	
	public String getSenha() {
		return senha;
	}
	
	
	public void setSenha(String Senha) {
	this.senha = Senha;
}


	public int getCargo() {
		return cargo;
	}


	public void setCargo(int cargo) {
		this.cargo = cargo;
	}


	
	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public UsuarioDTO () {
		
	}
	
	
	
	
	
}
