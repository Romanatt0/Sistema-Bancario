package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ConexaoDAO.UsuarioDAO;
import DTO.UsuarioDTO;
import View.ViewCliente;


public class LoginView {

	JFrame frame;
	private JTextField textUsuario;
	private JPasswordField passwordSenha;
    
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        } catch (InstantiationException ex) {
        	System.err.println(ex);
        } catch (IllegalAccessException ex) {
        	System.err.println(ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        	System.err.println(ex);
        }
        
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(92, 78, 55, 21);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(102, 115, 55, 27);
		frame.getContentPane().add(lblSenha);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsuario.setBounds(157, 78, 148, 31);
		frame.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(157, 119, 148, 27);
		frame.getContentPane().add(passwordSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				logar();
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEntrar.setBounds(180, 165, 100, 27);
		frame.getContentPane().add(btnEntrar);
		
		JButton btnCadastrar = new JButton("Cadastrar-se");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CasdastroView cadastroview = new CasdastroView();
				
				cadastroview.setVisible(true);
				
				frame.dispose();
 			}
		});
		btnCadastrar.setBounds(180, 202, 100, 21);
		frame.getContentPane().add(btnCadastrar);
	}
	

	public void logar () {
		UsuarioDTO usuariologin = new UsuarioDTO();
		
		usuariologin.setnome(textUsuario.getText());
		usuariologin.setSenha(passwordSenha.getText());
		
		UsuarioDAO usuario = new UsuarioDAO();
		
		
		ResultSet atenticacao = (ResultSet) usuario.login(usuariologin);
						
		try {
			if(atenticacao.next()) {
				JOptionPane.showMessageDialog(null, "Bem-vindo!");
				
				switch (atenticacao.getInt("Usuario_Cargo"))
				{
				case 1: 
					
					ViewCliente ViewCliente = new ViewCliente(atenticacao);
					
					ViewCliente.setVisible(true);
					
					frame.dispose();
					
					break;
				
				case 2: 
					
					CLTView escravo = new CLTView(atenticacao);
					
					escravo.setVisible(true);
					
					frame.dispose();
					break;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Usuario ou senha invalida!");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			
		}
		
	}
}
