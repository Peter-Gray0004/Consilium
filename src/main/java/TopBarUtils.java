import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.Label;
import javafx.util.Pair;

public class TopBarUtils {

    

    public static Pair<Label, Label> timeAndDate() {
        
        Label timeLabel = updateTime();
        Label dateLabel = updateDate();

        return new Pair<>(timeLabel, dateLabel);
    }


    private static Label updateTime() {
        Boolean is24HourFormat = true;
        //Get current time
        LocalTime currentTime = LocalTime.now();

        //Formats time
        DateTimeFormatter timeFormatter;
        if (is24HourFormat == false) {
            //12H
            timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
           
        } 
        else {
            //24H
            timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        }

        Label timeLabel = new Label("Time - " + currentTime.format(timeFormatter));
        return timeLabel;
    }

    private static Label updateDate() {
        boolean monthDayYearFormat = false;
        //Get current date
        LocalDate currentDate = LocalDate.now();
        Label dateLabel = new Label("Date - " + currentDate);

        //Formats date
        DateTimeFormatter dateFormatter;
        if (monthDayYearFormat == false) {
            //Day month
            dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        }

        else {
            //Month day
            dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        }

        dateLabel.setText("Date - " + currentDate.format(dateFormatter));

        return dateLabel;
    }
}