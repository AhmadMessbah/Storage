package com.mftplus.storage.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@NamedQueries({@NamedQuery(name="Stuff.FindByName",query = "select oo from stuffEntity oo where oo.name =:name"),
        @NamedQuery(name="Stuff.FindByGroupId", query = "select oo from stuffEntity oo where oo.group.id =:groupId"),
        @NamedQuery(name="Stuff.FindByGroupTitle", query = "select oo from stuffEntity oo where oo.group.title =:groupTitle")})

@Table(name = "stuff_tbl")
@Entity(name = "stuffEntity")
public class Stuff extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "s_name")
    @Pattern(regexp = "^[a-zA-z1-9]$" , message = "invalid name!")
    private String name;

    @OneToOne
    @JoinColumn(name = "s_group")
    private Group group;

    @OneToOne
    @JoinColumn(name = "s_stuff_unit")
    private StuffUnit stuffUnit;





}
