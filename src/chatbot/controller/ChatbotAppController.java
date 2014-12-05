package chatbot.controller;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotPanel;
import chatbot.view.ChatbotView;

import javax.swing.JOptionPane;

/**
 * Runs the Chatbot Project. Owns the model and associated views.
 * @author Braeden Barwick
 * @version 1.2 10/2/14 - cleaned the quit method.
 */
public class ChatbotAppController
{
	/**
	 * The instance of the ChatbotView, View of the app
	 */
	private ChatbotView appView;
	
	/**
	 * The instance of the Chatbot, the Model
	 */
	private Chatbot mySillyChatbot;
	
	/**
	 * retrieves the baseFrame
	 * @return
	 */
	public ChatbotFrame getBaseFrame()
	{
		return baseFrame;
	}

	/**
	 * The message used when starting the app
	 */
	private String startMessage;
	
	/**
	 * Message provided when the user quits the app
	 */
	private String quitMessage;
	
	/**
	 * Reference to the GUI JFrame object for the app
	 */
	private ChatbotFrame baseFrame;
	
	/**
	 * Builds the controller. (constructor)
	 */
	public ChatbotAppController()
	{
		appView = new ChatbotView(this);
		baseFrame = new ChatbotFrame(this);
		mySillyChatbot = new Chatbot("Dorf");
		startMessage = "Welcome to the " + mySillyChatbot.getName() + " chatbot. What is your name?";
		quitMessage = mySillyChatbot.getName() + ": I... Die...";
	}
	
	/**
	 * retrieves the name of the chatbot
	 * @return
	 */
	public Chatbot getMySillyChatbot()
	{
		return mySillyChatbot;
	}
	
	/**
	 * this method is called by the ChatbotRunner when the program starts
	 */
	public void start()
	{
		//String result = appView.showChatbotDialog(startMessage);
		
		((ChatbotPanel) baseFrame.getContentPane()).showTextMessage(startMessage);
		
		//ChatbotPanel testPanel = (ChatbotPanel) baseFrame.getContentPane();
		
				
	}
	
	/**
	 * this method sets the Chatbot's response to the userinput by running processText in Chatbot
	 * @param input
	 * @return
	 */
	public String getChatbotDialog(String input)
	{
		String result = "";
		
		result = mySillyChatbot.processText(input);
		
		return result;
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
