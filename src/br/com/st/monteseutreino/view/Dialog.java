/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.st.monteseutreino.view;

import br.com.st.monteseutreino.MainApp;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Samuel
 */
public class Dialog {

    public Dialog(String fxml, Window parent,String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Scene scene = new Scene(root);
            final Stage dialog = new Stage();
            dialog.setResizable(false);
            dialog.setTitle(title);
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.initOwner(parent);
            dialog.setScene(scene);
            dialog.getIcons().add(new Image(MainApp.LOCAL_ICONE));
            dialog.show();
        } catch (IOException ex) {
            Logger.getLogger(Dialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}