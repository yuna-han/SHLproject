import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements MouseListener {

	private JPanel contentPane;
	public JTextField txtID;
	private JPasswordField pwdPW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void Login_internal() {
		String userID = txtID.getText();
		String userPW = pwdPW.getText();
		
		DBcon.dbopen();
		DBcon.query(String.format("select * from member where id='%s' and pw='%s'", userID, userPW));
		try {
			while(DBcon.rs.next()) {
				if(userID.equals("admin")) { //관리자 로그인
					JOptionPane.showMessageDialog(null, "관리자 로그인 성공!");
					Main_admin ma = new Main_admin();
					ma.lblName.setText(this.txtID.getText());
					ma.setVisible(true);
					
				}else { //회원 로그인
					JOptionPane.showMessageDialog(null, "회원 로그인 성공!");
					Main_member mm= new Main_member();
					mm.lblName.setText(this.txtID.getText());
					mm.setVisible(true);
				}
				dispose();
			}
		} catch (Exception ex) {
			System.out.println("실패에러: " + ex.toString());
		}
	}
	
	
	public Login() { //Login UI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblID = new JLabel("ID");
		lblID.setForeground(Color.BLACK);
		lblID.setFont(new Font("Dialog", Font.BOLD, 18));
		lblID.setBounds(12, 110, 50, 40);
		contentPane.add(lblID);
		
		JLabel lblPW = new JLabel("PW");
		lblPW.setForeground(Color.BLACK);
		lblPW.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPW.setBounds(12, 162, 50, 40);
		contentPane.add(lblPW);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtID.setColumns(10);
		txtID.setBounds(52, 110, 185, 40);
		contentPane.add(txtID);
		
		pwdPW = new JPasswordField();
		pwdPW.setFont(new Font("Dialog", Font.PLAIN, 15));
		pwdPW.setBounds(52, 162, 185, 40);
		contentPane.add(pwdPW);
		
		JButton btnJoin = new JButton("회원 가입");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Join j = new Join();
				j.setVisible(true);
			}
		});
		
		btnJoin.setFont(new Font("Dialog", Font.BOLD, 15));
		btnJoin.setBounds(22, 231, 320, 40);
		contentPane.add(btnJoin);
		
		JButton btnPwFind = new JButton("비밀번호 찾기");
		btnPwFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PwFind pf = new PwFind();
				pf.setVisible(true);
			}
		});
		btnPwFind.setFont(new Font("Dialog", Font.BOLD, 15));
		btnPwFind.setBounds(22, 275, 320, 40);
		contentPane.add(btnPwFind);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_internal();
			}
		});
		btnLogin.setFont(new Font("Dialog", Font.BOLD, 15));
		btnLogin.setBounds(262, 110, 95, 90);
		contentPane.add(btnLogin);
		
		JLabel ldlSHL = new JLabel("SHL병원");
		ldlSHL.setForeground(Color.BLACK);
		ldlSHL.setFont(new Font("Dialog", Font.BOLD, 32));
		ldlSHL.setBounds(124, 31, 131, 40);
		contentPane.add(ldlSHL);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
