package car_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class engineSelector extends JFrame {

	private JPanel contentPane;
	public engineSelector() {
		//JOptionPane
		UIManager UI=new UIManager();
		UI.put("OptionPane.background", Color.GRAY);
		UI.put("Panel.background", Color.gray);
		
		
		setBounds(0, 0, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//fullScreen
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setUndecorated(true);
		setVisible(true);
		//Background		
		ImageIcon fondo=new ImageIcon(this.getClass().getResource("StartedMenuBackgroud.jpg"));
		Image fondo1 = fondo.getImage().getScaledInstance(1933, 1203,Image.SCALE_DEFAULT);	
		ImageIcon p=new ImageIcon(fondo1);
		//TITLE
		JLabel lblChooseACar = new JLabel("Choose the Engine");
		lblChooseACar.setForeground(Color.WHITE);
		lblChooseACar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 42));
		lblChooseACar.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseACar.setBounds(656, 11, 603, 141);
		contentPane.add(lblChooseACar);
		
		//engine Cylinders
		CCounter CC=new CCounter();
		
		JLabel CCounter=new JLabel();
		
		//imagen Selector
		JLabel recorrerTipos=new JLabel("0");
		String[][] engines=new String[4][3];
		engines[0][0]="Engine0.gif";
		engines[0][1]="4boxer.gif";
		engines[1][0]="Engine1.gif";
		engines[2][0]="Engine2.gif";
		engines[2][1]="6Boxer.gif";
		engines[2][2]="6inline.gif";
		engines[3][0]="Engine3.gif";
		
		//costo
		int[][] costos=new int[4][3];
		costos[0][0]=800;
		costos[0][1]=2500;
		costos[1][0]=1900;
		costos[2][0]=2000;
		costos[2][1]=4000;
		costos[2][2]=2500;
		costos[3][0]=3000;
		
		//engine imagen JLabel
		JLabel Car14 = 	new JLabel("");
		
		ImageIcon Car12 = new ImageIcon(this.getClass().getResource(engines[CC.getCounter()][0]));
		Image CarA=Car12.getImage().getScaledInstance(1202, 906, Image.SCALE_DEFAULT);
		ImageIcon CarFinal1=new ImageIcon(CarA);
		Car14.setIcon(CarFinal1);
		
		
		JLabel lblCosto = new JLabel("$:"+costos[CC.getCounter()][0]);
		lblCosto.setForeground(Color.WHITE);
		lblCosto.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 42));
		lblCosto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCosto.setBounds(656, 986, 603, 88);
		contentPane.add(lblCosto);
		
		//derecha
		JLabel FlechaD = new JLabel();
		FlechaD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					int recorrerTiposint=Integer.parseInt(recorrerTipos.getText());
					if(CC.getCounter()==0) {
						if(recorrerTiposint==1) {
							
						} else {
							recorrerTiposint++;
							recorrerTipos.setText(String.valueOf(recorrerTiposint));
							ImageIcon Car13 = new ImageIcon(this.getClass().getResource(engines[CC.getCounter()][recorrerTiposint]));
							lblCosto.setText("$:"+costos[CC.getCounter()][recorrerTiposint]);
							Image CarAD13=Car13.getImage().getScaledInstance(1202, 906, Image.SCALE_DEFAULT);
							ImageIcon CarFinal13=new ImageIcon(CarAD13);
							Car14.setIcon(CarFinal13);
							
						}
						
					}else if(CC.getCounter()==1) {
						ImageIcon Car13 = new ImageIcon(this.getClass().getResource(engines[CC.getCounter()][recorrerTiposint]));
						lblCosto.setText("$:"+costos[CC.getCounter()][recorrerTiposint]);
						Image CarAD13=Car13.getImage().getScaledInstance(1202, 906, Image.SCALE_DEFAULT);
						ImageIcon CarFinal13=new ImageIcon(CarAD13);
						Car14.setIcon(CarFinal13);
						
					}else if(CC.getCounter()==2) {
						if(recorrerTiposint==2) {
							
						} else {
							recorrerTiposint++;
							recorrerTipos.setText(String.valueOf(recorrerTiposint));
							ImageIcon Car13 = new ImageIcon(this.getClass().getResource(engines[CC.getCounter()][recorrerTiposint]));
							lblCosto.setText("$:"+costos[CC.getCounter()][recorrerTiposint]);
							Image CarAD13=Car13.getImage().getScaledInstance(1202, 906, Image.SCALE_DEFAULT);
							ImageIcon CarFinal13=new ImageIcon(CarAD13);
							Car14.setIcon(CarFinal13);
							
						}
					}else if(CC.getCounter()==3) {
						ImageIcon Car13 = new ImageIcon(this.getClass().getResource(engines[CC.getCounter()][recorrerTiposint]));
						lblCosto.setText("$:"+costos[CC.getCounter()][recorrerTiposint]);
						Image CarAD13=Car13.getImage().getScaledInstance(1202, 906, Image.SCALE_DEFAULT);
						ImageIcon CarFinal13=new ImageIcon(CarAD13);
						Car14.setIcon(CarFinal13);
					}
				
			}
		});
		ImageIcon fDI=new ImageIcon(this.getClass().getResource("openD.png"));
		Image fadD=fDI.getImage().getScaledInstance(236, 198, Image.SCALE_DEFAULT);
		ImageIcon FDIFinal=new ImageIcon(fadD);
		
		FlechaD.setIcon(FDIFinal);
		FlechaD.setBounds(1600, 482, 236, 198);
		contentPane.add(FlechaD);
		
		//izquierda
		JLabel flechaI = new JLabel("");
		flechaI.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int recorrerTiposint=Integer.parseInt(recorrerTipos.getText());
				if(CC.getCounter()==0) {
					if(recorrerTiposint==0) {
						
					} else {
						recorrerTiposint--;
						recorrerTipos.setText(String.valueOf(recorrerTiposint));
						ImageIcon Car13 = new ImageIcon(this.getClass().getResource(engines[CC.getCounter()][recorrerTiposint]));
						lblCosto.setText("$:"+costos[CC.getCounter()][recorrerTiposint]);
						Image CarAD13=Car13.getImage().getScaledInstance(1202, 906, Image.SCALE_DEFAULT);
						ImageIcon CarFinal13=new ImageIcon(CarAD13);
						Car14.setIcon(CarFinal13);
						
					}
					
				}else if(CC.getCounter()==1) {
					ImageIcon Car13 = new ImageIcon(this.getClass().getResource(engines[CC.getCounter()][recorrerTiposint]));
					lblCosto.setText("$:"+costos[CC.getCounter()][recorrerTiposint]);
					Image CarAD13=Car13.getImage().getScaledInstance(1202, 906, Image.SCALE_DEFAULT);
					ImageIcon CarFinal13=new ImageIcon(CarAD13);
					Car14.setIcon(CarFinal13);
					
				}else if(CC.getCounter()==2) {
					if(recorrerTiposint==0) {
						
					} else {
						recorrerTiposint--;
						recorrerTipos.setText(String.valueOf(recorrerTiposint));
						ImageIcon Car13 = new ImageIcon(this.getClass().getResource(engines[CC.getCounter()][recorrerTiposint]));
						lblCosto.setText("$:"+costos[CC.getCounter()][recorrerTiposint]);
						Image CarAD13=Car13.getImage().getScaledInstance(1202, 906, Image.SCALE_DEFAULT);
						ImageIcon CarFinal13=new ImageIcon(CarAD13);
						Car14.setIcon(CarFinal13);
						
					}
				}else if(CC.getCounter()==3) {
					ImageIcon Car13 = new ImageIcon(this.getClass().getResource(engines[CC.getCounter()][recorrerTiposint]));
					lblCosto.setText("$:"+costos[CC.getCounter()][recorrerTiposint]);
					Image CarAD13=Car13.getImage().getScaledInstance(1202, 906, Image.SCALE_DEFAULT);
					ImageIcon CarFinal13=new ImageIcon(CarAD13);
					Car14.setIcon(CarFinal13);
				}
			}
		});
		ImageIcon fII=new ImageIcon(this.getClass().getResource("open.png"));
		Image fad=fII.getImage().getScaledInstance(236, 198, Image.SCALE_DEFAULT);
		ImageIcon FIIFinal=new ImageIcon(fad);
		flechaI.setIcon(FIIFinal);
		flechaI.setBounds(135, 482, 236, 198);
		contentPane.add(flechaI);
		
		//pago
		Car14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int recorrerTiposint=Integer.parseInt(recorrerTipos.getText());
				CCounter CC=new CCounter();
				CC.setEngineType(recorrerTiposint);
				CC.setEngineCost(costos[CC.getCounter()][recorrerTiposint]);
				running rn=new running();
				rn.setVisible(true);
				dispose();
			}
		});
		
		//image set Jframe
		ImageIcon CarI=new ImageIcon(this.getClass().getResource(""));
		Image CarAD=CarI.getImage().getScaledInstance(1202, 906, Image.SCALE_DEFAULT);
		ImageIcon CarFinal=new ImageIcon(CarAD);
		
		Car14.setIcon(CarFinal);
		Car14.setBounds(387, 163, 1202, 906);
		contentPane.add(Car14);
		
		
		
		//Backgroud JLabel
		JLabel labelB13 = new JLabel("");
		labelB13.setBounds(0, 0, 1933, 1203);
		contentPane.add(labelB13);
		labelB13.setIcon(p);
		
	}
}
