package chatbot.model;

import java.util.ArrayList;

/**
 * The Chatbot model class. Used for checking and manipulating Strings.
 * 
 * @author bbar7754
 * @version 1.2 10/09/14
 */
public class Chatbot
{
	/**
	 * A list of Strings, will contain memes.
	 */
	private ArrayList<String> memeList;

	/**
	 * This is the name of the chatbot.
	 */
	private String name;

	private String contentArea;

	/**
	 * this is the amount of chats within the program, counted by
	 * updateChatCount.
	 */
	private int chatCount;

	/**
	 * creates a Chatbot object with the supplied name and initializes the
	 * current number of chats to zero
	 * 
	 * @param name
	 *            The supplied name for the Chatbot
	 */
	public Chatbot(String name)
	{
		memeList = new ArrayList<String>();
		this.name = name;
		chatCount = 0;
		fillTheMemeList();
	}

	/**
	 * This can change the name of the chatbot, base on the input in
	 * Chatbot(string name)
	 * 
	 * @param name
	 *            the name supplied in Chatbot
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * this contains a list of memes to add to the memeList in the constructor
	 */
	private void fillTheMemeList()
	{
		memeList.add("kitties");
		memeList.add("success kid");
		memeList.add("I had fun once...");
		memeList.add("doge");
		memeList.add("ceilingCat");
		memeList.add("Table flip!");
	}

	/**
	 * Returns the name of the Chatbot object.
	 * 
	 * @return The Current name of the Chatbot.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * This is the number of chats that occur with the chatbot.
	 * 
	 * @return The number of chats.
	 */
	public int getChatCount()
	{
		return chatCount;
	}

	/**
	 * processes input from the user against the checkerMethods. Returns the
	 * next output for the view.
	 * 
	 * @param currentInput
	 *            The supplied text.
	 * @return The processed text based on checker or other methods.
	 */
	public String processText(String currentInput)
	{
		String result = "";

		int randomPosition = (int) (Math.random() * 3);

		if (currentInput != null)
		{

			if (randomPosition == 0)
			{
				if (stringLengthChecker(currentInput))
				{
					result = "Ughh... You talk a lot.";
				} else
				{
					result = "I like how you don't mince words!";
				}

			}

			else if (randomPosition == 1)
			{
				if (contentChecker(currentInput))
				{
					result = "Gotta love them zergling rushes!";
				} else
				{
					result = "What do you think about the game StarCraft?";
				}
			}

			else
			{
				if (memeChecker(currentInput))
				{
					result = "Wow, " + currentInput + " is a meme! Wahoo!";
				} else
				{
					result = "Not a meme, noob. Try again.";
				}
			}
		}

		return result;
	}

	/**
	 * This method increases the chatCount by 1 every time it is called.
	 */
	private void updateChatCount()
	{
		chatCount++;
	}

	private boolean stringLengthChecker(String input)
	{
		boolean isLong = false;

		if (input.length() >= 25)
		{
			isLong = true;
		}

		return isLong;
	}

	private boolean contentChecker(String input)
	{
		boolean hasContent = false;

		if (input.contains("zergling"))
		{
			hasContent = true;

		}

		return hasContent;

	}

	/**
	 * Checks the input against memeList and responds if your text is a meme
	 * 
	 * @param input
	 *            The current input
	 * @return Whether it is a meme or not
	 */
	private boolean memeChecker(String input)
	{
		boolean isAMeme = false;

		for (String currentMeme : memeList)
		{
			if (input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}

		return isAMeme;
	}

	/**
	 * this initializes a boolean and sets it to false. It will control whether
	 * it is safe to quit.
	 * 
	 * @param input
	 *            This is the text input.
	 * @return True or False.
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if (input != null && input.equalsIgnoreCase("die"))
		{
			okToQuit = true;
		}

		return okToQuit;
	}

}
