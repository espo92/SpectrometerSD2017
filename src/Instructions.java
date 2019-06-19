
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Instructions extends JFrame {

	private JPanel contentPane;
	public boolean status=true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instructions frame = new Instructions();
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
	public Instructions() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInstructions = new JLabel("Instructions");
		lblInstructions.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblInstructions.setForeground(new Color(255, 215, 0));
		lblInstructions.setBackground(Color.BLACK);
		lblInstructions.setBounds(284, 36, 187, 28);
		contentPane.add(lblInstructions);
		
		JLabel lblNewLabel = new JLabel("1. Please verify all necessary data/power connections have been made properly");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(255, 215, 0));
		lblNewLabel.setBounds(29, 92, 536, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPleaseVerify = new JLabel("2. Please verify all necessary safety precautions have been taken.");
		lblPleaseVerify.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPleaseVerify.setForeground(new Color(255, 215, 0));
		lblPleaseVerify.setBounds(29, 117, 591, 14);
		contentPane.add(lblPleaseVerify);
		
		JLabel lblBeginTest = new JLabel("3. Begin Test. Dark Spectrum will be taken with laser powered off.");
		lblBeginTest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBeginTest.setForeground(new Color(255, 215, 0));
		lblBeginTest.setBounds(29, 142, 567, 14);
		contentPane.add(lblBeginTest);
		
		JLabel lblPowerOn = new JLabel("4. Power on laser. Line up probe using video signal on screen.");
		lblPowerOn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPowerOn.setForeground(new Color(255, 215, 0));
		lblPowerOn.setBounds(29, 167, 383, 14);
		contentPane.add(lblPowerOn);
		
		JLabel lblBeginTesting = new JLabel("5. Begin testing procedure on skin sample. Test should be over in less than 15 seconds.");
		lblBeginTesting.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBeginTesting.setForeground(new Color(255, 215, 0));
		lblBeginTesting.setBounds(29, 192, 567, 14);
		contentPane.add(lblBeginTesting);
		
		JLabel lblADetermination = new JLabel("6. A determination of your sample will be made, based upon the Raman signal.");
		lblADetermination.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblADetermination.setForeground(new Color(255, 215, 0));
		lblADetermination.setBounds(29, 217, 536, 14);
		contentPane.add(lblADetermination);
		
		JLabel lblTheOutput = new JLabel("7. The output data is placed in a text file where the program has been run from.");
		lblTheOutput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTheOutput.setForeground(new Color(255, 215, 0));
		lblTheOutput.setBounds(29, 242, 536, 14);
		contentPane.add(lblTheOutput);
		
		JLabel lblWarningLaserSafety = new JLabel("WARNING: Laser Safety is no joke. Only use laser when necessary.");
		lblWarningLaserSafety.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWarningLaserSafety.setForeground(new Color(255, 0, 0));
		lblWarningLaserSafety.setBounds(54, 289, 698, 41);
		contentPane.add(lblWarningLaserSafety);
	}
}
