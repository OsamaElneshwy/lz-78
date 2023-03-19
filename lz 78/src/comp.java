import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;




import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;


public class comp {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private JButton btnNewButton_2;
	
	Vector<String> v = new Vector<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comp window = new comp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	/**
	 * Create the application.
	 */
	public comp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Compression");
		frame.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		JButton btnNewButton = new JButton("Compression");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s=textField.getText();
				
				v.add(null);
				
				
				
				compression(s, v);
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Your String :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton_1 = new JButton("Clean");
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 10));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textField.setText("");
				v.clear();
			}
		});
		
		btnNewButton_2 = new JButton("Close");
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 10));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
						.addComponent(textField, 281, 281, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
							.addComponent(btnNewButton_2))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 620, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public void open()
	{
		comp window = new comp();
		window.frame.setVisible(true);
	}
	
	
	
	public void compression(String data,Vector<String> v)
	{
		String s=new String();
		Formatter x=null;
		try {
			x = new Formatter("CompressionData.txt");
		} catch (FileNotFoundException e) {
			textArea.append("File cannot open !!!\n");
		} 
		
		s="**********************Tags*****************************\n";
		this.textArea.append("**********************Tags*****************************\n");
		String temp="";
		for(int i =0;i<data.length();i++)
		{
			int q=0;
			char c=data.charAt(i);
			temp+=String.valueOf(c);
			q=v.lastIndexOf(temp);
			if (i == data.length()-1)
            {
				this.textArea.append("<"+0+","+temp+">");
				s+="<"+0+","+temp+">";
				if(i==0)
	            {
					v.add(temp);
	            }
            }
			else if(!v.contains(temp))
			{
				v.add(temp);
                                
				if(q==-1)
				{
					q=0;
					this.textArea.append("<"+q+","+temp+">"+" ");
					s+="<"+q+","+temp+">"+" ";
                    temp="";
				}	
			}
            else
            {                          
                while(v.contains(temp))
                {              
                	i++;                               
                    char o = data.charAt(i);
                    q=v.lastIndexOf(temp);
                    temp+=String.valueOf(o);                                                   
                    if(!v.contains(temp))
                    {
                    	v.add(temp);
                    	char Next = data.charAt(i);
                    	this.textArea.append("<"+q+","+Next+">"+" ");
                    	s+="<"+q+","+Next+">"+" ";
                        temp="";
                        break;
                    }
                    else if(i==data.length()-1)
                    {
                    	if(v.contains(temp))
                    	{
                    		q=v.lastIndexOf(temp);
                        	this.textArea.append("<"+q+","+"null"+">"+" ");
                        	s+="<"+q+","+"null"+">"+" ";
                            temp="";
                            break;
                    	}
                    }
                }
            }
		}	
		this.textArea.append("\n");
		s+="\n";
		this.textArea.append("*********************Dictionary************************\n");
		s+="*********************Dictionary************************\n";
		String t="";
		for(int i=0;i<v.size();i++)
		{
			t+=i+" | ";
			t+=v.get(i)+"\n";
		}
		s+=t;
		this.textArea.append(t);
		x.format("%s", s);
		x.close();
	}
}
