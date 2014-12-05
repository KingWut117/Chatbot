package chatbot.view;

import javax.swing.JFrame;
import chatbot.controller.ChatbotAppController;
import java.awt.Color;

public class ChatbotFrame extends JFrame
{
	private ChatbotPanel basePanel;
	
	public ChatbotFrame(ChatbotAppController baseController)
	{
		basePanel = new ChatbotPanel(baseController);
		basePanel.setBackground(Color.DARK_GRAY);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setVisible(true);
	}

}
