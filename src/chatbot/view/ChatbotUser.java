package chatbot.view;

public class ChatbotUser
{
	// four data members
	//at least two differnt types (String, int, boolean, double)
	private String userName;
	private boolean isMLG;
	private boolean hasSweg;
	private String numberOfQuickscopes;
	
	public ChatbotUser()
	{
		this.userName = "";
		this.isMLG = false;
		this.hasSweg = false;
		this.numberOfQuickscopes = "none";
	}

	public String getUserName()
	{
		return userName;
	}
	
	public boolean isMLG()
	{
		return isMLG;
	}

	public boolean hasSweg()
	{
		return hasSweg;
	}

	public String getNumberOfQuickscopes()
	{
		return numberOfQuickscopes;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public void setMLG(boolean isMLG)
	{
		this.isMLG = isMLG;
	}

	public void setHasSweg(boolean hasSweg)
	{
		this.hasSweg = hasSweg;
	}	

	public void setNumberOfQuickscopes(String numberOfQuickscopes)
	{
		this.numberOfQuickscopes = numberOfQuickscopes;
	}

	
}
