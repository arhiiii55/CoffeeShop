package com.example.coffeespringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
//import javax.persistence.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

//import org.springframework.data.domain.Persistable;

//import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Getter
@Setter
@Table(name = "user")
public class User{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;

	@NonNull
    @Column(name = "account_name")
    private String accountName;

	@NonNull
    @Column(name = "account_password")
    private String accountPassword;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private int phone;

    @Column(name = "address")
    private String address;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role" , nullable = true)
    private Role idRole;

    @Column(name = "actived")
    private int actived;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Cart cart;

    @JsonIgnore
    @OneToMany(mappedBy = "employeeId")
    private Set<Bill> bills;
   
  
	@Override
	public int hashCode() {
		return Objects.hash(accountName, accountPassword, actived, address, bills, cart, createDate, email, idRole,
				idUser, phone, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(accountName, other.accountName) 
				&& Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& phone == other.phone;
//				&& Objects.equals(bills, other.bills) && Objects.equals(cart, other.cart)
//				&& Objects.equals(createDate, other.createDate) &
//				&& Objects.equals(idRole, other.idRole) 
//				&& Objects.equals(userName, other.userName);
//				&& Objects.equals(accountPassword, other.accountPassword)
	}
}
