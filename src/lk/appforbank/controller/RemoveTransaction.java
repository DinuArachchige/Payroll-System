/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.appforbank.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.appforbank.BO.BOFactory;
import lk.appforbank.BO.custome.TransactionBO;
import lk.appforbank.DTO.RemoveTransactionDTO;



public class RemoveTransaction implements Initializable {

    public AnchorPane removeTransactionPane;
    public JFXDatePicker fromDatePicker;
    public JFXButton removeBtn;
    public JFXButton homeBtn;
    public JFXDatePicker toDatePicke;

    private TransactionBO transactionBO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        transactionBO = BOFactory.getInstence().getBO(BOFactory.BOTypes.TRANSACTION);
    }

    @FXML
    public void removeTransactions(ActionEvent actionEvent) {

        Date fromDate = Date.valueOf(fromDatePicker.getValue());
        Date toDate = Date.valueOf(toDatePicke.getValue());

        RemoveTransactionDTO removeTransactionDTO = new RemoveTransactionDTO(fromDate, toDate);
        try {
            boolean b = transactionBO.removeTransactionInGivenPeriod(removeTransactionDTO);
            if (b) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Remove successed");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("remove fail");
                alert.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goHome(ActionEvent actionEvent) {
        try {
            Node chile = FXMLLoader.load(getClass().getResource("/lk/appforbank/view/Home.fxml"));
            if (removeTransactionPane.getChildren().isEmpty()) {
                removeTransactionPane.getChildren().remove(0);
            }
            removeTransactionPane.getChildren().add(chile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
