package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String street;

    @Getter
    @Setter
    private Integer number;

    public Collection<Customer> getOwners(){
        return new HashSet<>(customers);
    }

    @ManyToMany(mappedBy = "addresses")
    @Getter
    private Collection<Customer> customers;
}
