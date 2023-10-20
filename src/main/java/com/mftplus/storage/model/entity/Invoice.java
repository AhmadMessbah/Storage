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
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@NamedQueries({@NamedQuery(name="Invoice.FindByUserId" , query = "select  oo from invoiceEntity oo where user.id=:userId") ,
@NamedQuery(name = "Invoice.FindByUserName" , query = "select oo from invoiceEntity  oo where user.userName=:userName"),
        @NamedQuery(name = "Invoice.FindByDateRange", query = "select oo from invoiceEntity oo where oo.invoiceTimeStamp between :startTimeStamp and :endTimeStamp"),
        @NamedQuery(name = "Invoice.FindByInvoiceNumber" , query = "select oo from invoiceEntity oo where oo.invoiceNumber=:invoiceNumber"),
        //@NamedQuery(name = "Invoice.FindByInvoiceItemId", query = "select oo from invoiceEntity  oo where oo.invoiceItems"),
        //@NamedQuery(name = "Invoice.FindByStuffId" , query = "select  oo from invoiceEntity oo where oo")
})
@Table(name = "invoice_tbl")
@Entity(name = "invoiceEntity")
public class Invoice extends Base{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "i_invoiceNumber")
    private Long invoiceNumber;


    @Column(name = "i_invoiceType")
    private InvoiceType invoiceType;

    @Column(name = "i_invoiceTimeStamp")
    private LocalDateTime invoiceTimeStamp;

    @Column(name = "i_amount")
    private Long amount;

    @Column(name = "i_discount")
    private Long discount;

    @Column(name = "i_pureAmount")
    private Long pureAmount;

    @OneToOne
    private User user;

    @OneToMany
    private List<InvoiceItem> invoiceItems;

}
