package com.mftplus.storage.model.entity;

import com.google.gson.Gson;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "invoiceItemEntity")
@Table(name="invoiceItem_tbl")
public class InvoiceItem extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ii_count")
    private Long count;


    @Column(name = "ii_amount")
    private Long amount;


//    @ManyToOne
//    private Invoice invoice;


    @OneToOne
    @JoinColumn(name = "ii_stuff_id")
    private Stuff stuff;


}
