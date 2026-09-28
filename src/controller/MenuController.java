/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;
import service.DonasiService;
import service.DonaturService;
import service.PenerimaService;
import service.PenyaluranService;
import util.InputUtil;

public class MenuController {
    
    private AdminController admin;
    private PetugasController petugas;

    public MenuController() {

        DonaturService donaturService = new DonaturService();
        DonasiService donasiService = new DonasiService(donaturService);
        PenerimaService penerimaService = new PenerimaService();
        PenyaluranService penyaluranService = new PenyaluranService(donasiService, penerimaService);

        admin = new AdminController(donaturService, donasiService, penerimaService, penyaluranService);
        petugas = new PetugasController(donasiService, penerimaService,penyaluranService);
    }


    public void mulai(Scanner scanner) {
        boolean berjalan = true;

        while (berjalan) {

            tampilkanMenu();

            int pilihan = InputUtil.bacaInt(scanner, ">> ");

            switch (pilihan) {

                case 1 -> admin.mulai(scanner);

                case 2 -> petugas.mulai(scanner);

                case 3 -> {
                    System.out.println("------------------------------------");
                    System.out.println("[Terima kasih sudah menggunakan");
                    System.out.println(" Food Redistribution System ^^]");
                    System.out.println("------------------------------------");
                    berjalan = false;
                }

                default -> {
                    System.out.println("------------------------------------");
                    System.out.println("Mohon maaf, pilihan tidak valid! T-T");
                    System.out.println("------------------------------------");
                    InputUtil.tekanEnter(scanner);
                }
            }
        }
    }
    
    private void tampilkanMenu() {
        System.out.println("========================================");
        System.out.println("            SELAMAT DATANG DI           ");
        System.out.println("        FOOD REDISTRIBUTION SYSTEM      ");
        System.out.println("========================================");
        System.out.println("[1] Admin");
        System.out.println("[2] Petugas");
        System.out.println("[3] Keluar");
    }
    
}
