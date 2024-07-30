package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

    Ticket ticket1 = new Ticket("Екатеринбург", "Москва", 40_000, 7_00, 8_00);
    Ticket ticket2 = new Ticket("Екатеринбург", "Москва", 10_000, 13_00, 18_00);
    Ticket ticket3 = new Ticket("Екатеринбург", "Москва", 15_000, 10_00, 12_00);
    Ticket ticket4 = new Ticket("Екатеринбург", "Москва", 55_000, 1_00, 1_30);
    Ticket ticket5 = new Ticket("Екатеринбург", "Казань", 35_000, 16_00, 19_00);

    @BeforeEach
    public void setUp() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
    }

    @Test
    public void testTicketPriceCompareTo() {

        Assertions.assertEquals(1, ticket1.compareTo(ticket2));
        Assertions.assertEquals(-1, ticket2.compareTo(ticket4));
    }

    @Test
    public void testTicketTimeComparator() {
        Ticket[] tickets = aviaSouls.findAll();
        Arrays.sort(tickets, ticketTimeComparator);
        Ticket[] expected = {ticket4, ticket1, ticket3, ticket5, ticket2};
        Ticket[] actual = tickets;
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testTicketSearch() {
Ticket[] expected = {ticket2,ticket3,ticket1,ticket4};
        Ticket[] actual = aviaSouls.search("Екатеринбург","Москва");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testTicketSearchAndSort() {
        Ticket[] expected = {ticket4,ticket1,ticket3,ticket2};
        Ticket[] actual = aviaSouls.searchAndSortBy("Екатеринбург","Москва", ticketTimeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
