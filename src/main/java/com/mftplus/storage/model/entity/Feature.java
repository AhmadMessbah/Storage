package com.mftplus.storage.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import jakarta.validation.constraints.Pattern;
@NamedQueries({@NamedQuery(name="Feature.FindByName",query = "select oo from featureEntity oo where oo.FeatureName =:featureName"),
        @NamedQuery(name="Feature.FindByGroupId", query = "select oo from featureEntity oo where oo.group.id =:id"),
        @NamedQuery(name="Feature.FindByGroupTitle", query = "select oo from featureEntity oo where oo.group.title =:title")})

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
    @Pattern(regexp = "^[a-zA-Z\\s]{0,20}$", message = "Invalid Feature Name")
    private String FeatureName;

    @OneToOne
    private Group group;

}
