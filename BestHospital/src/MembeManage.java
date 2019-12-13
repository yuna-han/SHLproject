import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class MembeManage extends JFrame {

	private JPanel contentPane;
	private JTable tbMember;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MembeManage frame = new MembeManage();
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
	public void Reload()
	{
		DefaultTableModel model = (DefaultTableModel)tbMember.getModel();
		model.setRowCount(0);
		DBcon.dbopen();
		DBcon.query("SELECT * FROM member;");
		try
		{

			while (DBcon.rs.next())
			{
				Object data[] = { DBcon.rs.getString(1), DBcon.rs.getString(2),
						DBcon.rs.getString(3), DBcon.rs.getString(4), DBcon.rs.getString(5) };
				DefaultTableModel dt = (DefaultTableModel)tbMember.getModel();
				
				dt.addRow(data);
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());		
		}
	}
	public MembeManage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 169, 729, 251);
		contentPane.add(scrollPane);
		
		tbMember = new JTable();
		tbMember.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uC544\uC774\uB514", "\uBE44\uBC00\uBC88\uD638", "\uC774\uB984", "\uC804\uD654\uBC88\uD638", "E-mail"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		scrollPane.setViewportView(tbMember);
		
		JLabel lblTitle = new JLabel("회원 정보 관리");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 32));
		lblTitle.setBounds(278, 10, 239, 40);
		contentPane.add(lblTitle);
		
		JButton btnClose = new JButton("닫기");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main_admin ma = new Main_admin();
			}
		});
		btnClose.setFont(new Font("Dialog", Font.BOLD, 15));
		btnClose.setBounds(590, 430, 151, 49);
		contentPane.add(btnClose);
		
		JLabel lblInfo = new JLabel("조작을 원하는 회원을 더블클릭 하세요.");
		lblInfo.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblInfo.setBounds(12, 115, 329, 50);
		contentPane.add(lblInfo);
		
		JButton btnNewButton = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reload();
			}
		});
		btnNewButton.setBounds(432, 430, 143, 49);
		contentPane.add(btnNewButton);
		
		DBcon.dbopen();
		DBcon.query("SELECT * FROM member;");
		try
		{

			while (DBcon.rs.next())
			{
				Object data[] = { DBcon.rs.getString(1), DBcon.rs.getString(2),
						DBcon.rs.getString(3), DBcon.rs.getString(4), DBcon.rs.getString(5) };
				DefaultTableModel dt = (DefaultTableModel)tbMember.getModel();
				
				dt.addRow(data);
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());		
		}
		
		tbMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					
					MemberDetail mi = new MemberDetail(tbMember.getValueAt(tbMember.getSelectedRow(), 1).toString());
					mi.setVisible(true);
					
					
				}
			}
		});
		
	}
}

