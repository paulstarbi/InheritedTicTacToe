package com.paul.IOStreams;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Created by paul on 09.07.17.
 */
public class ConnectionCreate {
    Socket clientSocket;
    ServerSocket serverSocket;
    Socket incomingSocket;
    String ip="127.0.0.1";
    InputStream inStream;
    OutputStream outStream;
    OutputController outputController;
    InputController inputController;
    private boolean ServerConnect = false;

    public ConnectionCreate(InputController inputController, OutputController outputController) {
        this.outputController = outputController;
         this.inputController = inputController;
    }

    public void initializeGame() {
        if (ServerConnect)
            initializeServer();
        else
            clientConnect();
    }

    private void clientConnect() {
        try {
            clientSocket = new Socket(ip, 5000);
            clientSocket.getOutputStream().write("a".getBytes());
            outStream =new DataOutputStream(clientSocket.getOutputStream());
            inStream = new DataInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeServer() {
            try {
                serverSocket = new ServerSocket(5000);
                incomingSocket = serverSocket.accept();
            } catch (IOException e)  {
                e.printStackTrace();
            }
    }
}
