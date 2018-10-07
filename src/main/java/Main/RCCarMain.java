package Main;

<<<<<<< HEAD
import StreamCapture.ImageCreator;

import java.io.IOException;
import java.net.MalformedURLException;

public class RCCarMain {

    public static void main(String[] args) throws IOException {
        ImageCreator imgCreator = new ImageCreator();
        imgCreator.initCameraStream();


        long waitParseTime = 250;

        long startWaitTime = System.currentTimeMillis();

        while (true) {

            if(System.currentTimeMillis() - startWaitTime < waitParseTime ) {
                System.out.println("Updating!");
                imgCreator.parseImage();
                startWaitTime = System.currentTimeMillis();
            }

        }
    }

=======




public class RCCarMain {
    // Instantiates a client
    public static void main(String[] args) throws Exception
    {


    }


>>>>>>> googlevisionAPI
}

