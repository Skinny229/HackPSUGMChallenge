package StreamCapture;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamStreamer;
import com.github.sarxos.webcam.ds.ipcam.IpCamAuth;
import com.github.sarxos.webcam.ds.ipcam.IpCamDevice;
import com.github.sarxos.webcam.ds.ipcam.IpCamDeviceRegistry;
import com.github.sarxos.webcam.ds.ipcam.IpCamMode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;

public class ImageCreator
{
    IpCamDevice webcam;
    public void initCameraStream() throws MalformedURLException
    {

            IpCamDeviceRegistry.register("RCVision", new URL("http://66.71.22.148:8080/shot.jpg"), IpCamMode.PULL, new IpCamAuth("bla", "blabla"));
            webcam = IpCamDeviceRegistry.getIpCameras().get(0);
            webcam.open();
    }

    public void parseImage() throws IOException {
        // get image
        webcam.open();
        BufferedImage image = webcam.getImage();

        // save image to PNG file
        ImageIO.write(image, "PNG", new File("src/main/java/Resources/rcCarView.png"));
    }
}
