//package com.paul.IOStreams;
//
//import java.io.*;
//import java.net.Socket;
///**
// * Created by paul on 09.07.17.
// */
//public class ConnectionCreate {
//    Socket socket;
//    int port =5000;
//    String ip;
//    InputStream inStream;
//    OutputStream outStream;
//    OutputController outputController;
//    InputController inputController;
//    private boolean accepted;
//    private boolean yourTurn;
//    private boolean circle;
//
//    public ConnectionCreate(InputController inputController, OutputController outputController) {
//        this.outputController = outputController;
//         this.inputController = inputController;
//    }
//
//    public void initializeGame() {
//        outputController.printSelectIPMessage();
//        ip = inputController.getIP();
//        if (!connection()) initializeServer();
//    }
//
//
//    private boolean connection() {
//        try {
//            socket = new Socket(ip, port);
//            outStream =new DataOutputStream(socket.getOutputStream());
//            inStream = new DataInputStream(socket.getInputStream());
//            accepted = true;
//        } catch (IOException e) {
//            System.out.println("Unable to connect to the address: " + ip + ":" + port + " | Starting a server");
//            return false;
//        }
//        System.out.println("Successfully connected to the server.");
//        return true;
//    }
//    private void initializeServer() {
//        ServerConnection serverConnection = new ServerConnection();
//        serverConnection.hostServerCreation();
//        yourTurn = true;
//        circle = false;
//    }
//}
