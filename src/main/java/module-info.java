module com.anindya.matrixoperation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.anindya.matrixoperation to javafx.fxml;
    exports com.anindya.matrixoperation;
}