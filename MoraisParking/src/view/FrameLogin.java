package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import model.FuncionarioCredenciado;
import persistencia.BD;
import persistencia.BDCredencial;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FrameLogin extends JFrame {

	
	private JPanel contentPane;
	protected JTextField txtUsername;
	protected JPasswordField txtPassword;
	private JLabel lblLoginMessage = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
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
	public FrameLogin() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setForeground(Color.DARK_GRAY);
		panelPrincipal.setBackground(new Color(0, 128, 128));
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		
		JPanel UserNamePanel = new JPanel();
		UserNamePanel.setBounds(176, 156, 231, 37);
		panelPrincipal.add(UserNamePanel);
		UserNamePanel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().equals("Username")) {
					txtUsername.setText("");
				}
				else {}
					txtUsername.selectAll();
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 11, 159, 20);
		UserNamePanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUserloginIcon = new JLabel("");
		lblUserloginIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserloginIcon.setIcon(new ImageIcon("C:\\img\\avatar (2).png"));
		lblUserloginIcon.setBounds(201, 0, 30, 37);
		UserNamePanel.add(lblUserloginIcon);
		
		JPanel PasswordPanel = new JPanel();
		PasswordPanel.setBounds(176, 216, 231, 37);
		panelPrincipal.add(PasswordPanel);
		PasswordPanel.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password"))
				txtPassword.setEchoChar('*');
				txtPassword.setText("");
		}
		
		
		});
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPassword.setText("Password");
		txtPassword.setBounds(10, 11, 161, 20);
		PasswordPanel.add(txtPassword);
		
		JLabel lblPsswdLoginIcon = new JLabel("");
		lblPsswdLoginIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblPsswdLoginIcon.setIcon(new ImageIcon("C:\\img\\keyhole.png"));
		lblPsswdLoginIcon.setBounds(200, 0, 31, 37);
		PasswordPanel.add(lblPsswdLoginIcon);
		
		JPanel LoginPanel = new JPanel();
		LoginPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(BDCredencial.getInstance().verificacaoGeral(txtUsername.getText(), txtPassword.getText())) {
					// caso o login for correto
					lblLoginMessage.setText("");
					JOptionPane.showMessageDialog(null, "Logado!");
					FrameLogin.this.dispose();
					TelaPrincipal tela = new TelaPrincipal();
					tela.setVisible(true);
					tela.loginDigitado = txtUsername.getText();
					tela.senhaDigitada = txtPassword.getText();
					
				}
				
				else if(txtUsername.getText().equals("") ||  txtUsername.getText().equals("Username") || txtPassword.getText().equals("") || txtPassword.getText().equals("Password") ){
					lblLoginMessage.setText("Por favor, digite todas as credenciais!");
					
				}
				
				else {
					lblLoginMessage.setText("Usu�rio e senha incorreto!");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				LoginPanel.setBackground(new Color(100, 60, 60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LoginPanel.setBackground(new Color(107, 142, 35));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				LoginPanel.setBackground(new Color(60, 80, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				LoginPanel.setBackground(new Color(100, 60, 60));
			}
		});
		LoginPanel.setBackground(new Color(107, 142, 35));
		LoginPanel.setBounds(176, 304, 237, 54);
		panelPrincipal.add(LoginPanel);
		LoginPanel.setLayout(null);
		
		JLabel pnlBtnLogin = new JLabel("LOG IN");
		pnlBtnLogin.setForeground(Color.LIGHT_GRAY);
		pnlBtnLogin.setFont(new Font("Arial", Font.BOLD, 14));
		pnlBtnLogin.setBounds(85, 11, 142, 32);
		LoginPanel.add(pnlBtnLogin);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
				FrameLogin.this.dispose();
			
			 }
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			
			}
		
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setForeground(Color.LIGHT_GRAY);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(571, 0, 25, 20);
		panelPrincipal.add(lblX);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setIcon(new ImageIcon("C:\\img\\computer.png"));
		lblIconLogo.setBounds(26, 29, 535, 105);
		panelPrincipal.add(lblIconLogo);
		
		lblLoginMessage.setForeground(Color.LIGHT_GRAY);
		lblLoginMessage.setFont(new Font("Arial", Font.BOLD, 11));
		lblLoginMessage.setBounds(375, 371, 211, 14);
		panelPrincipal.add(lblLoginMessage);
		
		
		
	}
}
