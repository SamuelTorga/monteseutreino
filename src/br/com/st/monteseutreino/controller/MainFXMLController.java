/*
 * TODO: 
 */
package br.com.st.monteseutreino.controller;

import br.com.st.monteseutreino.MainApp;
import br.com.st.monteseutreino.model.Exercicio;
import br.com.st.monteseutreino.model.Treino;
import br.com.st.monteseutreino.view.Dialog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.util.Callback;

/**
 *
 * @author Samuel
 */
public class MainFXMLController implements Initializable {

    private final List<Treino> listaTreino = new ArrayList<>();
    private ObservableList<Treino> listaTreinoObservavel = FXCollections.observableList(listaTreino);

    private final List<Exercicio> listaExercicio = new ArrayList<>();
    private ObservableList<Exercicio> listaExercicioObservavel;    

    @FXML
    private ListView<Exercicio> listViewExercicios;
    private List<Exercicio> lista;

    //Botoes
    @FXML
    private Button botaoCadastrarExercicio;
    @FXML
    private Button botaoEditarExercicio;
    @FXML
    private Button botaoGerarPDF;

    //Variáveis dos radio buttons
    @FXML
    private RadioButton radioButtonAparaB;
    @FXML
    private RadioButton radioButtonAparaC;
    @FXML
    private RadioButton radioButtonAparaD;
    @FXML
    private RadioButton radioButtonAparaE;
    @FXML
    private RadioButton radioButtonAparaF;

    

    @FXML
    private ImageView peitoImageView;
    @FXML
    private ImageView bicepsDireitoImageView;
    @FXML
    private ImageView ombroEsquerdoFrenteImageView;
    @FXML
    private ImageView ombroDireitoFrenteImageView;
    @FXML
    private ImageView ombroEsquerdoCostasImageView;
    @FXML
    private ImageView ombroDireitoCostasImageView;
    @FXML
    private ImageView trapezioFrenteImageView;
    @FXML
    private ImageView trapezioCostasImageView;
    @FXML
    private ImageView bicepsEsquerdoImageView;
    @FXML
    private ImageView abdomenImageView;
    @FXML
    private ImageView tricepsEsquerdoFrenteImageView;
    @FXML
    private ImageView tricepsDireitoFrenteImageView;
    @FXML
    private ImageView tricepsEsquerdoCostasImageView;
    @FXML
    private ImageView tricepsDireitoCostasImageView;
    @FXML
    private ImageView antebracoEsquerdoFrenteImageView;
    @FXML
    private ImageView antebracoDireitoFrenteImageView;
    @FXML
    private ImageView antebracoEsquerdoCostasImageView;
    @FXML
    private ImageView antebracoDireitoCostasImageView;
    @FXML
    private ImageView pernasFrenteImageView;
    @FXML
    private ImageView pernasCostasImageView;
    @FXML
    private ImageView panturrilhaFrenteImageView;
    @FXML
    private ImageView panturrilhaCostasImageView;
    @FXML
    private ImageView costasImageView;

    @FXML
    private AnchorPane anchorPaneDiaA;
    @FXML
    private AnchorPane anchorPaneDiaB;
    @FXML
    private AnchorPane anchorPaneDiaC;
    @FXML
    private AnchorPane anchorPaneDiaD;
    @FXML
    private AnchorPane anchorPaneDiaE;
    @FXML
    private AnchorPane anchorPaneDiaF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listViewExercicios.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listViewExercicios.getSelectionModel().selectFirst();
        inicializarBotoes();

        listaExercicio.add(new Exercicio("Supino", "Peito"));
        listaExercicio.add(new Exercicio("Testa", "Tríceps"));
        listaExercicioObservavel = FXCollections.observableArrayList(listaExercicio);

        listViewExercicios.setItems(listaExercicioObservavel);

        listaExercicio.add(new Exercicio("Flexão", "Peito"));
        
