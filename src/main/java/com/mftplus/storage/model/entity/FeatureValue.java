package com.mftplus.storage.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import jakarta.validation.constraints.Pattern;

import java.awt.*;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Table(name = "property_value_tbl")
@Entity(name = "propertyValueEntity")
public class FeatureValue extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "pv_value")
    @Pattern(regexp = "^[A-Za-z]{2,30}$", message = "Invaild Value")
    private String value;

    @OneToOne
    @JoinColumn(name = "feature_id")
    private Feature feature;
}
