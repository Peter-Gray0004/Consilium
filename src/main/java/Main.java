import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        
        CalendarScene calendarScene = new CalendarScene(stage);
        stage.setScene(calendarScene.getScene());
        stage.getScene().getStylesheets().add(getClass().getResource("/styles/global.css").toExternalForm());
        stage.setTitle("Consilium");
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }


}

