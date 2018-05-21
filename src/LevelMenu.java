import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LevelMenu extends Application {
  int levelNum, qNum, i, j;
  public LevelMenu() {}

  public static void main(String[] args) {
    // LevelMenu();
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    levelNum = qNum = 1;

    //primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../resources/LQ_logo_2_32.png")));
    primaryStage.getIcons().add(new Image("file:../resources/4learning_icon_32.png"));   //set logo for window
    primaryStage.setTitle("Menu Testing");

    MenuBar menuBar = new MenuBar();
    Menu levels = new Menu("Levels");
    levels.setGraphic(new ImageView(new Image("file:../resources/LQ_logo_2_32.png")));
    ArrayList<Menu> levelItems = new ArrayList<Menu>(); //Levels array
    ArrayList<ArrayList<MenuItem>> levelQuestions = new ArrayList<ArrayList<MenuItem>>(); //Array of the questions array for each level

    ArrayList<int> iArray = new ArrayList<int>();
    ArrayList<int> jArray = new ArrayList<int>();
    Label presentation = new Label("Level: " + Integer.toString(levelNum) + " Question: " + Integer.toString(qNum));

    //TODO Sort this out fot getting number of levels and questions
    for(i=0; i<5; i++) {
      levelItems.add(new Menu("Level " + (i+1)));

      levelItems.get(i).setGraphic(confusedFace());

      ArrayList<MenuItem> questions = new ArrayList<MenuItem>();  //Array of questions in current level.

      for(j=0; j<5; j++) {
        questions.add(new MenuItem("Question: " + (j+1)));
        levelItems.get(i).getItems().add(questions.get(j));

        questions.get(j).setGraphic(smilingFace());

        questions.get(j).setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
            //NONE OF THIS WORKS LOL
            setSlide();
            presentation.setText("Level: " + Integer.toString(levelNum) + " Question: " + Integer.toString(qNum));
            System.out.println("Level: " + Integer.toString(levelNum) + " Question: " + Integer.toString(qNum));
          }
        });
      }
      levels.getItems().add(levelItems.get(i));
      levelQuestions.add(questions);
    }
    menuBar.getMenus().add(levels);


    VBox vBox = new VBox(menuBar);
    BorderPane borderLayout = new BorderPane();
    borderLayout.setTop(vBox);
    borderLayout.setCenter(presentation);

    Scene scene = new Scene(borderLayout, 960, 600);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void setSlide() {
    this.levelNum = this.iArray;
    this.qNum = this.jArray;

  }

  public ImageView confusedFace() {
    ImageView confusedFace = new ImageView(new Image("file:../resources/confused.png"));
    confusedFace.setFitWidth(15);
    confusedFace.setFitHeight(15);
    return confusedFace;
  }

    public ImageView smilingFace() {
    ImageView smilingFace = new ImageView(new Image("file:../resources/smiling.png"));
    smilingFace.setFitWidth(15);
    smilingFace.setFitHeight(15);
    return smilingFace;
  }
}
