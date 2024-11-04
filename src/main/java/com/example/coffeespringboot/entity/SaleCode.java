package com.example.coffeespringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import jakarta.persistence.*;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salecode")
public class SaleCode implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale_code")
    private int id;

    @Column(name = "name_sale")
    private String nameSale;

    @Column(name = "sale")
    private int sale;

    @JsonIgnore
    @OneToMany(mappedBy = "saleCode")
    private Set<Bill> bill ;
}
