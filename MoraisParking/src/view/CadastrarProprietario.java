package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.Proprietario;
import model.Veiculo;
import persistencia.BD;

public class CadastrarProprietario {

	private JFrame frame;
	private JTextField textFieldNome;
	private JTextField textField_1Curso;
	private JTextField textField_2Matricula;
	private JTextField textField_3Placa;
	private static ArrayList<String> listaDeErros = new ArrayList<String>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarProprietario window = new CadastrarProprietario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CadastrarProprietario() {
		initialize();
	}
	
	// ---- deixa o frame visível
	
	public void visible() {
		frame.setVisible(true);
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
	
	// ------ verifica se digitou alguma coisa errada. exemplo: se colocou números onde era letras
	
	private static ArrayList<String> validaInformacoes(String nome, String curso, String matricula) {
		if (!nome.substring(0).matches("[A-z]*")) {
			listaDeErros.add(nome);
		}
		if (!curso.substring(0).matches("[A-z]*")) {
			listaDeErros.add(curso);
		}
		if (!matricula.substring(0).matches("[0-9]*")) {
			listaDeErros.add(matricula);
		}
		
		return listaDeErros;
	}
	
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 476);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel labelTitulo = new JLabel("Informe os dados para realizar o cadastro");
		labelTitulo.setBounds(10, 22, 314, 20);
		frame.getContentPane().add(labelTitulo);

		JLabel lblNewLabel_1Nome = new JLabel("Nome");
		lblNewLabel_1Nome.setBounds(10, 76, 46, 14);
		frame.getContentPane().add(lblNewLabel_1Nome);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(100, 73, 224, 20);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblNewLabel_2Curso = new JLabel("Curso");
		lblNewLabel_2Curso.setBounds(10, 119, 46, 14);
		frame.getContentPane().add(lblNewLabel_2Curso);

		textField_1Curso = new JTextField();
		textField_1Curso.setBounds(100, 116, 224, 20);
		frame.getContentPane().add(textField_1Curso);
		textField_1Curso.setColumns(10);

		JLabel lblNewLabel_3Matricula = new JLabel("Matrícula");
		lblNewLabel_3Matricula.setBounds(10, 166, 62, 14);
		frame.getContentPane().add(lblNewLabel_3Matricula);

		textField_2Matricula = new JTextField();
		textField_2Matricula.setBounds(100, 163, 224, 20);
		frame.getContentPane().add(textField_2Matricula);
		textField_2Matricula.setColumns(10);

