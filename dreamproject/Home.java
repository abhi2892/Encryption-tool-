package dreamproject;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JFrame
{
		
	static Dimension tk;
	JLabel title,img1,img2,img3,img4,text;
	JPanel mp1,mp2;

		Home()
		{
			tk=Toolkit.getDefaultToolkit().getScreenSize();

			setTitle("Data Crypt");
			setSize(tk);		
			setLayout(null);
			
							
			mp1=new JPanel();
			mp1.setBounds(0,0,tk.width,100);   //my width=1366 height=768
			mp1.setBackground(new Color(70,130,180));
			mp1.setLayout(new FlowLayout());
			title=new JLabel();		
			Font f1=new Font("Algerian",Font.PLAIN,75);
			title.setFont(f1);
			title.setForeground(new Color(255,255,255));
			title.setText("J-Crypt");

			mp1.add(title);
			add(mp1);

			
			mp2= new JPanel();
			mp2.setBounds(0,101,1366,668);
			mp2.setLayout(null);
			mp2.setBackground(new Color(255,255,255));
			img1 = new JLabel();
			img1.setBounds(0,0,tk.width,80);
			Font f2=new Font("Gisha",Font.BOLD,35);
			img1.setFont(f2);
			img1.setForeground(new Color(255,255,255));
			img1.setText("                                             Choose Mode Of Input Data......!");
			img1.setBackground(new Color(70,130,180));
			img1.setOpaque(true);
				
			img2 = new JLabel(new ImageIcon("Res/text.png"));
			img2.setBounds(270,100,300,300);
			img3 = new JLabel(new ImageIcon("Res/easy.png"));
			img3.setBounds(770,100,300,300);
			img4 = new JLabel(new ImageIcon("Res/line.png"));
			img4.setBounds(670,90,20,400);
			
			
			
			text = new JLabel("         Choose Text File               Manually Enter...");
			
			text.setBackground(new Color(70,130,180));
			text.setOpaque(true);
			text.setForeground(new Color(255,255,255));
			text.setFont(new Font("Elephant",Font.PLAIN,55));
			text.setBounds(0,500,tk.width,100);
		
			
			mp2.add(img1);
		
			mp2.add(img2);
			mp2.add(img3);
			mp2.add(img4);
			mp2.add(text);
			add(mp2);
			
			img3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me)
			{
				new Text();
			}
			});
			
			img2.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent me){
					new Fileip();
				}
			});
			
			
			
			setVisible(true);	
			
			
			
			//close Window
			addWindowListener(new WindowAdapter() {	
				public void windowClosing(WindowEvent e) {
				System.exit(0);
				}
			});
		}
}
