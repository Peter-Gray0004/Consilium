import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SchedulerService {
    

    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    private final StringProperty timeProperty =  new SimpleStringProperty();
    private final StringProperty dateProperty = new SimpleStringProperty();

    public SchedulerService() {
        // Schedule the updateTimeAndDate method to run every second
        startClock();
        
    }

    private void startClock() {
    executor.scheduleAtFixedRate(() -> {
        // Update the time and date properties
        
        Platform.runLater(() ->{
            timeProperty.set(TopBarUtils.updateTime().getText());
            dateProperty.set(TopBarUtils.updateDate().getText());
        });
    }, 0, 1, java.util.concurrent.TimeUnit.SECONDS);
    }
    
    public StringProperty timeProperty() {
        return timeProperty;   

    }   
    public StringProperty dateProperty() {
        return dateProperty;   

    }   

}

