

/*
 * File: FacePamphletCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the social
 * network are displayed.  NOTE: This class does NOT need to update the
 * display when the window is resized.
 */


import acm.graphics.*;
import java.awt.*;
import java.util.*;

import javax.swing.JLabel;

public class FacePamphletCanvas extends GCanvas implements FacePamphletConstants {
	
	
	/** 
	 * This method displays a message string near the bottom of the 
	 * canvas.  Every time this method is called, the previously 
	 * displayed message (if any) is replaced by the new message text 
	 * passed in.
	 */
	public void showMessage(String msg) {
		removeAll();
		
		appMsg=new GLabel(msg);
		appMsg.setFont(MESSAGE_FONT);
		add(appMsg,getWidth()/2-appMsg.getWidth()/2,getHeight()-BOTTOM_MESSAGE_MARGIN);
	}
	
	
	/** 
	 * This method displays the given profile on the canvas.  The 
	 * canvas is first cleared of all existing items (including 
	 * messages displayed near the bottom of the screen) and then the 
	 * given profile is displayed.  The profile display includes the 
	 * name of the user from the profile, the corresponding image 
	 * (or an indication that an image does not exist), the status of
	 * the user, and a list of the user's friends in the social network.
	 */
	public void displayProfile(FacePamphletProfile profile) {
		
		
		name=new GLabel(profile.getName());
		name.setColor(Color.BLUE);
		name.setFont(PROFILE_NAME_FONT);
		add(name,LEFT_MARGIN,TOP_MARGIN);
		
		if(profile.getImage()==null){
			emptyImage=new GRect(LEFT_MARGIN,IMAGE_MARGIN,IMAGE_WIDTH,IMAGE_HEIGHT);
			emptyImageText=new GLabel("No Image");
			add(emptyImageText,LEFT_MARGIN+40,IMAGE_MARGIN+50);
			add(emptyImage);
		}
		else{
			img=profile.getImage();
			//scaling not workin!
			add(img,LEFT_MARGIN,IMAGE_MARGIN);
			
		}
		
		stat=new GLabel(profile.getStatus());
		stat.setFont(PROFILE_STATUS_FONT);
		add(stat,LEFT_MARGIN,STATUS_MARGIN+IMAGE_HEIGHT);
		
		
		
		friendsTag=new GLabel("Friends: ");
		friendsTag.setFont(PROFILE_FRIEND_FONT);
		add(friendsTag,getWidth()/2-friendsTag.getHeight()/2,IMAGE_HEIGHT);
		double dyFriends=IMAGE_HEIGHT;
		
		for(int i=0;i<profile.friendList.size();i++){
			friends=new GLabel(profile.friendList.get(i));
			add(friends,getWidth()/2-friendsTag.getHeight()/2,dyFriends+15);
			dyFriends+=15;
			
		}
	}
	
	/*instance variables*/
	private GLabel appMsg;
	private GLabel name;
	private GRect emptyImage;
	private GLabel emptyImageText;
	private GImage img;
	private GLabel stat;
	private GLabel friendsTag;
	private GLabel friends;
	
}
