package org.rainday.erp.jfoenix.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Notifications;

/**
 * Created by admin on 2021/3/14 15:00:49.
 */
public class PopupController implements Initializable {
    
    @FXML
    private Button button;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            Notifications notify = Notifications.create().title("Downloading")
                    .text("Download Started")
                    .hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);
            notify.darkStyle();
            notify.show();
        });
        
    }
}
