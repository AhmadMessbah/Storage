package com.mftplus.storage.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@NamedQueries({@NamedQuery(name="Storage.FindByStock",query = "select oo.stock from storageTransactionEntity oo where oo.stuff.name =:stuffName"),
        @NamedQuery(name="Storage.FindByEntrance", query = "select oo from storageTransactionEntity oo where oo.entrance =:entrance"),
        @NamedQuery(name="Storage.FindByExit", query = "select oo from storageTransactionEntity oo where oo.outlet=:exit") ,
        @NamedQuery(name="Storage.FindByTransactionDate", query = "select oo from storageTransactionEntity oo where oo.transactionTimeStamp =:transactionDate"),
        @NamedQuery(name="Storage.FindByUserId", query = "select oo from storageTransactionEntity oo where oo.user.id =:userId"),
        @NamedQuery(name="Storage.FindByStuffName", query = "select oo from storageTransactionEntity oo where oo.stuff.name =:stuffName"),
        @NamedQuery(name="Storage.FindByStuffId", query = "select oo from storageTransactionEntity oo where oo.stuff.id =:stuffId")})


@Table(name = "Storage_transaction_tbl")
@Entity(name = "storageTransactionEntity")
public class StorageTransaction extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "st_entrance")
    private long entrance;

    @Column(name = "st_outlet")
    private long outlet;

    @Column(name = "st_stock")
    private long stock;

    @Column(name = "st_transactionDate")
    private LocalDateTime transactionTimeStamp;

    @OneToOne
    @JoinColumn(name = "st_stuff_id")
    private Stuff stuff;

    @OneToOne
    @JoinColumn(name = "st_user_id")
    private User user;
}
