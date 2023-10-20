package com.mftplus.storage.model.entity;

import com.mftplus.storage.model.entity.enums.PaymentType;
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
//@NamedQueries({
//todo: findByUserId/userName, findByInvoiceId, findByDateRange, Sum_amount(findByDateRange), findByPaymentType
//})
@Table(name = "payment_tbl")

@Entity(name = "paymentEntity")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;

    private String description;

    private LocalDateTime paymentTimeStamp;

    @OneToOne
    private Invoice invoice;

    @OneToOne
    private User user;
}
