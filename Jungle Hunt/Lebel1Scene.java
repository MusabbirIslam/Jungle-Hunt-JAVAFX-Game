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
class Lebel1Scene implements Runnable{


		private final Image backgroundImage,animal1Image,gunImage,animal2Image,animal3Image,backgroundLayerImage,bloodImage,levelCompleteImage;
		private final ImageView backgroundImageView,animal1ImageView,animal2ImageView,animal3ImageView,gunImageView,deerBloodImageiew,tigerBloodImageiew,levelCompleteImageView,monkeyBloodImageiew,backgroundLayerImageView;
		private Group root;
		private Scene scene;
		private Thread carThread;
		private Boolean threadTrue,deerKilled,tigerKilled,monkeyKilled;
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
				double animal1Position= animal1ImageView.getTranslateY();
				double animal2Position= animal2ImageView.getTranslateY();
				double animal3Position= animal3ImageView.getTranslateY();

				if(count<=9)
					animal1ImageView.setTranslateY(animal1Position+10);
				else
					animal1ImageView.setTranslateY(animal1Position-10);

				if(countDeer%3==0)
				{
					if(count<=9)
						animal2ImageView.setTranslateY(animal2Position-10);
					else
						animal2ImageView.setTranslateY(animal2Position+10);
				}

				if(countDeer%4==0)
				{
					if(count>9)
						animal3ImageView.setTranslateY(animal3Position-10);
					else
						animal3ImageView.setTranslateY(animal3Position+10);
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
			backButton.setVisible(true);
			tryAgainButton.setVisible(true);
			if(MyStage.SCORE>110)
			{
				nextLevelButton.setVisible(true);
				levelCompleteImageView.setVisible(true);
			}
			MyStage.sendScore();
		};




		//----------------------------constructor--------------------------
		Lebel1Scene(){
		//load Image
		// resizes the image to have Higt of 500 and width of 800
        // higher quality filtering method; this ImageView is also cached to
        // improve performance
		count=0;
		deerKilled=false;
		tigerKilled=false;
		monkeyKilled=false;
		backgroundImage= new Image("Backgrounds/level1background.jpg");
		backgroundImageView= new ImageView(backgroundImage);
		backgroundImageView.setFitHeight(MyStage.HEIGHT);
		backgroundImageView.setFitWidth(MyStage.WIDTH);
		backgroundImageView.setPreserveRatio(false);
		backgroundImageView.setSmooth(true);
        backgroundImageView.setCache(true);

		backgroundLayerImage= new Image("Backgrounds/level1backgroundLayer.png");
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

		animal1Image= new Image("Characters/deerOne.png");
		animal1ImageView= new ImageView(animal1Image);
		animal1ImageView.setFitHeight(100);
		animal1ImageView.setFitWidth(100);
		animal1ImageView.setTranslateX(173d);
		animal1ImageView.setTranslateY(160d);
		animal1ImageView.setPreserveRatio(false);
		animal1ImageView.setSmooth(true);

		bloodImage= new Image("otherImage/blood.png");
		deerBloodImageiew= new ImageView(bloodImage);
		deerBloodImageiew.setFitHeight(150d);
		deerBloodImageiew.setFitWidth(150d);
		deerBloodImageiew.setTranslateX(150d);
		deerBloodImageiew.setTranslateY(150d);
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
		animal2ImageView.setFitHeight(100);
		animal2ImageView.setFitWidth(100);
		animal2ImageView.setTranslateX(751d);
		animal2ImageView.setTranslateY(205d);
		animal2ImageView.setPreserveRatio(false);
		animal2ImageView.setSmooth(true);

		tigerBloodImageiew= new ImageView(bloodImage);
		tigerBloodImageiew.setFitHeight(180d);
		tigerBloodImageiew.setFitWidth(180d);
		tigerBloodImageiew.setTranslateX(700d);
		tigerBloodImageiew.setTranslateY(90d);
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

		animal3Image= new Image("Characters/monkeyTwo.png");
		animal3ImageView= new ImageView(animal3Image);
		animal3ImageView.setFitHeight(100);
		animal3ImageView.setFitWidth(100);
		animal3ImageView.setTranslateX(450d);
		animal3ImageView.setTranslateY(-110d);
		animal3ImageView.setPreserveRatio(false);
		animal3ImageView.setSmooth(true);

		monkeyBloodImageiew= new ImageView(bloodImage);
		monkeyBloodImageiew.setFitHeight(100d);
		monkeyBloodImageiew.setFitWidth(100d);
		monkeyBloodImageiew.setTranslateX(460d);
		monkeyBloodImageiew.setTranslateY(5d);
		monkeyBloodImageiew.setPreserveRatio(false);
		monkeyBloodImageiew.setSmooth(true);
		monkeyBloodImageiew.setVisible(false);
		//event for animal 1
        animal3ImageView.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                monkeyBloodImageiew.setVisible(true);
				animal3ImageView.setVisible(false);
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
		nextLevelButton = new Button("Unlock Level");
		nextLevelButton.setLayoutX(410);
        nextLevelButton.setLayoutY(350);
		nextLevelButton.setVisible(false);
		nextLevelButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		//--------next level button action------
		nextLevelButton.setOnAction(
			e->{
				MyStage.changeScene(2);
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
		animalGroup.getChildren().addAll(animal1ImageView,animal2ImageView,animal3ImageView,deerBloodImageiew,tigerBloodImageiew,monkeyBloodImageiew);
		Group buttonGroup=new Group();
		buttonGroup.getChildren().addAll(backButton,tryAgainButton,nextLevelButton);


		//starting Thread
		carThread = new Thread(this);
        carThread.start();
		//player.startCharacter();
		//main group for scene
		root=new Group(backgroundImageGroup,animalGroup,backgroundLayerImageView,levelCompleteImageView,gunImageView,scoreText,massage,buttonGroup);
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
