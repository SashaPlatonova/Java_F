package lesson4;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ChatController implements Initializable{
    public TextField output;
    public TextField input;

    public void send(ActionEvent actionEvent) {
        output.appendText(input.getText() + "\n");
        input.clear();
    }

    public void quit(ActionEvent actionEvent) throws IOException {
        Parent chat = FXMLLoader.load(getClass().getResource("auth.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Регистрация");
        stage.setScene(new Scene(chat));
        stage.setResizable(false);
        stage.show();
        input.getScene().getWindow().hide();
        FileHistoryService.getInstance().save(
                Arrays.asList(output.getText().split("\n").clone()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FileHistoryService.getInstance().load().forEach(historyLine -> {
            output.appendText(historyLine + "\n");
        });
    }
}
