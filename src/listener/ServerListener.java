package listener;

import java.net.*;
import thread.*;
import model.*;

public class ServerListener {
	ServerSocket server = null;
	public final int port = 8080;
	ServerListenThread listenThread;
	UserList userlist = null;
	
	public void StartService(){
			try {
				server = new ServerSocket(port,15);
				System.out.println("game server starts successfully!\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
			userlist = new UserList();
			
	}
}
