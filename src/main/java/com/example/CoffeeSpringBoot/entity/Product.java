package com.example.CoffeeSpringBoot.entity;
import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "product")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private int id;

	@Getter
	@Setter
    @Column(name = "product_name")
    private String productName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "type" ,nullable=false)
    private TypeProduct typeProduct;

    @Column(name = "sale")
    private int sale;

    @Column(name = "image")
    private String image;

    @Column(name = "favorite")
    private boolean favorite;

    @Column(name = "actived")
    private boolean actived;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "price")
    private int price;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<ProductsInCart> productsInCart ;
    
//    public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getProductName() {
//		return productName;
//	}
//
//	public void setProductName(String productName) {
//		this.productName = productName;
//	}
//
//	public TypeProduct getTypeProduct() {
//		return typeProduct;
//	}
//
//	public void setTypeProduct(TypeProduct typeProduct) {
//		this.typeProduct = typeProduct;
//	}
//
//	public int getSale() {
//		return sale;
//	}
//
//	public void setSale(int sale) {
//		this.sale = sale;
//	}
//
//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}
//
//	public boolean isFavorite() {
//		return favorite;
//	}
//
//	public void setFavorite(boolean favorite) {
//		this.favorite = favorite;
//	}
//
//	public boolean isActived() {
//		return actived;
//	}
//
//	public void setActived(boolean actived) {
//		this.actived = actived;
//	}
//
//	public Date getCreateDate() {
//		return createDate;
//	}
//
//	public void setCreateDate(Date createDate) {
//		this.createDate = createDate;
//	}
//
//	public int getPrice() {
//		return price;
//	}
//
//	public void setPrice(int price) {
//		this.price = price;
//	}
//
//	public Set<ProductsInCart> getProductsInCart() {
//		return productsInCart;
//	}
//
//	public void setProductsInCart(Set<ProductsInCart> productsInCart) {
//		this.productsInCart = productsInCart;
//	}
}
