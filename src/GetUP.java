import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GetUP extends JFrame {
	Statement st;
	Connection con;
	ResultSet rs;


	private JPanel contentPane;
	private JTable tblData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
					GetUP frame = new GetUP();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public GetUP() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mishr\\Downloads\\Attendance.jpeg"));
		setFont(new Font("Yu Gothic", Font.BOLD, 12));
		setTitle("Attendance System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 402);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(65, 31, 479, 321);
		contentPane.add(panel);
		
		JButton b1 = new JButton("Display");
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				b1.setBackground(new Color(65, 105, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				b1.setBackground(new Color(255, 255, 255));
			}
		});
		b1.setBounds(10, 283, 89, 27);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/attensys","root","1911");
					System.out.println("Connection Created");
					st=con.createStatement();
					rs=st.executeQuery("Select * from Attendance1");
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel)tblData.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
					
					for(int i=0;i<cols;i++){
						colName[i]=rsmd.getColumnName(i+1);}
					model.setColumnIdentifiers(colName);
					
					String Name,Email_Id,Roll_No, Sub,Batch,Date;
					while(rs.next()) {
						
						Name=rs.getString(1);
						Email_Id=rs.getString(2);
						Roll_No=rs.getString(3);
						Sub=rs.getString(4);
						Batch=rs.getString(5);
						Date=rs.getString(6);
						String row[]= {Name,Email_Id,Roll_No,Sub,Batch ,Date};
						model.addRow(row);
						
					}
					st.close();
					con.close();
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
				}
				
				
			
		});
		panel.setLayout(null);
		b1.setBackground(new Color(240, 240, 240));
		b1.setForeground(new Color(128, 0, 0));
		b1.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		panel.add(b1);
		
		JLabel lblNewLabel = new JLabel("Attendance Detail");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBounds(152, 3, 272, 27);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 119, 459, 153);
		panel.add(scrollPane);
		
		tblData = new JTable();
		scrollPane.setViewportView(tblData);
		
		JLabel label = new JLabel("New label");
		scrollPane.setColumnHeaderView(label);
		
		JLabel label_1 = new JLabel("New label");
		scrollPane.setColumnHeaderView(label_1);
		
		JButton b2 = new JButton("Done ");
		b2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				b2.setBackground(new Color(0, 128, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				b2.setBackground(new Color(255, 255, 255));
			}
		});
		b2.setBounds(370, 283, 89, 27);
		b2.setForeground(new Color(128, 0, 0));
		b2.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Login l=new Login();
				l.setVisible(true);
			}
		});
		b2.setBackground(new Color(240, 240, 240));
		panel.add(b2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(-64, -23, 543, 344);
		Image img2 = new ImageIcon(this.getClass().getResource("/bg4.jpeg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/bg4.jpeg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 586, 363);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		Image img3= new ImageIcon(this.getClass().getResource("/bg4.jpeg")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img3));
		lblNewLabel_4.setBounds(0, 11, 405, 211);
		contentPane.add(lblNewLabel_4);
	}
}
