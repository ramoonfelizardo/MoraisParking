package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import model.Proprietario;
import model.Veiculo;
import persistencia.BD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastrarVeiculo extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtPlaca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarVeiculo frame = new CadastrarVeiculo();
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
	public CadastrarVeiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMatricula = new JLabel("Digite sua matrícula:");
		lblMatricula.setBounds(10, 62, 129, 14);
		contentPane.add(lblMatricula);
		
		JLabel lblTitulo = new JLabel("Cadastro de veículos");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBounds(120, 11, 189, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblPlaca = new JLabel("Digite a placa do veículo:");
		lblPlaca.setBounds(10, 113, 149, 14);
		contentPane.add(lblPlaca);
		
		JRadioButton rdbtnTipoDoVeiculoCarro = new JRadioButton("Carro");
		JRadioButton rdbtnTipoDoVeiculoMoto = new JRadioButton("Moto");
		
		rdbtnTipoDoVeiculoMoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnTipoDoVeiculoMoto.isSelected()) {

					rdbtnTipoDoVeiculoCarro.setSelected(false);

				}
			}
		});

		rdbtnTipoDoVeiculoCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnTipoDoVeiculoCarro.isSelected()) {

					rdbtnTipoDoVeiculoMoto.setSelected(false);

				}
			}
		});
		
		rdbtnTipoDoVeiculoMoto.setBounds(120, 160, 70, 23);
		contentPane.add(rdbtnTipoDoVeiculoMoto);
		
		rdbtnTipoDoVeiculoCarro.setBounds(192, 160, 70, 23);
		contentPane.add(rdbtnTipoDoVeiculoCarro);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(162, 59, 86, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(162, 110, 86, 20);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		JLabel lblTipoDoVeiculo = new JLabel("Tipo do veículo:");
		lblTipoDoVeiculo.setBounds(10, 164, 101, 14);
		contentPane.add(lblTipoDoVeiculo);
		
		JButton btnCadastrarVeiculo = new JButton("Cadastrar");
		btnCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int matricula = Integer.parseInt(txtMatricula.getText());
				String placa = txtPlaca.getText();
				String tipoDeVeiculo;
				
				if (rdbtnTipoDoVeiculoCarro.isSelected()) {

					tipoDeVeiculo = "Carro";

				} else {
					tipoDeVeiculo = "Moto";
				}
				
				Proprietario proprietario = BD.getInstance().buscarProprietario(matricula);
				if (proprietario != null) {
					Veiculo veiculoNovo = new Veiculo(placa, tipoDeVeiculo, proprietario);
					BD.getInstance().salvarVeiculo(veiculoNovo);
					JOptionPane.showMessageDialog(null, "Veículo Cadastrado!");
					CadastrarVeiculo.this.dispose();
					new InterfaceEstacionar().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Você não é cadastrado.");
					new CadastrarProprietario().visible();
					CadastrarVeiculo.this.dispose();
				}
				
			}
		});
		btnCadastrarVeiculo.setBounds(170, 213, 101, 23);
		contentPane.add(btnCadastrarVeiculo);
	}

}
