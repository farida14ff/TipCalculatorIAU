package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Text p;

    @FXML
    private TextField d;

    @FXML
    private TextField h;

    @FXML
    private TextField k;

    @FXML
    private Slider f;
    double percent = 15.0;
    @FXML
    void initialize(){
        f.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                double h  = f.getValue();
                double t = (h * 10) / 30;
                percent = t;
                p.setText(String.format("%.0f", t) + "%");
            }
        });

    }

    @FXML
    void clik(ActionEvent event) {
            double t = Double.parseDouble(d.getText());
            h.setText(String.format("%.1f", t * (percent / 100)));
            k.setText(String.format("%.1f", t + (t * (percent / 100))));
    }
}