        listViewExercicios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Exercicio>() {

            @Override
            public void changed(ObservableValue<? extends Exercicio> observable, Exercicio oldValue, final Exercicio newValue) {
                listViewExercicios.setCellFactory(new Callback<ListView<Exercicio>, ListCell<Exercicio>>() {

                    @Override
                    public ListCell<Exercicio> call(ListView<Exercicio> param) {
                        return new ListViewCell(newValue);
                    }
                });
            }
        });

    }

    private void inicializarBotoes() {
        botaoCadastrarExercicio.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Dialog dialog = new Dialog(MainApp.TELA_CADASTRAR_EXERCICIO, MainApp.getPrimaryStage(), "Cadastrar exercício");

            }
        });

        botaoEditarExercicio.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Dialog dialog = new Dialog(MainApp.TELA_EDITAR_EXERCICIO, MainApp.getPrimaryStage(), "Editar/Remover exercício");
            }
        });

        botaoGerarPDF.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Dialog dialog = new Dialog(MainApp.TELA_GERAR_PDF, MainApp.getPrimaryStage(), "Gerar PDF");
            }
        });
    }
    
    

    

    private class ListViewCell extends ListCell<Exercicio> {

        ContextMenu contextMenuAdicionar;
        MenuItem menuItemAdicionarContextMenu;

        private ListViewCell(final Exercicio exercicio) {
            menuItemAdicionarContextMenu = new MenuItem("Adicionar");
            menuItemAdicionarContextMenu.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    Treino treino = new Treino(exercicio);
//                    tabelaTreinoDiaA.getItems().add(treino);
                }
            });
            this.contextMenuAdicionar = new ContextMenu(menuItemAdicionarContextMenu);
        }

        @Override
        protected void updateItem(Exercicio item, boolean empty) {
            super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.

            if (empty) {
                setText(null);
            } else if (item instanceof Exercicio) {
                setText(item.getNome());
                setContextMenu(contextMenuAdicionar);
            } else {
                setText(item == null ? "null" : item.getNome());
            }
        }

    }

    @FXML
    private void mouseInOmbro(MouseEvent me) {

        ombroEsquerdoFrenteImageView.getStyleClass().add("image");
        ombroDireitoFrenteImageView.getStyleClass().add("image");
        ombroEsquerdoCostasImageView.getStyleClass().add("image");
        ombroDireitoCostasImageView.getStyleClass().add("image");
    }

    @FXML
    private void mouseOutOmbro(MouseEvent me) {

        ombroEsquerdoFrenteImageView.getStyleClass().clear();
        ombroDireitoFrenteImageView.getStyleClass().clear();
        ombroEsquerdoCostasImageView.getStyleClass().clear();
        ombroDireitoCostasImageView.getStyleClass().clear();
    }

    @FXML
    private void mouseInPeito(MouseEvent me) {
        peitoImageView.getStyleClass().add("image");
    }

    @FXML
    private void mouseOutPeito(MouseEvent me) {
        peitoImageView.getStyleClass().clear();
    }

    @FXML
    private void mouseInCostas(MouseEvent me) {
        costasImageView.getStyleClass().add("image");
    }

    @FXML
    private void mouseOutCostas(MouseEvent me) {
        costasImageView.getStyleClass().clear();
    }

    @FXML
    private void mouseInBiceps(MouseEvent me) {
        bicepsEsquerdoImageView.getStyleClass().add("image");
        bicepsDireitoImageView.getStyleClass().add("image");
    }

    @FXML
    private void mouseOutBiceps(MouseEvent me) {
        bicepsEsquerdoImageView.getStyleClass().clear();
        bicepsDireitoImageView.getStyleClass().clear();
    }

    @FXML
    private void mouseInTriceps(MouseEvent me) {
        tricepsDireitoCostasImageView.getStyleClass().add("image");
        tricepsDireitoFrenteImageView.getStyleClass().add("image");
        tricepsEsquerdoCostasImageView.getStyleClass().add("image");
        tricepsEsquerdoFrenteImageView.getStyleClass().add("image");
    }

    @FXML
    private void mouseOutTriceps(MouseEvent me) {
        tricepsDireitoCostasImageView.getStyleClass().clear();
        tricepsDireitoFrenteImageView.getStyleClass().clear();
        tricepsEsquerdoCostasImageView.getStyleClass().clear();
        tricepsEsquerdoFrenteImageView.getStyleClass().clear();
    }

    @FXML
    private void mouseInPernas(MouseEvent me) {
        pernasCostasImageView.getStyleClass().add("image");
        pernasFrenteImageView.getStyleClass().add("image");
    }

    @FXML
    private void mouseOutPernas(MouseEvent me) {
        pernasCostasImageView.getStyleClass().clear();
        pernasFrenteImageView.getStyleClass().clear();
    }

    @FXML
    private void mouseInPanturrilhas(MouseEvent me) {
        panturrilhaCostasImageView.getStyleClass().add("image");
        panturrilhaFrenteImageView.getStyleClass().add("image");
    }

    @FXML
    private void mouseOutPanturrilhas(MouseEvent me) {
        panturrilhaCostasImageView.getStyleClass().clear();
        panturrilhaFrenteImageView.getStyleClass().clear();
    }

    @FXML
    private void mouseInTrapezio(MouseEvent me) {
        trapezioFrenteImageView.getStyleClass().add("image");
        trapezioCostasImageView.getStyleClass().add("image");
    }

    @FXML
    private void mouseOutTrapezio(MouseEvent me) {
        trapezioFrenteImageView.getStyleClass().clear();
        trapezioCostasImageView.getStyleClass().clear();
    }

    @FXML
    private void mouseInAbdomen(MouseEvent me) {
        abdomenImageView.getStyleClass().add("image");
    }

    @FXML
    private void mouseOutAbdomen(MouseEvent me) {
        abdomenImageView.getStyleClass().clear();
    }

    @FXML
    private void mouseInAntebraco(MouseEvent me) {
        antebracoDireitoFrenteImageView.getStyleClass().add("image");
        antebracoEsquerdoFrenteImageView.getStyleClass().add("image");
        antebracoDireitoCostasImageView.getStyleClass().add("image");
        antebracoEsquerdoCostasImageView.getStyleClass().add("image");
    }

    @FXML
    private void mouseOutAntebraco(MouseEvent me) {
        antebracoDireitoFrenteImageView.getStyleClass().clear();
        antebracoEsquerdoFrenteImageView.getStyleClass().clear();
        antebracoDireitoCostasImageView.getStyleClass().clear();
        antebracoEsquerdoCostasImageView.getStyleClass().clear();
        
        
    }
    
    
}