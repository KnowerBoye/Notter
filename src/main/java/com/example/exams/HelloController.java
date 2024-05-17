package com.example.exams;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloController implements Initializable {

    @FXML
    private TextArea tArea;

    @FXML

    private Label count;

    FileChooser dbox = new FileChooser();



    @FXML
    void charCount() {

        count.setText("Characters Typed: " + tArea.getLength());

    }

    @FXML

    void openFile() throws FileNotFoundException {

        dbox.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (.txt)" , "*.txt"));

        File selected = dbox.showOpenDialog(new Stage());

        if(selected != null){

            Scanner mscan = new Scanner(selected);

            tArea.setText("");
            while(mscan.hasNextLine()){
                tArea.appendText(mscan.nextLine() + "\n");
            }

            mscan.close();

            count.setText("Characters Typed: " + tArea.getLength());


        }


    }

    @FXML

    void saveFile() throws FileNotFoundException {

        dbox.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (.txt)" , "*.txt"));

        File selected = dbox.showSaveDialog(new Stage());

        if(selected != null){

            PrintWriter output = new PrintWriter(selected);

            output.print(tArea.getText());

            output.close();
        }

    }


    @FXML
    void closeApp(){
        Platform.exit();
    }

    @FXML
    void disableEdit(ActionEvent event) {

        tArea.setEditable(false);

    }

    @FXML
    void enableEdit(ActionEvent event) {

        tArea.setEditable(true);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbox.setInitialDirectory(new File("C:/Users/"));
    }
}
