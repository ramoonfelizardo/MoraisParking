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
	
	// ------- verifica se digitou uma placa certa no modelo real

	private static boolean validaPlaca(String placa){
		   if(placa.length() != 7){
		      return false;
		   }
		   if(!placa.substring(0, 3).matches("[A-Z]*")){
		      return false;
		   }
		   return placa.substring(3).matches("[0-9]*");
	}
	
	public CadastrarVeiculo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
				String matricula = txtMatricula.getText();
				String placa = null;
				String tipoDeVeiculo;
				String mensagemErroTipoDoVeiculo = null;
				
				// ----- tira tudo o que não for letra ou número
				
				txtPlaca.setText(txtPlaca.getText().replaceAll("[^a-zA-Z0-9]", ""));
				
				// ------- verifica se digitou uma placa certa no modelo real
				
				if(validaPlaca(txtPlaca.getText())){
					placa = txtPlaca.getText();
				}
				else if (txtPlaca.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Você deixou algumas informações em branco");
					return;
				}
				else {
					JOptionPane.showMessageDialog(null, "Você digitou uma placa inválida");
					return;
				}
				
				// ------ verifica se foi selecionado alguma caixa
				
				if (!rdbtnTipoDoVeiculoCarro.isSelected() && !rdbtnTipoDoVeiculoMoto.isSelected()) {
					mensagemErroTipoDoVeiculo = "Você não marcou uma opção : Tipo do veículo";
					JOptionPane.showMessageDialog(null, mensagemErroTipoDoVeiculo);
					mensagemErroTipoDoVeiculo = null;
					return;
				}
				
				if (rdbtnTipoDoVeiculoCarro.isSelected()) {

					tipoDeVeiculo = "Carro";

				} else {
					tipoDeVeiculo = "Moto";
				}
				
				// ------ verifica se foi digitado apenas números
				
				if (!matricula.substring(0).matches("[0-9]*")) {
					JOptionPane.showMessageDialog(null, "Por favor, digite apenas números na matrícula");
					return;
				}
				
				Proprietario proprietario = BD.getInstance().buscarProprietario(matricula);
				if (proprietario != null) {
					Veiculo veiculoNovo = new Veiculo(placa, tipoDeVeiculo, proprietario);
					BD.getInstance().salvarVeiculo(veiculoNovo);
					if(JOptionPane.showConfirmDialog(null, "Veículo cadastrado, você deseja cadastrar outro?", "Confirm", JOptionPane.YES_NO_OPTION) != 0) {
						CadastrarVeiculo.this.dispose();
					}
					else {
						txtMatricula.setText("");
						txtPlaca.setText("");
						rdbtnTipoDoVeiculoCarro.setSelected(false);
						rdbtnTipoDoVeiculoMoto.setSelected(false);
					}
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
