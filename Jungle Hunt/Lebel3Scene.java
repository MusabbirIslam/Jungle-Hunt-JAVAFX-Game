import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.lang.Exception;
import javafx.application.Platform;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import javafx.event.ActionEvent;
class Lebel3Scene implements Runnable{


		private final Image backgroundImage,animal1Image,gunImage,animal2Image,animal3Image,backgroundLayerImage,bloodImage,animal4Image,levelCompleteImage;
		private final ImageView backgroundImageView,lionBloodImageiew,animal1ImageView,animal2ImageView,animal3ImageView,gunImageView,levelCompleteImageView,deerBloodImageiew,animal4ImageView,tigerBloodImageiew,monkeyBloodImageiew,backgroundLayerImageView;
		private Group root;
		private Scene scene;
		private Thread carThread;
		private Boolean threadTrue,deerKilled,tigerKilled,monkeyKilled,lionKilled;
		public static int count;
		private Group carGroup;
		private Text scoreText,massage;
		private Button nextLevelButton,backButton,tryAgainButton;

		public void run()
		{
			int count=1,countDeer=0;
			threadTrue=true;
			while(countDeer<10 && threadTrue)
			{
				double animal1Position= animal1ImageView.getTranslateX();
				double animal2Position= animal2ImageView.getTranslateX();
				double animal3Position= animal3ImageView.getTranslateX();
				double animal4Position= animal4ImageView.getTranslateY();

				if(count<=9)
					animal1ImageView.setTranslateX(animal1Position-10);
				else
					animal1ImageView.setTranslateX(animal1Position+10);

				if(countDeer%2==0)
				{
					animal2ImageView.setTranslateX(animal2Position+10);

				}
				if(countDeer%4==0)
				{
					animal2ImageView.setTranslateX(animal2Position-10);
				}
				if(countDeer%5==0)
				{
					animal3ImageView.setTranslateX(animal3Position-10);
				}

				if(countDeer%7==0)
				{
					animal3ImageView.setTranslateX(animal3Position+10);
				}

				if(countDeer%4==0)
				{
					if(count>9)
						animal4ImageView.setTranslateY(animal4Position-10);
					else
						animal4ImageView.setTranslateY(animal4Position+10);
				}


				if(deerKilled && count==9)
				{
						deerBloodImageiew.setVisible(false);
						deerKilled=false;
						animal1ImageView.setVisible(true);
				}

				if(tigerKilled && count==18)
				{
						tigerBloodImageiew.setVisible(false);
						tigerKilled=false;
						animal2ImageView.setVisible(true);
				}

				if(lionKilled && count==18)
				{
						lionBloodImageiew.setVisible(false);
						lionKilled=false;
						animal3ImageView.setVisible(true);
				}

				if(monkeyKilled && count==1)
				{
						monkeyBloodImageiew.setVisible(false);
						monkeyKilled=false;
						animal3ImageView.setVisible(true);
				}

				//----------sleep----------
				try{
					Thread.sleep(160);
				}catch(Exception e){};

				if(count==18)
				{
					count=0;
					countDeer++;
				}

				count++;

			}

			if(MyStage.SCORE>270)
			{
				nextLevelButton.setVisible(true);
				levelCompleteImageView.setVisible(true);
			}

			backButton.setVisible(true);
			tryAgainButton.setVisible(true);
			nextLevelButton.setVisible(true);
			MyStage.sendScore();
		};




