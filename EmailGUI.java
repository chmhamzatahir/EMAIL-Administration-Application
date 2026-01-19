package emailapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmailGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("IT Administration - New Hire Email Creator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        
        Label lblFirst = new Label("First Name:");
        GridPane.setConstraints(lblFirst, 0, 0);
        TextField txtFirst = new TextField();
        GridPane.setConstraints(txtFirst, 1, 0);
        Label lblLast = new Label("Last Name:");
        GridPane.setConstraints(lblLast, 0, 1);
        TextField txtLast = new TextField();
        GridPane.setConstraints(txtLast, 1, 1);
        Label lblDept = new Label("Department:");
        GridPane.setConstraints(lblDept, 0, 2);
        ComboBox<String> comboDept = new ComboBox<>();
        comboDept.getItems().addAll("Sales", "Development", "Accounting", "None");
        comboDept.setValue("None");
        GridPane.setConstraints(comboDept, 1, 2);
        Button btnCreate = new Button("Create Account");
        GridPane.setConstraints(btnCreate, 1, 3);
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPromptText("Account details will appear here...");
        VBox bottomLayout = new VBox(outputArea);
        bottomLayout.setPadding(new Insets(10, 20, 20, 20));
        btnCreate.setOnAction(e -> {
            if (txtFirst.getText().isEmpty() || txtLast.getText().isEmpty()) {
                outputArea.setText("Error: Please enter both First and Last names.");
            } else {
                Email emp = new Email(txtFirst.getText(), txtLast.getText(), comboDept.getValue());
                
                String result = "ACCOUNT CREATED SUCCESSFULLY\n" +
                                "------------------------------\n" +
                                "Name: " + emp.getFirstName() + " " + emp.getLastName() + "\n" +
                                "Email: " + emp.getEmail() + "\n" +
                                "Initial Password: " + emp.getPassword();
                outputArea.setText(result);
            }
        });
        VBox mainLayout = new VBox(grid, bottomLayout);
        Scene scene = new Scene(mainLayout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
