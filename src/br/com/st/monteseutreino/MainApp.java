/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.st.monteseutreino;

import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Samuel
 */
public class MainApp extends Application {

    private static Stage primaryStage;

    public static final String TELA_PRINCIPAL_NOTEBOOK = "/br/com/st/monteseutreino/view/TelaPrincipal_Notebook.fxml";
    public static final String TELA_PRINCIPAL_1920X1080 = "/br/com/st/monteseutreino/view/TelaPrincipal_1920X1080.fxml";
    public static final String TELA_CADASTRAR_EXERCICIO = "/br/com/st/monteseutreino/view/CadastrarExercicio.fxml";
    public static final String TELA_EDITAR_EXERCICIO = "/br/com/st/monteseutreino/view/EditarExercicio.fxml";
    public static final String TELA_CARREGAR_BANCO = "/br/com/st/monteseutreino/view/EditarExercicio.fxml";
    public static final String TELA_GERAR_PDF = "/br/com/st/monteseutreino/view/GerarPDF.fxml";
    
    public static final String LOCAL_ICONE = "/resources/bitmap.png";

    @Override
    public void start(Stage stage) throws Exception {
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource(TELA_PRINCIPAL_NOTEBOOK));
//        if (width < 1900 || height < 1000) {
//            root = FXMLLoader.load(getClass().getResource(TELA_PRINCIPAL_NOTEBOOK));
//            System.out.println("Notebook");
//        } else {
//            root = FXMLLoader.load(getClass().getResource(TELA_PRINCIPAL_1920X1080));
//            System.out.println("1920");
//        }        
        
        Scene scene = new Scene(root);

        setPrimaryStage(stage);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.setTitle("Monte seu treino");
        
        stage.getIcons().add(new Image(LOCAL_ICONE));

        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static void setPrimaryStage(Stage stage) {
        MainApp.primaryStage = stage;
    }

    public static Stage getPrimaryStage() {
        return MainApp.primaryStage;
    }
}
