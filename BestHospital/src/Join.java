import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Join extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwd;
	private JPasswordField pwd_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join frame = new Join();
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
	public Join() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField txtID = new JTextField();
		txtID.setBounds(148, 84, 150, 30);
		txtID.setToolTipText("");
		txtID.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtID.setColumns(10);
		contentPane.add(txtID);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(29, 87, 100, 20);
		lblId.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane.add(lblId);
		
		
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setBounds(29, 139, 100, 20);
		lblPw.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane.add(lblPw);
		
		pwd = new JPasswordField(15);
		pwd.setBounds(148, 136, 150, 30);
		pwd.setToolTipText("");
		pwd.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(pwd);
		
		JLabel lblPw_1 = new JLabel("PW Ȯ��");
		lblPw_1.setBounds(29, 193, 142, 20);
		lblPw_1.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane.add(lblPw_1);
		
		JLabel lblName = new JLabel("����");
		lblName.setBounds(29, 245, 100, 20);
		lblName.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane.add(lblName);
		
		JTextField txtName = new JTextField();
		txtName.setBounds(148, 239, 150, 30);
		txtName.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(txtName);
		
		JLabel lblTell = new JLabel("��ȭ��ȣ");
		lblTell.setBounds(29, 297, 100, 20);
		lblTell.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane.add(lblTell);
		
		JTextField txtTell = new JTextField();
		txtTell.setToolTipText("����)010-2233-4455");
		txtTell.setBounds(148, 294, 150, 30);
		txtTell.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(txtTell);
		
		JLabel lblJoin = new JLabel("ȸ������");
		lblJoin.setBounds(146, 23, 150, 40);
		lblJoin.setForeground(Color.BLACK);
		lblJoin.setFont(new Font("Dialog", Font.BOLD, 32));
		contentPane.add(lblJoin);
		
		
		
		JButton btnCancel = new JButton("���");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(225, 422, 154, 60);
		btnCancel.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(btnCancel);
		
		pwd_1 = new JPasswordField(15);
		pwd_1.setToolTipText("�� PW�� �����ϰ� �Է����ּ���.");
		pwd_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		pwd_1.setBounds(148, 190, 150, 30);
		contentPane.add(pwd_1);
		
		JLabel lblEmail = new JLabel("�̸���");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEmail.setBounds(29, 354, 100, 20);
		contentPane.add(lblEmail);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setToolTipText("����)shl@naver.com");
		txtEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtEmail.setBounds(148, 351, 150, 30);
		contentPane.add(txtEmail);
		
		JButton btnJoin = new JButton("ȸ������");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					DBcon.dbopen();
					DBcon.query(String.format("INSERT INTO member (`id` ,`pw` ,`name` ,`tell` ,`email`) VALUES"
							+ " ('%s', '%s', '%s', '%s', '%s');" , txtID.getText(), pwd.getText(), txtName.getText(), txtTell.getText(), txtEmail.getText()));
					
					JOptionPane.showMessageDialog(null, "ȸ������ ����!");
					dispose();
					
				}
				catch (Exception ee)
				{
					JOptionPane.showMessageDialog(null, "ȸ������ ����!");
					System.out.println(ee.toString());
				}
			}
		});
		btnJoin.setEnabled(false);
		btnJoin.setBounds(59, 422, 154, 60);
		btnJoin.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(btnJoin);
		
		JButton btnIDcheck = new JButton("�ߺ�Ȯ��");
		btnIDcheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					DBcon.dbopen();
					DBcon.query(String.format("SELECT * FROM member where id='%s';", txtID.getText()));
					if (DBcon.rs.next())
					{
						JOptionPane.showMessageDialog(null, "�ߺ� ���̵� ����");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "����ϼŵ� ���� ���̵�");
						btnJoin.setEnabled(true);
						txtID.setEnabled(false);
						btnIDcheck.setEnabled(false);
					}
				}
				catch (Exception e)
				{
					System.out.println(e.toString());
				}
			}
		});
		btnIDcheck.setBounds(310, 84, 112, 30);
		btnIDcheck.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(btnIDcheck);
		
		
	}
}
