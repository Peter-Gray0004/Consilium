import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

public class CalendarScene {
    private final Scene scene;

    public CalendarScene(Stage stage) {
        BorderPane borderPane = new BorderPane();

        // Creates the items for the top interface IE: Name, Weather, Time.
        HBox topMenu =  topMenuContent();
        borderPane.setTop(topMenu);
    
        scene = new Scene(borderPane, 400, 300);
    }

    private HBox topMenuContent() {
        // Welcome part of the top menu
        HBox topMenu = new HBox(20);

        VBox welcomeBox = new VBox(10);
        topMenu.getChildren().add(welcomeBox);
        
        Label WelcomeLabel = new Label("Welcome: ");
        welcomeBox.getChildren().add(WelcomeLabel);

        
        // Weather part of the top menu
        VBox weatherBox = new VBox(10);
        topMenu.getChildren().add(weatherBox);

        Label weatherLabel = new Label("Weather");
        weatherBox.getChildren().add(weatherLabel);

        //Time and date part of the top menu
        VBox timeDateBox = new VBox(5);
        topMenu.getChildren().add(timeDateBox);

        //Gets the time and date labels
        Pair<Label, Label> timeDateLabels = TopBarUtils.timeAndDate();

        //Time
        Label timeLabel = timeDateLabels.getKey();
        timeDateBox.getChildren().add(timeLabel);

        //Date
        Label dateLabel = timeDateLabels.getValue();
        timeDateBox.getChildren().add(dateLabel);

        return topMenu;
    }
    
    public Scene getScene() {
        return scene;
    }
}
