import java.awt.EventQueue;
import java.util.Formatter;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.SystemColor;

public class decomp {

	private JFrame frmDecompression;

	 Vector<data> v =new Vector<data>();
	 Vector<String> d =new Vector<String>();
	 
	
	private JTextField textField_1;
	private JTextField textField;
	private JButton btnNewButton;
	private JTextArea textArea;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JScrollPane scrollPane;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					decomp window = new decomp();
					window.frmDecompression.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public decomp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDecompression = new JFrame();
		frmDecompression.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmDecompression.setTitle("Decompression");
		frmDecompression.setBounds(100, 100, 553, 350);
		frmDecompression.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Enter your Position :");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		
		JLabel lblEnterYourNext = new JLabel("Enter your Next :");
		lblEnterYourNext.setFont(new Font("Arial", Font.BOLD, 13));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btnNewButton = new JButton("ADD");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				data x=new data();
				
				x.position=Integer.parseInt(textField.getText());
				x.next=textField_1.getText();
				
				v.add(x);
				textArea.append("<"+x.position+" , "+x.next+">"+" ");
				textField.setText("");
				textField_1.setText("");
				
			}
			
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 10));
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.remove(v.size()-1);
				
				String t="";
				for(int i=0;i<v.size();i++)
				{
					t+="<"+v.get(i).position+" , "+v.get(i).next+">"+" ";
				}
			
				textArea.setText(t);
				d.clear();
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 10));
		
		btnNewButton_2 = new JButton("Close");
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDecompression.setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 10));
		
		btnNewButton_3 = new JButton("Decompression");
		btnNewButton_3.setBackground(SystemColor.activeCaption);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.add(null);
				
				String data="";
				decompression( v ,  d , data);
				
				
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 10));
		
		btnNewButton_4 = new JButton("Clean");
		btnNewButton_4.setBackground(SystemColor.activeCaption);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("");
				v.clear();
				d.clear();
			}
		});
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 10));
		
		scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frmDecompression.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblEnterYourNext))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField_1, 0, 0, Short.MAX_VALUE)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton_1))
								.addComponent(btnNewButton_2))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEnterYourNext))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton)
								.addComponent(btnNewButton_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_4)
							.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
							.addComponent(btnNewButton_2)
							.addContainerGap())))
		);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		frmDecompression.getContentPane().setLayout(groupLayout);
	}

	
	public void open()
	{
		decomp window = new decomp();
		window.frmDecompression.setVisible(true);
	}
	
	
	public void decompression(Vector<data> v , Vector<String> d , String data)
	{
		String s=new String();
		Formatter x=null;
		try {
			x = new Formatter("De-compressionData.txt");
		} catch (FileNotFoundException e) {
			textArea.append("File cannot open !!!\n");
		}
		
		textArea.append("\n");
		textArea.append("******************Data******************\n");
		s="\n";
		s+="******************Data******************\n";
		for(int i=0;i<v.size();i++)
        {
        	String temp="";
        	int a=0;
        	
        	a=v.get(i).position;
        	temp=d.get(a);
        	
            if(temp == null)
            {
            	temp = v.get(i).next;  
            	
            }
            else
            {
                temp+=v.get(i).next;
            }
        	
        	if(!d.contains(temp))
        	{
        		d.add(temp);
        		data+=temp;
          	}
        	else if(i==v.size()-1 && a==0)
        	{
        		temp=v.get(i).next;
        		data+=temp;
        	}
        	
        	        	
        }
		
		
		textArea.append("==>> "+data);
		s+="==>>"+data+"\n";
		textArea.append("\n");
		textArea.append("***************Dictionary****************\n");
		s+="***************Dictionary****************\n";
		String t="";
		for(int i=0;i<d.size();i++)
		{
			t+=i+" | ";
			t+=d.get(i)+"\n";
		}
		
		textArea.append(t);
		s+=t;
		x.format("%s", s);
		x.close();
		
	}
	
	
}
