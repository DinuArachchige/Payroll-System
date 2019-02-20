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
import java.sql.Date;
import java.time.LocalDate;
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
import lk.appforbank.BO.custome.AccountBO;
import lk.appforbank.DTO.AccountDTO;








public class Account implements Initializable {

    public JFXTextField accountNoTxt;
    public JFXComboBox accountTypeCombo;
    public JFXButton saveBtn;
    public JFXButton homeBtn;
    public AnchorPane newAccountPane;
    private AccountBO accountBO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> typeList = FXCollections.observableArrayList();
        typeList.add("Saving");
        accountTypeCombo.setItems(typeList);

        accountBO = BOFactory.getInstence().getBO(BOFactory.BOTypes.ACCOUNT);
    }

    @FXML
    public void openNewAccount(ActionEvent actionEvent) {
        if (accountNoTxt.getText().isEmpty() || accountTypeCombo.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Please enter account number or select Account type");
            alert.show();
            return;
        }
        if (accountNoTxt.getText().matches("[0-9]*")) {
            int accountNo = Integer.parseInt(accountNoTxt.getText());
            String accountType = (String) accountTypeCombo.getSelectionModel().getSelectedItem();
            Date date = Date.valueOf(LocalDate.now());

            AccountDTO accountDTO = new AccountDTO(accountNo, date, accountType);
            try {
                boolean b = accountBO.openNewAccount(accountDTO);
                if (b) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Opening account success");
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Cannot create account");
                    alert.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Enter Correct Details ..!");
            alert.showAndWait();
            return;
        }
    }

    @FXML
    public void goHome(ActionEvent actionEvent) {
        try {
            Node chile=FXMLLoader.load(getClass().getResource("/lk/appforbank/view/Home.fxml"));
            if (!newAccountPane.getChildren().isEmpty()){
                newAccountPane.getChildren().remove(0);
            }
            newAccountPane.getChildren().add(chile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
