package com.mftplus.storage.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import jakarta.validation.constraints.Pattern;
@NamedQueries({@NamedQuery(name="Feature.FindByName",query = "select oo from featureEntity oo where oo.FeatureName =:featureName"),
        @NamedQuery(name="Feature.FindByGroupId", query = "select oo from featureEntity oo where oo.group.id =:groupId"),
        @NamedQuery(name="Feature.FindByGroupTitle", query = "select oo from featureEntity oo where oo.group.title =:groupTitle")})

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
    @Pattern(regexp = "^[A-Za-zا-ی\\s]{0,20}$", message = "Invalid Feature Name")
    private String featureName;

    @OneToOne
    private Group group;

}
