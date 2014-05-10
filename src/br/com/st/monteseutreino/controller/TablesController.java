/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.st.monteseutreino.controller;

import br.com.st.monteseutreino.model.Exercicio;
import br.com.st.monteseutreino.model.Treino;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Samuel
 */
public class TablesController implements Initializable {
    
    @FXML
    private TableView tabelaTreinoDiaA;
    @FXML
    private TableView tabelaTreinoDiaB;
    @FXML
    private TableView tabelaTreinoDiaC;
    @FXML
    private TableView tabelaTreinoDiaD;
    @FXML
    private TableView tabelaTreinoDiaE;
    @FXML
    private TableView tabelaTreinoDiaF;
    
    //Colunas
    @FXML
    private TableColumn colunaOrdemTabelaDiaA;
    @FXML
    private TableColumn colunaOrdemTabelaDiaB;
    @FXML
    private TableColumn colunaOrdemTabelaDiaC;
    @FXML
    private TableColumn colunaOrdemTabelaDiaD;
    @FXML
    private TableColumn colunaOrdemTabelaDiaE;
    @FXML
    private TableColumn colunaOrdemTabelaDiaF;

    @FXML
    private TableColumn colunaNomeExercicioTabelaDiaA;
    @FXML
    private TableColumn colunaNomeExercicioTabelaDiaB;
    @FXML
    private TableColumn colunaNomeExercicioTabelaDiaC;
    @FXML
    private TableColumn colunaNomeExercicioTabelaDiaD;
    @FXML
    private TableColumn colunaNomeExercicioTabelaDiaE;
    @FXML
    private TableColumn colunaNomeExercicioTabelaDiaF;

    @FXML
    private TableColumn colunaGrupoMuscularTabelaDiaA;
    @FXML
    private TableColumn colunaGrupoMuscularTabelaDiaB;
    @FXML
    private TableColumn colunaGrupoMuscularTabelaDiaC;
    @FXML
    private TableColumn colunaGrupoMuscularTabelaDiaD;
    @FXML
    private TableColumn colunaGrupoMuscularTabelaDiaE;
    @FXML
    private TableColumn colunaGrupoMuscularTabelaDiaF;

    @FXML
    private TableColumn colunaRepeticoesTabelaDiaA;
    @FXML
    private TableColumn colunaRepeticoesTabelaDiaB;
    @FXML
    private TableColumn colunaRepeticoesTabelaDiaC;
    @FXML
    private TableColumn colunaRepeticoesTabelaDiaD;
    @FXML
    private TableColumn colunaRepeticoesTabelaDiaE;
    @FXML
    private TableColumn colunaRepeticoesTabelaDiaF;

    @FXML
    private TableColumn colunaSeriesTabelaDiaA;
    @FXML
    private TableColumn colunaSeriesTabelaDiaB;
    @FXML
    private TableColumn colunaSeriesTabelaDiaC;
    @FXML
    private TableColumn colunaSeriesTabelaDiaD;
    @FXML
    private TableColumn colunaSeriesTabelaDiaE;
    @FXML
    private TableColumn colunaSeriesTabelaDiaF;

    @FXML
    private TableColumn colunaObservacoesTabelaDiaA;
    @FXML
    private TableColumn colunaObservacoesTabelaDiaB;
    @FXML
    private TableColumn colunaObservacoesTabelaDiaC;
    @FXML
    private TableColumn colunaObservacoesTabelaDiaD;
    @FXML
    private TableColumn colunaObservacoesTabelaDiaE;
    @FXML
    private TableColumn colunaObservacoesTabelaDiaF;
    
    //Variáveis das abas dos dias de treino
    @FXML
    private Tab abaA;
    @FXML
    private Tab abaB;
    @FXML
    private Tab abaC;
    @FXML
    private Tab abaD;
    @FXML
    private Tab abaE;
    @FXML
    private Tab abaF;
    
    private ListView<Exercicio> listViewExercicios;
    private RadioButton radioButtonAparaB;
    private RadioButton radioButtonAparaC;
    private RadioButton radioButtonAparaD;
    private RadioButton radioButtonAparaE;
    private RadioButton radioButtonAparaF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        inicializarTabelas();
        
