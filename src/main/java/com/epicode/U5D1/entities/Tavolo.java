package com.epicode.U5D1.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tavolo {
    int numeroTavolo;
    int copertiMax;
    private StatoTavolo statoTavolo;

    public Tavolo(int numero, int copertiMax, StatoTavolo stato) {
        this.copertiMax = copertiMax;
        this.numeroTavolo = numero;
        this.statoTavolo = stato;
    }

    @Override
    public String toString() {
        return "Tavolo{" +
                "numeroTavolo=" + numeroTavolo +
                ", copertiMax=" + copertiMax +
                ", statoTavolo=" + statoTavolo +
                '}';
    }
}
