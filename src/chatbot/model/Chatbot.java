package chatbot.model;

import java.util.ArrayList;

import chatbot.view.ChatbotUser;

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

	/**
	 * The String that holds the text shown in the chatbox
	 */
	private String contentArea;

	/**
	 * this is the amount of chats within the program, counted by
	 * updateChatCount.
	 */
	private int chatCount;
	
	/**
	 * The user of the chatbot as seen in ChatbotUser
	 */
	private ChatbotUser myUser;

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
		contentArea = "zergling";
		myUser = new ChatbotUser();
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
	 * retrieves that data set in ChatbotUser
	 * @return
	 */
	public ChatbotUser getMyUser()
	{
		return myUser;
	}

	/**
	 * sets the info gained from getMyUser to myUser in Chatbot.java
	 * @param myUser
	 */
	public void setMyUser(ChatbotUser myUser)
	{
		this.myUser = myUser;
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
		
		if(getChatCount() < 4)
		{
			if(getChatCount() == 0)
			{
			result = "Dorf: Are you MLG bruh?";
			myUser.setUserName(currentInput);
			}
			
			else if(getChatCount() == 1)
			{
				if(currentInput.contains("yes"))
				{
					result = "Dorf: Dank! So I assume you have sweg as well?";
					myUser.setMLG(true);
				}
				
				else
				{
					result = "Dorf: You aren't even cool bruh. Do you even have sweg?";
					myUser.setMLG(false);
				}
			}
			
			else if(getChatCount() == 2)
			{
				if(currentInput.contains("yes"))
				{
					result = "Dorf: Great! How many quickscopes do you get?";
					myUser.setHasSweg(true);
				}
				
				else
				{
					result = "Dorf: What a skrub! Quickscopes are your only redemption! How many you get?";
					myUser.setHasSweg(false);
				}
			}
			
			else if(getChatCount() == 3)
			{
				if(currentInput.contains("9001"))
				{
					result = "Dorf: OMGZ! OVER 9000?!!? *dies*";
					System.exit(500);
				}
				
				else
				{
					result = "Dorf: Meh... I guess " + currentInput + " is alright...";
					myUser.setNumberOfQuickscopes(currentInput);
				}
			}

		}

		int randomPosition = (int) (Math.random() * 7);

		if (currentInput != null & getChatCount() >= 4)
		{

			if(randomPosition == 0)
			{
				if (stringLengthChecker(currentInput))
				{
					result = "Dorf: Ughh... You talk a lot.";
				} 
				else
				{
					result = "Dorf: I like how you don't mince words!";
				}

			}

			else if(randomPosition == 1)
			{
				if (contentChecker(currentInput))
				{
					result = "Dorf: Gotta love them zergling rushes!";
				} 
				else
				{
					result = "Dorf: What do you think about the game StarCraft?";
				}
			}

			else if(randomPosition == 2)
			{
				if (memeChecker(currentInput))
				{
					result = "Dorf: Wow, " + currentInput + " is a meme! Wahoo!";
				} 
				else
				{
					result = "Dorf: Not a meme, noob. Try again.";
				}
			}
			
			else if(randomPosition == 3)
			{
				result = "Dorf: " + myUser.getUserName() + " is a pretty nice name... I guess.";
			}
			
			else if(randomPosition == 4)
			{
				if(myUser.isMLG())
				{
					result = "Dorf: So, have you won any MLG tournaments?";
				}
				else
				{
					result = "Dorf: You should be MLG";
				}
			}
			
			else if(randomPosition == 5)
			{
				if(myUser.hasSweg())
				{
					result = "Sweg Dorf: Sweg bruh, sweg. Swegswegswegswegswegsweg.";
				}
				else
				{
					result = "Sweg Dorf: Sorry, I only hang with ppl who has sweg.";
					System.exit(500);
				}
			}
			
			else
			{
				result = "Dorf: Braeden is awesome.";
			}
		}
		updateChatCount();
		return result;
	}

	/**
	 * This method increases the chatCount by 1 every time it is called.
	 */
	private void updateChatCount()
	{
		chatCount++;
	}

	/**
	 * checks the length of the user input for use in processText
	 * @param input
	 * @return
	 */
	private boolean stringLengthChecker(String input)
	{
		boolean isLong = false;

		if (input.length() >= 25)
		{
			isLong = true;
		}

		return isLong;
	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	private boolean contentChecker(String input)
	{
		boolean hasContent = false;

		if (input.contains(contentArea))
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
