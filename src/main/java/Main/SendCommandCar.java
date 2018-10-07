package Main;


import com.fazecast.jSerialComm.SerialPort;


public class SendCommandCar {

    String finalCMD;
    SerialPort serialPort = SerialPort.getCommPort("COM3");

    public void initComInterface(){
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);
        serialPort.openPort();
    }
    public void sendCmd(float speed, float ang){
        finalCMD = "1,"+speed+";2,"+ang+";";
        byte[] writeBuffer = new byte[serialPort.bytesAvailable()];
        serialPort.writeBytes(writeBuffer, writeBuffer.length);
    }


}
