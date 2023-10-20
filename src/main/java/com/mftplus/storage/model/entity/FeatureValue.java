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

@NamedQueries({@NamedQuery(name="FeatureValue.FindByName",query = "select oo from featureValueEntity oo where oo.value =:value"),
        @NamedQuery(name="FeatureValue.FindByGroupId", query = "select oo from featureValueEntity  oo where oo.group.id =:id"),
        @NamedQuery(name="FeatureValue.FindByGroupName", query = "select oo from featureValueEntity  oo where oo.group.title =:title")})
// TODO: 10/20/2023 findByFeatureName, findByGroupTitle

@Table(name = "feature_value_tbl")
@Entity(name = "featureValueEntity")
public class FeatureValue extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "pv_value")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z\s]{0,255}[a-zA-Z]$", message = "Invaild Value")
    private String value;

    @OneToOne
    @JoinColumn(name = "feature_id")
    private Feature feature;

    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
