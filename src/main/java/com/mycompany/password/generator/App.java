package com.mycompany.password.generator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var scene = new Scene(new StackPane(), 640, 480);

        Image icon = new Image("file:icon.png");

        stage.getIcons().add(icon);

        Button button8 = new Button("test8");
        Button button16 = new Button("test16");
        Button button24 = new Button("test24");
        Button button32 = new Button("test32");

        button8.setPrefSize(200, 100);
        button16.setPrefSize(200, 100);
        button24.setPrefSize(200, 100);
        button32.setPrefSize(200, 100);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(button8, button16, button24, button32);

        TextField outputTextField = new TextField();
        outputTextField.setPrefWidth(200);

        Button copyButton = new Button("Kopieren");
        copyButton.setOnAction(e -> {
            String outputText = outputTextField.getText();

            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(outputText);
            clipboard.setContent(content);

            System.out.println("Text kopiert: " + outputText);
        });

        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox, outputTextField, copyButton);
        vbox.setSpacing(20);

        StackPane root = new StackPane(vbox);
        StackPane.setMargin(vbox, new Insets(240, 0, 0, 0));

        scene.setRoot(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

        Generator generator = new Generator();

    }

}
