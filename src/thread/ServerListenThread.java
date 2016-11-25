package thread;

import java.net.ServerSocket;
import model.*;

public class ServerListenThread extends Thread{
	ServerSocket server = null;
	UserList userlist = null;
	UserInfo client = null;
    ServerReceiveThread recvThread;
	public boolean isStop;
	
	public ServerListenThread(ServerSocket server,UserList userlist){
		this.server = server;
		this.userlist = userlist;
		isStop = false;
	}
	
	public void run(){
		while(!isStop && !server.isClosed()){
			try{
				client = new UserInfo();
				client.SetClient(server.accept());
				
				userlist.addUser(client);
				
				System.out.println("client online£¬the port is "+client.GetClient().getPort()+"\n");
				System.out.println("user count is "+userlist.GetUserCount()+"\n");
				
				recvThread = new ServerReceiveThread(client,userlist);
				recvThread.start();
			}
			catch(Exception e){
			}
		}
	}
}
