package chatbot.controller;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;
import javax.swing.JOptionPane;

/**
 * Runs the Chatbot Project. Owns the model and associated views.
 * @author Braeden Barwick
 * @version 1.2 10/2/14 - cleaned the quit method.
 */
public class ChatbotAppController
{
	private ChatbotView appView;
	private Chatbot mySillyChatbot;
	private String startMessage;
	private String quitMessage;
	
	
	/**
	 * Builds the controller. (constructor)
	 */
	public ChatbotAppController()
	{
		appView = new ChatbotView(this);
		mySillyChatbot = new Chatbot("Dorf");
		startMessage = "Welcome to the " + mySillyChatbot.getName() + " chatbot. What is your name?";
		quitMessage = "I... Die...";
	}
	
	public Chatbot getMySillyChatbot()
	{
		return mySillyChatbot;
	}
	
	/**
	 * this method is called by the ChatbotRunner when the program starts
	 */
	public void start()
	{
		String result = appView.showChatbotDialog(startMessage);
		
		while(!mySillyChatbot.quitChecker(result))
		{
			result = appView.showChatbotDialog(result);
		}
		
		quit();
		
	}
	
	/**
	 * this method, when called, ends the program
	 */
	private void quit()
	{
		appView.showChatbotMessage(quitMessage);
		System.exit(0);
	}
	
}
