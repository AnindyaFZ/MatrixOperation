package com.anindya.matrixoperation;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Random;
public class MatrixOperationController
{
    @javafx.fxml.FXML
    private TextField matrix2ColTexfield;
    @javafx.fxml.FXML
    private TextField matrix1ColTexfield;
    @javafx.fxml.FXML
    private TextField matrix1RowTexfield;
    @javafx.fxml.FXML
    private TextField matrix2RowTexfield;
    @javafx.fxml.FXML
    private ComboBox<String> selectOperationCombobox;
    @javafx.fxml.FXML
    private Label resultLabel;
    Matrix m1=null,m2=null,m3;
    int rowIndex,colIndex;
    @javafx.fxml.FXML
    private TextField elementTextField;
    @javafx.fxml.FXML
    public void initialize() {
        rowIndex=colIndex=0;
        selectOperationCombobox.getItems().add("adding");
        selectOperationCombobox.getItems().add("sub");
    }
    @Deprecated
    public void executeOnMouseCLicked(Event event){
        String selectedOperation=selectOperationCombobox.getValue();
        if (selectedOperation.equals("adding")) {
            m3 = m1.add(m2);
            resultLabel.setText("Matrix 1:\n" + m1.toString() +
                    "\n\nMatrix 2:\n" + m2.toString() +
                    "\n\nAdded Matrix :\n" + m3.toString()
            );
        }


    }
    @javafx.fxml.FXML
    public void addMatrixElementOnMouseClicked(Event event) {
        if (m1==null)
            m1= new Matrix(
                    Integer.parseInt(matrix1RowTexfield.getText()),
                    Integer.parseInt(matrix1ColTexfield.getText())
            );

        if (rowIndex==m1.vals.length-1 && colIndex==m1.vals[0].length-1 ){
            resultLabel.setText("Matrix Overflow!");
            return;
        }
        m1.vals[rowIndex][colIndex]=Integer.parseInt(elementTextField.getText());
        if(colIndex<m1.vals[0].length-1){
            colIndex++;

        }
        else if (colIndex==m1.vals[0].length-1) {
            if (rowIndex<m1.vals.length-1){
                rowIndex++;colIndex=0;

            }
            else if (rowIndex==m1.vals.length-1) {
                resultLabel.setText("Matrix Overflow!");

            }

        }

    }

    @javafx.fxml.FXML
    public void generateRandomNoMatrixOnAction(ActionEvent actionEvent) {
        if (m2 == null)
            m2 = new Matrix(
                    Integer.parseInt(matrix2RowTexfield.getText()),
                    Integer.parseInt(matrix2ColTexfield.getText())
            );
        int i, j;
        Random r = new Random();
        for (i = 0; i < m2.vals.length; i++) {
            for (j = 0; j < m2.vals[i].length; j++) {
                m2.vals[i][j] = r.nextInt(100);
            }
        }
    }}