		JRadioButton rdbtnNewRadioButtonSIM = new JRadioButton("Sim");
		JRadioButton rdbtnNewRadioButton_1NAO = new JRadioButton("Nao");
		rdbtnNewRadioButton_1NAO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton_1NAO.isSelected()) {
					rdbtnNewRadioButtonSIM.setSelected(false);
				}
			}
		});

		rdbtnNewRadioButtonSIM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButtonSIM.isSelected()) {
					rdbtnNewRadioButton_1NAO.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButtonSIM.setBounds(100, 218, 62, 23);
		frame.getContentPane().add(rdbtnNewRadioButtonSIM);

		rdbtnNewRadioButton_1NAO.setBounds(164, 218, 59, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1NAO);

		JLabel lblNewLabel_4AreaEspecial = new JLabel("Área especial");
		lblNewLabel_4AreaEspecial.setBounds(10, 222, 84, 14);
		frame.getContentPane().add(lblNewLabel_4AreaEspecial);

		JLabel lblNewLabel_5TipoVeiculo = new JLabel("Tipo do veiculo");
		lblNewLabel_5TipoVeiculo.setBounds(10, 270, 84, 14);
		frame.getContentPane().add(lblNewLabel_5TipoVeiculo);

		JRadioButton rdbtnNewRadioButton_2CARRO = new JRadioButton("Carro");
		JRadioButton rdbtnNewRadioButton_3MOTO = new JRadioButton("Moto");

		rdbtnNewRadioButton_2CARRO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton_2CARRO.isSelected()) {
					rdbtnNewRadioButton_3MOTO.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton_2CARRO.setBounds(100, 266, 59, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2CARRO);

		rdbtnNewRadioButton_3MOTO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton_3MOTO.isSelected()) {
					rdbtnNewRadioButton_2CARRO.setSelected(false);
				}
			}
		});
		
		rdbtnNewRadioButton_3MOTO.setBounds(164, 266, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3MOTO);

		JLabel lblNewLabel_6Placa = new JLabel("Placa");
		lblNewLabel_6Placa.setBounds(10, 320, 62, 14);
		frame.getContentPane().add(lblNewLabel_6Placa);

		textField_3Placa = new JTextField();
		textField_3Placa.setBounds(100, 317, 95, 20);
		frame.getContentPane().add(textField_3Placa);
		textField_3Placa.setColumns(10);

		JButton btnNewButtonCadastrar = new JButton("Cadastrar");
		btnNewButtonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curso;
				String nome;
				String matricula;
				String mensagemErroEspecial = null;
				String mensagemErroTipoDoVeiculo = null;
				
				// ---- verifica se faltou colocar alguma informação ou se digitou errado
				
				validaInformacoes(textFieldNome.getText(), textField_1Curso.getText(), textField_2Matricula.getText());
				if (listaDeErros.isEmpty()) {
					nome = textFieldNome.getText();
					curso = textField_1Curso.getText();
					matricula = textField_2Matricula.getText();
				}
				
				else if (textField_1Curso.getText().isEmpty() || textField_2Matricula.getText().isEmpty() || textFieldNome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Você deixou algumas informações em branco");
					return;
				}
				else {
					JOptionPane.showMessageDialog(null, "Você digitou incorretamente as seguintes informações:\n" + listaDeErros);
					listaDeErros.clear();
					return;
				}
				
				// ------ verifica se foi selecionado alguma caixa

				if (!rdbtnNewRadioButton_1NAO.isSelected() && !rdbtnNewRadioButtonSIM.isSelected()) {
					mensagemErroEspecial = "Você não marcou uma opção : Especial";
				}
				
				boolean especial = rdbtnNewRadioButtonSIM.isSelected();

				Proprietario proprietario = new Proprietario(nome, curso, matricula, especial);
				
				
				
				

				// --------------------Veiculo-----------------
				
				String placa = null;
				
				textField_3Placa.setText(textField_3Placa.getText().replaceAll("[^a-zA-Z0-9]", ""));
				
				if(validaPlaca(textField_3Placa.getText())){
					placa = textField_3Placa.getText();
				}
				else if (textField_3Placa.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Você deixou algumas informações em branco");
					return;
				}
				else {
					JOptionPane.showMessageDialog(null, "Você digitou uma placa inválida");
					return;
				}
				
				// ------ verifica se foi selecionado alguma caixa

				if (!rdbtnNewRadioButton_2CARRO.isSelected() && !rdbtnNewRadioButton_3MOTO.isSelected()) {
					mensagemErroTipoDoVeiculo = "Você não marcou uma opção : Tipo do veículo";
				}
				
				if (mensagemErroEspecial != null || mensagemErroTipoDoVeiculo != null) {
					if (mensagemErroEspecial != null && mensagemErroTipoDoVeiculo != null) {
						JOptionPane.showMessageDialog(null, mensagemErroTipoDoVeiculo + "\n" + mensagemErroEspecial);
					}
					else if (mensagemErroEspecial == null && mensagemErroTipoDoVeiculo != null) {
						JOptionPane.showMessageDialog(null, mensagemErroTipoDoVeiculo);
					}
					else {
						JOptionPane.showMessageDialog(null, mensagemErroEspecial);
					}
					
					mensagemErroEspecial = null;
					mensagemErroTipoDoVeiculo = null;
					return;
				}
				
				String tipoDeVeiculo;
				if (rdbtnNewRadioButton_2CARRO.isSelected()) {

					tipoDeVeiculo = "Carro";

				} else {
					tipoDeVeiculo = "Moto";
				}

				Veiculo veiculo = new Veiculo(placa, tipoDeVeiculo, proprietario);
				
				BD.getInstance().salvarProprietario(proprietario);
				BD.getInstance().salvarVeiculo(veiculo);
				
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
				frame.dispose();


				textFieldNome.setText("");
				textField_1Curso.setText("");
				textField_2Matricula.setText("");
				textField_3Placa.setText("");

				rdbtnNewRadioButtonSIM.setSelected(false);
				rdbtnNewRadioButton_1NAO.setSelected(false);
				rdbtnNewRadioButton_2CARRO.setSelected(false);
				rdbtnNewRadioButton_3MOTO.setSelected(false);
			}
		});
		btnNewButtonCadastrar.setBounds(164, 381, 119, 23);
		frame.getContentPane().add(btnNewButtonCadastrar);
	}
}
