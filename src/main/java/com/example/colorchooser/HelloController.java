package com.example.colorchooser;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.SetChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class HelloController {

    @FXML
    private Slider alphaSlider;

    @FXML
    private TextField alphaTextField;

    @FXML
    private Slider blueSlider;

    @FXML
    private TextField blueTextField;

    @FXML
    private Slider greenSlider;

    @FXML
    private TextField greenTextField;

    @FXML
    private Slider redSlider;

    @FXML
    private TextField redTextField;
    @FXML
    private Rectangle colorRectangle;
    public void initialize(){
        alphaSlider.setValue(1.0);
        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(redTextField.textProperty(), redSlider.valueProperty(), converter);
        Bindings.bindBidirectional(greenTextField.textProperty(), greenSlider.valueProperty(), converter);
        Bindings.bindBidirectional(blueTextField.textProperty(), blueSlider.valueProperty(), converter);
        Bindings.bindBidirectional(alphaTextField.textProperty(), alphaSlider.valueProperty(), converter);

        Runnable updateColor = () -> {
            int red = (int) redSlider.getValue();
            int green = (int) greenSlider.getValue();
            int blue = (int) blueSlider.getValue();
            double alpha = alphaSlider.getValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        };

        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor.run());
        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor.run());
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor.run());
        alphaSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor.run());
    }
}
