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
        stage.setTitle("Password-Gen  @v1.0");

        VBox vbox2 = new VBox();
        vbox2.setSpacing(20);
        vbox2.setPadding(new Insets(20));

        // Überschrift
        Label label = new Label("Decode / Encode");
        label.setFont(new Font(20));

        // TextField
        TextField textField = new TextField();
        TextField textFieldOutput = new TextField();
        textFieldOutput.setEditable(false);
        textField.setPrefSize(300, 30);
        textFieldOutput.setPrefWidth(150);
        textField.setPromptText("Enter the password you want to encode");

        // buttons for de or encoding
        Button encodeButton = new Button("Encode");
        Button decodeButton = new Button("Decode");

        //action-listener
        encodeButton.setOnAction(e -> {

            String input = textField.getText();
            Encoder encoder = new Encoder();
            textFieldOutput.setText(encoder.encode(input));

        });

        //action-listener
        decodeButton.setOnAction(e -> {

            String input = textField.getText();
            Encoder encoder = new Encoder();
            textFieldOutput.setText(encoder.decode(input));
        });

        HBox hbox2 = new HBox();
        hbox2.setSpacing(10);
        hbox2.getChildren().addAll(textField, encodeButton, decodeButton);

        // add to vbox
        vbox2.getChildren().addAll(label, hbox2, textFieldOutput);

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
        Button button8 = new Button("8 characters");
        Button button16 = new Button("16 characters");
        Button button24 = new Button("24 characters");
        Button button32 = new Button("32 characters");

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

        //second vbox
        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox, outputTextField, copyButton);
        vbox.setSpacing(10);

        //root
        BorderPane root = new BorderPane();
        root.setTop(vbox2);
        root.setBottom(vbox);
        BorderPane.setMargin(vbox, new Insets(10, 0, 10, 0));

        scene.setRoot(root);

        scene.setRoot(root);

        stage.setScene(scene);
        stage.show();
    }

    

}
