package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Funcionario;
import persistencia.BDFuncionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CadastrarFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCargo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarFuncionario frame = new CadastrarFuncionario();
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
	public CadastrarFuncionario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Cadastro de Funcionários");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBounds(140, 11, 171, 15);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Digite o nome:");
		lblNome.setBounds(10, 62, 83, 14);
		contentPane.add(lblNome);
		
		JLabel lblCargo = new JLabel("Digite o cargo:");
		lblCargo.setBounds(10, 104, 83, 14);
		contentPane.add(lblCargo);
		
		JLabel lblEspecial = new JLabel("Permitir acessar áreas especiais:");
		lblEspecial.setBounds(10, 152, 209, 14);
		contentPane.add(lblEspecial);
		
		txtNome = new JTextField();
		txtNome.setToolTipText("");
		txtNome.setBounds(119, 59, 289, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(119, 101, 289, 20);
		contentPane.add(txtCargo);
		txtCargo.setColumns(10);
		
		JRadioButton rdbtnEspecialNao = new JRadioButton("Nao");
		JRadioButton rdbtnEspecialSim = new JRadioButton("Sim");
		rdbtnEspecialSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnEspecialSim.isSelected()) {

					rdbtnEspecialNao.setSelected(false);

				}
			}
		});

		rdbtnEspecialNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnEspecialNao.isSelected()) {

					rdbtnEspecialSim.setSelected(false);

				}
			}
		});
		
		rdbtnEspecialSim.setBounds(10, 186, 109, 23);
		contentPane.add(rdbtnEspecialSim);
		
		rdbtnEspecialNao.setBounds(148, 186, 109, 23);
		contentPane.add(rdbtnEspecialNao);
		
		JButton btnCadastrarFuncionario = new JButton("Cadastrar");
		btnCadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = txtNome.getText();
				String cargo = txtCargo.getText();
				boolean especial = rdbtnEspecialSim.isSelected();
				
				Funcionario funcionario = new Funcionario(nome, cargo);
				//funcionario.setEspecial(especial);
				
				BDFuncionario.getInstance().salvarFuncionario(funcionario);
				
				int escolha = JOptionPane.showConfirmDialog(null, "Funcionário cadastrado. Deseja cadastar mais algum funcionário?",
						"Confirm", JOptionPane.YES_NO_OPTION);

				if (escolha != 0) {

					CadastrarFuncionario.this.dispose();
					
				}
				
				txtCargo.setText("");
				txtNome.setText("");
				rdbtnEspecialNao.setSelected(false);
				rdbtnEspecialSim.setSelected(false);
			}
		});
		btnCadastrarFuncionario.setBounds(177, 216, 98, 23);
		contentPane.add(btnCadastrarFuncionario);
	}
}
