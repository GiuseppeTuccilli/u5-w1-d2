package com.epicode.U5D1.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    @Qualifier("ordine1")
    Ordine ordine;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(ordine);

    }
}
