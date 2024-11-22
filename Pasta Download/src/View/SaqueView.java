package View;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexaoDAO.UsuarioDAO;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import View.LoginView;

public class SaqueView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaqueView frame = new SaqueView(null);
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
	public SaqueView(ResultSet usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textValor = new JTextField();
		textValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textValor.setBounds(163, 113, 96, 19);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double saldo = 0;
			    
				try {
					saldo = usuario.getDouble("Usuario_Saldo");
					saldo = saldo - Double.parseDouble(textValor.getText());
					
					if (saldo < 0) {
						
						JOptionPane.showMessageDialog(null, "Você não tem fundos o suficiente para esta transação!");
					} else {
						
						UsuarioDAO depositodao = new UsuarioDAO(); 
						
						depositodao.saldo_muda(usuario, saldo);
						
						
						ResultSet result = (ResultSet) depositodao.refresh(usuario);
						
						
						JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Saque não realizado");

				}
				
				dispose();
			}
		});
		btnSacar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSacar.setBounds(159, 170, 85, 21);
		contentPane.add(btnSacar);
	}

}
