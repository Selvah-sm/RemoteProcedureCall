/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloserver;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author Selvah
 */
public class HelloClient {
    public static void main(String[] args) throws IOException{
             try {
                        Socket s = new Socket("localhost",6666);
                        System.out.println("Connected to the Server");
                        System.out.println("Enter a number: ");
                        OutputStreamWriter dout = new OutputStreamWriter(s.getOutputStream());
                        PrintWriter pw = new PrintWriter(dout);
                        Scanner scan = new Scanner(System.in);
                        int n;
                        n = scan.nextInt();
                        pw.println(n);
                        scan.close();
                        dout.close();
                        
                        HelloInterface hello = (HelloInterface) Naming.lookup("//localhost/Hello");
                        System.out.println("The entered number is " + hello.say());
                        s.close();
                        
                } catch (MalformedURLException | NotBoundException | RemoteException e) {
                        System.out.println("HelloClient exception: " + e);
                }

    }
}
