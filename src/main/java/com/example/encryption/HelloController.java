package com.example.encryption;
//imported libraries
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;

public class HelloController {
    @FXML
    private Label File; //label lists the imported file directory
    @FXML
    private Label FileDirect; //label lists the export directory
    @FXML
    private Label Key; //label lists the key being used
    private FileManager fm = new FileManager(); //file manager


    @FXML
    protected void onExportClick() { //method links export button with export file method.
        fm.exportFile();
        FileDirect.setText(fm.getDirectory());

    }
    @FXML
    protected void onImportClick() throws IOException {//method links import button with import file method.
        fm.importFile();
        File.setText(fm.getFilePath());

    }
    @FXML
    protected void onEncryptClick() throws IOException { //method links encrypt button with encrypt method.
        EncryptDecrypt ED = new EncryptDecrypt(fm.getText());
        fm.createFile(ED.encrypt(fm.getText(), "a"));

    }

}