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
import service.PetugasService;
import util.InputUtil;

public class PetugasController {
    private DonasiService donasiService;
    private PenerimaService penerimaService;
    private PetugasService petugasService;
    
    public PetugasController(
            DonasiService donasiService,
            PenerimaService penerimaService,
            PenyaluranService penyaluranService) {

        this.donasiService = donasiService;
        this.penerimaService = penerimaService;
        this.petugasService = new PetugasService(penyaluranService);
    }
    
    public void mulai(Scanner scanner) {
        menuPetugas(scanner);
    }

    private void menuPetugas(Scanner scanner) {
        boolean berjalanPetugas = true;

        while (berjalanPetugas) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("              MENU PETUGAS              ");
            System.out.println("========================================");
            System.out.println("[1] Lihat Data Donasi");
            System.out.println("[2] Lihat Data Penerima");
            System.out.println("[3] Lihat Data Penyaluran");
            System.out.println("[4] Kembali");

            int pilihanPetugas = InputUtil.bacaInt(scanner, ">> ");

            switch (pilihanPetugas) {

                case 1 -> {
                    donasiService.tableData();
                    InputUtil.tekanEnter(scanner);
                }

                case 2 -> {
                    penerimaService.tableData();
                    InputUtil.tekanEnter(scanner);
                }

                case 3 -> {
                    petugasService.lihatDataPenyaluran(scanner);
                }

                case 4 -> berjalanPetugas = false;

                default -> {
                    System.out.println("------------------------------------");
                    System.out.println("Mohon maaf, pilihan tidak valid! T-T");
                    System.out.println("------------------------------------");
                    InputUtil.tekanEnter(scanner);
                }
            }
        }
    }

}
