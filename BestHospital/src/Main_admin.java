import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_admin  extends JFrame {

	private JPanel contentPane;
	public JLabel lblName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_admin frame = new Main_admin();
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
	public Main_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblName = new JLabel("");
		lblName.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblName.setBounds(32, 10, 99, 50);
		contentPane.add(lblName);
		
		JLabel lblIntro = new JLabel("님 환영합니다");
		lblIntro.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblIntro.setBounds(105, 14, 130, 50);
		contentPane.add(lblIntro);
		
		JButton btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "로그아웃되셨습니다.");
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
				
			}
		});
		btnLogout.setFont(new Font("Dialog", Font.BOLD, 15));
		btnLogout.setBounds(237, 24, 95, 31);
		contentPane.add(btnLogout);
		
		JButton btnReservationManage = new JButton("진료예약 관리");
		btnReservationManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationManage rm = new ReservationManage();
				rm.setVisible(true);
			}
		});
		btnReservationManage.setFont(new Font("Dialog", Font.BOLD, 15));
		btnReservationManage.setBounds(12, 70, 320, 79);
		contentPane.add(btnReservationManage);
		
		JButton btnMemberManage = new JButton("회원 관리");
		btnMemberManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MembeManage mmn = new MembeManage();
				mmn.setVisible(true);
			}
		});
		btnMemberManage.setFont(new Font("Dialog", Font.BOLD, 15));
		btnMemberManage.setBounds(12, 159, 320, 79);
		contentPane.add(btnMemberManage);
	}

}
