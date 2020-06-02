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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Monitorar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
	 * @throws ParseException 
	 */
	public Monitorar() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new LineBorder(new Color(0, 139, 139), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabelM = new JLabel("Monitoramento de vagas");
		lblNewLabelM.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabelM.setBounds(27, 21, 176, 14);
		contentPane.add(lblNewLabelM);
		
		JLabel lblVaga = new JLabel("");
		lblVaga.setOpaque(true);
		lblVaga.setForeground(new Color(0, 0, 0));
		lblVaga.setFont(new Font("Arial", Font.BOLD, 11));
		lblVaga.setBackground(SystemColor.menu);
		lblVaga.setBounds(27, 85, 136, 23);
		contentPane.add(lblVaga);
		
		JLabel labelZona = new JLabel("");
		labelZona.setOpaque(true);
		labelZona.setForeground(Color.BLACK);
		labelZona.setFont(new Font("Arial", Font.BOLD, 11));
		labelZona.setBackground(SystemColor.menu);
		labelZona.setBounds(27, 130, 136, 23);
		contentPane.add(labelZona);
		
		JLabel labelVagasEsp = new JLabel("");
		labelVagasEsp.setOpaque(true);
		labelVagasEsp.setForeground(Color.BLACK);
		labelVagasEsp.setFont(new Font("Arial", Font.BOLD, 11));
		labelVagasEsp.setBackground(SystemColor.menu);
		labelVagasEsp.setBounds(27, 173, 136, 23);
		contentPane.add(labelVagasEsp);
		
		JLabel labelEvento = new JLabel("");
		labelEvento.setFont(new Font("Arial", Font.BOLD, 11));
		labelEvento.setOpaque(true);
		labelEvento.setBounds(274, 85, 120, 23);
		contentPane.add(labelEvento);
		
	
		
		
		
		
		JButton btnConsultar = new JButton("Consultar\r\n");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 	
				try {
					lblVaga.setText("Vagas: " + BDEstacionamento.getInstance().getQtdVagas().toString());
				} catch (ParseException e1) {
				
					e1.printStackTrace();
				}
				
				try {
					labelZona.setText("Área Evento: " + BDEstacionamento.getInstance().getQtdZonaEvento().toString());
				} catch (ParseException e1) {
				
					e1.printStackTrace();
				}
				
				try {
					labelVagasEsp.setText("Vagas Especiais: " + BDEstacionamento.getInstance().getQtdVagasEspeciais().toString());
				} catch (ParseException e1) {
			
					e1.printStackTrace();
				}
			
			
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(27, 46, 89, 23);
		contentPane.add(btnConsultar);
		
		JLabel label1 = new JLabel("Monitoramento de Evento");
		label1.setFont(new Font("Arial", Font.BOLD, 11));
		label1.setBounds(248, 21, 176, 14);
		contentPane.add(label1);
		
		JLabel labelDataIni = new JLabel("");
		labelDataIni.setOpaque(true);
		labelDataIni.setFont(new Font("Arial", Font.BOLD, 11));
		labelDataIni.setBounds(274, 130, 120, 23);
		contentPane.add(labelDataIni);
		
		JLabel labelDataFin = new JLabel("");
		labelDataFin.setOpaque(true);
		labelDataFin.setFont(new Font("Arial", Font.BOLD, 11));
		labelDataFin.setBounds(274, 173, 120, 23);
		contentPane.add(labelDataFin);
		
		JButton buttonEvento = new JButton("Consultar\r\n");
		buttonEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Date dataDeHoje = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
				try {
					Evento evento = BDEvento.getInstance().RetornaEventoPelaDataInicio(sdf.format(dataDeHoje));
					if (evento != null) {
						labelEvento.setText(evento.getNome());
						labelDataIni.setText(sdf.format(evento.getDataInicio()));
						labelDataFin.setText(sdf.format(evento.getDataFinal()));
					}
					else {
						labelEvento.setText("");
					}
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
			
			}
		});
		buttonEvento.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonEvento.setBounds(305, 46, 89, 23);
		contentPane.add(buttonEvento);
		
		JLabel lblNewLabel = new JLabel("Início:");
		lblNewLabel.setBounds(227, 135, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fim:");
		lblNewLabel_1.setBounds(227, 177, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setBounds(227, 90, 46, 14);
		contentPane.add(lblNewLabel_2);
		
	
	}
}
