//package com.paul.IOStreams;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//
///**
// * Created by paul on 09.07.17.
// */
//public class ServerConnection {
//
//    public void hostServerCreation(){
//        try {
//            ServerSocket s = new ServerSocket(5000);
//            while (true)
//            {
//                Socket incoming = s.accept();
//                Runnable clientRunHandler = new ThreadedClientHandler(incoming);
//                Thread t = new Thread(clientRunHandler);
//                t.start();
//            }
//        } catch (IOException e)  {
//            e.printStackTrace();
//        }
//    }
//}
