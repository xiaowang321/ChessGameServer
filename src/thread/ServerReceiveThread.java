package thread;

import model.*;
import protocol.*;


public class ServerReceiveThread extends Thread{
	UserInfo client = null;
	UserList userlist = null;
	public boolean isStop;
	OpCode op = null;
	ProtocolHandler handler = null;
	
	public ServerReceiveThread(UserInfo client ,UserList userlist){
		this.client = client;
		this.userlist = userlist;
		isStop = false;
		op = new OpCode();
		handler = new ProtocolHandler(userlist);
	}
	
	public void run(){
		while(!isStop && !client.GetClient().isClosed()){
			int opcode;
			try{
				opcode = (int) client.GetInput().readObject();
				if(opcode == op.BattleRequest)handler.handleBattleRequest(client);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
