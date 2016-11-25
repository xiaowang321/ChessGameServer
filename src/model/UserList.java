package model;

import java.net.Socket;
import java.util.ArrayList;

public class UserList {
	private ArrayList<UserInfo> userlist = null;
	
	public void addUser(UserInfo user){
		userlist.add(user);
	}
	
	public void deleteUser(UserInfo user){
		userlist.remove(user);
	}
	
	public int GetUserCount(){
		return userlist.size();
	}
	
	public UserInfo FindUser(Socket client){
		UserInfo user = null;
		for(int i = 0;i < userlist.size();i++){
			if(client == userlist.get(i).client)
			{
				user = userlist.get(i);
				break;
			}
		}
		return user;
	}
	
	public UserInfo FindUser(int index){
		UserInfo user = null;
		if((index > userlist.size()) ||(index < 0)){
			return user;
		}
		user = userlist.get(index);
		return user;
	}
}
