package com.AboussororAbderrahmane.app.controllers;


import com.AboussororAbderrahmane.app.entities.Client;
import com.AboussororAbderrahmane.app.entities.Employee;
import com.AboussororAbderrahmane.app.services.ClientService;
import com.AboussororAbderrahmane.app.services.EmployeeService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ClientController {

    private final ClientService clientService;
    private final EmployeeService employeeService;
    private static final Scanner scanner = new Scanner(System.in);

    public ClientController(ClientService instance1, EmployeeService instance2) {
        clientService = instance1;
        employeeService = instance2;
    }

    public void save() {

        Client client = new Client();
        System.out.print("Enter The Client Code -> ");
        String code = scanner.next();
        client.setCode(code);
        System.out.print("Enter The Client First Name -> ");
        String firstName = scanner.next();
        client.setFirstName(firstName);
        System.out.print("Enter The Client Last Name -> ");
        String lastName = scanner.next();
        client.setLastName(lastName);
        LocalDate birthDate = LocalDate.of(2001, 2, 2);
        client.setBirthDate(birthDate);
        System.out.print("Enter The Client Phone Number -> ");
        String phoneNumber = scanner.next();
        client.setPhoneNumber(phoneNumber);
        System.out.print("Enter The Client Adress -> ");
        String address = scanner.next();
        client.setAddress(address);
        System.out.print("Enter The Employee Code -> ");
        String employeeCode = scanner.next();
        Employee employee = employeeService.findByCode(employeeCode);
        client.setEmployee(employee);
        System.out.println(clientService.save(client));

    }

    public void findAll() {
        List<Client> clients = clientService.findAll();
        for (Client client: clients) {
            System.out.println(client);
        }
    }

    public void findByCode() {
        System.out.print("Enter The Code Of The Client You're Looking For -> ");
        String clientCode = scanner.next();
        System.out.println(clientService.findByCode(clientCode));
    }

    public void update() {
        System.out.print("Enter The Code Of The Client You Wanna Update -> ");
        String code = scanner.next();

        if(clientService.findByCode(code) != null) {

            System.out.println("Enter The New Information");
            Client client = new Client();
            System.out.print("Enter The Client First Name -> ");
            String firstName = scanner.next();
            client.setFirstName(firstName);
            System.out.print("Enter The Client Last Name -> ");
            String lastName = scanner.next();
            client.setLastName(lastName);
            LocalDate birthDate = LocalDate.of(2001, 2, 2);
            client.setBirthDate(birthDate);
            System.out.print("Enter The Client Phone Number -> ");
            String phoneNumber = scanner.next();
            client.setPhoneNumber(phoneNumber);
            System.out.print("Enter The Client Address -> ");
            String adress = scanner.next();
            client.setAddress(adress);
            client.setCode(code);
            boolean clientUpdated = clientService.update(client);
            if (clientUpdated) {
                System.out.println("Client updated!");
            }
            else {
                System.out.println("Oops...Something went wrong!");
            }
        }
    }

    public void findByAddress() {
        System.out.print("Enter The Address Of The Client You're Looking For -> ");
        String clientAddress = scanner.next();
        System.out.println(clientService.findByAddress(clientAddress));

    }

    public void delete() {

        System.out.print("Enter The Code Of The Client You Wanna Delete -> ");
        String clientCodeToDelete = scanner.next();
        if(clientService.delete(clientCodeToDelete)) {
            System.out.println("Deleted With Success!");
        }

    }

}
