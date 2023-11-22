package br.com.senai.cardapiosmktplaceview.views;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.cardapiosmktplaceview.model.Carrying;
import br.com.senai.cardapiosmktplaceview.model.User;
import br.com.senai.cardapiosmktplaceview.service.CarryingService;
import br.com.senai.cardapiosmktplaceview.service.DriverService;
import br.com.senai.cardapiosmktplaceview.views.tables.DriversTableModel;
import jakarta.annotation.PostConstruct;

@Component
public class CarriersView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTable tableDriver = new JTable();

	private JLabel lblCarrying;
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private CarryingService carryingService;
	
	public void showView(User user) {
		Carrying carrying = carryingService.findBy(user.getId());
		this.lblCarrying.setText(carrying.getName());
		this.setVisible(true);
	}

	@PostConstruct
	public void initialize() {
		DriversTableModel model = new DriversTableModel(driverService.findAll());
		tableDriver.setModel(model);
	}
	
	public CarriersView() {
		setTitle("Tela transportadora");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblCarrying = new JLabel("Nome");
		lblCarrying.setBounds(10, 11, 438, 32);
		lblCarrying.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		JButton btnCadastrarMotorista = new JButton("Cadastrar Motorista");
		
		JScrollPane scrollPane = new JScrollPane(tableDriver);
		
		JButton btnLogout = new JButton("Logout");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCarrying)
							.addPreferredGap(ComponentPlacement.RELATED, 412, Short.MAX_VALUE)
							.addComponent(btnLogout))
						.addComponent(btnCadastrarMotorista)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCarrying)
						.addComponent(btnLogout))
					.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCadastrarMotorista)
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
		setLocationRelativeTo(null);
	}
}
