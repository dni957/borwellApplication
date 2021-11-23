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

    Stage window;
    Scene mainScene, introScene;//declaring menu scenes

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


        window = primaryStage;
        window.setTitle("Menu");
        window.setOnCloseRequest(e -> closeGame());

        Text lengthText = new Text();
        lengthText.setText("Length:");
        lengthText.setFont(Font.font(null, 20));
        lengthText.setTextAlignment(TextAlignment.CENTER);
        lengthText.setTranslateX(10);

        Text widthText = new Text();
        widthText.setText("Width:");
        widthText.setFont(Font.font(null, 20));
        widthText.setTextAlignment(TextAlignment.CENTER);
        widthText.setTranslateX(10);

        Text heightText = new Text();
        heightText.setText("Height:");
        heightText.setFont(Font.font(null,20));
        heightText.setTextAlignment(TextAlignment.CENTER);
        heightText.setTranslateX(10);


        TextField xInput = new TextField();
        xInput.setOnAction(e->{
            x=getDoubleFromTextField(xInput);
        });
        xInput.setMaxWidth(50.0);
        xInput.setTranslateX(100);
        xInput.setTranslateY(-138);


        TextField yInput = new TextField();
        yInput.setOnAction(e->{
            y=getDoubleFromTextField(yInput);
        });
        yInput.setMaxWidth(50.0);
        yInput.setTranslateX(100);
        yInput.setTranslateY(-138);


        TextField zInput = new TextField();
        zInput.setOnAction(e->{
            z=getDoubleFromTextField(zInput);
        });
        zInput.setMaxWidth(50.0);
        zInput.setTranslateX(100);
        zInput.setTranslateY(-135);

        Text areaOutput = new Text();
        areaOutput.setText("--");
        areaOutput.setFont(Font.font(null,16));
        areaOutput.setTextAlignment(TextAlignment.CENTER);
        areaOutput.setTranslateX(10);
        areaOutput.setTranslateY(-110);

        Button buttonArea = new Button();
        buttonArea.setText("Area");
        buttonArea.setOnAction(e->{
            System.out.println("area button pressed");
            System.out.println(x*y);
            System.out.println(x);
            System.out.println(y);
            areaOutput.setText((x*y)+"");
        });
        buttonArea.setTranslateX(10);
        buttonArea.setTranslateY(-100);

        Text wallOutput = new Text();
        wallOutput.setText("--");
        wallOutput.setFont(Font.font(null,16));
        wallOutput.setTextAlignment(TextAlignment.CENTER);
        wallOutput.setTranslateX(70);
        wallOutput.setTranslateY(-198);

        Button buttonWalls = new Button();
        buttonWalls.setText("Wall surface");
        buttonWalls.setOnAction(e->{
            wallOutput.setText((2*z*x+2*z*y)+"");
        });
        buttonWalls.setTranslateX(70);
        buttonWalls.setTranslateY(-188);

        Text volumeOutput = new Text();
        volumeOutput.setText("--");
        volumeOutput.setFont(Font.font(null,16));
        volumeOutput.setTextAlignment(TextAlignment.CENTER);
        volumeOutput.setTranslateX(170);
        volumeOutput.setTranslateY(-285);

        Button buttonVolume = new Button();
        buttonVolume.setText("volume");
        buttonVolume.setOnAction(e->{
            volumeOutput.setText((x*y*z)+"");
        });
        buttonVolume.setTranslateX(170);
        buttonVolume.setTranslateY(-275);



        Label label = new Label("Room dimensions (m)");
        label.setTranslateX(10);
        label.setFont(Font.font(null,23));
        VBox mainLayout = new VBox(20);
        mainLayout.getChildren().addAll(label, lengthText,widthText,heightText, xInput, yInput,  zInput,
                buttonArea, areaOutput, buttonWalls, wallOutput, buttonVolume, volumeOutput);
        mainScene = new Scene(mainLayout,250, 350);


        Label introTitle = new Label();
        introTitle.setText("Instructions:");
        introTitle.setFont(Font.font(null,20));
        introTitle.setTranslateX(10);


        Label introText = new Label();
        introText.setText("To use this app, simply input the dimensions of the room by writing the numbers and pressing enter to confirm each entry, then press any of the buttons to receive the output. All of the dimensions are in metres.");
        introText.setWrapText(true);
        introText.setFont(Font.font(null,12));
        introText.setMaxWidth(230);
        introText.setTranslateX(10);

        Button introButton = new Button();
        introButton.setText("Next");
        introButton.setOnAction(e->{
            window.setScene(mainScene);
        });
        introButton.setTranslateX(100);

        VBox introLayout = new VBox(20);
        introLayout.getChildren().addAll(introTitle, introText, introButton);
        introScene= new Scene(introLayout,250,350);


        window.setScene(introScene);
        window.show();


    }
}
