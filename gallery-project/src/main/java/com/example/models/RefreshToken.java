package com.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "refresh_token")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken extends BaseEntity{

    @Column(name = "refresh_token")
    private String refreshToken;
    @Column(name = "expired_date")
    private Date expiredDate;
    @ManyToOne
    private User user;
}
