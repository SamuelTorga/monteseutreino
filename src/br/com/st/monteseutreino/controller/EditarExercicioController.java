/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.st.monteseutreino.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Samuel
 */
public class EditarExercicioController implements Initializable {
    
    @FXML
    private Pane paneTabela;
    @FXML
    private Button botaoCancelar;
    @FXML
    private Button botaoConfirmar;
    @FXML
    private AnchorPane anchorPanePrincipal;
        
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        botaoCancelar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Stage stage = (Stage) botaoCancelar.getScene().getWindow();
                stage.close();
            }
        });
        
        botaoConfirmar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Stage stage = (Stage) botaoConfirmar.getScene().getWindow();
                stage.close();
            }
        });
    }    
    
}
