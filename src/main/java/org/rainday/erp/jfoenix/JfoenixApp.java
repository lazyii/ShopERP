package org.rainday.erp.jfoenix;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by admin on 2021/3/14 13:50:12.
 */
public class JfoenixApp extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url2 = JfoenixApp.class.getResource("/Popup.fxml");
        URL url3 = JfoenixApp.class.getClassLoader().getResource("Popup.fxml");
        
        System.out.println(url2);
        System.out.println(url3);
        
    
    
        Parent root = FXMLLoader.load(getClass().getResource("Popup.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
