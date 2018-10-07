package Main;

import StreamCapture.ImageCreator;

public class RCCarMain {

    public static void main(String[] args) throws Exception {
        ImageCreator imgCreator = new ImageCreator();
        imgCreator.initCameraStream();
        CommandGeneration cmdGenerator = new CommandGeneration();
        RekognitionCompareFaces aws = new RekognitionCompareFaces();
        SendCommandCar cmdHandler = new SendCommandCar();
        cmdHandler.initComInterface();


        long waitParseTime = 500;

        long startWaitTime = System.currentTimeMillis();
        long sendCmdStartDelay = System.currentTimeMillis();

        while (true) {
            if (System.currentTimeMillis() - startWaitTime < waitParseTime) {
                System.out.println("Updating!");
                imgCreator.parseImage();
                cmdGenerator.getFace(aws.getFaceInStream());
                startWaitTime = System.currentTimeMillis();
            }
            if (System.currentTimeMillis() - sendCmdStartDelay < 100) {
                cmdHandler.sendCmd(CommandGeneration.magCompY, CommandGeneration.magCompX);
                sendCmdStartDelay = System.currentTimeMillis();
            }
        }
    }


}

