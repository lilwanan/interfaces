import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jframe24 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jframe24 frame = new Jframe24();
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
	public Jframe24() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1410, 860);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JButton btnclicsecundario = new JButton("Haz clic aqui");
		btnclicsecundario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*JFSecundario secundario = new JFSecundario();
				secundario.setVisible(true);
				dispose();*/
				
				JDSecundarioModal secundario = new JDSecundarioModal(this,true);
				
				//JFSecundario secundario = new JFSecundario(this,true);
			}
		});
		btnclicsecundario.setBounds(853, 371, 89, 23);
		contentPane.add(btnclicsecundario);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
