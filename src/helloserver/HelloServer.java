/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Selvah
 */
public class HelloServer {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
                try {
                        ServerSocket ss= new ServerSocket(6666);
                        System.out.println("Server is connected and ready for operation.");
                        Socket s = ss.accept();
                        System.out.println("Connection Established");
                        Scanner scan = new Scanner(s.getInputStream());
                        int number;
                        number= scan.nextInt();
                        scan.close();
                        
                        Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);//1099 is the port number
                        r.rebind("Hello", new Hello(number));
                        s.close();
                        ss.close();
                        
                        } catch (RemoteException e) {
                        System.out.println("Server not connected: " + e);
                        }
    }         
}
