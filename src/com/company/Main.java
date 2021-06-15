package com.company;

import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapter;
import Concerete.NeroCustomerManager;
import Concerete.StarbucksCustomerManager;
import Entities.Customer;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        BaseCustomerManager neroCustomerManager=new NeroCustomerManager();
        BaseCustomerManager starbucksCustomerManager=new StarbucksCustomerManager(new MernisServiceAdapter());

        Customer ali=new Customer();
        ali.setId(1);
        ali.setFirstName("Ali");
        ali.setLastName("Öztürk");
        ali.setNationalityId("11111111111");
        ali.setDateOfBirth(LocalDate.of(2000,1,1));

        Customer customer2=new Customer(2,"customer2","customer",LocalDate.of(2000,1,2),"00000000000");
        neroCustomerManager.Save(ali);
        neroCustomerManager.Save(customer2);
        System.out.println("**********");
        starbucksCustomerManager.Save(ali);
        starbucksCustomerManager.Save(customer2);


    }
}
