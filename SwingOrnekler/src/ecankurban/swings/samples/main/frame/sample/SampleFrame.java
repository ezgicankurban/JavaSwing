package ecankurban.swings.samples.main.frame.sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;

public class SampleFrame extends JFrame{
	
	JProgressBar prbarOrnek=null;
	JButton btn=null;
	Timer timer=null;
	private JTextField textField;
	public SampleFrame() {
		getContentPane().setBackground(new Color(173, 216, 230));
		initialize();
		
		
	}

	private void initialize() {
		setTitle("Deneme Ekraný");
		getContentPane().setLayout(null);
		setBounds(150, 250, 484, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		btn=new JButton("Týkla");
		btn.setBackground(SystemColor.desktop);
		btn.setForeground(Color.RED);
		btn.setVisible(true);
		btn.setBounds(362, 25, 89, 35);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(timer==null) {
					timer=new Timer(50,new ActionListener() {
						int deger=0;
						
						@Override
						public void actionPerformed(ActionEvent e) {
							deger++;
							if(deger>100) {
								timer.stop();
								timer=null;
							}
							prbarOrnek.setValue(deger);
							textField.setText(""+deger);
							
						}
					});
					timer.start();
					
				}
				
				
			}
		});
		
		
		
		
		
		
		/*btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {//click event i 
				//JOptionPane.showMessageDialog(SampleFrame.this, "Butona basýldý!!!!");
				
				Thread t=new Thread(new Runnable() {
					
					@Override
					public void run() {
						btn.setEnabled(false);
						
						
						for (int i = 0; i <=100; i++) {
					System.out.println(prbarOrnek.getValue());
					prbarOrnek.setValue(i);
					prbarOrnek.setToolTipText(""+i);
					prbarOrnek.setStringPainted(true);
					textField.setText(""+i);
					btn.setVisible(false);
					repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e2) {
						e2.printStackTrace();
					}
					
				}		btn.setVisible(true);
						btn.setEnabled(true);
					}
				});
				
				t.start();
				
				
				
			}
		});*/
		
		getContentPane().add(btn);//extends aldýðý class jcomponent e gittiði için btn'yi component olarak kabul etti.Ata classlarýndan biri jcomponent 
		
		 prbarOrnek = new JProgressBar();
		prbarOrnek.setBounds(29, 25, 323, 35);
		getContentPane().add(prbarOrnek);
		
		textField = new JTextField();
		textField.setBounds(33, 81, 319, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
	}
}
