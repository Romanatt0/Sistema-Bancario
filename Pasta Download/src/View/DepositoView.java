package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexaoDAO.UsuarioDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DepositoView extends JFrame {
	
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textvalor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositoView frame = new DepositoView(null);
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
	public DepositoView(ResultSet usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textvalor = new JTextField();
		textvalor.setBounds(148, 79, 161, 34);
		contentPane.add(textvalor);
		textvalor.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Escolha o valor: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(33, 76, 171, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnDeposito = new JButton("Depositar");
		btnDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double saldo = 0;
				// pega o dinheiro do usuario
				try {
					saldo = usuario.getDouble("Usuario_Saldo");
					
					UsuarioDAO depositodao = new UsuarioDAO();
					
					saldo = saldo + Double.parseDouble(textvalor.getText());
					//pega o valor do saldo e manda para o banco de dados e abre uma nova view pro usuario
					
						depositodao.saldo_muda(usuario, saldo);
						
						JOptionPane.showMessageDialog(null, "Deposito efeutado com sucesso!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
					
					
					//fecha o deposito
				    dispose();
			}
		});
		btnDeposito.setBounds(148, 151, 109, 34);
		contentPane.add(btnDeposito);
	}
}