		//----------------------------constructor--------------------------
		Lebel3Scene(){
		//load Image
		// resizes the image to have Higt of 500 and width of 800
        // higher quality filtering method; this ImageView is also cached to
        // improve performance
		count=0;
		deerKilled=false;
		tigerKilled=false;
		monkeyKilled=false;
		lionKilled=false;
		backgroundImage= new Image("Backgrounds/LevelThreeBackground.jpg");
		backgroundImageView= new ImageView(backgroundImage);
		backgroundImageView.setFitHeight(MyStage.HEIGHT);
		backgroundImageView.setFitWidth(MyStage.WIDTH);
		backgroundImageView.setPreserveRatio(false);
		backgroundImageView.setSmooth(true);
        backgroundImageView.setCache(true);

		backgroundLayerImage= new Image("Backgrounds/levelThreeForeground.png");
		backgroundLayerImageView= new ImageView(backgroundLayerImage);
		backgroundLayerImageView.setFitHeight(MyStage.HEIGHT);
		backgroundLayerImageView.setFitWidth(MyStage.WIDTH);
		backgroundLayerImageView.setPreserveRatio(false);
		backgroundLayerImageView.setSmooth(true);
        backgroundLayerImageView.setCache(true);

		levelCompleteImage= new Image("Backgrounds/LEVELcOMPLETED.png");
		levelCompleteImageView= new ImageView(levelCompleteImage);
		levelCompleteImageView.setFitHeight(300);
		levelCompleteImageView.setFitWidth(300);
		levelCompleteImageView.setTranslateX(400d);
		levelCompleteImageView.setTranslateY(50d);
		levelCompleteImageView.setPreserveRatio(false);
		levelCompleteImageView.setSmooth(true);
        levelCompleteImageView.setCache(true);
		levelCompleteImageView.setVisible(false);

		gunImage= new Image("otherImage/gunPoint.png");
		gunImageView= new ImageView(gunImage);
		gunImageView.setFitHeight(80);
		gunImageView.setFitWidth(80);
		gunImageView.setTranslateX(200d);
		gunImageView.setTranslateY(440d);
		gunImageView.setPreserveRatio(false);
		gunImageView.setSmooth(true);

		animal1Image= new Image("Characters/deerTwo.png");
		animal1ImageView= new ImageView(animal1Image);
		animal1ImageView.setFitHeight(90);
		animal1ImageView.setFitWidth(80);
		animal1ImageView.setTranslateX(220d);
		animal1ImageView.setTranslateY(215d);
		animal1ImageView.setPreserveRatio(false);
		animal1ImageView.setSmooth(true);

		bloodImage= new Image("otherImage/blood.png");
		deerBloodImageiew= new ImageView(bloodImage);
		deerBloodImageiew.setFitHeight(100d);
		deerBloodImageiew.setFitWidth(100d);
		deerBloodImageiew.setTranslateX(230d);
		deerBloodImageiew.setTranslateY(200d);
		deerBloodImageiew.setPreserveRatio(false);
		deerBloodImageiew.setSmooth(true);
		deerBloodImageiew.setVisible(false);

		//event for animal 1
        animal1ImageView.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
				deerBloodImageiew.setVisible(true);
				animal1ImageView.setVisible(false);
				deerKilled=true;
				MyStage.SCORE=MyStage.SCORE+5;
				scoreText.setText("Score: " + String.valueOf(MyStage.SCORE));
            }
        });

		animal2Image= new Image("Characters/tigerTwo.png");
		animal2ImageView= new ImageView(animal2Image);
		animal2ImageView.setFitHeight(60);
		animal2ImageView.setFitWidth(60);
		animal2ImageView.setTranslateX(470d);
		animal2ImageView.setTranslateY(257d);
		animal2ImageView.setPreserveRatio(false);
		animal2ImageView.setSmooth(true);

		tigerBloodImageiew= new ImageView(bloodImage);
		tigerBloodImageiew.setFitHeight(80d);
		tigerBloodImageiew.setFitWidth(80d);
		tigerBloodImageiew.setTranslateX(380d);
		tigerBloodImageiew.setTranslateY(250d);
		tigerBloodImageiew.setPreserveRatio(false);
		tigerBloodImageiew.setSmooth(true);
		tigerBloodImageiew.setVisible(false);

		//event for animal 1
        animal2ImageView.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
				tigerBloodImageiew.setVisible(true);
				animal2ImageView.setVisible(false);
				tigerKilled=true;
				MyStage.SCORE=MyStage.SCORE+10;
				scoreText.setText("Score: " + String.valueOf(MyStage.SCORE));
            }
        });

		animal3Image= new Image("Characters/lionTwo.png");
		animal3ImageView= new ImageView(animal3Image);
		animal3ImageView.setFitHeight(80);
		animal3ImageView.setFitWidth(60);
		animal3ImageView.setTranslateX(530);
		animal3ImageView.setTranslateY(240d);
		animal3ImageView.setPreserveRatio(false);
		animal3ImageView.setSmooth(true);

		lionBloodImageiew= new ImageView(bloodImage);
		lionBloodImageiew.setFitHeight(80d);
		lionBloodImageiew.setFitWidth(80d);
		lionBloodImageiew.setTranslateX(620);
		lionBloodImageiew.setTranslateY(230d);
		lionBloodImageiew.setPreserveRatio(false);
		lionBloodImageiew.setSmooth(true);
		lionBloodImageiew.setVisible(false);
		//event for animal 1
        animal3ImageView.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                lionBloodImageiew.setVisible(true);
				animal3ImageView.setVisible(false);
				lionKilled=true;
				MyStage.SCORE=MyStage.SCORE+15;
				scoreText.setText("Score: " + String.valueOf(MyStage.SCORE));
            }
        });

		animal4Image= new Image("Characters/monkeyOne.png");
		animal4ImageView= new ImageView(animal4Image);
		animal4ImageView.setFitHeight(110d);
		animal4ImageView.setFitWidth(80d);
		animal4ImageView.setTranslateX(100d);
		animal4ImageView.setTranslateY(-110d);
		animal4ImageView.setPreserveRatio(false);
		animal4ImageView.setSmooth(true);

		monkeyBloodImageiew= new ImageView(bloodImage);
		monkeyBloodImageiew.setFitHeight(90d);
		monkeyBloodImageiew.setFitWidth(90d);
		monkeyBloodImageiew.setTranslateX(100d);
		monkeyBloodImageiew.setTranslateY(05d);
		monkeyBloodImageiew.setPreserveRatio(false);
		monkeyBloodImageiew.setSmooth(true);
		monkeyBloodImageiew.setVisible(false);
		//event for animal 1
        animal4ImageView.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                monkeyBloodImageiew.setVisible(true);
				animal4ImageView.setVisible(false);
				monkeyKilled=true;
				MyStage.SCORE=MyStage.SCORE+15;
				scoreText.setText("Score: " + String.valueOf(MyStage.SCORE));
            }
        });

		//----------score Text------------
		scoreText=new Text(800d,50d,"SCORE : "+String.valueOf(MyStage.SCORE));
		scoreText.setFont(new Font(40));
		scoreText.setFill(Color.WHITE);
		scoreText.setVisible(true);
		//-----------game over Text--------------
		massage=new Text(110,260,"GAME OVER");
		massage.setFont(new Font(40));
		massage.setFill(Color.RED);
		massage.setVisible(false);

		//-----------Next Level button-------
		nextLevelButton = new Button("High Score");
		nextLevelButton.setLayoutX(410);
        nextLevelButton.setLayoutY(350);
		nextLevelButton.setVisible(false);
		nextLevelButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		//--------next level button action------
		nextLevelButton.setOnAction(
			e->{
				MyStage.changeScene(4);
			}
		);

		//-----------Back button-------
		backButton = new Button("Back");
		backButton.setLayoutX(445);
        backButton.setLayoutY(400);
		backButton.setVisible(false);
		backButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		//--------next level button action------
		backButton.setOnAction(
			e->{
				MyStage.changeScene(0);
			}
		);

	    //--------------------------------------Try Again button---------------------------
		tryAgainButton = new Button("Try Again");
		tryAgainButton.setLayoutX(420);
        tryAgainButton.setLayoutY(450);
		tryAgainButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");

		tryAgainButton.setOnAction(
			e->{
				MyStage.changeScene(1);
			}
		);
		tryAgainButton.setVisible(false);

        //make group for background image
		Group backgroundImageGroup= new Group();
		backgroundImageGroup.getChildren().addAll(backgroundImageView);

		//group for animal
		Group animalGroup=new Group();
		animalGroup.getChildren().addAll(animal1ImageView,animal2ImageView,animal3ImageView,deerBloodImageiew,tigerBloodImageiew,monkeyBloodImageiew,lionBloodImageiew);
		Group buttonGroup=new Group();
		buttonGroup.getChildren().addAll(backButton,tryAgainButton,nextLevelButton);


		//starting Thread
		carThread = new Thread(this);
        carThread.start();

		//main group for scene
		root=new Group(backgroundImageView,animalGroup,backgroundLayerImageView,animal4ImageView,monkeyBloodImageiew,levelCompleteImageView,gunImageView,massage,buttonGroup,scoreText);
		scene=new Scene(root,MyStage.WIDTH,MyStage.HEIGHT);

			//tracking mouse
		scene.addEventFilter(MouseEvent.MOUSE_MOVED,	e->{
				gunImageView.setTranslateX(e.getScreenX()-220);
				gunImageView.setTranslateY(e.getScreenY()-100);
		});



}



		public Scene getScene(){
			return scene;
		}

		public void stopThread()
		{
			threadTrue=false;
		}
}
