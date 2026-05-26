module com.example.matdiscretas2proyecto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.matdiscretas2proyecto to javafx.fxml;
    exports com.example.matdiscretas2proyecto;
}