package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import model.Ocorrencia;
import model.Veiculo;
import persistencia.BD;
import persistencia.BDOcorrencia;

import javax.swing.JFormattedTextField;


public class CadastrarOcorrencia extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescricao;
	private JTextField txtVeiculo;
	private DefaultListModel dm = new DefaultListModel();
	private JList list;
	private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	private ArrayList<String> listaDeVeiculosNaoCadastrados = new ArrayList<String>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarOcorrencia frame = new CadastrarOcorrencia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// ------ adiciona na lista do Jlist
	
	private void addVeiculo(String nome) {
		
		list.setModel(dm);
		dm.addElement(nome);
	}
	
	// ------- verifica se digitou uma placa certa no modelo real
	
	public static boolean validaPlaca(String placa){
		   if(placa.length() != 7){
		      return false;
		   }
		   if(!placa.substring(0, 3).matches("[A-Z]*")){
		      return false;
		   }
		   return placa.substring(3).matches("[0-9]*");
	}
	
	
	public CadastrarOcorrencia() {
		list = new JList();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 657, 371);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new LineBorder(new Color(0, 128, 128), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsiraOsDados = new JLabel("Insira os dados da ocorrrência");
		lblInsiraOsDados.setBounds(10, 11, 182, 14);
		lblInsiraOsDados.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblInsiraOsDados);
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String selecionado = list.getSelectedValue().toString();
				txtVeiculo.setText(selecionado);
			}
		});
		list.setBounds(341, 52, 290, 142);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("Data DD/MM/AA:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 52, 118, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrio.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDescrio.setBounds(10, 101, 76, 14);
		contentPane.add(lblDescrio);
		
		JLabel lblVeculo = new JLabel("Veículo:");
		lblVeculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblVeculo.setFont(new Font("Arial", Font.PLAIN, 11));
		lblVeculo.setBounds(10, 148, 76, 14);
		contentPane.add(lblVeculo);
		setLocationRelativeTo(null);
		CadastrarOcorrencia.this.dispose();
		
		JFormattedTextField formattedTxtData = new JFormattedTextField();
		formattedTxtData.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTxtData.setBounds(96, 50, 217, 28);
		contentPane.add(formattedTxtData);
		
		try {
			MaskFormatter mask = new MaskFormatter("##/##/##");
			mask.install(formattedTxtData);
		} catch (ParseException e2) {

			e2.printStackTrace();
		}
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// ----- tira tudo o que não for letra ou número
				
				txtVeiculo.setText(txtVeiculo.getText().replaceAll("[^a-zA-Z0-9]", ""));
				
				// ------- verifica se digitou uma placa certa no modelo real
				
				if(validaPlaca(txtVeiculo.getText())){
					addVeiculo(txtVeiculo.getText());
					
					//LIMPAR TXT
					txtVeiculo.setText("");
				}
				else if (txtVeiculo.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Nenhum veículo digitado");
					return;
				}
				else {
					
					JOptionPane.showMessageDialog(null, "Você digitou uma placa inválida");
					return;
				}
			}
		});
		btnAdicionar.setBounds(358, 238, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = list.getSelectedIndex();
				
				dm.removeElementAt(index);
				
				//LIMPAR TXT
				txtVeiculo.setText("");
			}
		});
		btnDeletar.setBounds(514, 238, 89, 23);
		contentPane.add(btnDeletar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = list.getSelectedIndex();
				dm.setElementAt(txtVeiculo.getText(), index);
				
				//LIMPAR TXT
				txtVeiculo.setText("");
			}
		});
		btnAtualizar.setBounds(358, 205, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm.clear();
				list.setModel(dm);
			}
		});
		btnLimpar.setBounds(514, 205, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (dm.isEmpty() || txtDescricao.getText().equals("") || formattedTxtData.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Você deixou algumas informações em branco");
					return;
				}
				
				// ------ data
				
				Date data = null;
				
				try {
					data = sdf.parse(formattedTxtData.getText());
				} 
				catch (ParseException e1) {
					e1.printStackTrace();
				}
				
	// ----- percorre a lista do Jlist e retorna os veiculos digitados fazendo a verificação se esse veiculo consta no sistema
				
				String descricao = txtDescricao.getText();
				Veiculo veiculo;
				
				for (int i = 0; i < dm.getSize(); i++) {
					
					String placa = (String) dm.elementAt(i);
					
					if (BD.getInstance().buscarVeiculoPorPlaca(placa) == null) {
						listaDeVeiculosNaoCadastrados.add(placa);
					}
					
					else {
						veiculo = BD.getInstance().buscarVeiculoPorPlaca(placa);
						veiculos.add(veiculo);
					}
				}
				
				// ------- se a lista conter algo, ele mostra todos os nomes que n�o est�o cadastrados nos sistema

				if (listaDeVeiculosNaoCadastrados.isEmpty()) {
					
					Ocorrencia ocorrencia = new Ocorrencia(data, descricao, veiculos);
					BDOcorrencia.getInstance().salvarOcorrencia(ocorrencia);
					JOptionPane.showMessageDialog(null, "Ocorrência cadastrada!");
					CadastrarOcorrencia.this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Veículos não cadastrados: " + listaDeVeiculosNaoCadastrados);
					
					if(JOptionPane.showConfirmDialog(null, "Deseja cadastrar agora?", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
						
						listaDeVeiculosNaoCadastrados.clear();
						dm.clear();
						CadastrarVeiculo cadastrarVeiculo = new CadastrarVeiculo();
						cadastrarVeiculo.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Ocorrência não salva por falta de informações!");
						CadastrarOcorrencia.this.dispose();
					}
				}
			}
		});
		btnCadastrar.setBounds(254, 282, 102, 28);
		contentPane.add(btnCadastrar);
		
		txtVeiculo = new JTextField();
		txtVeiculo.setBounds(96, 141, 217, 28);
		contentPane.add(txtVeiculo);
		txtVeiculo.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				
				if (txtVeiculo.getText().equals("Veículo")) {
					txtVeiculo.setText("");
				}
				else {
					txtVeiculo.selectAll();
			}
		}});
		
		txtVeiculo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtVeiculo.setHorizontalAlignment(SwingConstants.CENTER);
		txtVeiculo.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtVeiculo.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(96, 94, 217, 28);
		contentPane.add(txtDescricao);
		txtDescricao.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (txtDescricao.getText().equals("Descrição")) {
					txtDescricao.setText("");
					}
				else {
					txtDescricao.selectAll();
					}
			}
		});
		txtDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescricao.setToolTipText("");
		txtDescricao.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtDescricao.setColumns(10);
	}
}
