package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import static javafx.application.Application.launch;


public class Main extends Application {

    Stage menuStage;
    Stage window;
    Scene mainScene;//declaring menu scenes

    private double x=0.0,y=0.0,z=0.0;


    public static void main(String[] args) {
        launch(args);
    }

    public static double getDoubleFromTextField(TextField textField) {
        String text = textField.getText();
        return Double.parseDouble(text);
    }

    public void closeGame() {
        window.close();
    }

    public void start(Stage primaryStage) throws Exception {



        menuStage = primaryStage;

        window = primaryStage;
        window.setTitle("Menu");
        window.setOnCloseRequest(e -> closeGame());

        Text lengthText = new Text();
        lengthText.setText("Length:");
        lengthText.setFont(Font.font(null, 23));
        lengthText.setTextAlignment(TextAlignment.CENTER);
        lengthText.setTranslateX(10);

        Text widthText = new Text();
        widthText.setText("Width:");
        widthText.setFont(Font.font(null, 23));
        widthText.setTextAlignment(TextAlignment.CENTER);
        widthText.setTranslateX(10);

        Text heightText = new Text();
        heightText.setText("Height:");
        heightText.setFont(Font.font(null,23));
        heightText.setTextAlignment(TextAlignment.CENTER);
        heightText.setTranslateX(10);


        TextField xInput = new TextField();
        xInput.setOnAction(e->{
            x=getDoubleFromTextField(xInput);
        });
        xInput.setMaxWidth(50.0);
        xInput.setTranslateX(100);
        xInput.setTranslateY(-147);


        TextField yInput = new TextField();
        yInput.setOnAction(e->{
            y=getDoubleFromTextField(yInput);
        });
        yInput.setMaxWidth(50.0);
        yInput.setTranslateX(100);
        yInput.setTranslateY(-142);


        TextField zInput = new TextField();
        zInput.setOnAction(e->{
            z=getDoubleFromTextField(zInput);
        });
        zInput.setMaxWidth(50.0);
        zInput.setTranslateX(100);
        zInput.setTranslateY(-136);

        Text areaOutput = new Text();
        areaOutput.setText("--");
        areaOutput.setFont(Font.font(null,23));
        areaOutput.setTextAlignment(TextAlignment.CENTER);

        Button buttonArea = new Button();
        buttonArea.setText("Area");
        buttonArea.setOnAction(e->{
            System.out.println("area button pressed");
            System.out.println(x*y);
            System.out.println(x);
            System.out.println(y);
            areaOutput.setText((x*y)+"");
        });

        Text wallOutput = new Text();
        wallOutput.setText("--");
        wallOutput.setFont(Font.font(null,23));
        wallOutput.setTextAlignment(TextAlignment.CENTER);

        Button buttonWalls = new Button();
        buttonWalls.setText("Wall surface");
        buttonWalls.setOnAction(e->{
            wallOutput.setText((2*z*x+2*z*y)+"");
        });

        Text volumeOutput = new Text();
        volumeOutput.setText("--");
        volumeOutput.setFont(Font.font(null,23));
        volumeOutput.setTextAlignment(TextAlignment.CENTER);

        Button buttonVolume = new Button();
        buttonVolume.setText("volume");
        buttonVolume.setOnAction(e->{
            volumeOutput.setText((x*y*z)+"");
        });

        Label label = new Label("Room dimensions (m)");
        label.setFont(Font.font(null,23));
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label, lengthText,widthText,heightText, xInput, yInput,  zInput,
                buttonArea, areaOutput, buttonWalls, wallOutput, buttonVolume, volumeOutput);
        mainScene = new Scene(layout1,400, 800);


        window.setScene(mainScene);
        window.show();


    }
}
