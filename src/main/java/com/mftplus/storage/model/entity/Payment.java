package com.mftplus.storage.model.entity;

import com.mftplus.storage.model.entity.enums.PaymentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@NamedQueries({@NamedQuery(name="Payment.FindByUserId" , query = "select  oo from paymentEntity oo where user.id=:userId") ,
        @NamedQuery(name = "Payment.FindByUserName" , query = "select oo from paymentEntity  oo where user.userName=:userName"),
        @NamedQuery(name = "Payment.FindByPaymentType", query = "select oo from paymentEntity oo where oo.paymentType= :paymentType"),
        @NamedQuery(name = "Payment.SumAmount", query = "select sum(oo.invoice.amount) from paymentEntity oo where oo.paymentTimeStamp between :startTimeStamp and :endTimeStamp"),
        @NamedQuery(name = "Payment.FindByDateRange", query = "select oo from paymentEntity oo where oo.paymentTimeStamp between :startTimeStamp and :endTimeStamp"),
        @NamedQuery(name = "Payment.FindByInvoiceNumber" , query = "select oo from paymentEntity oo where oo.invoice.invoiceNumber=:invoiceNumber"),

})
@Table(name = "payment_tbl")
@Entity(name = "paymentEntity")
public class Payment extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "p_entrance")
    private long entrance;

    @Column(name = "p_outlet")
    private long outlet;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "p_payment_type")
    private PaymentType paymentType;

    @Column(name = "p_description")
    @Pattern(regexp = "^[A-Za-zا-ی\\s]{1,255}$", message = "Invalid description")
    private String description;

    @Column(name = "p_payment_time_stamp")
    private LocalDateTime paymentTimeStamp;

    @OneToOne
    @JoinColumn(name = "p_invoice_id")
    private Invoice invoice;

    @OneToOne
    @JoinColumn(name = "p_user_id")
    private User user;
}
