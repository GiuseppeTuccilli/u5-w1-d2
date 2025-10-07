package com.epicode.U5D1.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Ordine {
    private int numeroOrdine;
    private List<Item> items;
    private Tavolo tavolo;
    private StatoOrdine stato;
    private LocalDateTime oraAcquisizione;
    private double costo;
    private int numCoperti;

    public Ordine(int numero, List<Item> items, Tavolo tavolo, StatoOrdine stato, double costoCoperto, int numeroCop) {
        this.oraAcquisizione = LocalDateTime.now();
        this.numeroOrdine = numero;
        this.items = items;
        this.tavolo = tavolo;
        this.stato = stato;
        double sum = 0;
        for (int i = 0; i < items.size(); i++) {
            sum = sum + items.get(i).getPrice();
        }
        this.costo = (costoCoperto * numeroCop) + sum;

    }

    @Override
    public String toString() {
        return "Ordine{" +
                "numeroOrdine=" + numeroOrdine +
                ", items=" + items +
                ", tavolo=" + tavolo +
                ", stato=" + stato +
                ", oraAcquisizione=" + oraAcquisizione +
                ", costo=" + costo +
                '}';
    }
}
