package com.mftplus.storage.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder


@Entity(name="personEntity")
@Table(name="person_tbl")

@NamedQueries({
        @NamedQuery(name = "Person.FindByNameFamily",query = "select oo from personEntity oo where name like :name and oo.family like :family")
})
public class Person extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="p_name",length = 30)
    @Pattern(regexp = "^[a-zA-Z\\s]{0,20}$", message = "Invalid Name")
    private String name;

    @Column(name="p_family",length = 30)
    @Pattern(regexp = "^[a-zA-Z\\s]{0,20}$", message = "Invalid Family")
    private String family;
}
