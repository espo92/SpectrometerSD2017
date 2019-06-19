import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Positive extends JFrame {

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
	public Positive() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		detailed=false;
		
		JLabel lblNewLabel = new JLabel("Raman Spectroscopy Test");
		lblNewLabel.setBounds(72, 11, 424, 28);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setForeground(new Color(255, 215, 0));
		contentPane.add(lblNewLabel);
		
		JLabel lblResults = new JLabel("Results:");
		lblResults.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblResults.setForeground(new Color(255, 215, 0));
		lblResults.setBounds(165, 70, 78, 19);
		contentPane.add(lblResults);
		
		JLabel lblAfterAnalyzingThe = new JLabel("After analyzing the results, the sample tested seems to contain");
		lblAfterAnalyzingThe.setForeground(new Color(255, 215, 0));
		lblAfterAnalyzingThe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAfterAnalyzingThe.setBounds(20, 100, 414, 14);
		contentPane.add(lblAfterAnalyzingThe);
		
		JLabel lblWeRecommend = new JLabel(" <Insert_Test_Here>. We recommend testing every 2 weeks to");
		lblWeRecommend.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblWeRecommend.setForeground(new Color(255, 215, 0));
		lblWeRecommend.setBounds(20, 119, 414, 14);
		contentPane.add(lblWeRecommend);
		
		JLabel lblNotEncounterUnexpected = new JLabel(" not encounter unexpected results.");
		lblNotEncounterUnexpected.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNotEncounterUnexpected.setForeground(new Color(255, 215, 0));
		lblNotEncounterUnexpected.setBounds(20, 139, 268, 14);
		contentPane.add(lblNotEncounterUnexpected);
		
		JButton btnViewDetailedResults = new JButton("View Detailed Results");
		btnViewDetailedResults.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				detailed=true;
			}
		});
		btnViewDetailedResults.setBackground(new Color(255, 215, 0));
		btnViewDetailedResults.setBounds(143, 189, 145, 23);
		contentPane.add(btnViewDetailedResults);
	}
	public boolean getDetailed()
	{
		return detailed;
	}
}
