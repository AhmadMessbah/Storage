package com.mftplus.storage.model.entity;

import com.mftplus.storage.model.entity.enums.InvoiceType;
import jakarta.persistence.*;
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

})
@Table(name = "invoice_tbl")
@Entity(name = "invoiceEntity")
public class Invoice extends Base{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "i_invoice_number")
    private Long invoiceNumber;

    @Column(name = "i_invoice_type")
    @Enumerated(EnumType.ORDINAL)
    private InvoiceType invoiceType;

    @Column(name = "i_invoice_time_stamp")
    private LocalDateTime invoiceTimeStamp;

    @Column(name = "i_amount")
    private Long amount;

    @Column(name = "i_discount")
    private Long discount;

    @Column(name = "i_pure_amount")
    private Long pureAmount;

    @OneToOne
    private User user;

    @OneToOne
    private Payment payment;

    @OneToMany
    private List<InvoiceItem> invoiceItems;

}
