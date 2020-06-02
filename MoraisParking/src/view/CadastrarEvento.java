package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import model.Evento;
import persistencia.BDEvento;

public class CadastrarEvento extends JFrame {
	private JFrame frame;
	private Evento event;
	private JPanel contentPane;
	private JTextField txtEvento;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

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

	
	public CadastrarEvento() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 368 );
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new LineBorder(new Color(0, 139, 139), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFormattedTextField formattedTxtDataInicio = new JFormattedTextField();
		formattedTxtDataInicio.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTxtDataInicio.setBounds(124, 152, 179, 23);
		contentPane.add(formattedTxtDataInicio);
		
		JFormattedTextField formattedTxtDataFim = new JFormattedTextField();
		formattedTxtDataFim.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTxtDataFim.setBounds(124, 221, 179, 23);
		contentPane.add(formattedTxtDataFim);
		
		try {
			MaskFormatter maskFim = new MaskFormatter("##/##/##");
			MaskFormatter maskInicio = new MaskFormatter("##/##/##");
			maskFim.install(formattedTxtDataFim);
			maskInicio.install(formattedTxtDataInicio);
		} catch (ParseException e2) {

			e2.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Insira os dados do evento");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 217, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnCadastroEvent = new JButton("Cadastrar");
		btnCadastroEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String evento = txtEvento.getText();
				Date dataFinal = null;
				Date dataInicio = null;
				
				// ---------- se alguma informação estiver em branco, o sistema para
				
				if (txtEvento.getText().isEmpty() || formattedTxtDataFim.getText().isEmpty() || formattedTxtDataInicio.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "você deixou algumas informações em branco!");
					return;
				}
				
				// ------ data
				
				try {
					dataInicio = sdf.parse(formattedTxtDataInicio.getText());
					dataFinal = sdf.parse(formattedTxtDataFim.getText());
				} 
				catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				Evento eventoNovo = new Evento(evento, dataInicio, dataFinal);
				BDEvento.getInstance().salvarEvento(eventoNovo);
				JOptionPane.showMessageDialog(null, "Evento Cadastrado");
				CadastrarEvento.this.dispose();
			
				
			
			
			
			}
		
		
		
		});
		btnCadastroEvent.setBounds(143, 236, 147, 30);
		contentPane.add(btnCadastroEvent);
		
		btnCadastroEvent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastroEvent.setForeground(new Color(0, 0, 0));
		btnCadastroEvent.setAutoscrolls(true);
		btnCadastroEvent.setBorder(null);
		btnCadastroEvent.setBackground(new Color(0, 139, 139));
		btnCadastroEvent.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastroEvent.setBounds(145, 277, 147, 30);
		contentPane.add(btnCadastroEvent);
		
		JLabel lblNewLabel_1 = new JLabel("Evento:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(161, 67, 109, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data de Início DD/MM/AA: ");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(142, 126, 150, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblDataDeEncerramento = new JLabel("Data de Encerramento DD/MM/AA: ");
		lblDataDeEncerramento.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDataDeEncerramento.setBounds(132, 186, 205, 13);
		contentPane.add(lblDataDeEncerramento);
		
		txtEvento = new JTextField();
		txtEvento.setBounds(124, 92, 179, 23);
		contentPane.add(txtEvento);
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
		txtEvento.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtEvento.setColumns(10);
	}
}
