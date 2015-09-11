
package trial;
/*
 * File: FacePamphletProfile.java
 * ------------------------------
 * This class keeps track of all the information for one profile
 * in the FacePamphlet social network.  Each profile contains a
 * name, an image (which may not always be set), a status (what 
 * the person is currently doing, which may not always be set),
 * and a list of friends.
 */

import acm.graphics.*;
import java.util.*;

public class FacePamphletProfile implements FacePamphletConstants {
	
	
	public FacePamphletProfile(String name) {
		userName=name;
	}

	
	public String getName() {
		
		return userName;
	}


	public GImage getImage() {
		
		return profilePic;
	}


	public void setImage(GImage image) {
		profilePic=image;
	}
	
	
	public String getStatus() {
		
		
		return latestStatus;
		
	}
	

	public void setStatus(String status) {
		latestStatus=status;
	}

	
	public boolean addFriend(String friend) {
		
		if(!friendList.contains(friend)){
			friendList.add(friend);
			return true;
			
		}
		
		return false;
	}

	
	public boolean removeFriend(String friend) {
		
		if(friendList.contains(friend)){
			friendList.remove(friend);
			return true;
			
		}
		return false;
	}

	/** 
	 * This method returns an iterator over the list of friends 
	 * associated with the profile.
	 */ 
	public Iterator<String> getFriends() {
		
		
		
		
		return null;
	}
	
	
	public String toString() {
		
		String friendString="";
		
		for(String x:friendList){
			
			friendString+=x+", ";
		}
		
		
		return getName()+"("+getStatus()+")"+": "+friendString;
	}
	
	private String userName;
	private String latestStatus="";
	private GImage profilePic=null;
	public ArrayList<String> friendList=new ArrayList<String>();
	private Iterator<String> iterator=friendList.iterator();
	
}
