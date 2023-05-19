import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {
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
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mishr\\Downloads\\Attendance.jpeg"));
		setFont(new Font("Dialog", Font.BOLD, 12));
		setForeground(Color.BLACK);
		setTitle("Attendace System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(353, 112, 114, -47);
		contentPane.add(desktopPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(85, 31, 424, 297);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel l1 = new JLabel("USER ID");
		l1.setForeground(new Color(255, 255, 255));
		l1.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		l1.setBounds(28, 98, 84, 22);
		panel.add(l1);
		
		txt1 = new JTextField();
		txt1.setBounds(135, 91, 226, 30);
		panel.add(txt1);
		txt1.setColumns(10);
		
		JLabel l2 = new JLabel("PASSWORD");
		l2.setForeground(new Color(255, 255, 255));
		l2.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		l2.setBounds(28, 139, 84, 22);
		panel.add(l2);
		
		JButton b1 = new JButton("SIGN IN");
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				b1.setBackground(new Color(0,128,0));
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
					if(txt1.getText()!=null && txt2.getText()!=null) {
						rs=st.executeQuery("Select * from login where uid='"+txt1.getText()+"' and upaswd='"+txt2.getText()+"'");
						if(rs.next()) {
							JOptionPane.showMessageDialog(b1," Login Successful");
							dispose();
							Attend l=new Attend();
							l.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(b1," Login Failed");
						}
						
					}
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		b1.setBackground(new Color(240, 240, 240));
		b1.setForeground(new Color(128, 0, 0));
		b1.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		b1.setBounds(92, 217, 94, 37);
		panel.add(b1);
		
		JButton b2 = new JButton("SIGN UP");
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
				Register r=new Register();
				r.setVisible(true);
				
			}
		});
		b2.setForeground(new Color(128, 0, 0));
		b2.setBackground(new Color(240, 240, 240));
		b2.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		b2.setBounds(249, 217, 94, 37);
		panel.add(b2);
		
		JLabel l0 = new JLabel("LOGIN");
		l0.setForeground(new Color(128, 0, 0));
		l0.setVerticalAlignment(SwingConstants.TOP);
		l0.setHorizontalAlignment(SwingConstants.CENTER);
		l0.setFont(new Font("Algerian", Font.BOLD, 20));
		l0.setBounds(202, 11, 105, 33);
		panel.add(l0);
		
		JCheckBox chbx1 = new JCheckBox("Forgot Password");
		chbx1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				if(chbx1.isSelected()) {
					dispose();
					Forgot f= new Forgot();
					f.setVisible(true);
				}
			}
		});
		chbx1.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		chbx1.setForeground(new Color(0, 0, 255));
		chbx1.setBackground(new Color(192, 192, 192));
		chbx1.setBounds(224, 174, 119, 22);
		panel.add(chbx1);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(135, 132, 226, 30);
		panel.add(txt2);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/bg4.jpeg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(-85, -38, 509, 410);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/bg4.jpeg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(-56, 207, 678, 187);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/bg4.jpeg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		lblNewLabel_2.setBounds(0, 0, 643, 405);
		contentPane.add(lblNewLabel_2);
		
//		JLabel lblNewLabel_1 = new JLabel("");
//		Image img1 = new ImageIcon(this.getClass().getResource("/bg4.jpeg")).getImage();
//		lblNewLabel_1.setIcon(new ImageIcon(img1));
//		lblNewLabel.setBounds(-30, -13, 499, 410);
//		panel.add(lblNewLabel_1);
		
		
	}
}
