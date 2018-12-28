/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroomscheduling;

import Algorithms.Astar;
import Algorithms.BFS;
import Model.Lecture;
import Model.TimeProgram;
import Model.University;
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

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //    launch(args);
        University university = new University();
        
        Lecture.All_Lectures.get(0).printLecture();

//        BFS algorithm = new BFS(new TimeProgram());
//        
//
//        TimeProgram t = algorithm.Solve();
//        if(t!=null)t.printProgram();
//        else System.out.println("Error");

    }

}
