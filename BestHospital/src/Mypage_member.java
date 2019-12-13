import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mypage_member extends JFrame {

	private JPanel contentPane;
	private JTable tbReservationList;
	private String userID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mypage_member frame = new Mypage_member("1");
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
	public Mypage_member(String ID) {
		this.userID = ID;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 169, 729, 251);
		contentPane.add(scrollPane);
		
		tbReservationList = new JTable();
		tbReservationList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uC608\uC57D \uBC88\uD638", "\uC608\uC57D \uC2DC\uAC04", "\uB0B4\uC6A9", "\uC9C4\uB8CC\uACFC"
			}
		));
		scrollPane.setViewportView(tbReservationList);
		
		JLabel lblTitle = new JLabel("진료 예약 목록");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 32));
		lblTitle.setBounds(278, 10, 239, 40);
		contentPane.add(lblTitle);
		
		JButton btnClose = new JButton("닫기");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Dialog", Font.BOLD, 15));
		btnClose.setBounds(590, 430, 151, 49);
		contentPane.add(btnClose);
		
		JLabel lblIntro = new JLabel("총");
		lblIntro.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblIntro.setBounds(12, 115, 62, 50);
		contentPane.add(lblIntro);
		
		JLabel lblNumber = new JLabel("");
		lblNumber.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNumber.setBounds(47, 109, 47, 50);
		contentPane.add(lblNumber);
		
		JLabel lblIntro_2 = new JLabel("건의 예약이 존재합니다.");
		lblIntro_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblIntro_2.setBounds(106, 115, 231, 50);
		contentPane.add(lblIntro_2);
		
		DBcon.dbopen();
		DBcon.query(String.format("SELECT * FROM reservation where id='%s'", ID));
		try
		{
			int a = 0;
			while (DBcon.rs.next())
			{
				a++;
				String[] name = { "id", "name", "age", "addr" };
				String deptName = "";
				
				String deptCode = DBcon.rs.getString(5);
				
				switch (deptCode)
		        {
		        case "D01":
		        	deptName = "외과";
		        	break;
		        case "D02":
		        	deptName = "내과";
		        	break;
		        case "D03":
		        	deptName = "신경외과";
		        	break;
		        case "D04":
		        	deptName = "피부과";
		        	break;
		        case "D05":
		        	deptName = "치과";
		        	break;
		        }
				Object data[] = { DBcon.rs.getString(1), DBcon.rs.getString(2),
						DBcon.rs.getString(3), deptName };
				DefaultTableModel dt = (DefaultTableModel)tbReservationList.getModel();
				dt.addRow(data);
				System.out.println(DBcon.rs.getString(3));
			}
			lblNumber.setText(Integer.toString(a));
		}
		catch(Exception e)
		{
			System.out.println(e.toString());		}
	}
}
