package chatbot.controller;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;

import javax.swing.JOptionPane;

/**
 * controls the function of the App
 * @author bbar7754
 *
 */
public class ChatbotAppController
{
	private ChatbotView appView;
	private Chatbot mySillyChatbot;
	
	/**
	 * Builds the controller. (constructor)
	 */
	public ChatbotAppController()
	{
		appView = new ChatbotView(this);
		mySillyChatbot = new Chatbot("Dorf");
	}
	
	/**
	 * this method is called by the ChatbotRunner when the program starts
	 */
	public void start()
	{
		String result = appView.showChatbot("Nerd");
		
		while(!mySillyChatbot.quitChecker(result))
		{
			result = appView.showChatbot(result);
		}
		
		if (mySillyChatbot.quitChecker(result))
		{
			quit();
		}
	}
	
	/**
	 * this method, when called, ends the program
	 */
	private void quit()
	{
		JOptionPane.showMessageDialog(null,  "Why did you kill me?");
		System.exit(0);
	}
	
}
