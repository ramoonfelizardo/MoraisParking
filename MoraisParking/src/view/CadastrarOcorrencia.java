package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import model.Ocorrencia;
import persistencia.BD;


public class CadastrarOcorrencia extends JFrame {

	private JPanel contentPane;
	private JTextField txtDataDdmmaa;
	private JTextField txtVeculo;
	private JTextField txtDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarOcorrencia frame = new CadastrarOcorrencia();
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
	public CadastrarOcorrencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new LineBorder(new Color(0, 128, 128), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsiraOsDados = new JLabel("Insira os dados da ocorr\u00EAncia");
		lblInsiraOsDados.setBounds(10, 11, 182, 14);
		lblInsiraOsDados.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblInsiraOsDados);
		
		JPanel dataOco = new JPanel();
		dataOco.setBounds(96, 52, 230, 28);
		contentPane.add(dataOco);
		dataOco.setLayout(null);
		
		txtDataDdmmaa = new JTextField();
		txtDataDdmmaa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtDataDdmmaa.getText().equals("Data DD/MM/AA")) {
					txtDataDdmmaa.setText("");
					}
				else {
					txtDataDdmmaa.selectAll();
					}
				
			}
		});
		txtDataDdmmaa.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDataDdmmaa.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataDdmmaa.setText("Data DD/MM/AA");
		txtDataDdmmaa.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtDataDdmmaa.setBounds(0, 0, 230, 28);
		dataOco.add(txtDataDdmmaa);
		txtDataDdmmaa.setColumns(10);
		
		JPanel descricaoOco = new JPanel();
		descricaoOco.setBounds(96, 101, 230, 28);
		contentPane.add(descricaoOco);
		descricaoOco.setLayout(null);
		
		txtDescricao = new JTextField();
		txtDescricao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtDescricao.getText().equals("Descri��o")) {
					txtDescricao.setText("");
					}
				else {
					txtDescricao.selectAll();
					}
				
			}
		});
		txtDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDescricao.setText("Descri\u00E7\u00E3o");
		txtDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescricao.setToolTipText("");
		txtDescricao.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(0, 0, 230, 28);
		descricaoOco.add(txtDescricao);
		
		JPanel veiculo = new JPanel();
		veiculo.setBounds(96, 148, 230, 28);
		contentPane.add(veiculo);
		veiculo.setLayout(null);
		
		txtVeculo = new JTextField();
		txtVeculo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtVeculo.getText().equals("Ve�culo")) {
					txtVeculo.setText("");
					}
				else {
					txtVeculo.selectAll();
			}
		}});
		txtVeculo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtVeculo.setHorizontalAlignment(SwingConstants.CENTER);
		txtVeculo.setText("Ve\u00EDculo");
		txtVeculo.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtVeculo.setColumns(10);
		txtVeculo.setBounds(0, 0, 230, 28);
		veiculo.add(txtVeculo);
		
		JButton button = new JButton("Cadastrar");
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBorder(null);
		button.setBackground(new Color(0, 139, 139));
		button.setAutoscrolls(true);
		button.setBounds(136, 233, 147, 30);
		contentPane.add(button);
		setLocationRelativeTo(null);
	}
}
