package pl.krzysiekstuglik.PhoneBook.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "numberbook")
@Data
public class NumberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private int number;
}
