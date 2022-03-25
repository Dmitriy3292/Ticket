package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Manager manager = new Manager();
    private Ticket air1 = new Ticket(1, 560, "VKO", "SIP", 90);
    private Ticket air2 = new Ticket(2, 585, "DME", "AER", 90);
    private Ticket air3 = new Ticket(3, 420, "SVO", "MMK", 76);
    private Ticket air4 = new Ticket(4, 380, "BKA", "MMK", 85);

    @BeforeEach
    public void before() {
        manager.save(air1);
        manager.save(air2);
        manager.save(air3);
        manager.save(air4);
    }

    @Test
    void shouldSearchByFrom_() {
        Ticket[] expented = new Ticket[]{air2};
        Ticket[] actual = manager.searchBy("DME", "");
        assertArrayEquals(expented, actual);
    }

    @Test
    void shouldSearchByFromOf() {
        Ticket[] expented = new Ticket[]{air4, air1};
        Ticket[] actual = manager.searchBy("BKA", "SIP");
        assertArrayEquals(expented, actual);
    }

    @Test
    void shouldSearchBy_Of() {
        Ticket[] expented = new Ticket[]{air1};
        Ticket[] actual = manager.searchBy("", "SIP");
        assertArrayEquals(expented, actual);
    }

    @Test
    void shouldSearchByOfFrom() {
        Ticket[] expented = new Ticket[]{};
        Ticket[] actual = manager.searchBy("AER", "BKA");
        assertArrayEquals(expented, actual);
    }

    @Test
    void shouldSearchByNoValues() {
        Ticket[] expented = new Ticket[]{};
        Ticket[] actual = manager.searchBy("", "");
        assertArrayEquals(expented, actual);
    }

    @Test
    void shouldSearchByFromOfOf() {
        Ticket[] expented = new Ticket[]{air4, air3, air2};
        Ticket[] actual = manager.searchBy("DME", "MMK");
        assertArrayEquals(expented, actual);
    }

}