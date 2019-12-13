import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class Reservation extends JFrame {

	private JPanel contentPane;
	private String userID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation frame = new Reservation("1");
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
	public Reservation(String id) {
		this.userID = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDepart = new JLabel("\uD76C\uB9DD\uC9C4\uB8CC\uACFC");
		lblDepart.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDepart.setBounds(103, 90, 127, 20);
		contentPane.add(lblDepart);
		
		JLabel lblTitle = new JLabel("\uC608\uC57D\uD558\uAE30");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 32));
		lblTitle.setBounds(206, 24, 150, 40);
		contentPane.add(lblTitle);
		
		JComboBox cbDepart = new JComboBox();
		cbDepart.setModel(new DefaultComboBoxModel(new String[] {"\uC678\uACFC", "\uB0B4\uACFC", "\uC2E0\uACBD\uC678\uACFC", "\uD53C\uBD80\uACFC", "\uCE58\uACFC"}));
		cbDepart.setBounds(88, 120, 150, 34);
		contentPane.add(cbDepart);
		
		JLabel lblDate = new JLabel("\uD76C\uB9DD\uB0A0\uC9DC");
		lblDate.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDate.setBounds(333, 90, 127, 20);
		contentPane.add(lblDate);
		
		JSpinner cbDate = new JSpinner();
		cbDate.setModel(new SpinnerDateModel(new Date(1575298800000L), null, null, Calendar.DAY_OF_YEAR));
		cbDate.setBounds(326, 120, 150, 34);
		contentPane.add(cbDate);
		
		JLabel lblContent = new JLabel("\uB0B4\uC6A9");
		lblContent.setFont(new Font("Dialog", Font.BOLD, 20));
		lblContent.setBounds(45, 178, 127, 20);
		contentPane.add(lblContent);
		
		JTextArea txtContent = new JTextArea();
		txtContent.setLineWrap(true);
		txtContent.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtContent.setBounds(28, 208, 506, 108);
		contentPane.add(txtContent);
		
		JButton btnConfirm = new JButton("\uD655\uC778");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String deptCode = "D01";
			        switch (cbDepart.getSelectedIndex())
			        {
			        case -1:
			        case 0:
			        	deptCode = "D01";
			        	break;
			        case 1:
			        	deptCode = "D02";
			        	break;
			        case 2:
			        	deptCode = "D03";
			        	break;
			        case 3:
			        	deptCode = "D04";
			        	break;
			        case 4:
			        	deptCode = "D05";
			        	break;
			        }
			        Date date = (Date)cbDate.getValue();
			        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			        String to = transFormat.format(date);
				DBcon.dbopen();
				DBcon.query(String.format("insert into reservation ( `rdate` ,`content` ,`id` ,`deptcode`) VALUES ('%s', '%s', '%s', '%s');", to, txtContent.getText(), userID, deptCode));
				Reservation_confirm rc = new Reservation_confirm();
				rc.setVisible(true);
				dispose();
			}
		});
		btnConfirm.setFont(new Font("Dialog", Font.BOLD, 15));
		btnConfirm.setBounds(115, 326, 154, 60);
		contentPane.add(btnConfirm);
		
		JButton btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			dispose();
			}
		});
		btnCancel.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnCancel.setBounds(281, 326, 154, 60);
		contentPane.add(btnCancel);
	}
}
