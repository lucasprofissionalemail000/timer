import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
public class controler {


    @FXML
    private Label Seconds;
    @FXML
    private Label Minutes;
    @FXML
    private Label Hours;

    Timeline tempo;
    private int SecondsCounter= 0;
    private int MinutesCounter= 0;
    private int HoursCounter= 0;
    @FXML
    private void Start () throws InterruptedException {

        if (tempo !=null){
            tempo.stop();
        }
        tempo = new Timeline( new KeyFrame(Duration.seconds(1), event -> {
            SecondsCounter++;
            Seconds.setText(String.valueOf(SecondsCounter));

            if(SecondsCounter == 6){
                SecondsCounter =0;
                Seconds.setText(String.valueOf(SecondsCounter));
                MinutesCounter++;
                Minutes.setText(String.valueOf(MinutesCounter));
                if (MinutesCounter == 6){
                    MinutesCounter = 0;
                    Minutes.setText(String.valueOf(MinutesCounter));
                    HoursCounter++;
                    Hours.setText(String.valueOf(HoursCounter));
                    if (HoursCounter == 6){
                        HoursCounter = 0;
                        Hours.setText(String.valueOf(HoursCounter));
                    }
                }
            }
        }));

        tempo.setCycleCount(Timeline.INDEFINITE);
        tempo.play();

    }
    @FXML
    private void Stop(){
        if(tempo != null){
        tempo.stop();
        }
    }

    @FXML
    private void reset(){
        if(tempo != null){
        Stop();
        SecondsCounter= 0;
        MinutesCounter= 0;
        HoursCounter= 0;
        Seconds.setText("0");
        Minutes.setText("0");
        Hours.setText("0");
        }
    }
    @FXML
    private VBox body;
    @FXML
    private Button transition;
    @FXML
    private void transition(){
        if(body.getStyleClass().contains("light")){
            body.getStyleClass().setAll("dark");
            transition.setText("Light mode");
        }
        else{
            body.getStyleClass().setAll("light");
            transition.setText("Dark mode");
        }
    }
}
