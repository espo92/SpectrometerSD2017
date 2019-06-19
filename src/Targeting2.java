import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Targeting2 extends JFrame {

	private JPanel contentPane;
	public boolean testing=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Targeting2 frame = new Targeting2();
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
	public Targeting2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRamanSpectroscopyTest = new JLabel("Raman Spectroscopy Test");
		lblRamanSpectroscopyTest.setBounds(163, 11, 611, 38);
		lblRamanSpectroscopyTest.setForeground(new Color(255, 215, 0));
		lblRamanSpectroscopyTest.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		contentPane.add(lblRamanSpectroscopyTest);
		
		
		
		JLabel lblLaserStatusNot = new JLabel("Laser Status:");
		lblLaserStatusNot.setBounds(315, 165, 152, 17);
		lblLaserStatusNot.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLaserStatusNot.setForeground(new Color(255, 215, 0));
		contentPane.add(lblLaserStatusNot);
		
		JLabel lblFiring = new JLabel("Not Firing");
		lblFiring.setBounds(305, 191, 246, 32);
		lblFiring.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblFiring.setForeground(new Color(50, 205, 50));
		contentPane.add(lblFiring);
		
		JLabel lblPleaseBeAware = new JLabel("Please be aware if the switch on the probe is not depressed,");
		lblPleaseBeAware.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseBeAware.setBounds(129, 247, 590, 32);
		lblPleaseBeAware.setForeground(new Color(255, 0, 0));
		contentPane.add(lblPleaseBeAware);
		
		JLabel lblAndTheTest = new JLabel(" power will cut and the test will have to be restarted.");
		lblAndTheTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAndTheTest.setBounds(149, 276, 518, 32);
		lblAndTheTest.setForeground(new Color(255, 0, 0));
		contentPane.add(lblAndTheTest);
		
		JButton btnBeginTest = new JButton("Begin Test");
		btnBeginTest.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnBeginTest.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				testing=true;
				
			}
		});
		btnBeginTest.setBounds(284, 115, 168, 23);
		btnBeginTest.setBackground(new Color(255, 0, 0));
		contentPane.add(btnBeginTest);
	}
	public boolean testing()
	{
		return testing;
	}
}
