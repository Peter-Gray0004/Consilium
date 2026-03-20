
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TopBar {

        private final SchedulerService scheduler = new SchedulerService();

    public HBox topMenuContent() {
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

        

        //Time
        Label timeLabel = new Label();
        timeLabel.textProperty().bind(scheduler.timeProperty());
        timeDateBox.getChildren().add(timeLabel);

        //Date
        Label dateLabel = new Label();
        dateLabel.textProperty().bind(scheduler.dateProperty());
        timeDateBox.getChildren().add(dateLabel);

        return topMenu;
    }
}
