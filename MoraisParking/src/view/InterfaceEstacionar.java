package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Estacionamento;
import model.Proprietario;
import model.Veiculo;

public class InterfaceEstacionar extends JFrame  {

	private ArrayList<Proprietario> p = new ArrayList<Proprietario>();
	private Proprietario proprietario = new Proprietario();
	private	Estacionamento estacionamento = new Estacionamento();
	private InterfaceProprietario interfaceProprietario = new InterfaceProprietario();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				p = interfaceProprietario.getLista();
				
				
				for(int i = 0; i < p.size(); i++) {
					
					if(p.get(i).getVeiculo().getPlaca().contentEquals(placa)) {
						
						proprietario = p.get(i);
						
						i = i + p.size();
					}
					i++;
				}
				
				estacionamento.locada(proprietario.getEspecial());
				
				
				System.out.println(estacionamento.getQtdVagasEspeciais());
				System.out.println(estacionamento.getQtdVagas());
				
			}
				
		
		});
		btnEstacionar.setBounds(151, 166, 112, 23);
		contentPane.add(btnEstacionar);
	}
	
	public void setP(ArrayList<Proprietario> lista) {
		this.p = lista;
	}
	
	public ArrayList<Proprietario> getP() {
		return p;
	}
	
}
