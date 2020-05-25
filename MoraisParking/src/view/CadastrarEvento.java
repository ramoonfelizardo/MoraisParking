package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import model.Evento;
import persistencia.BD;
import persistencia.BDEstacionamento;

import java.awt.Font;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.Cursor;







public class CadastrarEvento extends JFrame {
	private JFrame frame;
	private Evento event;
	private JPanel contentPane;
	private JTextField txtEvento;
	private JTextField txtDataDeInicio;
	private JTextField txtZona;
	private JTextField txtDataDeEncerramento_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarEvento frame = new CadastrarEvento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	

	
	public CadastrarEvento() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 320 );
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new LineBorder(new Color(0, 139, 139), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel nomeEventoPnl = new JPanel();
		nomeEventoPnl.setBorder(new EmptyBorder(0, 0, 0, 0));
		nomeEventoPnl.setBackground(new Color(255, 255, 255));
		nomeEventoPnl.setBounds(129, 51, 179, 23);
		contentPane.add(nomeEventoPnl);
		nomeEventoPnl.setLayout(null);
		
		txtEvento = new JTextField();
		txtEvento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			if (txtEvento.getText().equals("Evento")) {
				txtEvento.setText("");
				}
			else {
				txtEvento.selectAll();
				}
			}
			
		});
		txtEvento.setHorizontalAlignment(SwingConstants.CENTER);
		txtEvento.setFont(new Font("Arial", Font.PLAIN, 10));
		txtEvento.setText("Evento");
		txtEvento.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtEvento.setBounds(0, 0, 179, 23);
		nomeEventoPnl.add(txtEvento);
		txtEvento.setColumns(10);
		
		JPanel dataInicioPnl = new JPanel();
		dataInicioPnl.setBorder(new EmptyBorder(0, 0, 0, 0));
		dataInicioPnl.setBackground(new Color(255, 255, 255));
		dataInicioPnl.setBounds(129, 85, 179, 23);
		contentPane.add(dataInicioPnl);
		dataInicioPnl.setLayout(null);
		
		txtDataDeInicio = new JTextField();
		txtDataDeInicio.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtDataDeInicio.getText().equals("Data de In�cio DD/MM/AA")) {
					txtDataDeInicio.setText("");
					}
				else {
					txtDataDeInicio.selectAll();
					}
			}
		});
		txtDataDeInicio.setText("Data de In\u00EDcio DD/MM/AA");
		txtDataDeInicio.setFont(new Font("Arial", Font.PLAIN, 10));
		txtDataDeInicio.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataDeInicio.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtDataDeInicio.setBounds(0, 0, 179, 23);
		dataInicioPnl.add(txtDataDeInicio);
		txtDataDeInicio.setColumns(10);
		
		JPanel dataFinalPnl = new JPanel();
		dataFinalPnl.setBorder(new EmptyBorder(0, 0, 0, 0));
		dataFinalPnl.setAlignmentY(Component.TOP_ALIGNMENT);
		dataFinalPnl.setBackground(new Color(255, 255, 255));
		dataFinalPnl.setBounds(129, 119, 179, 23);
		contentPane.add(dataFinalPnl);
		dataFinalPnl.setLayout(null);
		
		txtDataDeEncerramento_1 = new JTextField();
		txtDataDeEncerramento_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtDataDeEncerramento_1.getText().equals("Data de Encerramento DD/MM/AA")) {
					txtDataDeEncerramento_1.setText("");
					}
				else {
					txtDataDeEncerramento_1.selectAll();
					}
				
			}
		});
		txtDataDeEncerramento_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataDeEncerramento_1.setFont(new Font("Arial", Font.PLAIN, 10));
		txtDataDeEncerramento_1.setText("Data de Encerramento DD/MM/AA");
		txtDataDeEncerramento_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtDataDeEncerramento_1.setBounds(0, 0, 179, 23);
		dataFinalPnl.add(txtDataDeEncerramento_1);
		txtDataDeEncerramento_1.setColumns(10);
		
		JPanel zonaPnl = new JPanel();
		zonaPnl.setBorder(new EmptyBorder(0, 0, 0, 0));
		zonaPnl.setBackground(new Color(255, 255, 255));
		zonaPnl.setBounds(129, 153, 179, 23);
		contentPane.add(zonaPnl);
		zonaPnl.setLayout(null);
		
		txtZona = new JTextField();
		txtZona.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtZona.getText().equals("Zona")) {
					txtZona.setText("");
					}
				else {
					txtZona.selectAll();
					}
			}
		});
		txtZona.setHorizontalAlignment(SwingConstants.CENTER);
		txtZona.setFont(new Font("Arial", Font.PLAIN, 11));
		txtZona.setText("Zona");
		txtZona.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtZona.setBounds(0, 0, 179, 23);
		zonaPnl.add(txtZona);
		txtZona.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Insira os dados do evento");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 217, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnCadastroEvent = new JButton("Cadastrar");
		btnCadastroEvent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastroEvent.setForeground(new Color(0, 0, 0));
		btnCadastroEvent.setAutoscrolls(true);
		btnCadastroEvent.setBorder(null);
		btnCadastroEvent.setBackground(new Color(0, 139, 139));
		btnCadastroEvent.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastroEvent.setBounds(147, 201, 147, 30);
		contentPane.add(btnCadastroEvent);
		setLocationRelativeTo(null);
	}
}
