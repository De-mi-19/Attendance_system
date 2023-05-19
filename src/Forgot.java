import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Forgot extends JFrame {
	Statement st;
	Connection con;
	ResultSet rs;
	

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgot frame = new Forgot();
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
	public Forgot() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mishr\\Downloads\\Attendance.jpeg"));
		setFont(new Font("Dialog", Font.BOLD, 12));
		setForeground(Color.BLACK);
		setTitle("Attendace System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 401);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(90, 54, 422, 269);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel l2 = new JLabel("ENTER USER_ID");
		l2.setForeground(new Color(255, 255, 255));
		l2.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		l2.setBounds(23, 64, 105, 36);
		panel.add(l2);
		
		JLabel l1 = new JLabel("FORGOT PASSWORD");
		l1.setForeground(new Color(128, 0, 0));
		l1.setFont(new Font("Algerian", Font.BOLD, 17));
		l1.setBounds(151, 0, 187, 28);
		panel.add(l1);
		
		JLabel l3 = new JLabel("NEW PASSWORD");
		l3.setForeground(new Color(255, 255, 255));
		l3.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		l3.setBounds(20, 123, 121, 32);
		panel.add(l3);
		
		txt1 = new JTextField();
		txt1.setBounds(151, 64, 205, 25);
		panel.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(151, 126, 205, 29);
		panel.add(txt2);
		txt2.setColumns(10);
		
		JButton b1 = new JButton("UPDATE");
		
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				b1.setBackground(new Color(0, 128, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				b1.setBackground(new Color(240, 240, 240));
			}
		});
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					con=DriverManager.getConnection("jdbc:mysql://localhost/attensys","root","1911");
					System.out.println("Connection Created");
					st=con.createStatement();
					st.executeUpdate("UPDATE login  SET upaswd='"+txt2.getText()+"' where uid='"+txt1.getText()+"' ");
					JOptionPane.showMessageDialog(b1,"Password updated");
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
	
		b1.setForeground(new Color(128, 0, 0));
		b1.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		b1.setBounds(145, 182, 93, 28);
		panel.add(b1);
		
		JButton b2 = new JButton("LOGIN");
		b2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				b2.setBackground(new Color(65, 105, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				b2.setBackground(new Color(240, 240, 240));
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l=new Login();
				l.setVisible(true);
			
			}
		});
		b2.setForeground(new Color(128, 0, 0));
		b2.setBackground(new Color(240, 240, 240));
		b2.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		b2.setBounds(145, 224, 93, 25);
		panel.add(b2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/bg4.jpeg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(-87, 0, 509, 291);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("eefrfr");
		btnNewButton.setBounds(23, 210, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/bg4.jpeg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 595, 395);
		contentPane.add(lblNewLabel);
	}
}
