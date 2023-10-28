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

@NamedQueries({@NamedQuery(name="StuffUnit.FindByName",query = "select oo from stuffUnitEntity oo where oo.unitName =:unitName")})

@Table(name="stuff_unit_tbl")
@Entity(name = "stuffUnitEntity")
public class StuffUnit extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "su_unitName")
    @Pattern(regexp = "^[A-Za-zا-ی\\s]{2,30}$", message = "Invalid Unit Name")
    private String unitName;


}
