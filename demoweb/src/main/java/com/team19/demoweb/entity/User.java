package com.team19.demoweb.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User { // table 역할
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_id", unique = true)
    private String email;
    @Column(name="password")
    private String pw;
    @Column
    private String name;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "store_name", referencedColumnName = "store_name")
    private Store store;
    
    @Builder
    public User(String email, String pw, String name, Store store) {
        this.email = email;
        this.pw = pw;
        this.name = name;
        this.store = store;
    }
}
