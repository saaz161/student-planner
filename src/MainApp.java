import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a label to display in the window
        Label label = new Label("Enter a task:");

        // Create a TextField for task input
        TextField taskInput = new TextField();

        // Create a button to add the task
        Button addButton = new Button("Add Task");

        // Create a listView to add the task into a list
        ListView<String> taskList = new ListView<>();

        // Create a layout and add the components to it
        VBox layout = new VBox(10); // 10 pixels spacing between elements
        layout.getChildren().addAll(label, taskInput, addButton, taskList);

        // Set up the event handler for the button
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String task = taskInput.getText(); // Get text from TextField
                if (!task.isEmpty()) { // Check if the input is not empty
                    taskList.getItems().add(task); // Add task to ListView
                    taskInput.clear(); // Clear the TextField
                }
            }
        });

        // Create a scene with the layout, set its size
        Scene scene = new Scene(layout, 300, 200);

        // Set the scene on the primary stage and show it
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Planner");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
