package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Evento;
import persistencia.BDEstacionamento;
import persistencia.BDEvento;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Monitorar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtShow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Monitorar frame = new Monitorar();
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
	public Monitorar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new LineBorder(new Color(0, 139, 139), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Monitoramento de vagas");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel.setBounds(27, 21, 176, 14);
		contentPane.add(lblNewLabel);
		BDEvento.getInstance().buscarEvento(getName());
			
		JPanel panelShow = new JPanel();
		panelShow.setBounds(27, 75, 176, 97);
		contentPane.add(panelShow);
		panelShow.setLayout(null);
		
		txtShow = new JTextField();
		txtShow.setBounds(0, 0, 176, 97);
		panelShow.add(txtShow);
		txtShow.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 176, 97);
		textField.setColumns(10);
		
		
		
		JButton btnConsultar = new JButton("Consultar\r\n");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 	
			BDEvento.getInstance().buscarEvento(getName());
			
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(305, 28, 89, 23);
		contentPane.add(btnConsultar);
		
	
	
	}
}
