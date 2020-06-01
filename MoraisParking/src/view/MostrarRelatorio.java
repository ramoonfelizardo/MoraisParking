package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import model.Evento;
import model.Ocorrencia;
import persistencia.BD;
import persistencia.BDEvento;
import persistencia.BDOcorrencia;
import persistencia.BDEstacionamento;


public class MostrarRelatorio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarRelatorio frame = new MostrarRelatorio();
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
	public MostrarRelatorio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(new Color(0, 206, 209));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 100, 280, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 139, 139), 2, true));
		contentPane.setBackground(new Color(192, 192, 192));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRelatrioEvento = new JButton("Relatório Evento");
		btnRelatrioEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRelatrioEvento.setForeground(Color.BLACK);
		btnRelatrioEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRelatrioEvento.setBorder(null);
		btnRelatrioEvento.setBackground(new Color(0, 139, 139));
		btnRelatrioEvento.setAutoscrolls(true);
		btnRelatrioEvento.setBounds(59, 32, 147, 30);
		contentPane.add(btnRelatrioEvento);
		
		JButton btnRelatrioOcorrncia = new JButton("Relatório Ocorrência");
		btnRelatrioOcorrncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ocorrencia oco = new Ocorrencia(null, null, null);
				BDOcorrencia.getInstance().escrever(oco);
			}
		});
		
		
		
		
		
		btnRelatrioOcorrncia.setForeground(Color.BLACK);
		btnRelatrioOcorrncia.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRelatrioOcorrncia.setBorder(null);
		btnRelatrioOcorrncia.setBackground(new Color(0, 139, 139));
		btnRelatrioOcorrncia.setAutoscrolls(true);
		btnRelatrioOcorrncia.setBounds(59, 73, 147, 30);
		contentPane.add(btnRelatrioOcorrncia);
		
		JButton btnRelatrioVeiculo = new JButton("Relat\u00F3rio Ve\u00EDculo\r\n");
		btnRelatrioVeiculo.setForeground(Color.BLACK);
		btnRelatrioVeiculo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRelatrioVeiculo.setBorder(null);
		btnRelatrioVeiculo.setBackground(new Color(0, 139, 139));
		btnRelatrioVeiculo.setAutoscrolls(true);
		btnRelatrioVeiculo.setBounds(59, 114, 147, 30);
		contentPane.add(btnRelatrioVeiculo);
		
		JButton btnRelatrioFuncionrio = new JButton("Relat\u00F3rio Funcion\u00E1rio");
		btnRelatrioFuncionrio.setForeground(Color.BLACK);
		btnRelatrioFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRelatrioFuncionrio.setBorder(null);
		btnRelatrioFuncionrio.setBackground(new Color(0, 139, 139));
		btnRelatrioFuncionrio.setAutoscrolls(true);
		btnRelatrioFuncionrio.setBounds(59, 155, 147, 30);
		contentPane.add(btnRelatrioFuncionrio);
	}
}
