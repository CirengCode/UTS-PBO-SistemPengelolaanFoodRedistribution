/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Scanner;
import model.Penyaluran;
import util.InputUtil;

public class PetugasService {

    private final PenyaluranService penyaluranService;

    public PetugasService(PenyaluranService penyaluranService) {
        this.penyaluranService = penyaluranService;
    }

    public void lihatDataPenyaluran(Scanner scanner) {
        boolean berjalan = true;

        while (berjalan) {
            penyaluranService.tableData();

            System.out.println("[1] Update Status Penyaluran");
            System.out.println("[2] Kembali");

            int pilihan =
                    InputUtil.bacaInt(scanner, ">> ");

            switch (pilihan) {

                case 1 -> updateStatusPenyaluran(scanner);

                case 2 -> berjalan = false;

                default -> {
                    System.out.println("------------------------------------");
                    System.out.println("Mohon maaf, pilihan tidak valid! T-T");
                    System.out.println("------------------------------------");
                    InputUtil.tekanEnter(scanner);
                }
            }
        }
    }

    private void updateStatusPenyaluran(Scanner scanner) {

        int idPenyaluran =
                InputUtil.bacaInt(scanner, "ID Penyaluran: ");

        Penyaluran penyaluran =
                penyaluranService.cariPenyaluran(idPenyaluran);

        if (penyaluran == null) {
            System.out.println("------------------------------------");
            System.out.println("[ID Penyaluran tidak ada -__-!]");
            System.out.println("------------------------------------");
            InputUtil.tekanEnter(scanner);
            return;
        }

        System.out.println("------------------------------------");
        System.out.println("Data Penyaluran");
        System.out.println("------------------------------------");
        System.out.println("ID Penyaluran: " + penyaluran.getIdPenyaluran());
        System.out.println("Nama Kegiatan: " + penyaluran.getNamaKegiatan());
        System.out.println("Status Penyaluran: " + penyaluran.getStatusPenyaluran());
        System.out.println("------------------------------------");

        System.out.print("Yakin ingin meng-update status? (y/n): ");
        String konfirmasi = scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
            System.out.println("------------------------------------");
            String statusPenyaluran = InputUtil.bacaString(scanner,"Status Penyaluran Baru: ");

            penyaluran.setStatusPenyaluran(statusPenyaluran);

            System.out.println("------------------------------------");
            System.out.println("[Yay! Status berhasil di-update ^^]");
            System.out.println("------------------------------------");

        } else {

            System.out.println("------------------------------------");
            System.out.println("[Update dibatalkan ^^]");
            System.out.println("------------------------------------");
        }

        InputUtil.tekanEnter(scanner);
    }
}
