/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.st.monteseutreino.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Samuel
 */
public class CadastrarExercicioController implements Initializable{
    
    @FXML
    private ComboBox comboBox;
    
     /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> options = FXCollections.observableArrayList("Peito","Costas","Ombro","Pernas","Panturrilha","Bíceps","Tríceps","Antebraço","Trapézio");
        comboBox.setItems(options);
    } 
    
}
