package ecankurban.swings.samples.main.frame.sample;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GirisFrame  extends JFrame{
	private JTextField txtKulAdi;
	private JTextField txtSifre;
	private String Kadi;
	private String Sifre;
	public GirisFrame() {
		
		JButton btnGiris;
		
		getContentPane().setLayout(null);
		initialize();
	}

	private void initialize() {
		
		
		txtKulAdi = new JTextField();
		txtKulAdi.setBounds(50, 46, 127, 31);
		getContentPane().add(txtKulAdi);
		txtKulAdi.setColumns(10);
		
		txtSifre = new JTextField();
		txtSifre.setBounds(50, 108, 127, 31);
		getContentPane().add(txtSifre);
		txtSifre.setColumns(10);
		
		JButton btnGiris = new JButton("Giri\u015F");
		btnGiris.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(kadi.equals)
				
			}
		});
		btnGiris.setBounds(254, 80, 91, 23);
		getContentPane().add(btnGiris);
		
		
	}

}
