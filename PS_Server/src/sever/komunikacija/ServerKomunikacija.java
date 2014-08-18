/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sever.komunikacija;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author aleksandar
 */
public class ServerKomunikacija {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSoket = new ServerSocket(8081);
        System.out.println("Server pokernut");
        while (true) {
            Socket soket = serverSoket.accept();

            KlijentNit k = new KlijentNit(soket);
            System.out.println("Prihvacen klijent");
        }
    }
}
