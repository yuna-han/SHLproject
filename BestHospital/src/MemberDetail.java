import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;
import java.awt.event.ActionEvent;

public class MemberDetail extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberDetail frame = new MemberDetail("");
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
	public MemberDetail(String UserID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("¼º¸í");
		lblName.setFont(new Font("Dialog", Font.BOLD, 20));
		lblName.setBounds(61, 35, 100, 20);
		contentPane.add(lblName);
		
		JTextField txtName = new JTextField();
		txtName.setEnabled(false);
		txtName.setToolTipText("");
		txtName.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBounds(186, 32, 186, 30);
		contentPane.add(txtName);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Dialog", Font.BOLD, 20));
		lblID.setBounds(61, 113, 100, 20);
		contentPane.add(lblID);
		
		txtID = new JTextField(15);
		txtID.setEnabled(false);
		txtID.setToolTipText("");
		txtID.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtID.setBounds(186, 110, 186, 30);
		contentPane.add(txtID);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPw.setBounds(61, 191, 100, 20);
		contentPane.add(lblPw);
		
		JTextField pwd_2 = new JTextField();
		pwd_2.setEnabled(false);
		pwd_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		pwd_2.setBounds(186, 188, 186, 30);
		contentPane.add(pwd_2);
		
		JLabel lblTell = new JLabel("ÀüÈ­¹øÈ£");
		lblTell.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTell.setBounds(61, 269, 100, 20);
		contentPane.add(lblTell);
		
		JTextField txtTell = new JTextField();
		txtTell.setEnabled(false);
		txtTell.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtTell.setBounds(186, 266, 186, 30);
		contentPane.add(txtTell);
		
		JButton btnClose = new JButton("´Ý±â");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Dialog", Font.BOLD, 15));
		btnClose.setBounds(61, 425, 154, 60);
		contentPane.add(btnClose);
		
		JButton btnDeleteMember = new JButton("È¸¿øÅ»Åð");
		btnDeleteMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteMember dm = new DeleteMember();
				dm.lblID.setText(txtID.getText());
				dm.setVisible(true);
				dispose();
			}
		});
		btnDeleteMember.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnDeleteMember.setBounds(227, 425, 154, 60);
		contentPane.add(btnDeleteMember);
		
		JLabel lblEmail = new JLabel("ÀÌ¸ÞÀÏ");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEmail.setBounds(61, 343, 100, 20);
		contentPane.add(lblEmail);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtEmail.setEnabled(false);
		txtEmail.setBounds(186, 340, 186, 30);
		contentPane.add(txtEmail);
		
		DBcon.dbopen();
		DBcon.query("SELECT * FROM member where id='" + UserID + "';");
		try
		{
			while (DBcon.rs.next())
			{
				txtID.setText(DBcon.rs.getString(1));
				pwd_2.setText(DBcon.rs.getString(2));
				txtName.setText(DBcon.rs.getString(3));
				txtTell.setText(DBcon.rs.getString(4));
				txtEmail.setText(DBcon.rs.getString(5));
			}
		}
		catch(Exception e)
		{
		}
	}
}
