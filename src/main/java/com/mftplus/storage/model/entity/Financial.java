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


@Entity(name="financialEntity")
@Table(name="financial_tbl")

@NamedQueries({
//        @NamedQuery(name = "",query = "")
})
public class Financial extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="f_amount")
    private Long amount;

    @Column(name ="f_payment_time_stamp")
    private LocalDateTime paymentTimeStamp;

    @Column(name = "f_payment_type")
    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;

    @OneToOne
    @JoinColumn(name = "f_invoice_id")
    private Invoice invoice;

    @OneToOne
    @JoinColumn(name="f_user_id")
    private User user;
}
