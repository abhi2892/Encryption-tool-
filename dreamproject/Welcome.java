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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Welcome extends JFrame
{
	static Dimension tk;
	JPanel mp1,mp2;
	JLabel title,backImg,ss,go,text,text1;
		Welcome()
		{
			tk=Toolkit.getDefaultToolkit().getScreenSize();

		
			setLayout(null);	
			setTitle("J Crypt");
			setSize(tk);					//pass object of Dimension
			setBackground(Color.white);
			
			
			
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


			
			
			
			mp2=new JPanel();
			mp2.setBounds(0,101,1366,668);
			mp2.setLayout(null);
			mp2.setBackground(Color.white);
			
			
			ss = new JLabel(new ImageIcon("Res/s2.png"));
			ss.setBounds(300,0,800,600);
			backImg = new JLabel(new ImageIcon("Res/key.png"));
			backImg.setBounds(0,30,600,450);
			go=new JLabel(new ImageIcon("Res/s.png"));
			go.setBounds(950,80,450,400);
			text = new JLabel("                         Secure Your Textual Data");
			
			text.setBackground(new Color(70,130,180));
			text.setOpaque(true);
			text.setForeground(new Color(255,255,255));
			text.setFont(new Font("Elephant",Font.PLAIN,55));
			text.setBounds(0,500,tk.width,100);
			
			text1 = new JLabel("Start Here");
			text1.setForeground(new Color(70,130,180));
			text1.setFont(new Font("Serif",Font.BOLD,35));
			text1.setBounds(1100, 400, 400, 50);
			
			mp2.add(go);
			mp2.add(ss);
			mp2.add(backImg);
			mp2.add(text);
			mp2.add(text1);
			add(mp2);
			
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			go.addMouseListener(new MouseAdapter() {
			
				public void mouseClicked(MouseEvent me)
				{
					setVisible(false);
					new Home();
				}
			});
			

		}
}
