import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFSecundario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					JFSecundario frame = new JFSecundario();
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
	public JFSecundario() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // no te deja cerrar la ventana 
		this.setUndecorated(true); // esconde la barra
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("ESTA ES LA VENTANA SECUNDARIRIA");
		lblNewLabel.setBounds(128, 97, 202, 43);
		contentPane.add(lblNewLabel);
		
		JButton btnvolverprincipal = new JButton("volver");
		btnvolverprincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jframe24 principal = new Jframe24();
				principal.setVisible(true);
				dispose();
			}
		});
		btnvolverprincipal.setBounds(10, 227, 89, 23);
		contentPane.add(btnvolverprincipal);
	}
}
