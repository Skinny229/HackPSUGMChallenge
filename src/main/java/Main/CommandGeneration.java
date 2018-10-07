package Main;

import com.amazonaws.services.rekognition.model.ComparedFace;
import com.amazonaws.services.rekognition.model.Landmark;

import java.util.List;

public class CommandGeneration {

    char xCompDir = ' ';
    char yCompDir = ' ';
    float magCompX;
    float magCompY;

    public static void getFace(ComparedFace face){
        if(face == null)
            return;

        List<Landmark> landmarks = face.getLandmarks();

        Landmark nose = landmarks.get(2);

        float xActual = nose.getX();
        float yActual = nose.getY();

        float targetX = (float) .5, targetY = .5f;


    }
}
