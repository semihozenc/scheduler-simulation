package com.mycompany.schedulersim;

public interface Algorithm
{
    /**
     * Zamanlayıcıyı başlatır
     */
    public abstract void schedule();

    /**
     * Uygun zamanlama algoritmasını kullanarak bir sonraki görevi seçer
     */
    public abstract Task pickNextTask();
}
