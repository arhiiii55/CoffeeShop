package com.example.coffeespringboot.entity;

import lombok.*;

import jakarta.persistence.*;
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ProductInBillKey implements Serializable {
    @Column(name = "bill_id")
    int billId;

    @Column(name = "product_id")
    int productId;
}
