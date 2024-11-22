package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.CadastroDTO;
import ConexaoDAO.UsuarioDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import View.LoginView;
import javax.swing.JPasswordField;

public class CasdastroView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCadastro_nome;
	private JLabel lblInsiriaUmaSenha;
	private JButton btnNewButton;
	private JPasswordField Cadastro_senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CasdastroView frame = new CasdastroView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CasdastroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastro_nome = new JLabel("Insiria um nome de usuário: ");
		lblCadastro_nome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCadastro_nome.setBounds(107, 35, 205, 31);
		contentPane.add(lblCadastro_nome);
		
		textCadastro_nome = new JTextField();
		textCadastro_nome.setBounds(102, 76, 210, 31);
		contentPane.add(textCadastro_nome);
		textCadastro_nome.setColumns(10);
		
		lblInsiriaUmaSenha = new JLabel("Insiria uma senha: ");
		lblInsiriaUmaSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInsiriaUmaSenha.setBounds(107, 117, 205, 31);
		contentPane.add(lblInsiriaUmaSenha);
		
		btnNewButton = new JButton("Casdatrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroDTO cadastro = new CadastroDTO();
				
				cadastro.setNome(textCadastro_nome.getText());
				cadastro.setSenha(Cadastro_senha.getText());
				
				UsuarioDAO usuario = new UsuarioDAO();
				
				if(usuario.verifica(cadastro) == true ) {
					
					usuario.cadastro(cadastro);
					dispose();
					
				} else {
					
					JOptionPane.showMessageDialog(null, "Usuário ja existente!");
				}
				
				
			}
		});
		btnNewButton.setBounds(168, 194, 85, 21);
		contentPane.add(btnNewButton);
		
		Cadastro_senha = new JPasswordField();
		Cadastro_senha.setBounds(102, 153, 210, 31);
		contentPane.add(Cadastro_senha);
	}
}
