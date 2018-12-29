/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Lecture;
import Model.SpecializationName;
import Model.Subject;
import Model.TimeProgram;
import Model.TypeLecture;
import Model.University;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Al-Hussein
 */
public class FXMLDocumentController implements Initializable {

    private TimeProgram t;

    @FXML
    private GridPane AI_Grid;
    SpecializationName specializationName;

    public void setSpecializationName(SpecializationName specializationName) {
        this.specializationName = specializationName;
    }

    public void setTimeProgram(TimeProgram t) {
        this.t = t;
        setProgramInterface();
    }

    private SpecializationName getSN(Lecture L){
        if(L.getTypeLecture().equals(TypeLecture.Theoretical)){
            for(Subject s: University.subjects){
                if(s.getName().equals(L.getSubject())){
                    if(s.isAI() && this.specializationName.equals(SpecializationName.Artificial_Intelligence))
                        return this.specializationName;
                    if(s.isN()&& this.specializationName.equals(SpecializationName.Networks))
                        return this.specializationName;
                    if(s.isSE()&& this.specializationName.equals(SpecializationName.Software_Engineering))
                        return this.specializationName;
                }
            }
            return L.getSpecializationName();
        }
        else return L.getSpecializationName();
    }
    public void setProgramInterface() {
//        System.out.println(t.getLectures().size());
        for (Lecture L : t.getLectures()) {
            int Day = L.getPeriod().getDay();
            int Time = L.getPeriod().getTime();
            SpecializationName SN = getSN(L);
//            System.out.println(Day+"  "+Time+"  "+SN);
            
            if (SN.equals(specializationName)) {
                addLecture(Day, (5 - Time) - 1, L);
//                addLecture(Day - 1, Time - 1, L);
            }
        }
    }

    private void addLecture(int i, int j, Lecture L) {
        L.printLecture();
//        AI_Grid.getChildren().get(i);
        System.out.println("Size AI = " + AI_Grid.getChildren().size());
        for (Node n : AI_Grid.getChildren()) {
            Integer x = GridPane.getRowIndex(n);
            Integer y = GridPane.getColumnIndex(n);
            if (x == null) {
                x = 0;
            }
            if (y == null) {
                y = 0;
            }
            System.out.println(x + "  " + y);

            if (x == i && y == j) {
                SplitPane temp = (SplitPane) n;
//                if (temp.getItems().size() != 0) {
//                    temp.getItems().add(new Label("_________________"));
//                }
                String st = "";
                if (L.getTypeLecture().equals(TypeLecture.Theoretical)) {
                    st = new String(L.getSubject().name() + "\n" + L.getTeacher().getName().name() + "\n" + "M:" + L.getHall().getID());

                } else if (L.getTypeLecture().equals(TypeLecture.Practical_THEATER)) {
                    st = new String(L.getSubject().name() + "\n" +"Group:" + L.getGroupNumber() + "-M:" + L.getHall().getID());

                } else {
                    st = new String(L.getSubject().name() + "\n" +"Category:" + L.getCategoryNumber() + "-M:" + L.getHall().getID());

                }
                temp.getItems().add(new Label(st));

            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
