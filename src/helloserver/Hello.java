/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Selvah
 */
public class Hello extends UnicastRemoteObject
           implements HelloInterface {
           private final int message;
           public Hello(int num) throws RemoteException {
                     message = num;
           }

    /**
     *
     * @return
     * @throws RemoteException
     */
    @Override
           public String say() throws RemoteException {
               if(message%2==0)
                    return "Even";
               else
                   return "Odd";
}
}

