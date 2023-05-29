package com.mycompany.password.generator;

import java.io.File;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    //special character checkbox
    private boolean special;

    @Override
    public void start(Stage stage) {
        var scene = new Scene(new StackPane(), 640, 480);
        stage.setTitle("Passwort Generator");
        
        try {
            File file = new File("src/main/java/com/mycompany/password/generator/icon.png");
            if (file.exists()) {
                Image icon = new Image(file.toURI().toString());
                stage.getIcons().add(icon);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button button8 = new Button("test8");
        Button button16 = new Button("test16");
        Button button24 = new Button("test24");
        Button button32 = new Button("test32");

        CheckBox specialCheckBox = new CheckBox("Spezial\nzeichen");
        specialCheckBox.setOnAction(e -> {
            special = specialCheckBox.isSelected();
        });

        Generator generator = new Generator();

        button8.setPrefSize(140, 80);
        button16.setPrefSize(140, 80);
        button24.setPrefSize(140, 80);
        button32.setPrefSize(140, 80);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(button8, button16, button24, button32, specialCheckBox);

        TextField outputTextField = new TextField();
        outputTextField.setPrefWidth(200);

        //button functions
        Button copyButton = new Button("Kopieren");
        copyButton.setOnAction(e -> {
            String outputText = outputTextField.getText();

            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(outputText);
            clipboard.setContent(content);

        });

        button8.setOnAction(e -> outputTextField.setText(generator.generate(8, special)));
        button16.setOnAction(e -> outputTextField.setText(generator.generate(16, special)));
        button24.setOnAction(e -> outputTextField.setText(generator.generate(24, special)));
        button32.setOnAction(e -> outputTextField.setText(generator.generate(32, special)));

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

    }

}
