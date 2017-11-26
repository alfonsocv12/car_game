package car_game;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StartedMenu extends JFrame {

	private JPanel contentPane;

	public StartedMenu() {
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
		ImageIcon fondo=new ImageIcon(this.getClass().getResource("StartedMenuBackgroud.jpg"));
		Image fondo1 = fondo.getImage().getScaledInstance(1933, 1203,Image.SCALE_DEFAULT);
		ImageIcon p=new ImageIcon(fondo1);
		
		JLabel lblChooseACar = new JLabel("Choose a car");
		lblChooseACar.setForeground(Color.WHITE);
		lblChooseACar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 42));
		lblChooseACar.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseACar.setBounds(656, 11, 603, 141);
		contentPane.add(lblChooseACar);
		
		//car counter
		JLabel CCounter=new JLabel("0");
		JLabel Car = new JLabel("");
		ImageIcon CarI=new ImageIcon(this.getClass().getResource("car"+CCounter.getText()+".jpg"));
		Image CarAD=CarI.getImage().getScaledInstance(1202, 906, Image.SCALE_DEFAULT);
		ImageIcon CarFinal=new ImageIcon(CarAD);
		Car.setIcon(CarFinal);
		Car.setBounds(387, 163, 1202, 906);
		contentPane.add(Car);
		
		JLabel FlechaD = new JLabel("");
		ImageIcon fDI=new ImageIcon(this.getClass().getResource("flechaD.jpg"));
		Image fadD=fDI.getImage().getScaledInstance(236, 198, Image.SCALE_DEFAULT);
		ImageIcon FDIFinal=new ImageIcon(fadD);
		FlechaD.setIcon(FDIFinal);
		FlechaD.setBounds(1600, 482, 236, 198);
		contentPane.add(FlechaD);
		
		
		
		JLabel flechaI = new JLabel("");
		
		ImageIcon fII=new ImageIcon(this.getClass().getResource("flechaI.jpg"));
		Image fad=fII.getImage().getScaledInstance(236, 198, Image.SCALE_DEFAULT);
		ImageIcon FIIFinal=new ImageIcon(fad);
		flechaI.setIcon(FIIFinal);
		flechaI.setBounds(135, 482, 236, 198);
		contentPane.add(flechaI);
		//Backgroud JLabel
		JLabel labelB = new JLabel("");
		
		labelB.setBounds(0, 0, 1933, 1203);
		contentPane.add(labelB);
		labelB.setIcon(p);
	}
}
