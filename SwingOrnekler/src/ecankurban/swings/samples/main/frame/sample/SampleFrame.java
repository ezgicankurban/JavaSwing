package ecankurban.swings.samples.main.frame.sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.beans.value.ChangeListener;
import sun.net.smtp.SmtpProtocolException;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;

public class SampleFrame extends JFrame{
	JRadioButton rdbtnKadin ;
	JRadioButton rdbtnErkek; 
	JTextArea txtOkunan ;	
	JProgressBar prbarOrnek=null;
	JButton btn=null;
	Timer timer=null;
	private JTextField txtcolor;
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
		btn.setForeground(new Color(255, 69, 0));
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
							txtcolor.setText(""+deger);
							
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
		 prbarOrnek.setBackground(Color.WHITE);
		prbarOrnek.setBounds(29, 25, 323, 35);
		getContentPane().add(prbarOrnek);
		
		txtcolor = new JTextField();
		txtcolor.setBounds(29, 71, 323, 39);
		getContentPane().add(txtcolor);
		txtcolor.setColumns(10);
		
		JButton btncolorchose = new JButton("Renk Se\u00E7imi");
		btncolorchose.setForeground(new Color(255, 69, 0));
		btncolorchose.setBackground(SystemColor.desktop);
		btncolorchose.setBounds(362, 71, 91, 36);
		btncolorchose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color renk=JColorChooser.showDialog(SampleFrame.this, "Renk seçim ekraný", Color.BLACK);
				
				if(renk!=null) {
					txtcolor.setBackground(renk);
					
				}else
					JOptionPane.showConfirmDialog(SampleFrame.this, "Renk seçimi yapýlmadý..!");
				
				
				
				
			}
		});
		
		getContentPane().add(btncolorchose);
		
		JButton btncolorcho = new JButton("Arkaplan Renk Se\u00E7imi");
		btncolorcho.setForeground(new Color(255, 69, 0));
		btncolorcho.setBackground(SystemColor.desktop);
		btncolorcho.setBounds(143, 136, 190, 23);
		btncolorcho.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color renk=JColorChooser.showDialog(SampleFrame.this, "Renk seçim ekraný", Color.BLACK);
				
				if(renk!=null) {
					getContentPane().setBackground(renk);
					
				}else
					JOptionPane.showConfirmDialog(SampleFrame.this, "Renk seçimi yapýlmadý..!");
				
				
			}
		});
		
		getContentPane().add(btncolorcho);
		
		JButton btnDosyaSec = new JButton("Dosya Se\u00E7");
		btnDosyaSec.setForeground(new Color(255, 69, 0));
		btnDosyaSec.setBackground(SystemColor.desktop);
		btnDosyaSec.setBounds(312, 170, 139, 23);
		btnDosyaSec.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();
				fc.addChoosableFileFilter(new FileNameExtensionFilter("Text Dosyasý", "txt"));
				int secim=fc.showDialog(SampleFrame.this, "Tamam");
				if(secim==JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(SampleFrame.this, "Dosya seçildi"+ fc.getSelectedFile().getName());
				}
				else if(secim==JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(SampleFrame.this, "Dosya seçilmedi..!");
				}
			}
		});
		getContentPane().add(btnDosyaSec);
		
		JButton btnDosya = new JButton("Dosya Se\u00E7");
		btnDosya.setForeground(new Color(255, 69, 0));
		btnDosya.setBackground(SystemColor.desktop);
		btnDosya.setBounds(312, 228, 139, 23);
		btnDosya.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();
				fc.addChoosableFileFilter(new FileNameExtensionFilter("Text Dosyasý", "txt"));
				fc.addChoosableFileFilter(new FileNameExtensionFilter("exe dosyasý", "exe"));
				int secim=fc.showDialog(SampleFrame.this, "Dosya Seç");
				if(secim==JFileChooser.APPROVE_OPTION) {
					File secilen=fc.getSelectedFile();
					if(null!=secilen) {
						JOptionPane.showMessageDialog(SampleFrame.this, "Dosya seçildi"+ secilen.getName());
						try {
							BufferedReader rd=new BufferedReader(new FileReader(secilen));
							String s=null;
							while( (s=rd.readLine())!=null) {
								String[] s1=s.split("=");
								txtOkunan.append(s1[1]+"\n");
			
							}
							
							//System.out.println(s);
							//txtOkunan.setText(s);
							
						} catch (IOException e1) {
							
							e1.printStackTrace();
						}
						
					}
					
					
				}
				else if(secim==JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(SampleFrame.this, "Dosya seçilmedi..!");
				}
				
				
			}
		});
		getContentPane().add(btnDosya);
		
		 txtOkunan = new JTextArea();
		txtOkunan.setBounds(41, 170, 248, 78);
		getContentPane().add(txtOkunan);
		
		
		Personel p=new Personel(1,"Ezgi","Bil Müh");
		Personel p1=new Personel(2,"Ezgi","Bil Müh");
		Personel p2=new Personel(3,"Ezgi","Bil Müh");
		Personel p3=new Personel(4,"Ezgi","Bil Müh");
		Personel[] liste= {p,p1,p2,p3};
		
		String[] veri= {"bil müh","Oðretmen","Doktor","Polis"};
		//JComboBox cmbUnvan = new JComboBox(veri);
		JComboBox cmbUnvan = new JComboBox(liste);
		
		cmbUnvan.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int id =((Personel)cmbUnvan.getSelectedItem()).getId();//getselectedýtem bize p nin hepsini veriyor.
				txtcolor.setText(""+id);
				System.out.println(id);
				
				
			}
		});
		cmbUnvan.setBounds(41, 283, 248, 23);
		getContentPane().add(cmbUnvan);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(415, 283, 36, 23);
		getContentPane().add(spinner);
		
		
		ChangeListener listener
		
		JRadioButton rdbtnKadin = new JRadioButton("Kad\u0131n");
		rdbtnKadin.setBounds(41, 330, 109, 23);
		rdbtnKadin.addChangeListener(listener);
		
		getContentPane().add(rdbtnKadin);
		
		JRadioButton rdbtnErkek = new JRadioButton("Erkek");
		rdbtnErkek.setBounds(180, 330, 109, 23);
		rdbtnErkek.addChangeListener(listener);
		getContentPane().add(rdbtnErkek);
		
		
		
		
	}
}
