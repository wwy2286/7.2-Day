import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by William Yu on 4/26/2017<br>
 * Email: wwy2286@gmail.com<br>
 * Purpose: To create a class Day with different methods and a Driver class to run it.<br>
 */
public class DayDriver extends Application {

    public void start(Stage primaryStage) {
        ObservableList<String> day =
                FXCollections.observableArrayList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
        ComboBox dateComboBox = new ComboBox(day);
        Label outputSetDay = new Label();
        Label outputAddDay = new Label();
        Label output = new Label();
        TextField inputAddDay = new TextField("Enter Number");
        GridPane pane = new GridPane();
        Day dayOfWeek = new Day(1);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25,25,25,25));
        pane.add(dateComboBox, 1, 1);
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        Button nextDay = new Button("Next Day");
        Button previousDay = new Button("Previous Day");
        Button addDay = new Button("Add Day");
        pane.add(outputSetDay,1,2);
        pane.add(nextDay,2,1);
        pane.add(previousDay,2,2);
        pane.add(output,1,3);
        pane.add(new Label("Enter a number to add to the day"),1,4,3,1);
        pane.add(inputAddDay,1,5,3,1);
        pane.add(addDay,1,6,3,1);
        pane.add(outputAddDay,1,7,3,1);
        nextDay.setOnAction(value ->{
            output.setText("The next day is " +dayOfWeek.nextDay());
        });
        previousDay.setOnAction(value ->{
            output.setText("The previous day is " +dayOfWeek.previousDay());
        });
        dateComboBox.setOnAction(value ->{
            dayOfWeek.setDay(day.indexOf(dateComboBox.getValue()));
            outputSetDay.setText(dayOfWeek.toString());
        });

        addDay.setOnAction(value->{
            outputAddDay.setText(dateComboBox.getValue() + " plus " + inputAddDay.getText()
                    + " day(s) is " +dayOfWeek.addDay(Integer.parseInt(inputAddDay.getText())));
        });


    }

    public static void main(String[] args) {
        launch(args);
        Day today = new Day(4);
        today.setDay(6);
        System.out.println(today.getDay());
        System.out.println(today.nextDay());
        System.out.println(today.previousDay());
        System.out.print(today.addDay(9));
    }
}
