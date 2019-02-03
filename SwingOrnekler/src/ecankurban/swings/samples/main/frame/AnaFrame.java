package ecankurban.swings.samples.main.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class AnaFrame extends JFrame {
	private JTextField txtUyari;
	public AnaFrame() {
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Giri\u015F Paneli");
		getContentPane().setBackground(new Color(224, 255, 255));
		//setSize(200, 200);framein boyutunu belirliyor.
		setBounds(150, 250, 662, 486);//x-y ile açýlan frame in ekranda konumu belirlenir.Ayrýca frame boyutunu da burdan belirleyebiliriz.
		getContentPane().setLayout(null);
		
		JLabel lblUyari = new JLabel("Uyar\u0131");
		lblUyari.setBounds(190, 11, 220, 41);
		lblUyari.setBackground(Color.WHITE);
		lblUyari.setFont(new Font("Tekton Pro Cond", Font.BOLD, 20));
		lblUyari.setHorizontalAlignment(SwingConstants.CENTER);
		lblUyari.setForeground(new Color(106, 90, 205));
		getContentPane().add(lblUyari);//frame'e objenin eklenmesini söylediðimiz yer.
		
		txtUyari = new JTextField();
		txtUyari.setForeground(Color.WHITE);
		txtUyari.setBounds(172, 138, 286, 41);
		getContentPane().add(txtUyari);
		
	}
	
	public void veriAL(String isim,String deger) {// bu methodla txt ye dýþarýdan deðer girdim.
		if(isim.equals("txtUyari")) {
			txtUyari.setText(deger);
		}
	}
}
