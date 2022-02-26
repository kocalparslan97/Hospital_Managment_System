package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Helper.Helper;
import Model.Hasta;

public class RegisterGUI extends JFrame {
	private JTextField fld_name;
	private JTextField fld_tcno;
	private JPasswordField fld_pass;
	private Hasta hasta = new Hasta();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI();
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
	public RegisterGUI() {
		setResizable(false);
		setTitle("Hastane Yonetim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 330);
		JPanel w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);

		JLabel label = new JLabel("Ad Soyad");
		label.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		label.setBounds(10, 21, 132, 22);
		w_pane.add(label);

		fld_name = new JTextField();
		fld_name.setColumns(10);
		fld_name.setBounds(10, 48, 274, 22);
		w_pane.add(fld_name);

		JLabel lblTcNo = new JLabel("T.C. No");
		lblTcNo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblTcNo.setBounds(10, 81, 132, 22);
		w_pane.add(lblTcNo);

		fld_tcno = new JTextField();
		fld_tcno.setColumns(10);
		fld_tcno.setBounds(10, 108, 274, 22);
		w_pane.add(fld_tcno);

		JLabel lblTcNo_1 = new JLabel("Sifre");
		lblTcNo_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblTcNo_1.setBounds(10, 141, 132, 22);
		w_pane.add(lblTcNo_1);

		fld_pass = new JPasswordField();
		fld_pass.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		fld_pass.setBounds(10, 164, 274, 22);
		w_pane.add(fld_pass);

		JButton btn_register = new JButton("Kay\u0131t Ol");
		btn_register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fld_tcno.getText().length() == 0 || fld_pass.getText().length() == 0
						|| fld_name.getText().length() == 0) {
					Helper.showMsg("fill");
				} else {
					try {
						boolean control = hasta.register(fld_tcno.getText(), fld_pass.getText(), fld_name.getText());
						if (control) {
							Helper.showMsg("success");
							LoginGUI login = new LoginGUI();
							login.setVisible(true);
							dispose();
						} else {
							Helper.showMsg("error");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btn_register.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btn_register.setBounds(10, 214, 274, 28);
		w_pane.add(btn_register);

		JButton btn_backTo = new JButton("Geri Don");
		btn_backTo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginGUI login = new LoginGUI();
				login.setVisible(true);
				dispose();
			}
		});
		btn_backTo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btn_backTo.setBounds(10, 253, 274, 28);
		w_pane.add(btn_backTo);
	}
}
