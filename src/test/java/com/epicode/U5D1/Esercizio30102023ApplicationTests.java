package com.epicode.U5D1;

import com.epicode.U5D1.entities.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Esercizio30102023ApplicationTests {

    @Test
    void CostoOrdine() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Pizza margherita = ctx.getBean("pizza_margherita", Pizza.class);
        Drink acqua = ctx.getBean("water", Drink.class);
        List<Item> ordList = new ArrayList<Item>();
        ordList.add(margherita);
        ordList.add(acqua);
        Tavolo t = ctx.getBean("tavolo1", Tavolo.class);
        double cop = ctx.getBean("costoCoperto", Double.class);
        Ordine ordine = new Ordine(5, ordList, t, StatoOrdine.SERVITO, cop, 2);
        double costo = ordine.getCosto();
        assertEquals(16.28, costo);
        ctx.close();

    }

    @Test
    void menuNonVuoto() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Menu m = ctx.getBean("menu", Menu.class);
        List<Pizza> mP = m.getPizzaList();
        List<Topping> mT = m.getToppingList();
        List<Drink> mD = m.getDrinkList();
        assertFalse(mP.isEmpty());
        assertFalse(mT.isEmpty());
        assertFalse(mD.isEmpty());

        ctx.close();
    }

    @ParameterizedTest
    @CsvSource({"1, 11.280000000000001", "2, 16.28", "3, 21.28"})
    void costoCoperti(int cop, double res) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Pizza margherita = ctx.getBean("pizza_margherita", Pizza.class);
        Drink acqua = ctx.getBean("water", Drink.class);
        List<Item> ordList = new ArrayList<Item>();
        ordList.add(margherita);
        ordList.add(acqua);
        Tavolo t = ctx.getBean("tavolo1", Tavolo.class);
        double copS = ctx.getBean("costoCoperto", Double.class);
        Ordine ordine = new Ordine(5, ordList, t, StatoOrdine.SERVITO, copS, cop);
        double costo = ordine.getCosto();
        assertEquals(res, costo);

        ctx.close();
    }

    @Test
    void costoOrdiniBean() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Ordine or1 = ctx.getBean("ordine1", Ordine.class);
        Ordine or2 = ctx.getBean("ordine2", Ordine.class);
        double sumCost = or1.getCosto() + or2.getCosto();
        assertTrue(sumCost > 53);
        assertTrue(sumCost < 54.97);

        ctx.close();
    }


}
