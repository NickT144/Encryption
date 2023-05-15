package com.example.encryption;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;

public class HelloController {
    @FXML
    private Label File;
    @FXML
    private Label FileDirect;
    @FXML
    private Label Key;
    @FXML
    private TextField KeyText;
    private FileManager fm = new FileManager();
    private String KeyValue;

    @FXML
    protected void onExportClick() {
        fm.exportFile();
        FileDirect.setText(fm.getDirectory());
    }
    @FXML
    protected void onImportClick() throws IOException {
        fm.importFile();
        File.setText(fm.getFilePath());

    }
    @FXML
    protected void onEncryptClick() throws IOException {

        EncryptDecrypt s = new EncryptDecrypt(fm.getText());
        fm.createFile(s.encrypt("se"));



    }
    @FXML
    protected void onDecryptClick() throws IOException {

        EncryptDecrypt s = new EncryptDecrypt(fm.getText());
        fm.createFile(s.decrypt(s.encrypt("se"), "se"));



    }
    @FXML
    protected void onSaveKeyClick(){
        KeyValue = KeyText.getText();
        Key.setText("Key chosen: " + KeyText.getText());

    }

}