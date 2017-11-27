package Car_Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class StartedMenu extends JFrame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartedMenu frame = new StartedMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPane;

	public StartedMenu() {
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
		
		JLabel lblChooseACar = new JLabel("Choose a car");
		lblChooseACar.setForeground(Color.WHITE);
		lblChooseACar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 42));
		lblChooseACar.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseACar.setBounds(656, 11, 603, 141);
		contentPane.add(lblChooseACar);
		
		//car counter
		JLabel CCounter=new JLabel("0");
		JLabel Car = 	new JLabel("");
		ImageIcon CarI=new ImageIcon(this.getClass().getResource("Engine"+CCounter.getText()+".gif"));
		Image CarAD=CarI.getImage().getScaledInstance(1202, 906, Image.SCALE_DEFAULT);
		ImageIcon CarFinal=new ImageIcon(CarAD);
		
		JLabel lblNewLabel = new JLabel("4 Cylinder");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 36));
		lblNewLabel.setBounds(732, 163, 457, 106);
		contentPane.add(lblNewLabel);
		
		JButton Select = new JButton("Select");
		Select.setBounds(880, 982, 167, 61);
		contentPane.add(Select);
		Car.setIcon(CarFinal);
		Car.setBounds(387, 163, 1202, 906);
		contentPane.add(Car);
		
		JLabel FlechaD = new JLabel("");
		FlechaD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int counterPlus= Integer.parseInt(CCounter.getText());
				if(counterPlus==3) {
					lblNewLabel.setText("8 Cylinders");
				
				}else {
					counterPlus++;
					System.out.println(counterPlus);
					CCounter.setText(String.valueOf(counterPlus));
					ImageIcon CarI = new ImageIcon(this.getClass().getResource("Engine"+CCounter.getText()+".gif"));
					Image CarAD=CarI.getImage().getScaledInstance(1202, 906, Image.SCALE_DEFAULT);
					ImageIcon CarFinal=new ImageIcon(CarAD);
					int numeroCilindros=4+counterPlus;
					if(numeroCilindros==7) {
						lblNewLabel.setText("8 cylinder");
					}
					switch(counterPlus) {
						case 0:
					}
					lblNewLabel.setText(numeroCilindros+" Cylinders");
					Car.setIcon(CarFinal);
					
				}
			}
		});
		ImageIcon fDI=new ImageIcon(this.getClass().getResource("openD.png"));
		Image fadD=fDI.getImage().getScaledInstance(236, 198, Image.SCALE_DEFAULT);
		ImageIcon FDIFinal=new ImageIcon(fadD);
		FlechaD.setIcon(FDIFinal);
		FlechaD.setBounds(1600, 482, 236, 198);
		contentPane.add(FlechaD);
		
		
		
		JLabel flechaI = new JLabel("");
		flechaI.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int counterPlus= Integer.parseInt(CCounter.getText());
				if(counterPlus==0) {
					lblNewLabel.setText("4 Cylinders");
				}else {
					counterPlus--;
					System.out.println(counterPlus);
					CCounter.setText(String.valueOf(counterPlus));
					CCounter.setText(String.valueOf(counterPlus));
					ImageIcon CarI = new ImageIcon(this.getClass().getResource("Engine"+CCounter.getText()+".gif"));
					Image CarAD=CarI.getImage().getScaledInstance(1202, 906, Image.SCALE_DEFAULT);
					ImageIcon CarFinal=new ImageIcon(CarAD);
					int numeroCilindros=4+counterPlus;
					lblNewLabel.setText(numeroCilindros+" Cylinders");
					Car.setIcon(CarFinal);
					
				}
			}
		});
		
		ImageIcon fII=new ImageIcon(this.getClass().getResource("open.png"));
		Image fad=fII.getImage().getScaledInstance(236, 198, Image.SCALE_DEFAULT);
		ImageIcon FIIFinal=new ImageIcon(fad);
		flechaI.setIcon(FIIFinal);
		flechaI.setBounds(135, 482, 236, 198);
		contentPane.add(flechaI);
		
		JLabel billete = new JLabel();
		
		billete.setBounds(10, 26, 46, 14);
		contentPane.add(billete);
		
		
		
		//Backgroud JLabel
		JLabel labelB = new JLabel("");
		labelB.setBounds(0, 0, 1933, 1203);
		contentPane.add(labelB);
		labelB.setIcon(p);
		ImageIcon pesoImagen=new ImageIcon(this.getClass().getResource("billete_8.jpg"));
		Image pesoImagenEscalada=pesoImagen.getImage().getScaledInstance(1202, 906, Image.SCALE_DEFAULT);
		ImageIcon pesoImagenFinal=new ImageIcon(pesoImagenEscalada);
		
		JOptionPane.showMessageDialog(null,"Ok you start with 3000 dollars","Money",JOptionPane.INFORMATION_MESSAGE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(null,"It's your work to get more","Money",JOptionPane.INFORMATION_MESSAGE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(null,"Select and Engine","Money",JOptionPane.INFORMATION_MESSAGE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
