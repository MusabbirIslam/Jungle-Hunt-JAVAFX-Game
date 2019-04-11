import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

public class Score{

	private  ImageView backgroundImageView;
	private Player [] player;
    private Scene scene;
	private Button backButton;
	private DataBase databaseObject;
	public Score(){

		Image backgroundImage= new Image("Backgrounds/topHunters.jpg");
		backgroundImageView= new ImageView(backgroundImage);
		backgroundImageView.setFitHeight(MyStage.HEIGHT);
		backgroundImageView.setFitWidth(MyStage.WIDTH);
		backgroundImageView.setPreserveRatio(false);
		backgroundImageView.setSmooth(true);
        backgroundImageView.setCache(true);

	    databaseObject=new DataBase();
		  player=new Player[3];
		  player[0]=new Player();
		  player[1]=new Player();
		  player[2]=new Player();

	    System.arraycopy(databaseObject.getPlayer(),0,player,0,3);

		Text score1 = new Text();
		score1.setX(310.0);
		score1.setY(220.0);
		score1.setFill(Color.WHITE);
		score1.setFont(Font.font(null, FontWeight.BOLD, 32));
		score1.setText("1. "+player[0].getName()+"  "+player[0].getScore());

		Text score2 = new Text();
		score2.setX(200.0);
		score2.setY(330.0);
		score2.setFill(Color.WHITE);
		score2.setFont(Font.font(null, FontWeight.BOLD, 32));
		score2.setText("2. "+player[1].getName()+"  "+player[1].getScore());

		Text score3= new Text();

		score3.setX(450.0);
		score3.setY(400.0);
		score3.setFill(Color.WHITE);
		score3.setFont(Font.font(null, FontWeight.BOLD, 32));
		score3.setText("3. "+player[2].getName()+"  "+player[2].getScore());

	    //-----------Back button-------
		backButton = new Button("Back");
		backButton.setLayoutX(615d);
        backButton.setLayoutY(522);
		backButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		//--------next level button action------
		backButton.setOnAction(
			e->{
				MyStage.changeScene(0);
			}
		);


	    Group highScoreGroup = new Group(backgroundImageView,score1,score2,score3,backButton);
	     scene = new Scene(highScoreGroup,MyStage.WIDTH,MyStage.HEIGHT) ;
	}

	public Scene getScene(){
			return scene;
		}
	public void checkNewHighScore(String name,int score)
	{
		databaseObject.checkNewHighScore(name,score);
	}
}
