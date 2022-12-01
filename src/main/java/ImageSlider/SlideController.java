package ImageSlider;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class SlideController implements Initializable {
    @FXML
    private ImageView image;

    String images[]={"file:/../src/image/1.png",
            "file:/../src/image/3.jpeg",
            "file:/../src/image/4.jpeg",
            "file:/../src/image/guy.png" };

    public void initialize(URL url, ResourceBundle rb){
        SliderThread sliderThread = new SliderThread();
        sliderThread.start();

    }
    class SliderThread extends Thread{
        int i = 0;
        public void run(){
            try {
                while (true){
                    sleep(1000); //1 sec
                    if(i>=images.length)


                    image.setImage(new Image(images[i]));
                    i++;
                }

            }
            catch (Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
