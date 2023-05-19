
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Toolkit;

public class Attend extends JFrame {
	
	PreparedStatement ps;
	Connection con;
	ResultSet rs;

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Attend frame = new Attend();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Attend() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mishr\\Downloads\\Attendance.jpeg"));
		setFont(new Font("Yu Gothic", Font.BOLD, 12));
		setTitle("Attendance System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(90, 32, 484, 290);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel l0 = new JLabel("Attendance Details");
		l0.setForeground(new Color(128, 0, 0));
		l0.setFont(new Font("Algerian", Font.BOLD, 20));
		l0.setBounds(104, 11, 231, 28);
		panel.add(l0);
		
		JLabel l1 = new JLabel("Subject:");
		l1.setForeground(new Color(255, 255, 255));
		l1.setFont(new Font("Tahoma", Font.BOLD, 15));
		l1.setBounds(10, 132, 75, 21);
		panel.add(l1);
		
		JComboBox cbx1 = new JComboBox();
		cbx1.setForeground(new Color(128, 0, 0));
		cbx1.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbx1.setModel(new DefaultComboBoxModel(new String[] {"Advance Java", "Android", ".Net", "ALgoritm","Linear Algebra"}));
		cbx1.setBounds(82, 133, 155, 20);
		panel.add(cbx1);
		
		JLabel l2 = new JLabel("Time:");
		l2.setForeground(new Color(255, 255, 255));
		l2.setFont(new Font("Tahoma", Font.BOLD, 15));
		l2.setBounds(10, 172, 45, 13);
		panel.add(l2);
		
		JComboBox cbx2 = new JComboBox();
		cbx2.setForeground(new Color(128, 0, 0));
		cbx2.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbx2.setModel(new DefaultComboBoxModel(new String[] {"From", "12:30", "4:30", "8:30"}));
		cbx2.setBounds(82, 164, 65, 23);
		panel.add(cbx2);
		
		@SuppressWarnings("rawtypes")
		JComboBox cbx3 = new JComboBox();
		cbx3.setForeground(new Color(128, 0, 0));
		cbx3.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbx3.setModel(new DefaultComboBoxModel(new String[] {"To", "02:00", "06:00", "10:00"}));
		cbx3.setBounds(246, 167, 52, 25);
		panel.add(cbx3);
		
		JLabel l3 = new JLabel("Batch:");
		l3.setForeground(new Color(255, 255, 255));
		l3.setFont(new Font("Tahoma", Font.BOLD, 15));
		l3.setBounds(279, 132, 85, 21);
		panel.add(l3);
		
		@SuppressWarnings("rawtypes")
		JComboBox cbx4 = new JComboBox();
		cbx4.setForeground(new Color(128, 0, 0));
		cbx4.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbx4.setModel(new DefaultComboBoxModel<String>(new String[] {"None", "Batch 1", "Batch 2", "Batch 3"}));
		cbx4.setBounds(346, 133, 85, 28);
		panel.add(cbx4);
		
		JButton b1 = new JButton("Submit");
		b1.setForeground(new Color(128, 0, 0));
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				b1.setBackground(new Color(65, 105, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				b1.setBackground(Color.white);
			}
		});
		
		b1.addActionListener(new ActionListener() {
			String cb1=(String) cbx1.getSelectedItem();
			String cb2=(String) cbx2.getSelectedItem();
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/attensys","root","1911");
					System.out.println("Connection Created");
					ps=con.prepareStatement("insert into attendance1 values(?,?,?,?,?,?)");
					ps.setString(1,t1.getText());
					ps.setString(2,t2.getText());
					ps.setString(3,t4.getText());
					ps.setString(4,cb1);
					ps.setString(5,cb2);
					ps.setString(6,t3.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(b1,"Attendance Marked");
					ps.close();
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					dispose();
					GetUP gu=new GetUP();
					gu.setVisible(true);
					
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		b1.setFont(new Font("Tahoma", Font.BOLD, 15));
		b1.setBackground(new Color(240, 240, 240));
		b1.setBounds(200, 251, 94, 28);
		panel.add(b1);
		
		JLabel l4 = new JLabel("Name: ");
		l4.setForeground(new Color(255, 255, 255));
		l4.setFont(new Font("Tahoma", Font.BOLD, 15));
		l4.setBounds(10, 50, 75, 21);
		panel.add(l4);
		
		t1 = new JTextField();
		t1.setBounds(82, 48, 242, 28);
		panel.add(t1);
		t1.setColumns(10);
		
		JLabel l5 = new JLabel("Email Id:");
		l5.setForeground(new Color(255, 255, 255));
		l5.setFont(new Font("Tahoma", Font.BOLD, 15));
		l5.setBounds(10, 94, 75, 30);
		panel.add(l5);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(82, 93, 242, 28);
		panel.add(t2);
		
		JLabel l6 = new JLabel("Date:");
		l6.setForeground(new Color(255, 255, 255));
		l6.setFont(new Font("Tahoma", Font.BOLD, 15));
		l6.setBounds(10, 218, 75, 21);
		panel.add(l6);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(80, 216, 101, 28);
		panel.add(t3);
		
		JLabel l7 = new JLabel("Roll No:");
		l7.setForeground(new Color(255, 255, 255));
		l7.setFont(new Font("Tahoma", Font.BOLD, 15));
		l7.setBounds(279, 219, 75, 21);
		panel.add(l7);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(346, 216, 65, 28);
		panel.add(t4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/bg4.jpeg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(-126, -32, 610, 365);
		panel.add(lblNewLabel_1);
		
		// Background
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/bg4.jpeg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(-37, 0, 621, 361);
		contentPane.add(lblNewLabel);
	}
}