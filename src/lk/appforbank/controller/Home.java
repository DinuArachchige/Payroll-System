/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.appforbank.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;



public class Home implements Initializable {

    public JFXButton accountBtn;
    public JFXButton depositBtn;
    public JFXButton removeBtn;
    public AnchorPane homePane;
    public JFXButton taxBtn;
    public JFXButton balanceBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void openNewAccountPage(ActionEvent actionEvent) {
        try {
            Node child = FXMLLoader.load(getClass().getResource("/lk/appforbank/view/Account.fxml"));
            if (!homePane.getChildren().isEmpty()) {
                homePane.getChildren().remove(0);
            }
            homePane.getChildren().add(child);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openDepositPage(ActionEvent actionEvent) {
        try {
            Node child = FXMLLoader.load(getClass().getResource("/lk/appforbank/view/Deposit.fxml"));
            if (!homePane.getChildren().isEmpty()) {
                homePane.getChildren().remove(0);
            }
            homePane.getChildren().add(child);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openRemovePage(ActionEvent actionEvent) {
        try {
            Node child = FXMLLoader.load(getClass().getResource("/lk/appforbank/view/RemoveTransactions.fxml"));
            if (!homePane.getChildren().isEmpty()) {
                homePane.getChildren().remove(0);
            }
            homePane.getChildren().add(child);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openTaxPage(ActionEvent actionEvent) {
        try {
            Node child = FXMLLoader.load(getClass().getResource("/lk/appforbank/view/Tax.fxml"));
            if (!homePane.getChildren().isEmpty()) {
                homePane.getChildren().remove(0);
            }
            homePane.getChildren().add(child);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openBalancePage(ActionEvent actionEvent) {
        try {
            Node child = FXMLLoader.load(getClass().getResource("/lk/appforbank/view/Balance.fxml"));
            if (!homePane.getChildren().isEmpty()) {
                homePane.getChildren().remove(0);
            }
            homePane.getChildren().add(child);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
