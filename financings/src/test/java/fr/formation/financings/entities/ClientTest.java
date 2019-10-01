package fr.formation.financings.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClientTest {

    Client client = new Client();

    Contact contact = new Contact();

    @Test
    public void should_return_client() {
	client.setLegalForm(null);
	client.setId((long) 1);
	client.setContact(contact);
	client.setName("Bob");
	String name = "Bob";
	Assertions.assertEquals(client.getName(), name);
    }
}
