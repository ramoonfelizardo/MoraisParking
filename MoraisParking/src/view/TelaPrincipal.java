package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Funcionario;
import model.FuncionarioCredenciado;
import persistencia.BDCredencial;
import view.FrameLogin;
import javax.swing.JButton;
import view.Monitorar;
import view.FrameLogin;
import java.awt.Font;


public class TelaPrincipal extends JFrame {
	
	protected String loginDigitado, senhaDigitada;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 370);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnEstac = new JMenu("Estacionamento");
		menuBar.add(mnEstac);
		
		JMenu mnNew = new JMenu("Cadastrar");
		mnEstac.add(mnNew);
		
		JMenuItem mnItemCadUsuario = new JMenuItem("Usuário");
		mnItemCadUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BDCredencial.getInstance().verificacaoEstac(loginDigitado, senhaDigitada)) {
					new CadastrarProprietario().visible();
				}
				else {
					JOptionPane.showMessageDialog(null, "Acesso Negado");
				}
			}
		});
		mnNew.add(mnItemCadUsuario);
		
		JMenuItem mnItemCadVeic = new JMenuItem("Veículo");
		mnItemCadVeic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BDCredencial.getInstance().verificacaoEstac(loginDigitado, senhaDigitada)) {
					new CadastrarVeiculo().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Acesso Negado");
				}
			}
		});
		mnNew.add(mnItemCadVeic);
		
		JMenuItem mnItemCadEven = new JMenuItem("Evento");
		 mnItemCadEven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BDCredencial.getInstance().verificacaoEstac(loginDigitado, senhaDigitada) || BDCredencial.getInstance().verificacaoGestor(loginDigitado, senhaDigitada)) {
					new CadastrarEvento().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Acesso Negado");
				}
			}
		});
		
		mnNew.add(mnItemCadEven);
		
		JMenuItem mnItemCadOc = new JMenuItem("Ocorrência");
		mnItemCadOc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BDCredencial.getInstance().verificacaoEstac(loginDigitado, senhaDigitada)) {
				new CadastrarOcorrencia().setVisible(true);
					}
				
				else {
					JOptionPane.showMessageDialog(null, "Acesso Negado");
				}
			}
		});
		
		mnNew.add(mnItemCadOc);
		
		JMenuItem mnItemCadArEsp = new JMenuItem("Área Especial");
		mnItemCadArEsp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BDCredencial.getInstance().verificacaoGestor(loginDigitado, senhaDigitada)) {
					new CadastrarAreaEspecial().setVisible(true);
						}
					
					else {
						JOptionPane.showMessageDialog(null, "Acesso Negado");
					}
			}
		});
		mnNew.add(mnItemCadArEsp);
		
		JMenuItem mnItemRemVeic = new JMenuItem("Remover Veículo");
		mnItemRemVeic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BDCredencial.getInstance().verificacaoEstac(loginDigitado, senhaDigitada)) {
					new RemoverVeiculo().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Acesso Negado");
				}
			}
		});
		mnEstac.add(mnItemRemVeic);
		
		JMenuItem mnItemPermissoes = new JMenuItem("Permissões");
		mnItemPermissoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BDCredencial.getInstance().verificacaoRH(loginDigitado, senhaDigitada)) {
					new CadastrarPermissoes().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Acesso Negado");
				}
			}
		});
		mnEstac.add(mnItemPermissoes);
		
		JMenu mnNewMenu = new JMenu("Monitoramento");
		menuBar.add(mnNewMenu);
		
		JMenuItem mnItemMonitorar = new JMenuItem("Monitorar");
		mnItemMonitorar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BDCredencial.getInstance().verificacaoRH(loginDigitado, senhaDigitada) || BDCredencial.getInstance().verificacaoEstac(loginDigitado, senhaDigitada)) {
					try {
						new Monitorar().setVisible(true);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Acesso Negado");
				}
			}
		});
		
		
		
		
		mnNewMenu.add(mnItemMonitorar);
		
		JMenu mnNewMenu_1 = new JMenu("Recursos Humanos");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mnItemCadFunc = new JMenuItem("Cadastrar Funcionário");
		mnItemCadFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (BDCredencial.getInstance().verificacaoRH(loginDigitado, senhaDigitada)) {
					new CadastrarFuncionario().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Acesso Negado");
				}
			}
		});
		mnNewMenu_1.add(mnItemCadFunc);
		
		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 492, 275);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImgMorais =  new JLabel("");
		lblImgMorais.setIcon(new ImageIcon("C:\\img\\Logo Morais Parking.png"));
		lblImgMorais.setBounds(209, 71, 216, 147);
		panel.add(lblImgMorais);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 492, 275);
		layeredPane.add(panel_1);
		
		JButton btnEstacionar = new JButton("Estacionar");
		btnEstacionar.setFont(new Font("Arial", Font.BOLD, 11));
		btnEstacionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InterfaceEstacionar().setVisible(true);
			}
		});
		btnEstacionar.setBounds(498, 12, 104, 23);
		layeredPane.add(btnEstacionar);
		
		JButton btnSair = new JButton("LOG OFF");
		btnSair.setFont(new Font("Arial", Font.BOLD, 11));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
				TelaPrincipal.this.dispose();
				FrameLogin frame = new FrameLogin();
				frame.setVisible(true);
				}
			}
		});
		
	
		
		btnSair.setBounds(498, 275, 104, 23);
		layeredPane.add(btnSair);
	}
}
