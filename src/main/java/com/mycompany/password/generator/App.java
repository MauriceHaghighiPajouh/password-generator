package com.mycompany.password.generator;

import java.io.File;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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

        VBox vbox2 = new VBox();
        vbox2.setSpacing(20);
        vbox2.setPadding(new Insets(20));

        // Überschrift
        Label label = new Label("Decode / Encode");
        label.setFont(new Font(20));

        // TextField
        TextField textField = new TextField();
        textField.setPrefSize(300, 30);

        // buttons for de or encoding
        Button encodeButton = new Button("Decode");
        Button decodeButton = new Button("Encode");

        //action-listener
        encodeButton.setOnAction(e -> {
            // TODO
            String input = textField.getText();

        });

        //action-listener
        decodeButton.setOnAction(e -> {

            //TODO
        });

        HBox hbox2 = new HBox();
        hbox2.setSpacing(10);
        hbox2.getChildren().addAll(textField, decodeButton, encodeButton);

        // add to vbox
        vbox2.getChildren().addAll(label, hbox2);

        try {
            File file = new File("src/main/java/com/mycompany/password/generator/icon.png");
            if (file.exists()) {
                Image icon = new Image(file.toURI().toString());
                stage.getIcons().add(icon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Label label2 = new Label("");
        Button button8 = new Button("test8");
        Button button16 = new Button("test16");
        Button button24 = new Button("test24");
        Button button32 = new Button("test32");

        CheckBox specialCheckBox = new CheckBox("special \ncharacters");
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
        outputTextField.setPrefWidth(120);

        //button functions
        Button copyButton = new Button("Copy to Clipboard");
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
        vbox.setSpacing(10);

        BorderPane root = new BorderPane();
        root.setTop(vbox2);
        root.setBottom(vbox);
        BorderPane.setMargin(vbox,new Insets(10,0,10,0));

        scene.setRoot(root);

        scene.setRoot(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();

    }

}
