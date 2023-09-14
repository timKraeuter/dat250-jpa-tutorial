package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.ArrayList;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }
  }

  private static void createObjects(EntityManager em) {
    Address address = new Address();
    address.setNumber(28);
    address.setStreet("Inndalsveien");

    Bank bank = new Bank();
    bank.setName("Pengebank");

    Pincode code = new Pincode();
    code.setPincode("123");
    code.setCount(1);

    CreditCard c1 = new CreditCard();
    c1.setNumber(12345);
    c1.setBalance(-5000);
    c1.setCreditLimit(-10000);
    c1.setPincode(code);
    c1.setBank(bank);

    CreditCard c2 = new CreditCard();
    c2.setNumber(123);
    c2.setBalance(1);
    c2.setCreditLimit(2000);
    c2.setPincode(code);
    c2.setBank(bank);

    Customer mm = new Customer();
    mm.setName("Max Mustermann");
    mm.getAddresses().add(address);
    mm.getCreditCards().add(c1);
    mm.getCreditCards().add(c2);

    em.persist(address);
    em.persist(mm);
    em.persist(code);
    em.persist(c1);
    em.persist(c2);
    em.persist(bank);
  }
}
