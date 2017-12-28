package dreamproject;


import java.awt.BorderLayout;

import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;



public class Text extends JFrame implements ActionListener{
	
	static Dimension tk;
	JPanel mp1;
	JPasswordField key;
	JTextArea pText,cText;
	
	JMenuBar mb;
	JMenu file,edit;
	JButton encrypt,decrypt;
	JMenuItem op,sa,cl,cp,pa,ct;
	JLabel iplbl,oplbl,keylbl,piche;
	PolyAlgo pAlgo;
	public Text() {
		tk=Toolkit.getDefaultToolkit().getScreenSize();

		
		setTitle("J-Crypt");
		setSize(tk);
		setLayout(null);
		
		mb = new JMenuBar();
		add(mb);
		mb.setBounds(0,0,tk.width,25);
		file = new JMenu("File");
		edit = new JMenu("Edit");
		mb.add(file);
		mb.add(edit);

		op = new JMenuItem("Open");
		sa = new JMenuItem("Save");
		cl = new JMenuItem("Exit");
		file.add(op);
		file.add(sa);
		file.add(cl);

		ct = new JMenuItem("Cut");
		cp = new JMenuItem("Copy");
		pa = new JMenuItem("Paste");
		edit.add(cp);
		edit.add(ct);
		edit.add(pa);
		
		op.addActionListener(this);
		 sa.addActionListener(this);
		cl.addActionListener(this);
		ct.addActionListener(this);
		cp.addActionListener(this);
		pa.addActionListener(this);
		
		
		
		
		
		
	
		mp1 = new JPanel();
		mp1.setSize(tk);       //my width=1366 height=768
		mp1.setLayout(null);
		mp1.setBackground(new Color(70,130,180));	
		
		key = new JPasswordField(40);
		
		
		pText = new JTextArea(10,84);
		pText.setFont(new Font("Arial",Font.BOLD,15));
		JScrollPane sP=new JScrollPane(pText);
		String str = pText.getText().toString();
		
		
		
		cText = new JTextArea(10,84);
		cText.setFont(new Font("Arial",Font.BOLD,15));
		cText.setText(str);
		cText.setEditable(false);
		JScrollPane cT=new JScrollPane(cText);
		
		encrypt = new JButton("Encrypt");
		decrypt = new JButton("Decrypt");
		
		iplbl = new JLabel("Input Text");
		iplbl.setFont(new Font("Serif",Font.BOLD,31));
		iplbl.setForeground(Color.WHITE);
		
		oplbl = new JLabel("Output Text");
		oplbl.setForeground(Color.WHITE);
		oplbl.setFont(new Font("Serif",Font.BOLD,31));
		
		keylbl = new JLabel("Enter Key");
		keylbl.setForeground(Color.WHITE);
		keylbl.setFont(new Font("Serif",Font.BOLD,25));
		
		keylbl.setBounds(320,60,220,30);
		key.setBounds(450,60,420,30);
		iplbl.setBounds(620,100,200,38);
		sP.setBounds(170,150,1020,210);
		encrypt.setBounds(550,370,100,30);
		decrypt.setBounds(700,370,100,30);
		oplbl.setBounds(620,420,200,38);
		cT.setBounds(170,470,1020,210);
		
		mp1.add(keylbl);
		mp1.add(key);
		mp1.add(iplbl);
		mp1.add(sP);
		mp1.add(encrypt);
		mp1.add(decrypt);
		mp1.add(oplbl);
	
		mp1.add(cT);
		
		
		encrypt.addActionListener(this);
		decrypt.addActionListener(this);
		add(mp1);
		
		setVisible(true);

	
	}
	
	public void actionPerformed(ActionEvent ae){
		
			if(op.isArmed()) ;
			if(sa.isArmed()) ;
			if(cl.isArmed()) setVisible(false);
			if(ct.isArmed()) System.out.println("Cut IS Clicked");
			if(cp.isArmed()) System.out.println("Copy is selected");
			if(pa.isArmed()) System.out.println("Paste Is Selected");
			if(ae.getSource()==encrypt) encryptData();
			if(ae.getSource()==decrypt)	decryptData();
	}
	
	
	public void encryptData()
	{
		String iptext = pText.getText();
		String KEY =key.getText();
		cText.setText("");
		if(iptext!=null && KEY !=null)
		{
			pAlgo = new PolyAlgo();
			String result=pAlgo.encrypt(iptext, KEY);
			
			cText.cut();
			cText.append(result);
		
		}
		
	}
	
	public void decryptData()
	{
		
		String iptext = pText.getText();
		String KEY =key.getText();
		cText.setText("");
		if(iptext!=null && KEY !=null)
		{
			pAlgo = new PolyAlgo();
			String result=pAlgo.decrypt(iptext,KEY);
			cText.enable();
			cText.append(result);
		}
	}

	
}
