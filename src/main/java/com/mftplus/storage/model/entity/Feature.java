package com.mftplus.storage.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import jakarta.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Table(name = "feature_tbl")
@Entity(name = "featureEntity")
public class Feature extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "f_feature_name")
    @Pattern(regexp = "^[A-Za-z]{2,30}$", message = "Invalid Feature Name")
    private String FeatureName;

}
