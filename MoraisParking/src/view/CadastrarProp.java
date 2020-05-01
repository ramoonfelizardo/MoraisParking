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

public class CadastrarProp {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarProp window = new CadastrarProp();
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
	public CadastrarProp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void visible() {
		frame.setVisible(true);
	}
	private void initialize() {

		ArrayList<Proprietario> list = new ArrayList<Proprietario>();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Informe os dados para realizar o cadastro");
		lblNewLabel.setBounds(10, 22, 283, 20);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 76, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(100, 73, 224, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Curso");
		lblNewLabel_2.setBounds(10, 119, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(100, 116, 224, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Matr\u00EDcula");
		lblNewLabel_3.setBounds(10, 166, 80, 14);
		frame.getContentPane().add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setBounds(100, 163, 224, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Sim");
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Nao");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnNewRadioButton_1.isSelected()) {

					rdbtnNewRadioButton.setSelected(false);

				}

			}
		});

		rdbtnNewRadioButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (rdbtnNewRadioButton.isSelected()) {

					rdbtnNewRadioButton_1.setSelected(false);

				}

			}
		});
		rdbtnNewRadioButton.setBounds(100, 218, 62, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1.setBounds(164, 218, 59, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);

		JLabel lblNewLabel_4 = new JLabel("Area especial");
		lblNewLabel_4.setBounds(10, 222, 84, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Tipo de veiculo");
		lblNewLabel_5.setBounds(10, 270, 84, 14);
		frame.getContentPane().add(lblNewLabel_5);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Carro");
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Moto");

		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnNewRadioButton_2.isSelected()) {

					rdbtnNewRadioButton_3.setSelected(false);

				}

			}
		});
		rdbtnNewRadioButton_2.setBounds(100, 266, 59, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);

		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnNewRadioButton_3.isSelected()) {

					rdbtnNewRadioButton_2.setSelected(false);

				}

			}
		});
		rdbtnNewRadioButton_3.setBounds(164, 266, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);

		JLabel lblNewLabel_6 = new JLabel("Placa");
		lblNewLabel_6.setBounds(10, 320, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);

		textField_3 = new JTextField();
		textField_3.setBounds(100, 317, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = textField.getText();
				String curso = textField_1.getText();
				int matricula = Integer.parseInt(textField_2.getText());

				boolean especial = rdbtnNewRadioButton.isSelected();

				Proprietario pro = new Proprietario(nome, curso, matricula, especial);
				
				//--------------------Veiculo-----------------
				
				
				String placa = textField_3.getText();
				String tipoDeVeiculo;
				
				
				if(rdbtnNewRadioButton_2.isSelected()) {
				
					tipoDeVeiculo = "Carro";
				
				}else {
						tipoDeVeiculo = "Moto";
				}	
				
				
				Veiculo veiculo = new Veiculo(placa, tipoDeVeiculo, pro);
				pro.setVeiculo(veiculo);
				
				JOptionPane.showConfirmDialog(null, "Cadastrado com sucesso! \nDeseja cadastrar mais algum?","Comfirm",JOptionPane.YES_NO_OPTION);
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				
				rdbtnNewRadioButton.setSelected(false);
				rdbtnNewRadioButton_1.setSelected(false);
				rdbtnNewRadioButton_2.setSelected(false);
				rdbtnNewRadioButton_3.setSelected(false);
				
				 list.add(pro); //Lista de Usuarios e veiculos
				 
				/*
				 * Proprietario p1 = list.get(0);
				 * 
				 * p1.getVeiculo().getPlaca(); //Pegando a placa
				 */				 
			}
		});
		btnNewButton.setBounds(164, 381, 109, 23);
		frame.getContentPane().add(btnNewButton);
		
	}
}
