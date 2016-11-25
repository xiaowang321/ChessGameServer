package protocol;

import java.io.IOException;

import model.*;

public class ProtocolHandler {
	
	UserList userlist = null;
	OpCode op = new OpCode();
	
	public ProtocolHandler(UserList userlist){
		this.userlist = userlist;
	}
	
	@SuppressWarnings("null")
	public void handleBattleRequest(UserInfo user){
		UserInfo client = null,opponent;
		client = userlist.FindUser(user.GetClient());
		if((client != null) || (client.GetGameStatus() != true)){
			for(int i = 0;i < userlist.GetUserCount();i++){
				opponent = userlist.FindUser(i);
			    if(opponent.GetGameStatus() != true){
				    //记录对手信息
			    	userlist.FindUser(client.GetClient()).SetGameStatus(true);
				    userlist.FindUser(client.GetClient()).SetOpponent(opponent.GetClient());
				    userlist.FindUser(opponent.GetClient()).SetGameStatus(true);
				    userlist.FindUser(opponent.GetClient()).SetOpponent(client.GetClient());
				    try {
					    client.GetOutput().writeObject(op.BattleResponse);
					    client.GetOutput().writeObject(true);
					    opponent.GetOutput().writeObject(op.BattleResponse);
					    opponent.GetOutput().writeObject(true);
						int j = (int)(Math.random()*2);
						if(j == 0){
							client.GetOutput().writeObject(true);
							opponent.GetOutput().writeObject(false);
						}
						else{
							client.GetOutput().writeObject(false);
							opponent.GetOutput().writeObject(true);
						}
						} catch (Exception e) {
							e.printStackTrace();
					    }
				    return;
				    }
			    }
		}
		//返回请求失败
		try {
			client.GetOutput().writeObject(op.BattleResponse);
			client.GetOutput().writeObject(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
}
