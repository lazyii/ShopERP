package org.rainday.erp.bootstrap;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.bootstrapfx.scene.layout.Panel;

/**
 * Created by admin on 2021/3/14 13:50:12.
 */
public class BootstrapFxApp extends Application {
    
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
//        HBox hBox = new HBox();
//        primaryStage.setTitle("招财猫ERP");
//        primaryStage.setScene(new Scene(hBox, 600, 400));
//        primaryStage.show();
    
        Panel panel = new Panel("This is the title");
        panel.getStyleClass().add("panel-primary");
        BorderPane content = new BorderPane();
        content.setPadding(new Insets(20));
        Button button = new Button("Hello BootstrapFX");
        button.getStyleClass().setAll("btn","btn-danger");
        content.setCenter(button);
        panel.setBody(content);
    
        Scene scene = new Scene(panel);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
    
        primaryStage.setTitle("BootstrapFX");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
