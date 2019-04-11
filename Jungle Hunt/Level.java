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
public class Level{

	private  ImageView backgroundImageView;
    private Scene scene;
	private Button backButton;
	public Level(){

		Image backgroundImage= new Image("Backgrounds/combined.jpg");
		backgroundImageView= new ImageView(backgroundImage);
		backgroundImageView.setFitHeight(MyStage.HEIGHT);
		backgroundImageView.setFitWidth(MyStage.WIDTH);
		backgroundImageView.setPreserveRatio(false);
		backgroundImageView.setSmooth(true);
        backgroundImageView.setCache(true);

		//-------------level 1 button and Text----------
		Text level1Text = new Text();
		level1Text.setX(415.0);
		level1Text.setY(110.0);
		level1Text.setFill(Color.WHITE);
		level1Text.setFont(Font.font(null, FontWeight.BOLD, 32));
		level1Text.setText(" The Rain Forest ");

		Button level1Button = new Button("PLAY");
		level1Button.setLayoutX(500);
        level1Button.setLayoutY(130);
		level1Button.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		//--------level 1 button action------
		level1Button.setOnAction(
			e->{
				MyStage.changeScene(1);
			}
		);


		//-------------level 2 button and Text----------
		Text level2Text = new Text();
		level2Text.setX(400.0);
		level2Text.setY(425.0);
		level2Text.setFill(Color.WHITE);
		level2Text.setFont(Font.font(null, FontWeight.BOLD, 32));
		level2Text.setText(" The Dark Forest ");


		Button level2Button = new Button("PLAY");
		level2Button.setLayoutX(490);
        level2Button.setLayoutY(445);
		level2Button.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		//--------level 2 button action------
		level2Button.setOnAction(
			e->{
					MyStage.changeScene(2);
			}
		);



	    //-----------Back button-------
		backButton = new Button(" Back ");
		backButton.setLayoutX(900);
        backButton.setLayoutY(550);
		backButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		//--------next level button action------
		backButton.setOnAction(
			e->{
				MyStage.changeScene(0);
			}
		);


	    Group highScoreGroup = new Group(backgroundImageView,level1Button,level2Button,level1Text,level2Text,backButton);
	     scene = new Scene(highScoreGroup,MyStage.WIDTH,MyStage.HEIGHT) ;
	}

	public Scene getScene(){
			return scene;
		}

}
