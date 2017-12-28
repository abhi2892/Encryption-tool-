package dreamproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.sun.xml.internal.ws.api.server.Container;

public class Fileip extends JFrame implements ActionListener{

	JMenuBar mb;
	JMenu file,edit;
	File f,s;
	JMenuItem op,cl,cp,pa,sa,ct;
	JLabel srclbl,dstlbl,keylbl,piche;
	JTextField src,dst;
	JPasswordField KEY;
	JButton browse,save,encrypt,decrypt;
	PolyAlgo algo;
	
	String str="";
	String str1="";
	String encoded="";

	public Fileip() {
			
		
		setLayout(null);
		setTitle("J-Crypt");
		mb=new JMenuBar();
		algo = new PolyAlgo();
		setLocation(300,100);
		mb.setBounds(0,0,1366,25);
		add(mb);
		
		
	
		
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
		
		
		cp = new JMenuItem("Copy");
		pa = new JMenuItem("Paste");
		ct = new JMenuItem("Cut");
		edit.add(cp);
		edit.add(pa);
		edit.add(ct);
		
		setSize(800,600);
		setVisible(true);
		
		op.addActionListener(this);
		sa.addActionListener(this);
		cl.addActionListener(this);
		cp.addActionListener(this);
		pa.addActionListener(this);
		ct.addActionListener(this);
		
	
		
		piche = new JLabel(new ImageIcon("Res/piche.jpg"));

		piche.setSize(1200,768);
		keylbl = new JLabel("Enter Key:");
		
		KEY = new JPasswordField(60);
		srclbl = new JLabel("Source:");
		
		src = new JTextField(100);
		dstlbl = new JLabel("Destination:");
		
		dst = new JTextField(100);
		
		
		keylbl.setFont(new Font("sans",Font.BOLD,20));
		keylbl.setBounds(10,150,110,30);
		KEY.setBounds(200,155,250,20);
		srclbl.setBounds(10,195,90,30);
		srclbl.setFont(new Font("sans",Font.BOLD,20));
		src.setBounds(200,200,400,20);
		dstlbl.setBounds(10,250,210,30);
		dstlbl.setFont(new Font("sans",Font.BOLD,20));
		dst.setBounds(200,256,400,20);
		
		src.setEditable(false);
		dst.setEditable(false);
	
		browse = new JButton("Browse");
		browse.setBounds(640,195,100,30);
		
		
		save = new JButton("Save");
		save.setBounds(640,250,100,30);
		

		encrypt = new JButton("Encrypt");
		encrypt.setBounds(200,350,100,30);

		decrypt = new JButton("Decrypt");
		decrypt.setBounds(350,350,100,30);
		
		save.setEnabled(false);
		encrypt.setEnabled(false);
		decrypt.setEnabled(false);
		
		
		piche.add(KEY);
		piche.add(keylbl);
		piche.add(srclbl);
		piche.add(src);
		piche.add(dstlbl);
		piche.add(dst);
		piche.add(browse);
		piche.add(save);
		piche.add(encrypt);
		piche.add(decrypt);
		add(piche);
		browse.addActionListener(this);
		save.addActionListener(this);
		encrypt.addActionListener(this);
		decrypt.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0) {

		if(op.isArmed()) openFile();
		if(sa.isArmed() && str1!="") 
		{	
			saveFile();
		}
		if(cl.isArmed()) setVisible(false);
		if(cp.isArmed()) System.out.println("Copy Is Clicked");
		if(pa.isArmed()) System.out.println("Paste Is Clicked");
		if(ct.isArmed()) System.out.println("Cut Is Clicked");
		if(arg0.getSource()==browse)	openFile();
		if(arg0.getSource()==save)	saveFile();
		if(arg0.getSource()==encrypt)encryptText();
		if(arg0.getSource()==decrypt)decryptText();	
	}
	
	
	public void openFile()
	{
		

		JFileChooser fc=new JFileChooser();
		int i= fc.showOpenDialog(this);
			
		if(i== JFileChooser.APPROVE_OPTION)
		 f = fc.getSelectedFile();
		
		String fname = f.getPath();
		try{
			BufferedReader br = new BufferedReader(new FileReader(fname));
			
			

			while((str = br.readLine())!= null)
			{
				
				str1+=str +"\n";
				
			}
			
			br.close();
			src.setText(fname);
			
			encrypt.setEnabled(true);
			decrypt.setEnabled(true);
			
		}
		catch(Exception e){
		}

	}

	
	public void encryptText()
	{
	
		String key ="";
		key=KEY.getText();
		if(key=="")
		{
			JOptionPane.showConfirmDialog(this,"Please Enter The Key","J-Crypt",JOptionPane.YES_NO_OPTION);
		}
		else if(str1 =="")
		{
			JOptionPane.showConfirmDialog(this,"Please Select The Valid File First","J-Crypt",JOptionPane.YES_NO_OPTION);
		}
		if(key!="" && str1 !="")
		{
			encoded=algo.encrypt(str1,key);
			new FileDataDisplay(encoded);
			save.setEnabled(true);
			
		}
		
	}
	
	public void decryptText()
	{
	
		String key ="";
		key=KEY.getText();
		
		
		if(key=="" ||key==null)
		{
			JOptionPane.showConfirmDialog(this,"Please Enter The Key","J-Crypt",JOptionPane.YES_NO_OPTION);
		}
		else if(str1 =="")
		{
			JOptionPane.showConfirmDialog(this,"Please Select The Valid File First","J-Crypt",JOptionPane.YES_NO_OPTION);
		}
		
		else
		{
			
			encoded=algo.decrypt(str1,key);
			new FileDataDisplay(encoded);
			save.setEnabled(true);
		}
		
		
		
		
	}
	
	
	public void saveFile()
	{	
		
		if(encoded=="")
			JOptionPane.showConfirmDialog(this,"Please Encrypt/Decrypt file first","J-Crypt",JOptionPane.YES_NO_OPTION);
		else
		{
				File sb;
				JFileChooser jf= new JFileChooser();
				jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int r = jf.showSaveDialog(this);
				if(r == jf.APPROVE_OPTION)
				{
					sb = jf.getSelectedFile();
					dst.setText(sb.toString());
				}
				else 
				{
					sb = null;
				}
				
				try{
					FileWriter fw = new FileWriter(new File(sb.toString()));
					 fw.write(encoded);
					 fw.close();
					 setVisible(false);
				}catch (Exception e)
				{
					
				}
				
		}					
	
	}
	

}

