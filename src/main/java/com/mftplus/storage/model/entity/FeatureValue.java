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

@NamedQueries({@NamedQuery(name = "FeatureValue.FindByName", query = "select oo from featureValueEntity oo where oo.value =:value"),
        @NamedQuery(name = "FeatureValue.FindByGroupId", query = "select oo from featureValueEntity  oo where oo.group.id =:groupId"),
        @NamedQuery(name = "FeatureValue.FindByGroupTitle", query = "select oo from featureValueEntity  oo where oo.group.title =:groupTitle")})

@Table(name = "feature_value_tbl")
@Entity(name = "featureValueEntity")
public class FeatureValue extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "pv_value")
    @Pattern(regexp = "^[A-Za-zا-ی\\s]{0,255}$", message = "Invalid Value")
    private String value;

    @OneToOne
    @JoinColumn(name = "feature_id")
    private Feature feature;

    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
