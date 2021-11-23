import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;




public class Main extends Application {

    //Declared the stage and scene variables that allow me to make the UI of the app

    Stage window;
    Scene mainScene, introScene;//declaring menu scenes

    //These are the variables used to calculate the area, wall surface and volume of the room
    private double x=0.0,y=0.0,z=0.0;


    public static void main(String[] args) {
        launch(args);
    }


    //This method transforms the text received as input to be transformed into the right type (double)
    public static double getDoubleFromTextField(TextField textField) {
        String text = textField.getText();
        return Double.parseDouble(text);
    }

    //This method is used to stop the code from running after closing the app
    public void closeApp() {
        window.close();
    }


    public void start(Stage primaryStage) throws Exception {


        window = primaryStage;

        //App title
        window.setTitle("Dimensions App");

        //Stop the code when the app is closed
        window.setOnCloseRequest(e -> closeApp());

        //Text box to present which input to be inserted (length of the room)
        Text lengthText = new Text();
        lengthText.setText("Length:");
        lengthText.setFont(Font.font(null, 20));
        lengthText.setTextAlignment(TextAlignment.CENTER);
        lengthText.setTranslateX(10);


        //Text box to present which input to be inserted (width of the room)
        Text widthText = new Text();
        widthText.setText("Width:");
        widthText.setFont(Font.font(null, 20));
        widthText.setTextAlignment(TextAlignment.CENTER);
        widthText.setTranslateX(10);


        //Text box to present which input to be inserted (height of the room)
        Text heightText = new Text();
        heightText.setText("Height:");
        heightText.setFont(Font.font(null,20));
        heightText.setTextAlignment(TextAlignment.CENTER);
        heightText.setTranslateX(10);


        //Input field that receives one of the three dimensions (x dimension)
        TextField xInput = new TextField();
        xInput.setOnAction(e->{
            x=getDoubleFromTextField(xInput);    //action that changes the value of one of the variables used for calculations
        });
        xInput.setMaxWidth(50.0);
        xInput.setTranslateX(100);
        xInput.setTranslateY(-138);


        //Input field that receives one of the three dimensions (y dimension)
        TextField yInput = new TextField();
        yInput.setOnAction(e->{
            y=getDoubleFromTextField(yInput);    //action that changes the value of one of the variables used for calculations
        });
        yInput.setMaxWidth(50.0);
        yInput.setTranslateX(100);
        yInput.setTranslateY(-138);


        //Input field that receives one of the three dimensions (z dimension)
        TextField zInput = new TextField();
        zInput.setOnAction(e->{
            z=getDoubleFromTextField(zInput);    //action that changes the value of one of the variables used for calculations
        });
        zInput.setMaxWidth(50.0);
        zInput.setTranslateX(100);
        zInput.setTranslateY(-135);


        //Output text field for the area of the room
        Text areaOutput = new Text();
        areaOutput.setText("--");
        areaOutput.setFont(Font.font(null,16));
        areaOutput.setTextAlignment(TextAlignment.CENTER);
        areaOutput.setTranslateX(10);
        areaOutput.setTranslateY(-110);


        //Button that shows the output for the area of the room
        Button buttonArea = new Button();
        buttonArea.setText("Area");
        buttonArea.setOnAction(e->{
            areaOutput.setText((x*y)+"");
        });
        buttonArea.setTranslateX(10);
        buttonArea.setTranslateY(-100);


        //Output text field for the wall surface of the room
        Text wallOutput = new Text();
        wallOutput.setText("--");
        wallOutput.setFont(Font.font(null,16));
        wallOutput.setTextAlignment(TextAlignment.CENTER);
        wallOutput.setTranslateX(70);
        wallOutput.setTranslateY(-198);


        //Button that shows the output for the wall surface of the room
        Button buttonWalls = new Button();
        buttonWalls.setText("Wall surface");
        buttonWalls.setOnAction(e->{
            wallOutput.setText((2*z*x+2*z*y)+"");
        });
        buttonWalls.setTranslateX(70);
        buttonWalls.setTranslateY(-188);


        //Output text field for the volume of the room
        Text volumeOutput = new Text();
        volumeOutput.setText("--");
        volumeOutput.setFont(Font.font(null,16));
        volumeOutput.setTextAlignment(TextAlignment.CENTER);
        volumeOutput.setTranslateX(170);
        volumeOutput.setTranslateY(-285);


        //Button that shows the output for the volume of the room
        Button buttonVolume = new Button();
        buttonVolume.setText("volume");
        buttonVolume.setOnAction(e->{
            volumeOutput.setText((x*y*z)+"");
        });
        buttonVolume.setTranslateX(170);
        buttonVolume.setTranslateY(-275);


        //Button used to change the scene to the instructions one
        Button buttonInstructions = new Button();
        buttonInstructions.setText("Back to Instructions");
        buttonInstructions.setOnAction(e->{
            window.setScene(introScene);
        });
        buttonInstructions.setTranslateX(60);
        buttonInstructions.setTranslateY(-300);


        //Label used as title for the main scene
        Label label = new Label("Room dimensions (m)");
        label.setTranslateX(10);
        label.setFont(Font.font(null,23));

        //Main layout of the app
        VBox mainLayout = new VBox(20);

        //Adding all the elements to the main layout
        mainLayout.getChildren().addAll(label, lengthText,widthText,heightText, xInput, yInput,  zInput,
                buttonArea, areaOutput, buttonWalls, wallOutput, buttonVolume, volumeOutput, buttonInstructions);

        //Initializing the main scene
        mainScene = new Scene(mainLayout,250, 350);

        //Title for the instructions scene
        Label introTitle = new Label();
        introTitle.setText("Instructions:");
        introTitle.setFont(Font.font(null,20));
        introTitle.setTranslateX(10);

        //Text that contains the instructions on how to use the app
        Label introText = new Label();
        introText.setText("To use this app, simply input the dimensions of the room by writing the numbers and pressing enter to confirm each entry, then press any of the buttons to receive the output. All of the dimensions are in metres.");
        introText.setWrapText(true);
        introText.setFont(Font.font(null,12));
        introText.setMaxWidth(230);
        introText.setTranslateX(10);


        //Button used to change to the main scene
        Button introButton = new Button();
        introButton.setText("Next");
        introButton.setOnAction(e->{
            window.setScene(mainScene);
        });
        introButton.setTranslateX(100);

        //The intro layout
        VBox introLayout = new VBox(20);

        //Adding the elements to the intro layout
        introLayout.getChildren().addAll(introTitle, introText, introButton);

        //Initializing the intro scene
        introScene= new Scene(introLayout,250,350);

        //Setting the app window to the intro scene
        window.setScene(introScene);
        window.show();
    }
}
