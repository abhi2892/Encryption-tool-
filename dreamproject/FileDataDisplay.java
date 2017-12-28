package dreamproject;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileDataDisplay extends JFrame
{
	JTextArea ta;
	JPanel jp;
	public FileDataDisplay(String str) {
	
		setSize(800,700);
		setLocation(300,30);
		setLayout(new FlowLayout());
		
		jp = new JPanel(new FlowLayout());
		jp.setSize(800,700);
		ta = new JTextArea(50,65);
		ta.setBounds(20,10,780,670);
		ta.setText(str);
		ta.setEditable(false);
		JScrollPane sP=new JScrollPane(ta);
		jp.add(sP);
		add(jp);
		setVisible(true);
		
		
	}

}
