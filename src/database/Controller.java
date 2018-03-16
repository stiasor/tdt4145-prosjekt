package database;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField query;

    @FXML
    private Button submitButton;

    @FXML
    public void onSubmitClick() {
        DatabaseHandler dbh = new DatabaseHandler(
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://127.0.0.1/treningsdagbok",
                "root",
                "root");
        app.setDatabaseHandler(dbh);
        System.out.println("test");
        try{
            app.testQuery(query.getText());
        } catch (Exception e){
            e.printStackTrace();
        }
}
    public Main app;
}
