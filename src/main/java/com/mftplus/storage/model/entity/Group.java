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

@Entity(name = "groupEntity")
@Table(name = "group_tbl")

@NamedQueries({
        @NamedQuery(name = "Group.FindByParentId", query = "select oo from groupEntity oo  where oo.parent.id=:parentId"),
        @NamedQuery(name = "Group.FindByParentTitle", query = "select oo from groupEntity oo  where oo.parent.title=:parentTitle"),
        @NamedQuery(name = "Group.FindRootParents", query = "select oo from groupEntity oo where oo.parent.id is null")
})
public class Group extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Pattern(regexp = "^[A-Za-zا-ی\\s]{2,20}$", message = "Invalid group title")
    @Column(name = "g_title", length = 30)
    private String title;

    @ManyToOne
    @JoinColumn(name = "g_parent_id")
    private Group parent;
}
