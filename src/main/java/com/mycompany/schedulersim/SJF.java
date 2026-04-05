package com.mycompany.schedulersim;

import java.util.List;

public class SJF implements Algorithm {
    
    private List<Task> queue;

    public SJF(List<Task> queue) {
        this.queue = queue;
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
