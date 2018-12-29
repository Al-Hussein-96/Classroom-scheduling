/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroomscheduling;

import Algorithms.BFS;
import Controller.FXMLDocumentController;
import Model.Lecture;
import Model.SpecializationName;
import Model.TimeProgram;
import Model.University;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Al-Hussein
 */
public class ClassroomScheduling extends Application {

        private static TimeProgram t;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/FXMLDocument.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(SpecializationName.Artificial_Intelligence.name());
        stage.show();
        FXMLDocumentController C = (FXMLDocumentController) fxmlLoader.getController();
        C.setSpecializationName(SpecializationName.Artificial_Intelligence);
        C.setTimeProgram(t);

        fxmlLoader = new FXMLLoader(getClass().getResource("/View/FXMLDocument.fxml"));
        root = (Parent) fxmlLoader.load();
        scene = new Scene(root);
        Stage s = new Stage();
        s.setScene(scene);
        s.setTitle(SpecializationName.Networks.name());
        s.show();
        C = (FXMLDocumentController) fxmlLoader.getController();
        C.setSpecializationName(SpecializationName.Networks);
        C.setTimeProgram(t);
        
        fxmlLoader = new FXMLLoader(getClass().getResource("/View/FXMLDocument.fxml"));
        root = (Parent) fxmlLoader.load();
        scene = new Scene(root);
        Stage s2 = new Stage();
        s2.setScene(scene);
        s2.setTitle(SpecializationName.Software_Engineering.name());
        s2.show();
        C = (FXMLDocumentController) fxmlLoader.getController();
        C.setSpecializationName(SpecializationName.Software_Engineering);
        C.setTimeProgram(t);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        University university = new University();

        Lecture l = new Lecture();

//        List<Lecture> lectures = Lecture.All_Lectures;
//        for (Lecture lecture : lectures) {
//            lecture.printLecture();
//        }
        BFS algorithm = new BFS(new TimeProgram());
         t = algorithm.Solve();

      //  System.out.println("Size: " + t.getLectures().size());
        for (Lecture u : t.getLectures()) {
            u.printLecture();
        }
        //t.printProgram();
        System.out.println("Finish");
//        if(t!=null)t.printProgram();
//        else System.out.println("Error");
            launch(args);

    }

}
