package blog;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import base.*;

import javax.swing.*;

public class BlogGUI{
	
	private JFrame mainFrame;
	private JLabel TextAreaLabel;
	private JTextArea postTextArea, postContent;
	private JButton refresh;
	private JButton post;
	private Blog myBlog = new Blog(new User(1, "COMP3021", "COMP3021@cse.ust.hk"));
	
	private int charLimit = 140;
	private String savefilepath="C:/"+myBlog.getUser().getUserName()+".blog";

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
		postTextArea.setLineWrap(true);
		postTextArea.setBackground(Color.yellow);
		postTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
		postTextArea.addKeyListener(new lengthListener());
		
		topPanel.add(TextAreaLabel, BorderLayout.PAGE_START);	
		topPanel.add(postTextArea, BorderLayout.CENTER);
		
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new GridLayout(1,2));
		
		refresh = new JButton("refresh");
		refresh.addActionListener(new refreshListener());
		subPanel.add(refresh);		
		
		post = new JButton("post");
		post.addActionListener(new postListener());
		subPanel.add(post);
		
		topPanel.add(subPanel, BorderLayout.PAGE_END);	
		topPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		mainFrame.add(topPanel);
		
		postContent = new JTextArea();
		postContent.setEditable(false);	
		JScrollPane postContentScroll = new JScrollPane(postContent);		
		
		myBlog.load(savefilepath);
		postContent.setText(myBlog.toString());
		
		mainFrame.add(postContentScroll);	
		
		mainFrame.getRootPane().setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class postListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String content = postTextArea.getText();
			if (content.length() <= 0){
				JOptionPane.showMessageDialog(mainFrame,"Your post content is empty!", "Input Error",JOptionPane.ERROR_MESSAGE);
			}
			else if (content.length() > 140){
				JOptionPane.showMessageDialog(mainFrame,"Your post length has exceed 140!", "Input Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
			Date date = new Date();
			Post post = new Post(date, content);
			myBlog.post(post);
			myBlog.save(savefilepath);
			postTextArea.setText("");
			TextAreaLabel.setText(" You can still input " + charLimit + " Charactors");
			postContent.append("A new Post:" + "/n" + post.toString());
			}
		}
	}
	
	class refreshListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			myBlog.load(savefilepath);
			postContent.setText(myBlog.toString());
		}
	}
	
	class lengthListener implements KeyListener{

		public void keyPressed(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {

			if(postTextArea.getText().length() > charLimit){
				TextAreaLabel.setText("Your post length has exceed 140!");
			}
			else{
				TextAreaLabel.setText("You can still input " + (charLimit - postTextArea.getText().length()) + " Charactors");
			}
		}
		public void keyTyped(KeyEvent e) {}
		
	}
			
	public static void main(String[] args){
		BlogGUI blogGUI = new BlogGUI();
		blogGUI.setWindow();
	}	
}
