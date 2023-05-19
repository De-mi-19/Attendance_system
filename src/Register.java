import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register extends JFrame {
	PreparedStatement ps;
	Connection con;
	ResultSet rs;
	

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mishr\\Downloads\\Attendance.jpeg"));
		setFont(new Font("Dialog", Font.BOLD, 12));
		setForeground(Color.BLACK);
		setTitle("Attendace System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(51, 50, 456, 260);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel l1 = new JLabel("Enter Name:");
		l1.setForeground(new Color(255, 255, 255));
		l1.setFont(new Font("Tahoma", Font.BOLD, 15));
		l1.setBounds(28, 69, 96, 22);
		panel.add(l1);
		
		JLabel l0 = new JLabel("REGISTER");
		l0.setForeground(new Color(128, 0, 0));
		l0.setFont(new Font("Algerian", Font.BOLD, 17));
		l0.setBounds(241, 28, 103, 28);
		panel.add(l0);
		
		JLabel l2 = new JLabel("Enter User_ID:");
		l2.setForeground(new Color(255, 255, 255));
		l2.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		l2.setBounds(28, 114, 109, 22);
		panel.add(l2);
		
		JLabel l3 = new JLabel("Enter Password:");
		l3.setForeground(new Color(255, 255, 255));
		l3.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		l3.setBounds(10, 163, 127, 22);
		panel.add(l3);
		
		txt1 = new JTextField();
		txt1.setBounds(165, 67, 216, 20);
		panel.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(165, 112, 216, 20);
		panel.add(txt2);
		
		p1 = new JTextField();
		p1.setColumns(10);
		p1.setBounds(164, 161, 217, 20);
		panel.add(p1);
		
		JButton b1 = new JButton("LOGIN");
		b1.setForeground(new Color(128, 0, 0));
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				b1.setBackground(new Color(0, 128, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				b1.setBackground(Color.white);
			}
		});
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login L= new Login();
				L.setVisible(true);
				
			}
			
		});
		b1.setBackground(Color.white);
		b1.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		b1.setBounds(316, 217, 103, 28);
		panel.add(b1);
		
		JButton b2 = new JButton("REGISTER");
		b2.setBounds(82, 217, 103, 29);
		b2.setForeground(new Color(128, 0, 0));
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
				
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						con=DriverManager.getConnection("jdbc:mysql://localhost/attensys","root","1911");
						System.out.println("Connection Created");
						ps=con.prepareStatement("insert into login values(?,?,?)");
						ps.setString(1,txt1.getText());
						ps.setString(2,txt2.getText());
						ps.setString(3,p1.getText());
						ps.executeUpdate();
						JOptionPane.showMessageDialog(b2,"Registered Succesfully");
						txt1.setText("");
						txt2.setText("");
						p1.setText("");
						ps.close();
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				
			}
		});
		b2.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		
		b2.setBackground(new Color(240, 240, 240));
		panel.add(b2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		Image img = new ImageIcon(this.getClass().getResource("/bg4.jpeg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(-51, 0, 507, 260);
		panel.add(lblNewLabel);
		
		// Background
		JLabel lblNewLabel_1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/bg4.jpeg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(0, 0, 584, 361);
		contentPane.add(lblNewLabel_1);
	}
}
