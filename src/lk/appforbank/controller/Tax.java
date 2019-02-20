/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.appforbank.controller;



import lk.appforbank.BO.BOFactory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import lk.appforbank.BO.custome.TaxRateBO;
import lk.appforbank.DTO.TaxRateDTO;

public class Tax implements Initializable {
    public AnchorPane taxPane;
    public JFXTextField rateTxt;
    public JFXTextField sRateTxt;
    public JFXTextField eRateTxt;
    public JFXButton saveBtn;
    public JFXButton homeBtn;
    private TaxRateBO taxRateBO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taxRateBO=BOFactory.getInstence().getBO(BOFactory.BOTypes.TAX_RATE);
    }

    @FXML
    public void saveNewTaxRate(ActionEvent actionEvent) {
        if (rateTxt.getText().isEmpty()||sRateTxt.getText().isEmpty() || eRateTxt.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Please enter Rang and start Range and end range");
            alert.show();
            return;
        }
        if (rateTxt.getText().matches("[0-9'.'0-9]*") && sRateTxt.getText().matches("[0-9'.'0-9]*") && eRateTxt.getText().matches("[0-9'.'0-9]*")){
            int rate=Integer.parseInt(rateTxt.getText());
            double sRange=Double.parseDouble(sRateTxt.getText());
            double eRange=Double.parseDouble(eRateTxt.getText());

            TaxRateDTO taxRateDTO=new TaxRateDTO(rate,sRange,eRange);
            try {
                boolean b = taxRateBO.saveNewTaxRate(taxRateDTO);
                if (b){
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("New Tax rate added success");
                    alert.show();
                }else{
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Tax rate added fail");
                    alert.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Please check enterd values");
            alert.show();
            return;
        }
    }

    @FXML
    public void goHome(ActionEvent actionEvent) {
        try {
            Node chile=FXMLLoader.load(getClass().getResource("/lk/appforbank/view/Home.fxml"));
            if (taxPane.getChildren().isEmpty()){
                taxPane.getChildren().remove(0);
            }
            taxPane.getChildren().add(chile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
