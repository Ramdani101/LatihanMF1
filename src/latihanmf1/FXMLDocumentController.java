/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package latihanmf1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author Ramdani
 */
public class FXMLDocumentController implements Initializable {
    
    LatihanMF1Model dt = new LatihanMF1Model();
    
    @FXML
    private Label label;
    @FXML
    private Button btnhitung;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnkeluar;
    @FXML
    private TextField txtpembeli;
    @FXML
    private ChoiceBox<String> chbjenis;
    @FXML
    private RadioButton rdbbiasa;
    @FXML
    private ToggleGroup kualitasmabel;
    @FXML
    private RadioButton rdbmewah;
    @FXML
    private TextField txtkuantitas;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chbjenis.setItems(FXCollections.observableArrayList("Lemari", "Meja", "Kursi"));
        chbjenis.getSelectionModel().select(0);
    }    

    @FXML
    private void hitungklik(ActionEvent event) {
        dt.setPembeli(txtpembeli.getText());
        dt.setKuantitas(Integer.parseInt(txtkuantitas.getText()));
        dt.setJenis(chbjenis.getSelectionModel().getSelectedIndex());
        dt.setBiasa(rdbbiasa.isSelected());
        dt.setMewah(rdbmewah.isSelected());
        try{  FXMLLoader loader=new    
          FXMLLoader(getClass().getResource("FXML_output.fxml"));    
          Parent root = (Parent)loader.load();
          FXML_outputController isidt=     
          (FXML_outputController)loader.getController();
          isidt.getdata(dt);
          Scene scene = new Scene(root);
          Stage stg=new Stage();  
          stg.setScene(scene);
          stg.show();
          }catch (IOException e){   e.printStackTrace();}
    }

    @FXML
    private void hapusklik(ActionEvent event) {
        txtpembeli.setText("");
        txtkuantitas.setText("");
        rdbbiasa.setSelected(false);
        rdbmewah.setSelected(false);
    }

    @FXML
    private void keluarkllik(ActionEvent event) {
        System.exit(0);
    }
    
}
