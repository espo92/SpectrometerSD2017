
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class Intro extends JFrame {

	private JPanel contentPane;
	public boolean visible;
	public int currScreen=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intro frame = new Intro();
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
	public int getCurrScreen()
	{
		return currScreen;
	}
	public Intro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRamanSpectroscopyTest = new JLabel("Raman Spectroscopy Test");
		lblRamanSpectroscopyTest.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblRamanSpectroscopyTest.setForeground(new Color(255, 215, 0));
		lblRamanSpectroscopyTest.setBounds(166, 11, 440, 45);
		contentPane.add(lblRamanSpectroscopyTest);
		
		JButton btnNewButton = new JButton("Begin Test\r\n");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				currScreen=2;
			}
		});
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setBounds(234, 106, 260, 43);
		contentPane.add(btnNewButton);
		
		JButton btnInstructions = new JButton("Instructions");
		btnInstructions.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnInstructions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 currScreen=1;
				
			}
		});
		btnInstructions.setBackground(new Color(255, 215, 0));
		btnInstructions.setBounds(234, 160, 260, 43);
		contentPane.add(btnInstructions);
	}
}
 