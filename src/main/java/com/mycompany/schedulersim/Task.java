package com.mycompany.schedulersim;

/**
 * Zamanlama algoritması tarafından zamanlanacak görev.
 *
 * Her görev aşağıdakilerle temsil edilir:
 *
 *  String name - görev adı, mutlaka benzersiz olması gerekmez
 *
 *  int tid - benzersiz görev tanımlayıcısı
 *
 *  int priority - görevin göreceli önceliği; burada daha yüksek sayı,
 *  daha yüksek göreceli önceliği gösterir.
 *
 *  int burst - görevin CPU patlaması
 */

import java.util.concurrent.atomic.AtomicInteger;

public class Task
{
    // her bir görevin gösterimi
    private String name;
    private int tid;
    private int priority;
    private int burst;

    /**
     * Her göreve benzersiz bir görev kimliği atamak için tamsayı kullanıyoruz.
     */
    private static AtomicInteger tidAllocator = new AtomicInteger();

    public Task(String name, int priority, int burst) {
        this.name = name;
        this.priority = priority;
        this.burst = burst;

        this.tid = tidAllocator.getAndIncrement();
    }

    /**
     * Uygun getter yöntemleri
     */
    public String getName() {
        return name;
    }

    public int getTid() {
        return tid;
    }

    public int getPriority() {
        return priority;
    }

    public int getBurst() {
        return burst;
    }

    /**
     * Uygun setter yöntemleri
     */
    public int setPriority(int priority) {
        this.priority = priority;

        return priority;
    }
    
    public int setBurst(int burst) {
        this.burst = burst;

        return burst;
    }

    /**
     * equals() yöntemini yeniden tanımlıyoruz, böylece
     * Java koleksiyon sınıflarında bir Task nesnesi kullanabiliyoruz.
     */
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (!(other instanceof Task))
            return false;

        /**
         * Aksi takdirde başka bir görevle karşı karşıyayız.
         * İki görev, aynı tid değerine sahipse eşittir.
         */
        Task rhs = (Task)other;
        return (this.tid == rhs.tid) ? true : false;
    }

    public String toString() {
        return
            "Name: " + name + "\n" + 
            "Tid: " + tid + "\n" + 
            "Priority: " + priority + "\n" + 
            "Burst: " + burst + "\n";
    }
}
