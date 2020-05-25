package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class TelaPrincipal extends JFrame {
	
	protected String loginDigitado, senhaDigitada;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 370);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnEstac = new JMenu("Estacionamento");
		menuBar.add(mnEstac);
		
		JMenu mnNew = new JMenu("Cadastrar");
		mnEstac.add(mnNew);
		
		JMenuItem mnItemCadVeic = new JMenuItem("Ve\u00EDculo");
		mnItemCadVeic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BDCredencial.getInstance().verificacaoEstac(loginDigitado, senhaDigitada)) {
					new CadastrarProprietario().visible();
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
				if(BDCredencial.getInstance().verificacaoEstac(loginDigitado, senhaDigitada)) {
					new CadastrarEvento().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Acesso Negado");
				}
			}
		});
		
		mnNew.add(mnItemCadEven);
		
		JMenuItem mnItemCadOc = new JMenuItem("Ocorr\u00EAncia");
		mnItemCadOc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BDCredencial.getInstance().verificacaoEstac(loginDigitado, senhaDigitada)) 
				{new CadastrarOcorrencia().setVisible(true);
					}
				
				else {
					JOptionPane.showMessageDialog(null, "Acesso Negado");
				}
			}
		});
		
		mnNew.add(mnItemCadOc);
		
		JMenuItem mnItemCadArEsp = new JMenuItem("\u00C1rea Especial");
		mnNew.add(mnItemCadArEsp);
		
		JMenuItem mnItemRemVeic = new JMenuItem("Remover Ve\u00EDculo");
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
		
		JMenuItem mnItemPermissoes = new JMenuItem("Permiss\u00F5es");
		mnEstac.add(mnItemPermissoes);
		
		JMenu mnNewMenu = new JMenu("Monitoramento");
		menuBar.add(mnNewMenu);
		
		JMenuItem mnItemMonitorar = new JMenuItem("Monitorar");
		mnNewMenu.add(mnItemMonitorar);
		
		JMenu mnNewMenu_1 = new JMenu("Gest\u00E3o");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mnItemCadFunc = new JMenuItem("Cadastrar Funcion\u00E1rio");
		mnItemCadFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (BDCredencial.getInstance().verificacaoGestor(loginDigitado, senhaDigitada)) {
					new CadastrarFuncionario().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Acesso Negado");
				}
			}
		});
		mnNewMenu_1.add(mnItemCadFunc);
		
		JMenu mnRelatorio = new JMenu("Relat\u00F3rio");
		menuBar.add(mnRelatorio);
		
		JMenuItem mnItemVisRel = new JMenuItem("Visualizar Relat\u00F3rio");
		mnRelatorio.add(mnItemVisRel);
		
		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 492, 275);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImgMorais =  new JLabel("");
		lblImgMorais.setIcon(new ImageIcon("C:\\Users\\Ramon\\Documents\\Atividades Java\\Logos Morais Parking\\Logo Morais Parking.png"));
		lblImgMorais.setBounds(209, 71, 216, 147);
		panel.add(lblImgMorais);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 492, 275);
		layeredPane.add(panel_1);
		
		JButton btnEstacionar = new JButton("Estacionar");
		btnEstacionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InterfaceEstacionar().setVisible(true);
			}
		});
		btnEstacionar.setBounds(498, 12, 104, 23);
		layeredPane.add(btnEstacionar);
	}
}
