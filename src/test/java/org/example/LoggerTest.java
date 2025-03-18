package org.example;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    @BeforeAll
    static void criarCenario() {
        User user1 = new User("Alice", "123456", 10000.00);
        User user2 = new User("Bob", "654321", 5000.00);

        user1.logIn();
        user1.checkBalance();
        user1.depositMoney(1000);
        user1.withdrawMoney(3000);
        user1.transferMoney(user2, 2000);
        user1.payBill(500);
        user1.logOut();

        user2.logIn();
        user2.checkBalance();
        user2.depositMoney(2000);
        user2.withdrawMoney(1000);
        user2.transferMoney(user2, 200);
        user2.payBill(450);
        user2.logOut();
    }

    @Test
    void deveTestarInstanciaUnica() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        assertSame(logger1,logger2, "Ambas as instancias devem ser a mesma.");
    }



}