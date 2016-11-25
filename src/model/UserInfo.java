package model;

import java.io.*;
import java.net.*;

public class UserInfo {
	Socket client = null;//客户端套接字
	boolean gameStatus = false;//客户当前游戏状态，true表示正在游戏
	Socket opponent = null;//对手端套接字，只有当gameStatus为true有效
	ObjectInputStream input = null;
	ObjectOutputStream output = null;
	
	public Socket GetClient(){
		return client;
	}
	
	public void SetClient(Socket client){
		this.client = client;
	}
	
	public boolean GetGameStatus(){
		return gameStatus;
	}
	
	public void SetGameStatus(boolean gameStatus){
		this.gameStatus = gameStatus;
	}
	
	public Socket GetOpponent(){
		return opponent;
	}
	
	public void SetOpponent(Socket opponent){
		this.opponent = opponent;
	}
	
	public ObjectInputStream GetInput(){
		return input;
	}
	
	public void SetInput(ObjectInputStream input){
		this.input = input;
	}
	
	public ObjectOutputStream GetOutput(){
		return output;
	}
	
	public void SetOutput(ObjectOutputStream output){
		this.output = output;
	}
}
