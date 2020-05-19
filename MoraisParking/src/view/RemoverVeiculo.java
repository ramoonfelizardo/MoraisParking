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

public class RemoverVeiculo extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaca;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public RemoverVeiculo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPlaca = new JTextField();
		txtPlaca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String placa = txtPlaca.getText();
				
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
		txtPlaca.setBounds(169, 128, 102, 20);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Digite a placa do veículo para remover");
		lblPlaca.setBounds(124, 92, 183, 14);
		contentPane.add(lblPlaca);
	}
}
