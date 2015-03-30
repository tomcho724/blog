package blog;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class BlogGUI implements ActionListener, DocumentListener{
	
	private JFrame mainFrame;
	private JLabel TextAreaLabel;
	private JTextArea postTextArea;
	private JTextField postContent;
	private JButton refresh;
	private JButton post;
	
	private int charLimit = 140;

	public BlogGUI(){};
	
	public void setWindow(){
		mainFrame = new JFrame("Mirco Blog Demo");		
		mainFrame.setSize(500, 500);
		mainFrame.setLayout(new GridLayout(2,1));
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		
		TextAreaLabel = new JLabel(" You can still input " + charLimit + " Charactors");
		
		postTextArea = new JTextArea();
		postTextArea.setEditable(true);
		postTextArea.setText("What's on your mind?");
		postTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
		postTextArea.getDocument().addDocumentListener(this);
		
		topPanel.add(TextAreaLabel, BorderLayout.PAGE_START);	
		topPanel.add(postTextArea, BorderLayout.CENTER);
		
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new GridLayout(1,2));
		
		refresh = new JButton("refresh");
		//refresh.setBackground(Color.GREEN);
		refresh.addActionListener(this);
		subPanel.add(refresh);		
		
		post = new JButton("post");
		//post.setBackground(Color.YELLOW);
		post.addActionListener(this);
		subPanel.add(post);
		
		topPanel.add(subPanel, BorderLayout.PAGE_END);	
		topPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		mainFrame.add(topPanel);
		
		postContent = new JTextField();
		postContent.setEditable(false);
		postContent.setHorizontalAlignment(JTextField.CENTER);
		//postContent.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		mainFrame.add(postContent);	
		
		mainFrame.getRootPane().setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public static void main(String[] args){
		BlogGUI blogGUI = new BlogGUI();
		blogGUI.setWindow();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == post){
			postContent.setText("You clicked POST!");			
		}
		
		if(e.getSource() == refresh){
			postContent.setText("You clicked REFRESH!");			}
		}

	public void changedUpdate(DocumentEvent e) {
		
	}

	public void insertUpdate(DocumentEvent e) {
		TextAreaLabel.setText("You can still input " + (charLimit - e.getDocument().getLength()) + " Charactors");
	}

	public void removeUpdate(DocumentEvent e) {
		TextAreaLabel.setText("You can still input " + (charLimit + e.getDocument().getLength()) + " Charactors");
	}
}
