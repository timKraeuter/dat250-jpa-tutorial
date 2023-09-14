package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String name;

    @ManyToMany
    @Getter
    private Collection<Address> addresses = new ArrayList<>();

    @OneToMany
    @Getter
    private Collection<CreditCard> creditCards = new ArrayList<>();
}
