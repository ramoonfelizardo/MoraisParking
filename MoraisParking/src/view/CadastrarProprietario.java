package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public CadastrarProprietario() {
		initialize();
	}
	public void visible() {
		frame.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
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

		JLabel lblNewLabel_3Matricula = new JLabel("Matr\u00EDcula");
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

		JLabel lblNewLabel_4AreaEspecial = new JLabel("Area especial");
		lblNewLabel_4AreaEspecial.setBounds(10, 222, 84, 14);
		frame.getContentPane().add(lblNewLabel_4AreaEspecial);

		JLabel lblNewLabel_5TipoVeiculo = new JLabel("Tipo de veiculo");
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

				String nome = textFieldNome.getText();
				String curso = textField_1Curso.getText();
				int matricula = Integer.parseInt(textField_2Matricula.getText());

				boolean especial = rdbtnNewRadioButtonSIM.isSelected();

				Proprietario pro = new Proprietario(nome, curso, matricula, especial);

				// --------------------Veiculo-----------------

				String placa = textField_3Placa.getText();
				String tipoDeVeiculo;

				if (rdbtnNewRadioButton_2CARRO.isSelected()) {

					tipoDeVeiculo = "Carro";

				} else {
					tipoDeVeiculo = "Moto";
				}

				Veiculo veiculo = new Veiculo(placa, tipoDeVeiculo, pro);
				
				BD.getInstance().salvarProprietario(pro);
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
