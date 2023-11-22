package br.com.senai.cardapiosmktplaceview.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.cardapiosmktplaceview.model.User;
import br.com.senai.cardapiosmktplaceview.service.UserService;

@Component
public class LoginView extends JFrame {

private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	@Autowired
	private UserService service;
	
	private JTextField edtLogin;
	
	private JPasswordField edtSenha;
	
	@Autowired
	private CarriersView carriersView;

	public LoginView() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		edtLogin = new JTextField();
		edtLogin.setBounds(10, 28, 258, 20);
		contentPane.add(edtLogin);
		edtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 59, 46, 14);
		contentPane.add(lblSenha);
		
		edtSenha = new JPasswordField();
		edtSenha.setBounds(10, 75, 258, 20);
		contentPane.add(edtSenha);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = service.login(edtLogin.getText(), new String(edtSenha.getPassword()));
				edtLogin.setText("");
				edtSenha.setText("");
				carriersView.showView(user);
			
			}
		});
		btnLogar.setBounds(92, 106, 89, 23);
		contentPane.add(btnLogar);
		setLocationRelativeTo(null);
	}
}
