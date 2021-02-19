package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table (name = "configuration_pc")
public class Computer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String processor;
    @Column
    private String videoCard;
    @Column
    private String hdd;
    @Column
    private String ram;
    @Column
    private String powerSupply;
}
