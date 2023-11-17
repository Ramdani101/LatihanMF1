/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package latihanmf1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Ramdani
 */
public class FXML_outputController implements Initializable {

    @FXML
    private Label lblpembeli;
    @FXML
    private Label lbljenis;
    @FXML
    private Label lblpembelian;
    @FXML
    private Label lbltotalkotor;
    @FXML
    private Label lbljumlah;
    @FXML
    private Label lblharga;
    @FXML
    private Label lbldiskon;
    @FXML
    private Label lbltotalbersih;
    @FXML
    private Button btnkembali;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void kembaliklik(ActionEvent event) {
    btnkembali.getScene().getWindow().hide();;
    }
    
    public void getdata(LatihanMF1Model d){
        String jenis = "", kualitas = "";
        int hargaLemari = 0, hargaMeja = 0, hargaKursi = 0, diskon = 0;
        boolean lemari = true, meja = true, kursi = true;
        int hargaTerpilih = 0;
        
        switch(d.getJenis()){
            case 0 : jenis = "Lemari"; lemari = true; meja = false; kursi = false; break;
            case 1 : jenis = "Meja"; lemari = false; meja = true; kursi = false; break;
            case 2 : jenis = "Kursi"; lemari = false; meja = false; kursi = true; break;
            default : jenis = "tidak ada";
        }
        
        if(d.isBiasa() == true && lemari == true){
            hargaTerpilih = 800000;
            kualitas = "Biasa";
        }else if(d.isBiasa() == true && meja == true){
            hargaTerpilih = 300000;
            kualitas = "Biasa";
        }else if(d.isBiasa() == true && kursi == true){
            hargaTerpilih = 200000;
            kualitas = "Biasa";
        }else if(d.isMewah() == true && lemari == true){
            hargaTerpilih = 1000000;
            kualitas = "Mewah";
        }else if(d.isMewah() == true && meja == true){
            hargaTerpilih = 500000;
            kualitas = "Mewah";
        }else if(d.isMewah() == true && kursi == true){
            hargaTerpilih = 350000;
            kualitas = "Mewah";
        }
        
        
        
        int totalKotor = d.getKuantitas() * hargaTerpilih;
        
        if (totalKotor >= 10000000 && kursi == true){
            diskon = (int) (totalKotor * 0.1);
        }else{diskon = 0;}
        
        int totalBersih = totalKotor - diskon;
        
        lblpembeli.setText(d.getPembeli());
        lbljenis.setText(jenis);
        lblpembelian.setText(kualitas);
        lblharga.setText(String.valueOf(hargaTerpilih));
        lbljumlah.setText(String.valueOf(d.getKuantitas()));
        lbltotalkotor.setText(String.valueOf(totalKotor));
        lbldiskon.setText(String.valueOf(diskon));
        lbltotalbersih.setText(String.valueOf(totalBersih));
        
    }
    
        
    
    
    
}
