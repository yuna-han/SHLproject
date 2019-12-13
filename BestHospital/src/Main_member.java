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

public class Main_member  extends JFrame {

	private JPanel contentPane;
	public JLabel lblName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_member frame = new Main_member();
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
	public Main_member() {
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
		
		JButton btnReservation = new JButton("진료 예약하기");
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservation rv = new Reservation(lblName.getText());
				rv.setVisible(true);
			}
		});
		btnReservation.setFont(new Font("Dialog", Font.BOLD, 15));
		btnReservation.setBounds(12, 70, 320, 79);
		contentPane.add(btnReservation);
		
		JButton btnMypage = new JButton("진료예약 목록");
		btnMypage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mypage_member mpm = new Mypage_member(lblName.getText());
				mpm.setVisible(true);
			}
		});
		btnMypage.setFont(new Font("Dialog", Font.BOLD, 15));
		btnMypage.setBounds(12, 159, 320, 79);
		contentPane.add(btnMypage);
	}

}
