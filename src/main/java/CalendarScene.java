import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class CalendarScene {
    private final Scene scene;

    public CalendarScene(Stage stage) {
        BorderPane borderPane = new BorderPane();
        
        // Creates the items for the top interface IE: Name, Weather, Time.
        HBox topMenu =  new TopBar().topMenuContent();
        borderPane.setTop(topMenu);
    
        scene = new Scene(borderPane, 800, 600);


    }

    
    public Scene getScene() {
        return scene;
    }
}
