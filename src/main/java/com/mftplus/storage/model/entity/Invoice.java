package com.mftplus.storage.model.entity;

import com.google.gson.Gson;
import com.mftplus.storage.model.entity.enums.InvoiceType;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Invoice extends Base{

    //id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "i_invoiceNumber")
    private Long invoiceNumber;


    @Column(name = "i_invoiceType")
    private InvoiceType invoiceType;

    @Column(name = "i_invoiceDate")
    private LocalDateTime invoiceDate;

    @Column(name = "i_amount")
    private Long amount;

    @Column(name = "i_discount")
    private Long discount;

    @Column(name = "i_pureAmount")
    private Long pureAmount;

    @OneToOne
    private User user;

}
