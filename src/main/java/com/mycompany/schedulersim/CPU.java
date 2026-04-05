package com.mycompany.schedulersim;

/**
 * "Sanal" CPU
 */
 
public class CPU
{
    /**
     * Belirtilen görevi, belirtilen süre boyunca çalıştır.
     */
    public static void run(Task task, int slice) {
        System.out.println(
            "Running task = " + task.getName() +
            " [tid=" + task.getTid() +
            ", priority=" + task.getPriority() +
            ", burst=" + slice + "]"
        );
    }
}
