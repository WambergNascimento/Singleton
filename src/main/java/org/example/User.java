package org.example;

import java.util.UUID;

public class User {
    private String name;
    private String accountNumber;
    private double balance;

    public void setName(String name) {
        this.name = name;
    }

    private boolean loggedIn = false;

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public UUID getId() {
        return id;
    }

    private UUID id;

    public User(String name, String accountNumber, double balance) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void logIn() {
        loggedIn = true;
        System.out.println(name + " logged in successfully.");
        Logger.getInstance().setRegister("Login efetuado.", id);
    }

    public void checkBalance() {
        System.out.println("Your balance: R$ " + balance);
        Logger.getInstance().setRegister("Saldo checado.", id);
    }

    public void depositMoney(double amount) {
        balance += amount;
        System.out.println("R$ " + amount + " deposited. New balance: R$ " + balance);
        Logger.getInstance().setRegister("Deposito efetuado.", id);
    }

    public void withdrawMoney(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            Logger.getInstance().setRegister("Tentativa de saque.", id);
        } else {
            balance -= amount;
            System.out.println("R$ " + amount + " withdrawn. New balance: R$ " + balance);
            Logger.getInstance().setRegister("Saque efetuado", id);
        }
    }

    public void transferMoney(User recipient, double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            Logger.getInstance().setRegister("Tentativa de transferencia.", id);
        } else {
            balance -= amount;
            recipient.balance += amount;
            System.out.println("R$ " + amount + " transferred to " + recipient.name + ". New balance: R$ " + balance);
            Logger.getInstance().setRegister("Transferencia executada.", id);
        }
    }

    public void payBill(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds to pay the bill.");
            Logger.getInstance().setRegister("Tentativa de pagamento de conta executado.", id);
        } else {
            balance -= amount;
            System.out.println("Bill of R$ " + amount + " paid. New balance: R$ " + balance);
            Logger.getInstance().setRegister("Pagamento de conta executado.", id);
        }
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction history displayed.");
        Logger.getInstance().setRegister("Histótico de conta consultado.", id);
    }

    public void logOut() {
        loggedIn = false;
        System.out.println(name + " logged out.");
        Logger.getInstance().setRegister("Logout efetuado.", id);
    }
}