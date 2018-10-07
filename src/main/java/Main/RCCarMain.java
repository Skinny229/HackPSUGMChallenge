package Main;

import StreamCapture.ImageCreator;

public class RCCarMain {

    public static void main(String[] args) throws Exception {
        ImageCreator imgCreator = new ImageCreator();
        imgCreator.initCameraStream();
        RekognitionCompareFaces aws = new RekognitionCompareFaces();
        SendCommandCar cmdHandler = new SendCommandCar();
        cmdHandler.initComInterface();



        long waitParseTime = 500;

        long startWaitTime = System.currentTimeMillis();

        while (true) {

            if(System.currentTimeMillis() - startWaitTime < waitParseTime ) {
                System.out.println("Updating!");
                imgCreator.parseImage();
                 aws.test();

                startWaitTime = System.currentTimeMillis();

            }
        }
    }


}

