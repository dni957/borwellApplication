To build and run this application you need to add javafx library to the local project, and update the run configurations by adding VM options, then writing the 
following command:

--module-path {path_to_javafx_lib_folder} --add-modules javafx.controls,javafx.fxml

where you will change {path_to_javafx_lib_folder} with the path to your local javafx lib folder.

To add the javafx library go to https://gluonhq.com/products/javafx/ and download the sdk coresponding to the operating system in use.
Extract the files from the zip and place them anywhere you want (once placed you should not move them).