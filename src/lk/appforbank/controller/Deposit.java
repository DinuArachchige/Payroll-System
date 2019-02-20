/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.appforbank.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.appforbank.BO.BOFactory;
import lk.appforbank.BO.custome.TransactionBO;
import lk.appforbank.DTO.TransactionDTO;



public class Deposit implements Initializable {

    public AnchorPane depositPane;
    public JFXTextField accountNoTxt;
    public JFXTextField amountTxt;
    public JFXTextField trackIDTxt;
    public JFXTextField userTxt;
    public JFXButton saveBtn;
    public JFXButton homeBtn;
    public JFXComboBox transactionTypeCombo;
    public JFXTextField tidTxt;

    private TransactionBO transactionBO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> typeList = FXCollections.observableArrayList();
        typeList.add("Deposit");
        typeList.add("Withdraw");
        transactionTypeCombo.setItems(typeList);

        transactionBO = BOFactory.getInstence().getBO(BOFactory.BOTypes.TRANSACTION);
    }

    @FXML
    public void depositMoney(ActionEvent actionEvent) {
        if (tidTxt.getText().isEmpty() || accountNoTxt.getText().isEmpty() || transactionTypeCombo.getSelectionModel().isEmpty() || amountTxt.getText().isEmpty() || trackIDTxt.getText().isEmpty() || userTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Please fill all");
            alert.show();
            return;
        }
        if (tidTxt.getText().matches("[0-9'.'0-9']*") && accountNoTxt.getText().matches("[0-9'.'0-9']*") && amountTxt.getText().matches("[0-9'.'0-9']*") && trackIDTxt.getText().matches("[0-9'.'0-9']*") && userTxt.getText().matches("[a-zA-Z]*")) {
            int tid = Integer.parseInt(tidTxt.getText());
            int accountNo = Integer.parseInt(accountNoTxt.getText());
            String transactionType = (String) transactionTypeCombo.getSelectionModel().getSelectedItem();
            double amount = Double.parseDouble(amountTxt.getText());
            int trackID = Integer.parseInt(trackIDTxt.getText());
            String user = userTxt.getText();

            TransactionDTO transactionDTO = new TransactionDTO(tid, accountNo, transactionType, amount, trackID, user);
            try {
                boolean b = transactionBO.makeAccountTransaction(transactionDTO);
                if (b) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Transaction successed");
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Transaction faild");
                    alert.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("incorrect input values.Check it again");
            alert.show();
            return;
        }
    }

    @FXML
    public void goHome(ActionEvent actionEvent) {
        try {
            Node chile = FXMLLoader.load(getClass().getResource("/lk/appforbank/view/Home.fxml"));
            if (depositPane.getChildren().isEmpty()) {
                depositPane.getChildren().remove(0);
            }
            depositPane.getChildren().add(chile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
