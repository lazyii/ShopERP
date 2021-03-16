/**
 * Created by admin on 2021/3/14 13:55:36.
 */
module erp.main {
    
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires org.kordamp.bootstrapfx.core;
    requires org.controlsfx.controls;
    
    opens org.rainday.erp.jfoenix.controller to javafx.fxml, javafx.graphics;
    
    
    exports org.rainday.erp.bootstrap;
    exports org.rainday.erp.jfoenix;
}
