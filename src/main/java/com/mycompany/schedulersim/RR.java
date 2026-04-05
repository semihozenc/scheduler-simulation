package com.mycompany.schedulersim;

import java.util.ArrayList;
import java.util.List;

public class RR implements Algorithm {

    private List<Task> queue;

    public RR(List<Task> queue) {
        // RR algoritmasında task'lar çalıştırıldıktan sonra kuyruğun sonuna eklenir (rotate edilir).
        // Bu nedenle orijinal listeyi değiştirmemek için yeni bir ArrayList kopyası oluşturuyoruz.        
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