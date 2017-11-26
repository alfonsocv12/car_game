package car_game;

import java.awt.Image;
import java.awt.Toolkit;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class index extends JFrame {

	private JPanel contentPane;

	public index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		ImageIcon fondo=new ImageIcon(this.getClass().getResource("Sin t�tulo-1.jpg"));
		Image fondo1 = fondo.getImage().getScaledInstance(1933, 1203,Image.SCALE_DEFAULT);
		ImageIcon p=new ImageIcon(fondo1);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StartedMenu SM=new StartedMenu();
				SM.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 63, 173, 53);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(10, 155, 173, 53);
		contentPane.add(btnExit);
		
		JLabel lblMeatMyEngine = new JLabel("Meet my Engine");
		lblMeatMyEngine.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 42));
		lblMeatMyEngine.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeatMyEngine.setForeground(Color.WHITE);
		lblMeatMyEngine.setBounds(689, 63, 594, 209);
		contentPane.add(lblMeatMyEngine);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1933, 1203);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(p);
		
		Runnable sound = new sound();
        final Thread soundthread = new Thread(sound); 
        soundthread.start();
	}
	class sound implements Runnable {
		@Override
		public void run() {
			Clip clip = null; 
			try {
        		AudioInputStream audioInputStream =
        				AudioSystem.getAudioInputStream(this.getClass().getResource("Start song.wav"));
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
