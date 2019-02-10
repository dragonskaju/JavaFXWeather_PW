package pl.sda.openweather.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.scenario.effect.impl.prism.PrImage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {


    private String finalURL = "https://api.apixu.com/v1/current.json?key=d081446f4efd41a992a91031191002&q=";
    @FXML
    private Button search;

    @FXML
    private TextField city;

    @FXML
    private Label temperatura;

    @FXML
    private Label temperatura_odczuwalna;

    @FXML
    private Label dodajTemperatura;

    @FXML
    private Label dodajTemperatura_odczuwalna;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        city.setText("");
        temperatura.setText("Temperatura : ");
        temperatura_odczuwalna.setText(" Temperatura odczuwalna !!");


    }

    public void setCity(ActionEvent actionEvent) {
        try {
            URL jsonURL = new URL(finalURL+city.getText());
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(finalURL+city.getText());
            Weather weather = objectMapper.readValue(jsonURL, Weather.class);
            dodajTemperatura_odczuwalna.setText(String.valueOf(weather.getCurrent().getFeelslike_c()));
            dodajTemperatura.setText(String.valueOf(weather.getCurrent().getTemp_c()));


        } catch (
                IOException e) {
            e.printStackTrace();
        }


    }
}
