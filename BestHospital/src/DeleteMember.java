import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteMember extends JFrame {

	private JPanel contentPane;
	private JPasswordField adminPW;
	public JLabel lblID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteMember frame = new DeleteMember();
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
	public DeleteMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("회원탈퇴를 위해 관리자님의 비밀번호를 입력바랍니다.");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(12, 26, 462, 61);
		contentPane.add(label);
		
		adminPW = new JPasswordField(15);
		adminPW.setToolTipText("");
		adminPW.setFont(new Font("Dialog", Font.PLAIN, 15));
		adminPW.setBounds(150, 156, 188, 30);
		contentPane.add(adminPW);
		
		lblID = new JLabel("00");
		lblID.setFont(new Font("Dialog", Font.BOLD, 15));
		lblID.setBounds(232, 101, 57, 15);
		contentPane.add(lblID);

		JButton btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBcon.dbopen();
				if(adminPW.getText().equals("admin")) {
							DBcon.query(String.format("DELETE FROM member where id='" + lblID.getText() + "';"));
							JOptionPane.showMessageDialog(null, "탈퇴되었습니다.");
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "탈퇴가 실패했습니다.");
						}
			}
							
		});
		btnConfirm.setFont(new Font("Dialog", Font.BOLD, 15));
		btnConfirm.setBounds(167, 205, 154, 41);
		contentPane.add(btnConfirm);
		
		JLabel label_1 = new JLabel("\uD0C8\uD1F4\uD560 \uC544\uC774\uB514 :");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_1.setBounds(113, 97, 120, 22);
		contentPane.add(label_1);
		
		
	}
}
