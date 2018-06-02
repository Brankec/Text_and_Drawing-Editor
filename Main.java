import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Globals global;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        global.primaryStage = primaryStage;
        global.primaryStage.setTitle("TEditor");
        global.primaryStage.setResizable(false);
        Parent fxml_Txteditor = FXMLLoader.load(getClass().getResource("TextEditor.fxml"));
        Parent fxml_Draweditor = FXMLLoader.load(getClass().getResource("DrawEditor.fxml"));
        global.text = new Scene(fxml_Txteditor, 1920/2.5, 1080/2.5);
        global.draw = new Scene(fxml_Draweditor, 1920/2.5, 1080/2.5);


        global.primaryStage.setScene(global.text);
        global.primaryStage.show();
    }

}
