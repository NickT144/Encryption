package com.example.encryption;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Simple Text File Encryptor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        ArrayList<Character> ss = new ArrayList<Character>();
        String dad = "test this is lol";
        for(int i = 0; i < dad.length(); i++){
            ss.add(dad.charAt(i));
        }
        EncryptDecrypt s = new EncryptDecrypt(ss);
        System.out.println(s.encrypt(ss,"toy"));
        System.out.println(s.encrypt(s.encrypt(ss,"toy"),"toy"));
        System.out.println('l' ^ 'a');




        launch();

    }
}