        tabelaTreinoDiaA.setRowFactory(new Callback<TableView<Treino>, TableRow<Treino>>() {

            @Override
            public TableRow<Treino> call(TableView<Treino> param) {
                final TableRow<Treino> row = new TableRow<>();
                final ContextMenu contextMenu = new ContextMenu();
                final MenuItem menuItem = new MenuItem("Remover");
                menuItem.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        tabelaTreinoDiaA.getItems().remove(row.getItem());
                    }
                });
                contextMenu.getItems().add(menuItem);
                row.contextMenuProperty().bind(
                        Bindings.when(row.emptyProperty())
                                .then((ContextMenu)null)
                                .otherwise(contextMenu)
                );
                return row;
            }
        });
    }
    
    private void inicializarColunas() {
        colunaOrdemTabelaDiaA.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Treino, Integer>, ObservableValue<Integer>>() {

            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Treino, Integer> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getOrdem());
            }
        });

        colunaNomeExercicioTabelaDiaA.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Treino, Exercicio>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Treino, Exercicio> p) {
                return new ReadOnlyObjectWrapper<>(p.getValue().getExercicio().getNome());
            }

        });

        colunaGrupoMuscularTabelaDiaA.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Treino, Exercicio>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Treino, Exercicio> p) {
                return new ReadOnlyObjectWrapper<>(p.getValue().getExercicio().getGrupoMuscular());
            }

        });

        colunaRepeticoesTabelaDiaA.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Treino, Integer>, ObservableValue<Integer>>() {

            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Treino, Integer> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getRepeticoes());
            }
        });

        colunaSeriesTabelaDiaA.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Treino, Integer>, ObservableValue<Integer>>() {

            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Treino, Integer> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSeries());
            }
        });

        colunaObservacoesTabelaDiaA.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Treino, Exercicio>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Treino, Exercicio> p) {
                return new ReadOnlyObjectWrapper<>(p.getValue().getObservacoes());
            }

        });

    }
    
    private void inicializarTabelas() {
        inicializarColunas();
    }

    

    private void atualizarTabelas() {
//        listaTreinoObservavel.setAll(listaTreino);
//        tabelaTreinoDiaA.setItems(listaTreinoObservavel);
    }
    
    private void inicializarEventosTabelaDiaA() {

        listViewExercicios.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                System.out.println("setOnDragDetected");

                Dragboard dragBoard = listViewExercicios.startDragAndDrop(TransferMode.MOVE);

                ClipboardContent content = new ClipboardContent();

                content.putString(listViewExercicios.getSelectionModel().getSelectedItem().getNome() + "#" + listViewExercicios.getSelectionModel().getSelectedItem().getGrupoMuscular());

                dragBoard.setContent(content);
            }
        });

        tabelaTreinoDiaA.setOnDragOver(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != tabelaTreinoDiaA && event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
        });

        tabelaTreinoDiaA.setOnDragEntered(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != tabelaTreinoDiaA && event.getDragboard().hasString()) {
                    //Colorir tabela
                    tabelaTreinoDiaA.setBlendMode(BlendMode.DIFFERENCE);
                }

                event.consume();
            }
        });

        tabelaTreinoDiaA.setOnDragExited(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent t) {
                tabelaTreinoDiaA.setBlendMode(null);
            }
        });

        tabelaTreinoDiaA.setOnDragDropped(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                /* data dropped */
                System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    String nomeExercicio = db.getString().split("#")[0];
                    System.out.println("Nome Exercício: " + nomeExercicio);
                    String grupoMuscular = db.getString().split("#")[1];
                    System.out.println("Grupo Muscular: " + grupoMuscular);
                    Exercicio exercicio = new Exercicio();
                    exercicio.setNome(nomeExercicio);
                    exercicio.setGrupoMuscular(grupoMuscular);

                    System.out.println("Exercício criado: " + exercicio.getNome() + " " + exercicio.getGrupoMuscular());

                    Treino treino = new Treino();
                    treino.setOrdem(1);
                    treino.setExercicio(exercicio);
                    treino.setRepeticoes(1);
                    treino.setSeries(1);
                    treino.setDiaTreino("A");
                    treino.setObservacoes("OBSERVAÇÕES");

                    System.out.println("Treino criado: " + treino.getOrdem() + " " + treino.getExercicio().getNome() + " "
                            + treino.getExercicio().getGrupoMuscular() + " " + treino.getRepeticoes() + " " + treino.getSeries() + " "
                            + treino.getDiaTreino() + " " + treino.getObservacoes());

//                    listaTreinoObservavel.add(treino);
//                    tabelaTreinoDiaA.setItems(listaTreinoObservavel);

                    success = true;
                }
                /* let the source know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);

                event.consume();
            }
        });

        listViewExercicios.setOnDragDone(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    //source.setText("");
                }

                event.consume();
            }
        });
    }

    private void inicializarEventosTabelaDiaB() {
        tabelaTreinoDiaB.setOnDragOver(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != tabelaTreinoDiaB && event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
        });

        tabelaTreinoDiaB.setOnDragEntered(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != tabelaTreinoDiaB && event.getDragboard().hasString()) {
                    //Colorir tabela
                    //tabelaTreinoDiaB.setFill(Color.GREEN);
                }

                event.consume();
            }
        });

        tabelaTreinoDiaB.setOnDragExited(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent t) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        tabelaTreinoDiaB.setOnDragDropped(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                /* data dropped */
                System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    //target.setText(db.getString());
                    success = true;
                }
                /* let the source know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);

                event.consume();
            }
        });

        listViewExercicios.setOnDragDone(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    //source.setText("");
                }

                event.consume();
            }
        });
    }

    private void inicializarEventosTabelaDiaC() {
        tabelaTreinoDiaC.setOnDragOver(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != tabelaTreinoDiaC && event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
        });

        tabelaTreinoDiaC.setOnDragEntered(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != tabelaTreinoDiaC && event.getDragboard().hasString()) {
                    //Colorir tabela
                    //tabelaTreinoDiaC.setFill(Color.GREEN);
                }

                event.consume();
            }
        });

        tabelaTreinoDiaC.setOnDragExited(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent t) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        tabelaTreinoDiaC.setOnDragDropped(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                /* data dropped */
                System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    //target.setText(db.getString());
                    success = true;
                }
                /* let the source know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);

                event.consume();
            }
        });

        listViewExercicios.setOnDragDone(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    //source.setText("");
                }

                event.consume();
            }
        });
    }

    private void inicializarEventosTabelaDiaD() {
        tabelaTreinoDiaD.setOnDragOver(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != tabelaTreinoDiaD && event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
        });

        tabelaTreinoDiaD.setOnDragEntered(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != tabelaTreinoDiaD && event.getDragboard().hasString()) {
                    //Colorir tabela
                    //tabelaTreinoDiaD.setFill(Color.GREEN);
                }

                event.consume();
            }
        });

        tabelaTreinoDiaD.setOnDragExited(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent t) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        tabelaTreinoDiaD.setOnDragDropped(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                /* data dropped */
                System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    //target.setText(db.getString());
                    success = true;
                }
                /* let the source know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);

                event.consume();
            }
        });

        listViewExercicios.setOnDragDone(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    //source.setText("");
                }

                event.consume();
            }
        });
    }

    private void inicializarEventosTabelaDiaE() {
        tabelaTreinoDiaE.setOnDragOver(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != tabelaTreinoDiaE && event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
        });

        tabelaTreinoDiaE.setOnDragEntered(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != tabelaTreinoDiaE && event.getDragboard().hasString()) {
                    //Colorir tabela
                    //tabelaTreinoDiaE.setFill(Color.GREEN);
                }

                event.consume();
            }
        });

        tabelaTreinoDiaE.setOnDragExited(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent t) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        tabelaTreinoDiaE.setOnDragDropped(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                /* data dropped */
                System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    //target.setText(db.getString());
                    success = true;
                }
                /* let the source know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);

                event.consume();
            }
        });

        listViewExercicios.setOnDragDone(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    //source.setText("");
                }

                event.consume();
            }
        });
    }

    private void inicializarEventosTabelaDiaF() {
        tabelaTreinoDiaF.setOnDragOver(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != tabelaTreinoDiaF && event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
        });

        tabelaTreinoDiaF.setOnDragEntered(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != tabelaTreinoDiaF && event.getDragboard().hasString()) {
                    //Colorir tabela
                    //tabelaTreinoDiaF.setFill(Color.GREEN);
                }

                event.consume();
            }
        });

        tabelaTreinoDiaF.setOnDragExited(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent t) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        tabelaTreinoDiaF.setOnDragDropped(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                /* data dropped */
                System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    //target.setText(db.getString());
                    success = true;
                }
                /* let the source know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);

                event.consume();
            }
        });

        listViewExercicios.setOnDragDone(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    //source.setText("");
                }

                event.consume();
            }
        });
    }
    
    private void inicializarDragAndDropListaExercicios() {
        inicializarEventosTabelaDiaA();
        inicializarEventosTabelaDiaB();
        inicializarEventosTabelaDiaC();
        inicializarEventosTabelaDiaD();
        inicializarEventosTabelaDiaE();
        inicializarEventosTabelaDiaF();
    }
    
    private static class TableRowContextMenu extends TableRow<Treino> {

        ContextMenu contextMenuAdicionar;
        MenuItem menuItemAdicionarContextMenu;

        public TableRowContextMenu() {

            System.out.println("Entrou em TableRowContextMenu");

            menuItemAdicionarContextMenu = new MenuItem("Adicionar");
            menuItemAdicionarContextMenu.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    System.out.println("ADICIONOUUU!");
                }
            });
            this.contextMenuAdicionar = new ContextMenu(menuItemAdicionarContextMenu);
        }

        @Override
        protected void updateItem(Treino item, boolean empty) {
            System.out.println("Entrou em updateItem");
            super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.

            if (item == null) {
                setTooltip(null);
            } else {
                setContextMenu(contextMenuAdicionar);
            }
        }

    }
    
    private void inicializarEventosRadioButton() {
        radioButtonAparaB.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                abaA.setDisable(false);
                abaB.setDisable(false);
                abaC.setDisable(true);
                abaD.setDisable(true);
                abaE.setDisable(true);
                abaF.setDisable(true);

                tabelaTreinoDiaA.setDisable(false);
                tabelaTreinoDiaB.setDisable(false);
                tabelaTreinoDiaC.setDisable(true);
                tabelaTreinoDiaD.setDisable(true);
                tabelaTreinoDiaE.setDisable(true);
                tabelaTreinoDiaF.setDisable(true);
            }
        });

        radioButtonAparaC.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                abaA.setDisable(false);
                abaB.setDisable(false);
                abaC.setDisable(false);
                abaD.setDisable(true);
                abaE.setDisable(true);
                abaF.setDisable(true);

                tabelaTreinoDiaA.setDisable(false);
                tabelaTreinoDiaB.setDisable(false);
                tabelaTreinoDiaC.setDisable(false);
                tabelaTreinoDiaD.setDisable(true);
                tabelaTreinoDiaE.setDisable(true);
                tabelaTreinoDiaF.setDisable(true);
            }
        });

        radioButtonAparaD.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                abaA.setDisable(false);
                abaB.setDisable(false);
                abaC.setDisable(false);
                abaD.setDisable(false);
                abaE.setDisable(true);
                abaF.setDisable(true);

                tabelaTreinoDiaA.setDisable(false);
                tabelaTreinoDiaB.setDisable(false);
                tabelaTreinoDiaC.setDisable(false);
                tabelaTreinoDiaD.setDisable(false);
                tabelaTreinoDiaE.setDisable(true);
                tabelaTreinoDiaF.setDisable(true);
            }
        });

        radioButtonAparaE.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                abaA.setDisable(false);
                abaB.setDisable(false);
                abaC.setDisable(false);
                abaD.setDisable(false);
                abaE.setDisable(false);
                abaF.setDisable(true);

                tabelaTreinoDiaA.setDisable(false);
                tabelaTreinoDiaB.setDisable(false);
                tabelaTreinoDiaC.setDisable(false);
                tabelaTreinoDiaD.setDisable(false);
                tabelaTreinoDiaE.setDisable(false);
                tabelaTreinoDiaF.setDisable(true);
            }
        });

        radioButtonAparaF.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                abaA.setDisable(false);
                abaB.setDisable(false);
                abaC.setDisable(false);
                abaD.setDisable(false);
                abaE.setDisable(false);
                abaF.setDisable(false);

                tabelaTreinoDiaA.setDisable(false);
                tabelaTreinoDiaB.setDisable(false);
                tabelaTreinoDiaC.setDisable(false);
                tabelaTreinoDiaD.setDisable(false);
                tabelaTreinoDiaE.setDisable(false);
                tabelaTreinoDiaF.setDisable(false);
            }
        });

    }
}
