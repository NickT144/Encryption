package com.example.encryption;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import java.io.*;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class FileManager {
    private String directory;
    private String FileP;
    private ArrayList<String> text = new ArrayList<String>();
    public void exportFile()  {
        DirectoryChooser chooseDirec= new DirectoryChooser();
        chooseDirec.setTitle("Select Destination Folder to Export");
        File FilePath = new File(chooseDirec.showDialog(null),  addDateTime("encrypted")+ " .txt");
        directory = FilePath.getAbsolutePath();
    }

    public void importFile() throws IOException {
        text = new ArrayList<String>();
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        chooser.getExtensionFilters().add(extFilter);
        chooser.setTitle("Select Text File to Import");
        File fr = chooser.showOpenDialog(null);
        FileP = fr.getAbsolutePath();
        BufferedReader lineReader = new BufferedReader(new FileReader(fr));
        String temp = "";
        while((temp = lineReader.readLine()) != null){
            for(int i = 0; i < temp.length()-1; i++){
                text.add(temp.substring(i,i+2));
            }
        }
    }

    public void createFile(ArrayList<String> in) throws IOException {
        File f = new File(directory);
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(f));

        for(int i = 0; i < in.size(); i++){
            fileWriter.write(in.get(i));
        }
        fileWriter.close();
    }

    public String getDirectory(){
        return "Directory Chosen: " + directory;
    }

    public String getFilePath(){
        return "File Chosen: " + FileP;
    }
    public ArrayList<String> getText(){
        return text;
    }
    public static String addDateTime(String in){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        return in+"_"+dtf.format(now);
    }

}