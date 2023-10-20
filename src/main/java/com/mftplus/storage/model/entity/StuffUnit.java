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

@Table(name="stuff_unit_tbl")
@Entity(name = "stuffUnit")
public class StuffUnit extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "su_unitName")
    @Pattern(regexp = "^[A-Za-z]{2,30}$", message = "Invaild Unit Name")
    private String unitName;
}
