package data_package;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import translation_package.DrawTree;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        DataReader dataReader = new DataReader("dictionary.txt");
        DrawTree drawTree = new DrawTree(dataReader.getConstructOptimalBST().getRoot());
        primaryStage.setScene(new Scene(drawTree.getTreeView()));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
