import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PwFind extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PwFind frame = new PwFind();
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
	public PwFind() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("��й�ȣ ã��");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 32));
		lblTitle.setBounds(100, 10, 240, 82);
		contentPane.add(lblTitle);
		
		JLabel lblName = new JLabel("����");
		lblName.setFont(new Font("Dialog", Font.BOLD, 20));
		lblName.setBounds(31, 92, 100, 50);
		contentPane.add(lblName);
		
		JLabel lblTell = new JLabel("��ȭ��ȣ");
		lblTell.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTell.setBounds(28, 255, 100, 50);
		contentPane.add(lblTell);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtName.setBounds(128, 97, 265, 40);
		contentPane.add(txtName);
		
		JTextField txtTell = new JTextField();
		txtTell.setToolTipText("����)010-2233-4455");
		txtTell.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtTell.setBounds(128, 260, 265, 40);
		contentPane.add(txtTell);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Dialog", Font.BOLD, 20));
		lblId.setBounds(31, 167, 100, 50);
		contentPane.add(lblId);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtID.setBounds(128, 172, 265, 40);
		contentPane.add(txtID);
		
		JLabel lblEmail = new JLabel("�̸���");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEmail.setBounds(28, 333, 100, 50);
		contentPane.add(lblEmail);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setToolTipText("����)shl@naver.com");
		txtEmail.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtEmail.setBounds(128, 338, 265, 40);
		contentPane.add(txtEmail);
		
		
		
		
		JButton btnConfirm = new JButton("Ȯ��");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String userID = txtID.getText();
					String userName = txtName.getText();
					String userTell = txtTell.getText();
					String userEmail = txtEmail.getText();
					String userPW = null;
					
					DBcon.dbopen();
					DBcon.query(String.format("select pw from member where id='%s' and name='%s' and tell='%s' and email='%s';", userID, userName, userTell, userEmail));
					if (DBcon.rs.next() == false)
					{
						JOptionPane.showMessageDialog(null, "��ġ�ϴ� ������ �����ϴ�!");
					}
					else
					{
					JOptionPane.showMessageDialog(null, "ID : " + userID + "\nPW : " + DBcon.rs.getString(1));
					}
					dispose();
					
					
				}
				catch (Exception ee)
				{
					JOptionPane.showMessageDialog(null, "��ġ�ϴ� ������ �����ϴ�!");
					System.out.println(ee.toString());
				}
			}
		});
		btnConfirm.setFont(new Font("Dialog", Font.BOLD, 15));
		btnConfirm.setBounds(48, 418, 154, 60);
		contentPane.add(btnConfirm);
		
		JButton btnCancel = new JButton("���");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnCancel.setBounds(214, 418, 154, 60);
		contentPane.add(btnCancel);
		

	}
}
