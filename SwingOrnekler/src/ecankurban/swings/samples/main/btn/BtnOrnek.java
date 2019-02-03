package ecankurban.swings.samples.main.btn;

import javax.swing.JFrame;
import javax.swing.JButton;

public class BtnOrnek extends JFrame {
	
	public BtnOrnek() {
		initialize();
	}
	
	private void initialize()
	{
		setTitle("Btn Ornek");
		setBounds(150, 250, 662, 486);
		getContentPane().setLayout(null);
		
		JButton btnGiris = new JButton("Giri\u015F");
		
		btnGiris.setBounds(66, 79, 292, 23);
		getContentPane().add(btnGiris);
	}
}
