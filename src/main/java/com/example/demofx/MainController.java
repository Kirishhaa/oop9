package com.example.demofx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class MainController {

    @FXML
    private Label sumLabel;
    @FXML
    private Label averageLabel;
    @FXML
    private Label stepsLabel;
    @FXML
    private Label maxLabel;
    @FXML
    private Label minLabel;
    @FXML
    private TextField h;
    @FXML
    private TextField start;
    @FXML
    private TextField end;

    private Operations operations;

    public void initialize(){
        operations = new Operations();
    }

    @FXML
    private void tabulateButton() {
        double a = Double.parseDouble(start.getText());
        double b = Double.parseDouble(end.getText());
        double step = Double.parseDouble(h.getText());

        int steps = operations.calcSteps(a, b, step);
        ArrayList<Point> values = operations.getMassiveFromData(a, step, steps);
        operations.tabulation(values);
        Point maxValue = operations.findMax(values);
        Point minValue = operations.findMin(values);

        stepsLabel.setText(String.valueOf(steps));
        maxLabel.setText(String.format("x = %.4f  y = %.6f",maxValue.x(), maxValue.y()));
        minLabel.setText(String.format("x = %.4f  y = %.6f",minValue.x(), minValue.y()));
        sumLabel.setText(String.valueOf(operations.sumValues(values)));
        averageLabel.setText(String.valueOf(operations.averageValues(values)));
    }
}