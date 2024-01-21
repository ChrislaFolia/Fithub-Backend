package com.fithub.model.cart;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cart")
public class Cart {

	// Currently cart would not storage in database
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartid")
	private int cartId;

	@Column(name = "MEMBERID")
	private int memberId;

	@Column(name = "CLASSID")
	private int classId;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="MEMBERID",insertable = false,updatable = false)
//	private Member member;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="CLASSID",insertable = false,updatable = false)
//	private Classes classes;

}
