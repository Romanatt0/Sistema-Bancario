package View;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import View.LoginView;
import ConexaoDAO.UsuarioDAO;
import DTO.UsuarioDTO;


public class ViewCliente extends JFrame{
	
	 

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCliente frame = new ViewCliente(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ViewCliente(ResultSet usuario ) throws SQLException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario_Nome = new JLabel("Nome: " + usuario.getString("Usuario_Nome"));
		lblUsuario_Nome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario_Nome.setBounds(26, 21, 269, 37);
		contentPane.add(lblUsuario_Nome);
		
		
		JLabel lblSaldo = new JLabel("Saldo: " + usuario.getDouble("Usuario_Saldo") );
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSaldo.setBounds(26, 78, 269, 37);
		contentPane.add(lblSaldo);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SaqueView sacar = new SaqueView(usuario);
				
				sacar.setVisible(true);
				
				dispose();
			}
		});
		btnSacar.setBounds(46, 157, 102, 37);
		contentPane.add(btnSacar);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 DepositoView deposito = new DepositoView(usuario);
			 
			 deposito.setVisible(true);
			 
			 
			 dispose(); 
				
			}
		});
		btnDepositar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDepositar.setBounds(239, 157, 102, 37);
		contentPane.add(btnDepositar);
	}
	
}
