
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JProgressBar;

public class Targeting extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Targeting frame = new Targeting();
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
	public Targeting() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRamanSpectroscopyTest = new JLabel("Raman Spectroscopy Test");
		lblRamanSpectroscopyTest.setForeground(new Color(255, 215, 0));
		lblRamanSpectroscopyTest.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblRamanSpectroscopyTest.setBounds(175, 11, 599, 42);
		contentPane.add(lblRamanSpectroscopyTest);
		//Add webcam to this panel somehow 
		/*
		Webcam webcam = Webcam.getDefault();
	    webcam.setViewSize(WebcamResolution.VGA.getSize());
		
		WebcamPanel wpanel = new Webcam Panel(webcam);
		*/
		
		JLabel lblLaserStatusNot = new JLabel("Laser Status:");
		lblLaserStatusNot.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLaserStatusNot.setForeground(new Color(255, 215, 0));
		lblLaserStatusNot.setBounds(333, 131, 139, 14);
		contentPane.add(lblLaserStatusNot);
		
		JLabel lblFiring = new JLabel("Firing");
		lblFiring.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblFiring.setForeground(new Color(255, 0, 0));
		lblFiring.setBounds(343, 156, 139, 42);
		contentPane.add(lblFiring);
		
		JLabel lblPleaseDoNot = new JLabel("Don't move the probe during the testing phase. This is to ensure accuracy.");
		lblPleaseDoNot.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPleaseDoNot.setForeground(new Color(255, 215, 0));
		lblPleaseDoNot.setBounds(97, 265, 635, 24);
		contentPane.add(lblPleaseDoNot);
		
		JLabel lblApproximateTestingTime = new JLabel("Approximate Testing Time: 15 Seconds");
		lblApproximateTestingTime.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblApproximateTestingTime.setForeground(new Color(255, 215, 0));
		lblApproximateTestingTime.setBounds(232, 295, 367, 19);
		contentPane.add(lblApproximateTestingTime);
	}
}
