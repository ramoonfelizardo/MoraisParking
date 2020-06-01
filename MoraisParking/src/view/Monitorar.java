package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import persistencia.BDEvento;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Monitorar extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 500);
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
		
		JLabel lblNewLabel_1 = new JLabel("Total de vagas:\r\n");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(27, 70, 96, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Evento:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(162, 70, 96, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data In\u00EDcio:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(27, 136, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Data Final:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(162, 136, 96, 14);
		contentPane.add(lblNewLabel_4);
		
		JList list = new JList();
		list.setBounds(122, 293, 262, 116);
		contentPane.add(list);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBackground(new Color(192, 192, 192));
		rdbtnNewRadioButton.setBounds(110, 66, 21, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBackground(new Color(192, 192, 192));
		rdbtnNewRadioButton_1.setBounds(218, 66, 22, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.setBackground(new Color(192, 192, 192));
		rdbtnNewRadioButton_2.setBounds(110, 132, 21, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_3.setBackground(new Color(192, 192, 192));
		rdbtnNewRadioButton_3.setBounds(218, 132, 21, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JButton btnConsultar = new JButton("Consultar\r\n");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(296, 242, 89, 23);
		contentPane.add(btnConsultar);
	}
}
