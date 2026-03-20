import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        
        CalendarScene calendarScene = new CalendarScene(stage);
        stage.setScene(calendarScene.getScene());
        
        stage.setTitle("Consilium");
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }


}

