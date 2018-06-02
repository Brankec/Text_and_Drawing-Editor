import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.File;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControllerDraw {
    Globals global;
    public Button TextBtn, DrawBtn;
    public Canvas canvas;
    public BorderPane borderpane;

    public void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        canvas.setOnMouseDragged(e -> {
            double size = 20;
            double x = e.getX() - size/2;
            double y = e.getY() - size/2;

                MouseButton button = e.getButton();
                if(button==MouseButton.PRIMARY){
                    gc.setFill(Color.color(1,0,0));
                    gc.fillRect(x, y, size, size);
                }else if(button==MouseButton.SECONDARY) {
                    gc.clearRect(x, y, size, size);
                }
            });
        }

    public void OnButtonClickText(){
        global.primaryStage.setScene(global.text);
    }


    public void OnItemSave() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        Image snapshot = canvas.snapshot(null, null);

        File file = fileChooser.showSaveDialog(global.primaryStage);
        if (file != null) {
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file);
            } catch (IOException ex) {
                Logger.getLogger(
                        ControllerDraw.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}