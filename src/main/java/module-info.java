module cs113.listGame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens cs113.listGame to javafx.fxml;
    exports cs113.listGame;
    exports cs113.listGame.helpers;
    opens cs113.listGame.helpers to javafx.fxml;
    exports cs113.listGame.gamecore;
    opens cs113.listGame.gamecore to javafx.fxml;
}