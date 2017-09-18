/**
 * Hieu Duong
 * CSC 201
 * Assignment 7
 * Problem 7.15:
 * (Eliminate duplicates) Write a method that returns a new array by eliminating the
 * duplicate values in the array using the following method header:
 * public static int[] eliminateDuplicates(int[] list)
 * Write a test program that reads in ten integers, invokes the method, and displays
 * the result.
 *
 * 09/16/2017
 *
 */


package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
