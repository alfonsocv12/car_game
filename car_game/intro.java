package car_game;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import car_game.index;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class intro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					intro frame = new intro();
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
	public intro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//fullScreen
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setUndecorated(true);
		setVisible(true);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.addMouseListener(new MouseAdapter() {
			Boolean isIt=false;
			int counter;
			@Override
			public void mouseClicked(MouseEvent e) {
					isIt=false;
					Timer timer = new Timer(); 
			        counter = 7; 
			        TimerTask task = new TimerTask() {         			          
						public void run() {                       
			            	lblNewLabel_4.setText("00:"+Integer.toString(counter)); 
			                counter --;
			                Runnable sound = new sound();
			                final Thread soundthread = new Thread(sound); 
			                
			                if(counter ==6) {
			                	lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("Picture1.png")));	                	
			                	soundthread.start();			                
			                }
			                if(counter ==5) {
			                	lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("Picture2.png")));
			                }
			                if(counter ==4) {
			                	lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("Picture3.png")));
			                }
			                if(counter ==3) {
			                	lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("Picture4.png")));
			                }
			                if(counter ==2) {
			                	lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("Picture5.png")));
			                }
			                if(counter ==1) {
			                	lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("Picture6.png")));
			                }
			                if (counter == 0){ 		     
			                    timer.cancel();
			                    
			                    index cal=new index();
			                    cal.setVisible(true);
			                    soundthread.interrupt();
			                    dispose();
			                    
			                } else if(isIt){
			                    timer.cancel();
			                    isIt=false;
			                }
			            }
			        };
			 timer.scheduleAtFixedRate(task, 1000, 1000);
			 lblNewLabel.removeMouseListener(this);
			};
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(114,122,1933, 1203);
		contentPane.add(lblNewLabel);			
	}
	class sound implements Runnable {
		@Override
		public void run() {
			Clip clip = null; 
			try {
        		AudioInputStream audioInputStream =
        				AudioSystem.getAudioInputStream(this.getClass().getResource("Sound2.wav"));
        		clip = AudioSystem.getClip();		              		    			    
		        clip.open(audioInputStream); 
        		clip.start();		            
        		Thread.sleep(clip.getMicrosecondLength() / 1000);	             
        	} catch(InterruptedException ex) {
                clip.stop();
                System.out.println("Cancelled 1!");
        	} catch(Exception ex) {
        		System.out.println("Error with playing sound.");
        		ex.printStackTrace();
        	}
		}
	}
}