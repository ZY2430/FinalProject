import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ZooMainPage.ZooMainPage;

import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZooLogin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZooLogin window = new ZooLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ZooLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setFont(new Font("Apple Braille", Font.BOLD, 18));
		lblNewLabel.setBounds(178, 29, 138, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setBounds(46, 82, 86, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBounds(46, 148, 86, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setBounds(174, 77, 153, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 145, 149, 26);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.setBounds(61, 218, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = textField.getText();
				String password = passwordField.getText();
				
				if(password.contentEquals("CS151") && username.contentEquals("hello"))
				{
					JOptionPane.showConfirmDialog(null, "Login successful");
					
					ZooMainPage page = new ZooMainPage();
					page.main(null);
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Isnvalid ID or password, please try again");
					textField.setText(null);
					passwordField.setText(null);
				}
				
			}
		});
		btnLogin.setBounds(268, 218, 117, 29);
		frame.getContentPane().add(btnLogin);
	}

}
