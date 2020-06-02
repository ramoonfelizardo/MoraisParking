package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Proprietario;
import persistencia.BD;
import persistencia.BDEstacionamento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;

public class CadastrarAreaEspecial extends JFrame {

	private JPanel contentPane;
	private JTextField txtQntdVagasEspeciais;
	private JTextField txtNome;
	private DefaultListModel dm = new DefaultListModel();
	private JList list;
	private ArrayList<Proprietario> listaDeUsuarios = new ArrayList<Proprietario>();
	private ArrayList<String> listaDeUsuariosNaoCadastrados = new ArrayList<String>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarAreaEspecial frame = new CadastrarAreaEspecial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// ------ adicionar os nomes na lista do Jlist
	
	private void addNome(String nome) {
		
		list.setModel(dm);
		dm.addElement(nome);
	}

	public CadastrarAreaEspecial() {
		list = new JList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Cadastrar Área Especial");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBounds(193, 11, 189, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblQntdVagasEspeciais = new JLabel("Informe a quantidade de vagas especiais que você deseja:");
		lblQntdVagasEspeciais.setBounds(10, 62, 347, 14);
		contentPane.add(lblQntdVagasEspeciais);
		
		txtQntdVagasEspeciais = new JTextField();
		txtQntdVagasEspeciais.setBounds(20, 87, 97, 20);
		contentPane.add(txtQntdVagasEspeciais);
		txtQntdVagasEspeciais.setColumns(10);
		
		JButton btnCadastrarAreaEspecial = new JButton("Cadastrar");
		btnCadastrarAreaEspecial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int qtdVagasEspeciais;
				
				// ------- verifica se digitou apenas números
				
				if (!txtQntdVagasEspeciais.getText().substring(0).matches("[0-9]*")) {
					JOptionPane.showMessageDialog(null, "Por favor, digite apenas números");
					return;
				}
				
				else {
					qtdVagasEspeciais = Integer.parseInt(txtQntdVagasEspeciais.getText());
					try {
						BDEstacionamento.getInstance().addVagaEspecial(qtdVagasEspeciais);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
				}
				
		// ----- percorre a lista do Jlist e retorna os nomes digitados fazendo a verificação se esse nome consta no sistema
				
				for (int i = 0; i < dm.getSize(); i++) {
					String nome = (String) dm.elementAt(i);
					if (BD.getInstance().buscarProprietarioPeloNome(nome) == null) {
						listaDeUsuariosNaoCadastrados.add(nome);
					}
					else {
						Proprietario prop = BD.getInstance().buscarProprietarioPeloNome(nome);
						prop.setEspecial(true);
						BD.getInstance().salvarProprietario(prop);
					}
				}
				
				// ------- se a lista conter algo, ele mostra todos os nomes que não estão cadastrados nos sistema
				
				if (listaDeUsuariosNaoCadastrados.isEmpty()) {
					CadastrarAreaEspecial.this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Usuários digitados não cadastrados: " + listaDeUsuariosNaoCadastrados);
					CadastrarAreaEspecial.this.dispose();
				}
			}
		});
		btnCadastrarAreaEspecial.setBounds(247, 299, 97, 23);
		contentPane.add(btnCadastrarAreaEspecial);
		

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String selecionado = list.getSelectedValue().toString();
				txtNome.setText(selecionado);
			}
		});
		list.setBounds(299, 145, 271, 128);
		contentPane.add(list);
		
		JLabel lblUsuariosPermissoes = new JLabel("Digite os nomes dos usuários que você deseja permitir acesso:");
		lblUsuariosPermissoes.setBounds(10, 118, 372, 14);
		contentPane.add(lblUsuariosPermissoes);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// ----- verifica se foi digitado apenas letras
				
				if (!txtNome.getText().substring(0).matches("[A-z]*")) {
					JOptionPane.showMessageDialog(null, "Por favor, digite apenas letras no nome");
					return;
				}
				else {
					addNome(txtNome.getText());
					
					//LIMPAR TXT
					txtNome.setText("");
				}
			}
		});
		btnAdicionar.setBounds(18, 183, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = list.getSelectedIndex();
				
				dm.removeElementAt(index);
				
				//LIMPAR TXT
				txtNome.setText("");
			}
		});
		btnDeletar.setBounds(18, 217, 89, 23);
		contentPane.add(btnDeletar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = list.getSelectedIndex();
				dm.setElementAt(txtNome.getText(), index);
				
				//LIMPAR TXT
				txtNome.setText("");
			}
		});
		btnAtualizar.setBounds(137, 183, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm.clear();
				list.setModel(dm);
			}
		});
		btnLimpar.setBounds(137, 217, 89, 23);
		contentPane.add(btnLimpar);
		
		txtNome = new JTextField();
		txtNome.setBounds(20, 143, 226, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
	}
}
