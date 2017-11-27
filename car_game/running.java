package car_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

public class running extends JFrame {
	private JLabel lblCosto;
	private JLabel HP;
	private JPanel contentPane;

	public running() {
		setBounds(0, 0, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//fullScreen
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setUndecorated(true);
		setVisible(true);
		
		//engines
		String[][] engines=new String[4][3];
		engines[0][0]="Engine0.gif";
		engines[0][1]="4boxer.gif";
		engines[1][0]="Engine1.gif";
		engines[2][0]="Engine2.gif";
		engines[2][1]="6Boxer.gif";
		engines[2][2]="6inline.gif";
		engines[3][0]="Engine3.gif";
		
		//HP
		int[][] caballos=new int[4][3];
		caballos[0][0]=160;
		caballos[0][1]=210;
		caballos[1][0]=300;
		caballos[2][0]=340;
		caballos[2][1]=296;
		caballos[2][2]=324;
		caballos[3][0]=300;		
		this.HP = new JLabel("0");
		
		//Background
		ImageIcon fondo=new ImageIcon(this.getClass().getResource("StartedMenuBackgroud.jpg"));
		Image fondo1 = fondo.getImage().getScaledInstance(1933, 1203,Image.SCALE_DEFAULT);
		ImageIcon p=new ImageIcon(fondo1);
		
		//Dinero
		CCounter CC=new CCounter();
		CC.setMoney(3000-CC.getEngineCost());
		this.lblCosto = new JLabel(String.valueOf(CC.getMoney()));
		lblCosto.setForeground(Color.WHITE);
		lblCosto.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 42));
		lblCosto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCosto.setBounds(1311, 0, 603, 88);
		contentPane.add(lblCosto);
		
		
		JLabel UseExhaust =new JLabel("0");
		JButton btnExhaust = new JButton("Exhaust");
		btnExhaust.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int use;
				use=Integer.parseInt(UseExhaust.getText());
				if(use>0) {
					JOptionPane.showMessageDialog(null, "You already use this");
				}else {
				use=1;
				UseExhaust.setText(String.valueOf(use));
				int MTSLE=1;
				int hpsuma=Integer.parseInt(HP.getText());
				switch(CC.getCounter()) {
					case 0:switch(MTSLE) {
							case 0: 
									hpsuma+=60;
									HP.setText(String.valueOf(hpsuma));
							case 1:
								   hpsuma+=35;
								   HP.setText(String.valueOf(hpsuma));
						   }
					case 1:hpsuma+=32;
					       HP.setText(String.valueOf(hpsuma));
					case 3:switch(CC.getEngineType()) {
								case 0:hpsuma+=10;
								   HP.setText(String.valueOf(hpsuma));
								case 1:hpsuma+=20;
								   HP.setText(String.valueOf(hpsuma));
								case 2:	hpsuma+=5;
								   HP.setText(String.valueOf(hpsuma));
						   }
						
					case 4:hpsuma+=43;
					   HP.setText(String.valueOf(hpsuma));
				int costo=Integer.parseInt(lblCosto.getText())-2100;
				lblCosto.setText(String.valueOf(costo));   
				}
				
				}
			}
		});
		ImageIcon ExhaustI=new ImageIcon(this.getClass().getResource("Exhaust.jpg"));
		Image ExhaustIm = ExhaustI.getImage().getScaledInstance(300, 281,Image.SCALE_DEFAULT);
		ImageIcon ExhaustFinal=new ImageIcon(ExhaustIm);
		btnExhaust.setBounds(400, 381, 308, 248);
		btnExhaust.setIcon(ExhaustFinal);
		contentPane.add(btnExhaust);
		
		JLabel UseFilter =new JLabel("0");
		JButton btnAirfilter = new JButton("airFilter");
		btnAirfilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int use;
				use=Integer.parseInt(UseFilter.getText());
				if(use>0) {
					JOptionPane.showMessageDialog(null, "You already use this");
				}else {
				use=1;
				UseFilter.setText(String.valueOf(use));
				int MTSLE=1;
				int hpsuma=Integer.parseInt(HP.getText());
				switch(CC.getCounter()) {
					case 0:switch(MTSLE) {
							case 0: 
									hpsuma+=20;
									HP.setText(String.valueOf(hpsuma));
							case 1:
								   hpsuma+=8;
								   HP.setText(String.valueOf(hpsuma));
						   }
					case 1:hpsuma+=7;
					       HP.setText(String.valueOf(hpsuma));
					case 3:switch(CC.getEngineType()) {
								case 0:hpsuma+=2;
								   HP.setText(String.valueOf(hpsuma));
								case 1:hpsuma+=5;
								   HP.setText(String.valueOf(hpsuma));
								case 2:	hpsuma+=15;
								   HP.setText(String.valueOf(hpsuma));
						   }
						
					case 4:hpsuma+=18;
					   HP.setText(String.valueOf(hpsuma));
				}
				int costo=Integer.parseInt(lblCosto.getText())-500;
				lblCosto.setText(String.valueOf(costo)); 	
				
			}
			}
		});
		
		ImageIcon AirI=new ImageIcon(this.getClass().getResource("AirFilter.jpg"));
		Image AirReareange= AirI.getImage().getScaledInstance(300, 281,Image.SCALE_DEFAULT);
		ImageIcon AirFinal=new ImageIcon(AirReareange);
		btnAirfilter.setBounds(813, 381, 308, 248);
		btnAirfilter.setIcon(AirFinal);
		contentPane.add(btnAirfilter);
		
		JButton btnNos = new JButton("Nos");
		btnNos.addMouseListener(new MouseAdapter() {
			Boolean isIt=false;
			int counter;
			Timer timer = new Timer(); 
			@Override
			public void mousePressed(MouseEvent e) {
				
				int hpsuma=Integer.parseInt(HP.getText());
				hpsuma+=30;
				HP.setText(String.valueOf(hpsuma));
				isIt=false;
				
		        counter = 10;
		        TimerTask task = new TimerTask() {
		        	public void run() {
		        		counter --;
		        		
		        		if (counter == 0){ 		     
		    				
	                    int hpsuma=Integer.parseInt(HP.getText());
	                    hpsuma-=30;
	    					HP.setText(String.valueOf(hpsuma));
	                } else if(isIt){
	                    timer.cancel();
	                    isIt=false;
	                }
		        
				}
		       
		        	
			}; 	
			timer.scheduleAtFixedRate(task, 1000, 1000);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				int costo1=Integer.parseInt(lblCosto.getText())-10;
				lblCosto.setText(String.valueOf(costo1)); 
				int hpsuma=Integer.parseInt(HP.getText());
                hpsuma-=30;
				HP.setText(String.valueOf(hpsuma));
				timer.cancel();
			}
		});
		ImageIcon NosI=new ImageIcon(this.getClass().getResource("Nos.jpg"));
		Image NosReareange= NosI.getImage().getScaledInstance(300, 281,Image.SCALE_DEFAULT);
		ImageIcon NosFinal=new ImageIcon(NosReareange);
		btnNos.setBounds(1243, 381, 308, 248);
		btnNos.setIcon(NosFinal);
		contentPane.add(btnNos);
		
		JLabel lblERunning = new JLabel("New label");
		lblERunning.setBounds(297, 6, 411, 298);
		ImageIcon EngineIcon=new ImageIcon(this.getClass().getResource(engines[0][1]));
		Image EngineReareange=EngineIcon.getImage().getScaledInstance(300, 281, Image.SCALE_DEFAULT);
		ImageIcon EngineIconFinal=new ImageIcon(EngineReareange);
		
		
		HP.setHorizontalAlignment(SwingConstants.CENTER);
		HP.setForeground(Color.WHITE);
		HP.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 42));
		HP.setText(String.valueOf(caballos[CC.getCounter()][1]));
		HP.setBounds(478, 6, 603, 88);
		contentPane.add(HP);
		lblERunning.setIcon(EngineIconFinal);
		contentPane.add(lblERunning);
		
		//Backgroud JLabel
		JLabel labelB = new JLabel("");
		labelB.setBounds(0, 0, 1933, 1203);
		contentPane.add(labelB);
		labelB.setIcon(p);
		
		
	}
	Timer timer = new Timer(); 
	public int segundos; 
	public boolean frozen=false; 
 
	class MiTarea extends TimerTask {
		public void run() {
			segundos++;
			System.out.println(segundos);
			
		}
	}
 
	public void Start(int pSeg) throws Exception {
		frozen = false;
		int moneyPorsentaje=Integer.parseInt(this.HP.getText())/100;
		int moneyWin=moneyPorsentaje*8;
		int moneyFinal=Integer.parseInt(this.HP.getText())+moneyWin;
		this.lblCosto.setText(String.valueOf(moneyFinal));
		timer.schedule(new MiTarea(), 0, pSeg * 1000 * 60);
	}
	public void Stop() {
		System.out.println("Stop");
		frozen = true;
	}
 
    public void Reset() {
		System.out.println("Reset");
		frozen = true;
		segundos = 0;
	}

}
