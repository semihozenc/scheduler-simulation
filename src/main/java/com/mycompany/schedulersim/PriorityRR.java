package com.mycompany.schedulersim;

import java.util.ArrayList;
import java.util.List;

public class PriorityRR implements Algorithm {

    private List<Task> queue;

    public PriorityRR(List<Task> queue) {
        // PriorityRR algoritmasında aynı öncelikteki task'lar arasında Round Robin uygulanır.
        // Bu süreçte liste sürekli değiştirildiği için (remove/add), orijinal listeyi korumak adına kopya alıyoruz.        
        this.queue = new ArrayList<>(queue);
    }

    @Override
    public void schedule() {
        // Algoritmanın çalışması
    }

    @Override
    public Task pickNextTask() {
        // Task seçimi
    }
}