package ConexaoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

import DTO.CadastroDTO;
import DTO.UsuarioDTO;

import ConexaoDAO.conexaojdbc;


public class UsuarioDAO {
	
	Connection conn = new conexaojdbc().conexaobd();;
	
	PreparedStatement ptsm;
	
	ResultSet rs;
	
	public Resultset login (UsuarioDTO usuariologin) {
		
		
	try {
		
		String comandosql = "select * from Usuario where Usuario_Nome = ? and Usuario_Senha = ?";
		
		PreparedStatement pstm = conn.prepareStatement(comandosql);
		pstm.setString(1, usuariologin.getnome());
		pstm.setString(2, usuariologin.getSenha());
		
		ResultSet rs = pstm.executeQuery();
		
		return (Resultset) rs;
		
		
	} catch(Exception E) {
		
		JOptionPane.showMessageDialog(null,"Erro na conexão" + E);
		
		return null;
		
	}
	
	}

    public void cadastro(CadastroDTO cadastro)  {
		
		try {
		
		String sql = ("insert into usuario (Usuario_Nome, Usuario_Senha, Usuario_Cargo ) values (?, ?, 1);");
		
		PreparedStatement pstm = conn.prepareStatement(sql); 
		
		pstm.setString(1, cadastro.getNome());
		pstm.setString(2, cadastro.getSenha());
		
		pstm.execute();
		pstm.close();
		
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
		
		} catch(Exception E) {
			
			JOptionPane.showMessageDialog(null,"Erro no cadastro" + E);
			
		}
		
	}
    
    public boolean verifica (CadastroDTO cadastro) {
    	
    	
      try {
    		
    	  String sql = "select * from Usuario where Usuario_Nome = ? and Usuario_Senha = ?;";
    	  PreparedStatement ptsm = conn.prepareStatement(sql);

    	  ptsm.setString(1, cadastro.getNome());
    	  ptsm.setString(2, cadastro.getSenha());

    	  ResultSet resultado = ptsm.executeQuery();

    	  if (resultado.next()) {
    	      
    	      return false;
    	  } else {
    	      
    	      return true;
    	  }
       } catch (SQLException E) {
    	   
    	   JOptionPane.showMessageDialog(null,"Erro na verificação" + E);
    	   
    		return false;
       }

      
    }
    
    public ArrayList pesquisa () throws SQLException {
    	
    	
    	try{
    		
    		String sql = "Select * from Usuario;";
    		
        	ptsm = conn.prepareStatement(sql);
        	
        	ptsm.executeQuery();
        	
        	rs = (ResultSet) ptsm;
    		
    		while(rs.next()) {}
    		
    	}catch(Exception E) {
    		
    		
    	}
    	
		return null;}

    public void saldo_muda (ResultSet usuario, double deposito) throws SQLException {
    	
    	String comandosql = "update usuario set Usuario_Saldo = ? where Usuario_Nome =?;";
    	
    	String comandosql1 = "SET SQL_SAFE_UPDATES=0;";
    	
    	 ptsm = conn.prepareStatement(comandosql);
    	 
    	 PreparedStatement ptsm1 = conn.prepareStatement(comandosql1);
    	
    	 ptsm.setDouble(1, deposito);
    	 ptsm.setString(2, usuario.getString("Usuario_Nome"));
    	
    	 ptsm1.execute();
    	 ptsm1.close();
    	 
    	 ptsm.execute();
    	 ptsm.close();
    	 
    	 
		}
    
    public ResultSet refresh (ResultSet usuario) throws SQLException {
    	String comandosql = "select * from usuario where Usuario_Nome = ? and Usuario_Senha = ?;";

    	ptsm = conn.prepareStatement(comandosql);

    	ptsm.setString(1, usuario.getString("Usuario_Nome"));
    	ptsm.setString(2, usuario.getString("Usuario_Senha"));

    	return rs = ptsm.executeQuery();
    	
    }
    
    
}

