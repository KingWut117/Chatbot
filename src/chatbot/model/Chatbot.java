package chatbot.model;


/**
 * The Chatbot model class. Used for checking and manipulating Strings.
 * @author bbar7754
 * @version 1.1 9/26/14
 */
public class Chatbot
{
	/**
	 * This is the name of the chatbot.
	 */
	private String name;
	/**
	 * this is the amount of chats within the program, counted by updateChatCount.
	 */
	private int chatCount;
	
	/**
	 * creates a Chatbot object with the supplied name and initializes the current number of chats to zero
	 * @param name The supplied name for the Chatbot
	 */
	public Chatbot(String name)
	{
		this.name = name;
		chatCount = 0;
	}
	
	/**
	 * Returns the name of the Chatbot object.
	 * @return The Current name of the Chatbot.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * This is the number of chats that occur with the chatbot.
	 * @return The number of chats.
	 */
	public int getChatCount()
	{
		return chatCount;
	}
	
	/**
	 * This can change the name of the chatbot, base on the input in Chatbot(string name)
	 * @param name the name supplied in Chatbot
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * This method increases the chatCount by 1 every time it is called.
	 */
	private void updateChatCount()
	{
		chatCount++;
	}
	
	/**
	 * this initializes a boolean and sets it to false. It will control whether it is safe to quit.
	 * @param input This is the text input.
	 * @return True or False.
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input.equalsIgnoreCase("die"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}

}
