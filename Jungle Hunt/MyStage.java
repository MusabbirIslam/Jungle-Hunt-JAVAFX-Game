import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.application.Platform;
import javafx.stage.WindowEvent;
public class MyStage extends Application{

		public final static double WIDTH=1000;
		public final static double HEIGHT=600;
		public static int SCORE;
		private static Scene scene;
		private static Stage stage;
		private static Lebel1Scene lebel1SceneObject;
		private static Lebel3Scene lebel3SceneObject;
		private static String name;
		private static Score scoreObject;
		private static Level levelObject;

		//------------------------start method--------------------------
	 public void start(Stage myStage){
		stage=myStage;
		SCORE=0;

		//score object creating for sending score
		scoreObject=new Score();

		ImageView backgroundImageView;
	    Image backgroundImage= new Image("Backgrounds/coverPhoto.jpg");
		backgroundImageView= new ImageView(backgroundImage);
		backgroundImageView.setFitHeight(HEIGHT);
		backgroundImageView.setFitWidth(WIDTH);
		backgroundImageView.setPreserveRatio(false);
		backgroundImageView.setSmooth(true);
        backgroundImageView.setCache(true);


			//--------taking input for name----------
		TextField nameField=new TextField();
		nameField.setTranslateX(650d);
		nameField.setTranslateY(300d);
		nameField.setStyle("-fx-font-weight: bold;");

		//---------lebel for text massage----------
		Label l1=new Label("ENTER YOUR NAME");
		l1.setTranslateX(650d);
		l1.setTranslateY(282d);
        l1.setFont(new Font("Arial", 30));
		l1.setTextFill(Color.web("#FDFEFE"));
	    l1.setStyle("-fx-font-weight: bold;");
		//---------------------------All Button---------------------


		//-----------play button-------
		Button playButton = new Button("NEW GAME");
		playButton.setLayoutX(665);
        playButton.setLayoutY(280);
		playButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		//--------Play button action------
		playButton.setOnAction(
			e->{
				changeScene(1);
			}
		);


		//---------high score button---------
	    Button highScoreButton = new Button("TOP HUNTERS");
		highScoreButton.setLayoutX(650);
        highScoreButton.setLayoutY(350);
	    highScoreButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		//--------High button action------
		highScoreButton.setOnAction(
			e->{
			    changeScene(4);
			}
		);

		//-------- level button---------
	    Button levelButton = new Button("  SELECT LEVEL  ");
		levelButton.setLayoutX(636);
        levelButton.setLayoutY(420);
	    levelButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		//--------High button action------
		levelButton.setOnAction(
			e->{
			    changeScene(3);
			}
		);



		//------ok button------
		Button okButton=new Button("OK");
		okButton.setTranslateX(880d);
		okButton.setTranslateY(322d);
	    okButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");

		//---------VBox for name and ok button------
		VBox v1=new VBox();
		v1.getChildren().addAll(l1,nameField,okButton);

		//-----------Group for name and ok button---------
		Group nameGroup = new Group(backgroundImageView,v1);
		//-----------group for play high quit button--------
        Group buttonGroup = new Group(playButton,highScoreButton,levelButton);
		buttonGroup.setVisible(false);
		//--------ok button action------
		okButton.setOnAction(
			e->{
				name=nameField.getText();
				v1.setVisible(false);
				buttonGroup.setVisible(true);
			}
		);

         Group root=new Group(nameGroup,buttonGroup);
	     scene = new Scene(root,WIDTH,HEIGHT) ;
	     stage.setScene(scene) ;
	     stage.show() ;

		 stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
			  if(lebel1SceneObject!=null)
				lebel1SceneObject.stopThread();
			  else if(lebel3SceneObject!=null)
				 lebel3SceneObject.stopThread();

				stage.close();
          }
      });
	}


	public static void changeScene(int choise){
		if(choise==0)
		{
			SCORE=0;
			stage.setScene(scene) ;
			stage.show() ;
		}
		else if(choise==1)
		{
			SCORE=0;
			lebel1SceneObject=new Lebel1Scene();
			stage.setScene(lebel1SceneObject.getScene()) ;
			stage.show() ;
		}
		else if(choise==2)
		{
			lebel3SceneObject=new Lebel3Scene();
			stage.setScene(lebel3SceneObject.getScene()) ;
			stage.show() ;
		}
		else if(choise==3)
		{
			levelObject=new Level();
			stage.setScene(levelObject.getScene()) ;
			stage.show() ;
		}
		else if(choise==4)
		{
			scoreObject=new Score();
			stage.setScene(scoreObject.getScene()) ;
			stage.show() ;
		}

	}

	public static void sendScore()
	{
		scoreObject.checkNewHighScore(name,SCORE);
	}

}
