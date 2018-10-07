package Main;

import com.amazonaws.services.rekognition.model.ComparedFace;
import com.amazonaws.services.rekognition.model.Landmark;

import java.util.List;

public class CommandGeneration {

    char xCompDir = ' ';
    char yCompDir = ' ';
    static float magCompX;
    static float magCompY;

    public void getFace(ComparedFace face) {
        if (face == null)
            return;

        List<Landmark> landmarks = face.getLandmarks();

        Landmark nose = landmarks.get(2);

        float xActual = nose.getX();
        float yActual = nose.getY();

        float xTarget = (float) .5, targetY = .5f;
        float xThreshold = .05f;
        float yThreshold = .05f;

        if (Math.abs(xTarget - xActual) < xThreshold) {
            xCompDir = 'N';
        } else if (xActual > xTarget) {
            xCompDir = 'R';
        } else if (xActual < xTarget) {
            xCompDir = 'L';
        }

        if (Math.abs(targetY - yActual) < yThreshold) {
            yCompDir = 'N';
        } else if (targetY < yActual) {
            yCompDir = 'B';
        } else if (targetY > yActual) {
            yCompDir = 'F';
        }
        //speed: 0-90 is reverse, 90-180 is fowards
        //steering: between 145 and 35, angles?
    }


}
