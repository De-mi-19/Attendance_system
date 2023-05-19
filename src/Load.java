import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Load extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Load frame = new Load();
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
	public Load() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mishr\\Downloads\\Attendance.jpeg"));
		setForeground(Color.BLACK);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Attendance System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 399);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar pb = new JProgressBar(0,100);
		
		pb.setValue(50);
		pb.setStringPainted(true);
		pb.setForeground(new Color(128, 0, 0));
		pb.setBackground(Color.LIGHT_GRAY);
		pb.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pb.setBounds(10, 282, 564, 26);
		contentPane.add(pb);
		
		JLabel Title1 = new JLabel("WELCOME TO HAVARD UNIVERSITY");
		Title1.setForeground(new Color(128, 0, 0));
		Title1.setFont(new Font("Algerian", Font.BOLD, 26));
		Title1.setBounds(91, 48, 483, 105);
		contentPane.add(Title1);
		
		JLabel lblNewLabel = new JLabel("LOADING . . .");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBounds(0, 0, 584, 360);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/bg4.jpeg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 584, 360);
		contentPane.add(lblNewLabel_1);
		
		//Wait for progress..
		
		//just a dummy wait for progress...
	     for (int i = 0; i <= 100; i++) {
	     pb.setValue(i);
	     try {
	     Thread.sleep(100);
	     } catch (InterruptedException e) {
	     // TODO Auto-generated catch block
	     e.printStackTrace();
	     }
	     }
	    
	     //After completion of progress bar open Login Page code here
	     if (pb.getValue() == 100) {
	    
	     Login login = new Login();
	     login.setVisible(true);
	     
	     }
	     dispose();
	}
}
