package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Funcionario;
import persistencia.BD;
import persistencia.BDFuncionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CadastrarPermissoes extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private Funcionario func;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarPermissoes frame = new CadastrarPermissoes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CadastrarPermissoes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Digite o nome do Funcionário:");
		lblNome.setBounds(10, 81, 194, 14);
		contentPane.add(lblNome);
		
		JLabel lblTitulo = new JLabel("Cadastro de permissão para Área Especial");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBounds(93, 11, 264, 15);
		contentPane.add(lblTitulo);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 106, 362, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
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
		
		rdbtnEspecialSim.setBounds(10, 186, 83, 23);
		contentPane.add(rdbtnEspecialSim);
		
		rdbtnEspecialNao.setBounds(95, 186, 109, 23);
		contentPane.add(rdbtnEspecialNao);
		
		JLabel lblPermissao = new JLabel("Permitir acessar áreas especiais:");
		lblPermissao.setBounds(10, 145, 212, 14);
		contentPane.add(lblPermissao);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome;
				String mensagemErroEspecial;
				
				// ------ verifica se digitou alguma coisa errada. exemplo: se colocou números onde era letras
				
				if (!txtNome.getText().substring(0).matches("[A-z]*")) {
					JOptionPane.showMessageDialog(null, "Digite o nome apenas com letras");
					return;
				}
				else if (txtNome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Você deixou algumas informações em branco");
					return;
				}
				else {
					nome = txtNome.getText();
				}
				
				// ------ verifica se foi selecionado alguma caixa
				
				if (!rdbtnEspecialNao.isSelected() && !rdbtnEspecialSim.isSelected()) {
					mensagemErroEspecial = "Você não marcou uma opção : Tipo do veículo";
					JOptionPane.showMessageDialog(null, mensagemErroEspecial);
					mensagemErroEspecial= null;
					return;
				}
				
				boolean especial = rdbtnEspecialSim.isSelected();
				func = BDFuncionario.getInstance().buscarFuncionario(nome);
				
				if (func == null) {
					if(JOptionPane.showConfirmDialog(null, "Funcionário não cadastrado, você desejar cadastrar?", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
						CadastrarFuncionario cadastrarFunc = new CadastrarFuncionario();
						cadastrarFunc.setVisible(true);
					}
					else {
						CadastrarPermissoes.this.dispose();
					}
				}
				else {
					func.setEspecial(especial);
					BDFuncionario.getInstance().salvarFuncionario(func);
					JOptionPane.showMessageDialog(null, "Permissão Atualizada!");
					CadastrarPermissoes.this.dispose();
					
				}
			}
		});
		btnCadastrar.setBounds(169, 216, 109, 23);
		contentPane.add(btnCadastrar);
	}
}
