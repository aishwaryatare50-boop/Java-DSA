package OOPS;

import bank.*;

public class Packages {
    public static void main(String args[]) {
        Account account1 = new Account();

        account1.name = "Customer1";
        account1.setPassword("1234");
        System.out.println(account1.getPassword());
    }
}