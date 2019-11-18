
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Worker {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Worker window = new Worker();
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
	public Worker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(29, 6, 284, 20);
		frame.getContentPane().add(toolBar);
		
		JButton btnNewButton = new JButton("Feeder");
		btnNewButton.setBounds(22, 109, 154, 63);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Trainer");
		btnNewButton_1.setBounds(260, 109, 145, 63);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Performer");
		btnNewButton_2.setBounds(484, 109, 145, 63);
		frame.getContentPane().add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(484, 309, 187, 206);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JRadioButton rdbtnAdd = new JRadioButton("Add Worker");//The Upper One
		//Add litener here
		panel.add(rdbtnAdd);
		
		JRadioButton rdbtnRemove = new JRadioButton("Remove Worker");//
		//Add litener here
		panel.add(rdbtnRemove);
		
		JRadioButton rdbtnSearch = new JRadioButton("Search Worker");
		//Add litener here
		panel.add(rdbtnSearch);
		
		JRadioButton rdbtnPromote = new JRadioButton("Promote Worker");
		//Add litener here
		panel.add(rdbtnPromote);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnAdd);
		group.add(rdbtnRemove);
		group.add(rdbtnSearch);
		group.add(rdbtnPromote);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
