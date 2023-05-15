package com.example.encryption;
//imported libraries
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import java.io.*;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class FileManager {
    private String directory; //directory of where the text file will be saved
    private String FileP; //directory of the location of the imported file.
    private ArrayList<Character> text = new ArrayList<Character>(); //imported text
    public void exportFile()  { //method allows the user to choose a directory to export to.
        DirectoryChooser chooseDirec= new DirectoryChooser();
        chooseDirec.setTitle("Select Destination Folder to Export");
        //opens window dialog to allow user to choose directory and creates a new file named encrypted with time and date.
        File FilePath = new File(chooseDirec.showDialog(null),  addDateTime("encrypted")+ " .txt");
        //directory is saved inside directory variable.
        directory = FilePath.getAbsolutePath();
    }

    public void importFile() throws IOException { //method imports text from file and saves it to text variable.
        text = new ArrayList<Character>();
        FileChooser chooser = new FileChooser();
        //opens window dialog to allow user to choose a text file to import.
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        chooser.getExtensionFilters().add(extFilter);
        chooser.setTitle("Select Text File to Import");
        File fr = chooser.showOpenDialog(null);
        FileP = fr.getAbsolutePath(); //saves directory of imported file to FileP variable.
        BufferedReader lineReader = new BufferedReader(new FileReader(fr));
        String temp = "";
        while((temp = lineReader.readLine()) != null){ //loop that reads each line of the imported file.
            for(int i = 0; i < temp.length(); i++){
                text.add(temp.charAt(i)); //saves each line to text variable.
            }
        }

    }

    public void createFile(ArrayList<Character> in) throws IOException { //method writes to the newly created file
        File f = new File(directory);
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(f));

        for(int i = 0; i < in.size(); i++){
            fileWriter.write(in.get(i)); //loops and writes line by line of the inputted data.
        }
        fileWriter.close();
    }

    public String getDirectory(){ //returns directory of export.
        return "Directory Chosen: " + directory;
    }

    public String getFilePath(){ //returns directory of imported file.
        return "File Chosen: " + FileP;
    }
    public ArrayList<Character> getText(){ //returns imported text.
        return text;
    }
    public static String addDateTime(String in){ //method adds date and time to a string.
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        return in+"_"+dtf.format(now);
    }

}