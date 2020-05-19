package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Estacionamento;
import model.Veiculo;
import persistencia.BD;

public class InterfaceEstacionar extends JFrame  {
	
	private Veiculo veiculo;
	private	Estacionamento estacionamento = new Estacionamento();
	private JPanel contentPane;
	private JTextField txtPlaca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceEstacionar frame = new InterfaceEstacionar();
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
	public InterfaceEstacionar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(139, 107, 136, 20);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		JLabel lblInsiraAPlaca = new JLabel("Insira a placa para estacionar");
		lblInsiraAPlaca.setBounds(139, 82, 189, 14);
		contentPane.add(lblInsiraAPlaca);
		
		JButton btnEstacionar = new JButton("Estacionar");
		btnEstacionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String placa = txtPlaca.getText();
				veiculo = BD.getInstance().buscarVeiculoPorPlaca(placa);
				
				estacionamento.locarVaga(veiculo.getProprietario().getEspecial());
				
			}
				
		
		});
		btnEstacionar.setBounds(151, 166, 112, 23);
		contentPane.add(btnEstacionar);
	}
}
