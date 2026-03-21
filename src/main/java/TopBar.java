
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TopBar {

        private final SchedulerService scheduler = new SchedulerService();

    public HBox topMenuContent() {

        // Welcome part of the top menu
        HBox topMenu = new HBox(20);
        topMenu.setHgrow(topMenu, Priority.ALWAYS);
        VBox welcomeBox = new VBox(10);
        topMenu.getChildren().add(welcomeBox);
        topMenu.getStyleClass().add("top-menu");

        //Adding stylesheet
        topMenu.getStylesheets().add(getClass().getResource("/styles/topbar.css").toExternalForm());
        

        Label welcomeLabel = new Label("Welcome: ");
        welcomeBox.getChildren().add(welcomeLabel);
        welcomeLabel.getStyleClass().add("top-label");

        //First space between welcome and weather
        Pane spacer1 = new Pane();
        topMenu.getChildren().add(spacer1);
        topMenu.setHgrow(spacer1, Priority.ALWAYS);
        

        // Weather part of the top menu
        VBox weatherBox = new VBox(10);
        topMenu.getChildren().add(weatherBox);

        Label weatherLabel = new Label("Weather");
        weatherBox.getChildren().add(weatherLabel);
        weatherLabel.getStyleClass().add("top-label");

        //Second space time and date to the right of the top menu
        Pane spacer2 = new Pane();
        topMenu.getChildren().add(spacer2);
        topMenu.setHgrow(spacer2, Priority.ALWAYS);

        //Time and date part of the top menu
        VBox timeDateBox = new VBox(3);
        topMenu.getChildren().add(timeDateBox);
        
        timeDateBox.getStyleClass().add("top_label");
        
        //Time
        Label timeLabel = new Label();
        timeLabel.textProperty().bind(scheduler.timeProperty());
        timeDateBox.getChildren().add(timeLabel);
        timeLabel.getStyleClass().add("top-label-time");


        //Date
        Label dateLabel = new Label();
        dateLabel.textProperty().bind(scheduler.dateProperty());
        timeDateBox.getChildren().add(dateLabel);
        dateLabel.getStyleClass().add("top-label-date");
        


        //Font scaling for time and date labels
        Resize(topMenu, welcomeLabel, timeLabel, weatherLabel, dateLabel);



        return topMenu;
}
    private static HBox Resize(HBox topMenu, Label WelcomeLabel, Label timeLabel, Label weatherLabel, Label dateLabel) {

        Platform.runLater(() -> {
            Scene scene = topMenu.getScene();

                WelcomeLabel.styleProperty().bind(
                    scene.heightProperty().multiply(0.05).asString("-fx-font-size: %.0fpx;")
                );

                weatherLabel.styleProperty().bind(
                    scene.heightProperty().multiply(0.05).asString("-fx-font-size: %.0fpx;")
                );

                timeLabel.styleProperty().bind(
                    scene.heightProperty().multiply(0.02).asString("-fx-font-size: %.0fpx;")
                );

                dateLabel.styleProperty().bind(
                    scene.heightProperty().multiply(0.02).asString("-fx-font-size: %.0fpx;")
                );
        }); 

        return topMenu;
    }

    
}
