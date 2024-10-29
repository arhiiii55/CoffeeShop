package com.example.CoffeeSpringBoot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
// import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bill")
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bill")
    private int id;

    @Column(name = "total")
    private int total;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "payment")
    private Payment idPayment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bill_status" )
    private Status idStatus;

    @Column(name = "create_date")
    private Date createDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart idCart;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private User employeeId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sale_code_id")
    private SaleCode saleCode;

    @Column(name = "note")
    private String note;
}
