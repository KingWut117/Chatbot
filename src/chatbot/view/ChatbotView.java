package chatbot.view;

import chatbot.controller.ChatbotAppController;
import javax.swing.JOptionPane;

public class ChatbotView
{
	private ChatbotAppController baseController;
	
	public ChatbotView(ChatbotAppController baseController)
	{
		this.baseController = baseController;
	}
	
	/**
	 * Shows a string from the Chatbot with the availability of user input.
	 * @param currentInput The supplied String.
	 * @return The users typed response.
	 */
	public String showChatbotDialog(String currentInput)
	{
		String result = "";
		
		result = JOptionPane.showInputDialog(baseController.getBaseFrame(), baseController.getMySillyChatbot().getName() + " says: " + currentInput);
		
		return result;
	}
	
	 /**
	  * Shows a String from the Chatbot as a popup window.
	  * @param currentInput The string from the Chatbot.
	  */
	public void showChatbotMessage(String currentInput)
	{
		JOptionPane.showMessageDialog(baseController.getBaseFrame(), baseController.getMySillyChatbot().getName() + " says: " + currentInput);
	}

}
