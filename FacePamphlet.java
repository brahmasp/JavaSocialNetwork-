

import acm.graphics.GImage;

/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import acm.program.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class FacePamphlet extends Program implements FacePamphletConstants {

	public void init() {
		
		setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
		name=new JLabel("Name: ");
		nameField=new JTextField(TEXT_FIELD_SIZE);
		addButton=new JButton("Add");
		deleteButton=new JButton("Delete");
		lookupButton=new JButton("Look up");
		
		add(name,NORTH);
		add(nameField,NORTH);
		add(addButton,NORTH);
		add(deleteButton,NORTH);
		add(lookupButton,NORTH);
		
		statusField=new JTextField(TEXT_FIELD_SIZE);
		changeStatusButton=new JButton("Change Status");
		
		picField=new JTextField(TEXT_FIELD_SIZE);
		changePicButton=new JButton("Change Picture");
		
		addFriendField=new JTextField(TEXT_FIELD_SIZE);
		addFriendButton=new JButton("Add Friend");
		
		newUserRecord=new FacePamphletDatabase();
		canvas=new FacePamphletCanvas();
		
		
		add(statusField,WEST);
		add(changeStatusButton,WEST);
		add(picField,WEST);
		add(changePicButton,WEST);
		add(addFriendField,WEST);
		add(addFriendButton,WEST);
		add(canvas);
		
		addActionListeners();
		//have not created action listener for if we press enter
		
		
		
    }
   
    public void actionPerformed(ActionEvent e) {
		
    	if(e.getSource()==addButton){
    		newUserRecord.assignName(nameField.getText());
    		canvas.showMessage(nameField.getText()+" "+"added");
    		
    	}
    	else if(e.getSource()==deleteButton){
    		newUserRecord.deleteProfile(nameField.getText());
    		canvas.showMessage(nameField.getText()+" "+"deleted");
    	}
    	else if(e.getSource()==lookupButton){
    		if(newUserRecord.containsProfile(nameField.getText())){
    			canvas.showMessage(nameField.getText()+" "+"found");
    			canvas.displayProfile(newUserRecord.getProfile(nameField.getText()));
    		}
    		
    		
    	}
    	else if(e.getSource()==changeStatusButton){
    		if(newUserRecord.containsProfile(nameField.getText())){
    			newUserRecord.getProfile(nameField.getText()).setStatus(statusField.getText());
        		println(newUserRecord.getProfile(nameField.getText()).getStatus());
        		canvas.showMessage(nameField.getText()+" is"+" "+newUserRecord.getProfile(nameField.getText()).getStatus());
    		}
    	}
    	else if(e.getSource()==changePicButton){
    		if(newUserRecord.containsProfile(nameField.getText())){
    			try {
    		          image = new GImage(picField.getText());
    		        } catch (Exception ex) {
    		          
    		        }
    			
    			newUserRecord.getProfile(nameField.getText()).setImage(image);
    			canvas.showMessage(nameField.getText()+" set profile picture");
    		}
    		
    	}
    	else if(e.getSource()==addFriendButton){
    		if(newUserRecord.containsProfile(nameField.getText()) && newUserRecord.containsProfile(addFriendField.getText())){
    			
    			newUserRecord.getProfile(nameField.getText()).addFriend(addFriendField.getText());
    			
    				newUserRecord.getProfile(addFriendField.getText()).addFriend(nameField.getText());
    				
    			
    			canvas.showMessage(nameField.getText()+" added "+addFriendField.getText()+" as friend");
    		}
    		
    	}
    	
	}
    
    /*instance variables*/
    private JLabel name;
    private JTextField nameField,statusField,picField,addFriendField;
    private JButton addButton,deleteButton,lookupButton,changeStatusButton,changePicButton,addFriendButton;
    private FacePamphletCanvas canvas;
    private FacePamphletDatabase newUserRecord;
    private GImage image=null;

}
