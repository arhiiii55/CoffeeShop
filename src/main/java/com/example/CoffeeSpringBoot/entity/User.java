package com.example.CoffeeSpringBoot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
//import javax.persistence.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

//import org.springframework.data.domain.Persistable;

//import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
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
    
    public User() {};
   
    public User(@NonNull String accountName, @NonNull String accountPassword, @NonNull String userName, String email, int phone,
			String address, Role idRole, @NonNull int actived, LocalDateTime createDate, Cart cart, Set<Bill> bills) {
		super();
		this.accountName = accountName;
		this.accountPassword = accountPassword;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.idRole = idRole;
		this.actived = actived;
		this.createDate = createDate;
		this.cart = cart;
		this.bills = bills;
	}

	public int getIdUser() {
		return idUser;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Role getIdRole() {
		return idRole;
	}

	public void setIdRole(Role idRole) {
		this.idRole = idRole;
	}

	public int getActived() {
		return actived;
	}

	public void setActived(int actived) {
		this.actived = actived;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Set<Bill> getBills() {
		return bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}
    

}
