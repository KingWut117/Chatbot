package chatbot.controller;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;

import javax.swing.JOptionPane;

public class ChatbotAppController
{

	private ChatbotView appView;
	private Chatbot mySillyChatbot;
	
	public ChatbotAppController()
	{
		appView = new ChatbotView(this);
	}
	
	public void start()
	{
		String result = appView.showChatbot("Nerd");
		
		
		
		if (mySillyChatbot.quitChecker(result))
		{
			quit();
		}
	}
	
	private void quit()
	{
		JOptionPane.showMessageDialog(null,  "Why did you kill me?");
		System.exit(0);
	}
	
}
