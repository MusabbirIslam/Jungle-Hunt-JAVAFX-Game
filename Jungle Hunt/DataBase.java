import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.OutputStream;
import java.io.FileOutputStream;
public class DataBase
{
	private Player [] player;
	private Properties prop;
	private InputStream input;
	private OutputStream output;
	public DataBase(){
		  prop = new Properties();
		  input = null;
		  output = null;
		  player=new Player[3];
		  player[0]=new Player();
		  player[1]=new Player();
		  player[2]=new Player();
		  getFromDatabase();
	
	}
	
	public void getFromDatabase()
	{
		  try 
		  {
			input = new FileInputStream("score.properties");
			// load a properties file
		    prop.load(input);
		   
		   
		   for(int i=0;i<3;i++)
		   {
			  player[i].setName(prop.getProperty(i+"Name"));
			  player[i].setScore(Integer.parseInt(prop.getProperty(i+"Score")));
		   }
		   
		   input.close();
		  }
			
		  catch(IOException ex)
			{
			 ex.printStackTrace();
			}
	}
	
	private void insertNewData()
	{
		try {

		output = new FileOutputStream("score.properties");

		// set the properties value
		 for(int i=0;i<3;i++)
		 {
			prop.setProperty(i+"Name",player[i].getName());
			prop.setProperty(i+"Score",String.valueOf(player[i].getScore())); 
		 }

		// save properties to project root folder
		prop.store(output, null);
		output.close();
		}
		catch (Exception e)
		{
			System.out.println("Error in Database insertNewData function");
		}
	
	} 
	
	public void checkNewHighScore(String name,int score)
	{
		boolean change=false;//check if new score comes
		for(int i=0;i<3;i++)
		{
			if(player[i].getScore()<score)
			{
				String tempName=player[i].getName();
				int tempScore=player[i].getScore();
				player[i].setName(name);
				player[i].setScore(score);
				name=tempName;
				score=tempScore;
				change=true;
			}
		}
		if(change){
			insertNewData();
		}
	}
	
	public Player [] getPlayer(){
		return player;
	}
}