public class Player{
	private String name;
	private  int score;
	
	public Player()
	{
		this.name="";
		this.score=0;
	}


	public String getName()
	{
		return this.name;
	}
	
	public int getScore()
	{
		return this.score;
	}
	
	public void setName(String n)
	{
		this.name=n;
	}
	
	public void setScore(int s)
	{
		this.score=s;
	}
	
	}