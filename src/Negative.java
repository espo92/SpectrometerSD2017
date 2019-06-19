import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Negative extends JFrame {

	private JPanel contentPane;
	public boolean detailed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Positive frame = new Positive();
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
	public Negative() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Raman Spectroscopy Test");
		lblNewLabel.setBounds(190, 11, 424, 48);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblNewLabel.setForeground(new Color(255, 215, 0));
		contentPane.add(lblNewLabel);
		
		JLabel lblResults = new JLabel("Results:");
		lblResults.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblResults.setForeground(new Color(255, 215, 0));
		lblResults.setBounds(318, 107, 168, 23);
		contentPane.add(lblResults);
		
		JLabel lblAfterAnalyzingThe = new JLabel("After analyzing the results, the sample tested seems to");
		lblAfterAnalyzingThe.setForeground(new Color(255, 215, 0));
		lblAfterAnalyzingThe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAfterAnalyzingThe.setBounds(137, 158, 526, 19);
		contentPane.add(lblAfterAnalyzingThe);
		
		JLabel lblWeRecommend = new JLabel("not contain any currently identified compund. The apparent peaks");
		lblWeRecommend.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblWeRecommend.setForeground(new Color(255, 215, 0));
		lblWeRecommend.setBounds(137, 188, 526, 23);
		contentPane.add(lblWeRecommend);
		
		JLabel lblNotEncounterUnexpected = new JLabel("have not yet been catagorized.");
		lblNotEncounterUnexpected.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNotEncounterUnexpected.setForeground(new Color(255, 215, 0));
		lblNotEncounterUnexpected.setBounds(208, 222, 432, 19);
		contentPane.add(lblNotEncounterUnexpected);
		
		JButton btnViewDetailedResults = new JButton("View Detailed Results");
		btnViewDetailedResults.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnViewDetailedResults.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				detailed=true;
			}
		});
		btnViewDetailedResults.setBackground(new Color(255, 215, 0));
		btnViewDetailedResults.setBounds(262, 268, 224, 29);
		contentPane.add(btnViewDetailedResults);
	}
	public boolean getDetailed()
	{
		return detailed;
	}
}
