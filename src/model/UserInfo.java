package model;

import java.io.*;
import java.net.*;

public class UserInfo {
	Socket client = null;//�ͻ����׽���
	boolean gameStatus = false;//�ͻ���ǰ��Ϸ״̬��true��ʾ������Ϸ
	Socket opponent = null;//���ֶ��׽��֣�ֻ�е�gameStatusΪtrue��Ч
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
