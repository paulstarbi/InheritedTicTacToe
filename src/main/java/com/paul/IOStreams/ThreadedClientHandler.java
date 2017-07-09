//package com.paul.IOStreams;
//
//import com.paul.GameEngine.BestOfTreeFormat;
//import com.paul.GameEngine.GameFormats;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.util.ArrayDeque;
//import java.util.Scanner;
//
///**
// * Created by paul on 09.07.17.
// */
//public class ThreadedClientHandler implements Runnable {
//    private Socket incoming;
//    private InputStream inStream;
//    private OutputStream outStream;
//    private OutputController outputController;
//    private InputController inputController;
//
//    public ThreadedClientHandler(Socket i){
//        incoming = i;
//    }
//
//    public void run(){
//    try {
//        try{
//            inStream = incoming.getInputStream();
//            outStream = incoming.getOutputStream();
//            inputController = new InputController(inStream,outputController);
//            outputController = new OutputController(outStream);
//            outPrint(outputController);
//            boolean done = false;
//            while (!done) {
//                outputController.printWelcomeMessage();
//                GameFormats bo3 = new BestOfTreeFormat(inputController, outputController,true);
//                bo3.executeGameFormat();
//                done = true;
//            }
//        }
//        finally {
//            incoming.close();
//        }
//        } catch (IOException e) {
//             e.printStackTrace();
//        }
//    }
//
//    private void outPrint(OutputController out) {
//        out.printBayMessage();
//    }
//}
//
