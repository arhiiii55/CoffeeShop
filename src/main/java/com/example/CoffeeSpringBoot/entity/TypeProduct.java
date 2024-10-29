package com.example.CoffeeSpringBoot.entity;

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
@Table(name = "typeproduct")
public class TypeProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_product")
    private int id;

    @Column(name = "type_product")
    private String typeProduct;

    @JsonIgnore
    @OneToMany(mappedBy = "typeProduct")
    private Set<Product> products;

}
