package com.mycompany.schedulersim;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Schedulersim {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CPU Scheduler Simulation ===");
        System.out.println("Lütfen bir algoritma seçiniz:");
        System.out.println("1 - FCFS");
        System.out.println("2 - SJF");
        System.out.println("3 - Priority");
        System.out.println("4 - Round Robin");
        System.out.println("5 - Priority Round Robin");
        System.out.print("Seçiminiz: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // buffer temizleme

        System.out.print("Görevlerin bulunduğu dosya adını giriniz (ör: schedule.txt): ");
        String fileName = scanner.nextLine();

        List<Task> queue = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length != 3) {
                    System.out.println("Hatalı satır formatı: " + line);
                    continue;
                }

                String name = parts[0].trim();
                int priority = Integer.parseInt(parts[1].trim());
                int burst = Integer.parseInt(parts[2].trim());

                Task task = new Task(name, priority, burst);
                queue.add(task);
            }

        } catch (IOException e) {
            System.out.println("Dosya okunurken hata oluştu: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.out.println("Dosya içinde sayısal veri hatası var: " + e.getMessage());
            return;
        }

        if (queue.isEmpty()) {
            System.out.println("Görev listesi boş. Program sonlandırılıyor.");
            return;
        }

        Algorithm scheduler = null;

        switch (choice) {
            case 1:
                scheduler = new FCFS(queue);
                System.out.println("\nSeçilen algoritma: FCFS");
                break;
            case 2:
                scheduler = new SJF(queue);
                System.out.println("\nSeçilen algoritma: SJF");
                break;
            case 3:
                scheduler = new Priority(queue);
                System.out.println("\nSeçilen algoritma: Priority");
                break;
            case 4:
                scheduler = new RR(queue);
                System.out.println("\nSeçilen algoritma: Round Robin");
                break;
            case 5:
                scheduler = new PriorityRR(queue);
                System.out.println("\nSeçilen algoritma: Priority Round Robin");
                break;
            default:
                System.out.println("Geçersiz seçim yaptınız.");
                return;
        }

        System.out.println("\n--- Yüklenen Görevler ---");

        for (Task task : queue) {
            System.out.println(
                "Task = " + task.getName() +
                " [tid=" + task.getTid() +
                ", priority=" + task.getPriority() +
                ", burst=" + task.getBurst() + "]"
            );
        }

        System.out.println("\n--- Scheduling Başlatılıyor ---");
        scheduler.schedule();

        scanner.close();
    }
}