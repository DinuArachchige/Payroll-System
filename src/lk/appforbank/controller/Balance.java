/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.appforbank.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
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



public class Balance implements Initializable {
    public AnchorPane balancePane;
    public JFXTextField accountNoTxt;
    public JFXButton checkBtn;
    public JFXTextField balanceTxt;
    public JFXButton homeBtn;

    private TransactionBO transactionBO;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        transactionBO=BOFactory.getInstence().getBO(BOFactory.BOTypes.TRANSACTION);
    }

    @FXML
    public void goHome(ActionEvent actionEvent) {
        try {
            Node chile=FXMLLoader.load(getClass().getResource("/lk/appforbank/view/Home.fxml"));
            if (!balancePane.getChildren().isEmpty()){
                balancePane.getChildren().remove(0);
            }
            balancePane.getChildren().add(chile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void checkBalance(ActionEvent actionEvent) {
        if (accountNoTxt.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Please enter account number");
            alert.show();
            return;
        }
        if (accountNoTxt.getText().matches("[0-9'.'0-9]*")){
            int accountNo= Integer.parseInt(accountNoTxt.getText());
            try {
                double accountBalance = transactionBO.getAccountBalance(accountNo);
                balanceTxt.setText(""+accountBalance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Please enter correct account number");
            alert.show();
            return;
        }
    }
}