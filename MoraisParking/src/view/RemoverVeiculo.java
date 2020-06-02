package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.BD;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class RemoverVeiculo extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaca;
	private JLabel lblTitulo;
	private JButton btnRemover;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverVeiculo frame = new RemoverVeiculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	
	public RemoverVeiculo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(158, 130, 102, 20);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Digite a placa do veículo para remover:");
		lblPlaca.setBounds(94, 92, 247, 14);
		contentPane.add(lblPlaca);
		
		lblTitulo = new JLabel("Remossão de veículos");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBounds(118, 11, 189, 14);
		contentPane.add(lblTitulo);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String placa = null;
				
				// ----- tira tudo o que não for letra ou número
				
				txtPlaca.setText(txtPlaca.getText().replaceAll("[^a-zA-Z0-9]", ""));
				
				// ------- verifica se digitou uma placa certa no modelo real
				
				if(validaPlaca(txtPlaca.getText())){
					placa = txtPlaca.getText();
				}
				else if (txtPlaca.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Você deixou  informações em branco");
					return;
				}
				else {
					JOptionPane.showMessageDialog(null, "VocÊ digitou uma placa inválida");
					return;
				}
				
				if (BD.getInstance().excluirVeiculo(placa)) {
					if (JOptionPane.showConfirmDialog(null, "Veículo removido. Deseja remover mais algum veículo?", "Confirm", JOptionPane.YES_NO_OPTION) != 0) {
						RemoverVeiculo.this.dispose();
						 }
					}
				else if (JOptionPane.showConfirmDialog(null, "Veículo não existe. Deseja tentar de novo?", "Confirm", JOptionPane.YES_NO_OPTION) != 0) {
					RemoverVeiculo.this.dispose();
				 }
				
				txtPlaca.setText("");
				
			}
		});
		btnRemover.setBounds(167, 214, 89, 23);
		contentPane.add(btnRemover);
	}
}
