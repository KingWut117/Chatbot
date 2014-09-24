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
	
	public String showChatbot(String currentInput)
	{
		String result = "";
		
		JOptionPane.showMessageDialog(null, "Hello nerd, " + currentInput);
		result = JOptionPane.showInputDialog(null, "Are you done, nerd?");
		
		return result;
	}
	
}