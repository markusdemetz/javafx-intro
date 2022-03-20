module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;

    opens com.example.javafx to javafx.fxml;
    opens com.example.javafx.bl to org.junit.platform.commons;
    exports com.example.javafx;
}