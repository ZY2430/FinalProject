
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ZooMainPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZooMainPage window = new ZooMainPage();
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
	public ZooMainPage() {
		initialize();
	}

	
	class employeeActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			Worker workerPage= new Worker();
			workerPage.main(null);
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME BACK!");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 40));
		lblNewLabel.setBounds(150, 6, 361, 96);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnEmployee = new JButton("EMPLOYEE");
		btnEmployee.setBounds(33, 95, 117, 29);
		ActionListener listener = new employeeActionListener();
		btnEmployee.addActionListener(listener);
		frame.getContentPane().add(btnEmployee);
	}

}
