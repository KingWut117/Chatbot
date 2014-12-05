package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatbotAppController;

public class ChatbotPanel extends JPanel
{
	private ChatbotAppController baseController;
	
	/**
	 * panel components
	 */
	private JButton firstButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	
	/**
	 * constructs the panel
	 * @param baseController
	 */
	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;
		
		firstButton = new JButton("Enter");
		firstTextField = new JTextField(25);
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 6, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -12, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, -6, SpringLayout.WEST, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, -197, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -10, SpringLayout.EAST, this);
		chatArea = new JTextArea(5, 20);
		chatPane = new JScrollPane(chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 8, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, 356, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, 0, SpringLayout.EAST, firstButton);
		
		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * sets the properties of the chat pane
	 */
	private void setupPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
	}
	
	/**
	 * creates the panel and its components
	 */
	private void setupPanel()
	{
		this.setBackground(Color.darkGray);
		this.setSize(400, 400);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.add(chatPane);
	}
	
	private void setupLayout()
	{
	}
	
	/**
	 * creates the key and click listeners that will allow the user to input their text
	 */
	private void setupListeners()
	{
		firstTextField.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent keyPress)
			{
				if(keyPress.getKeyCode() == KeyEvent.VK_ENTER)
				{
					String currentInput = firstTextField.getText();
					String result = baseController.getChatbotDialog(currentInput);
				    showTextMessage("You: " + currentInput);
				    showTextMessage(result);
					firstTextField.setText("");
					firstTextField.requestFocus();
				}
				else
				{}
			}

			@Override
			public void keyReleased(KeyEvent sweg)
			{}

			@Override
			public void keyTyped(KeyEvent sweg)
			{}
		});
		
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String currentInput = firstTextField.getText();
			    String result = baseController.getChatbotDialog(currentInput);
			    showTextMessage("You: " + currentInput);
			    showTextMessage(result);
				firstTextField.setText("");
			}
		});
	}
	
	/**
	 * this appends the user's input to the chat dialogue
	 * @param userInput
	 * @return
	 */
	public String showTextMessage(String userInput)
	{
		chatArea.append("\n" + userInput);
		return firstTextField.getText();
	}

}
