package com.jiangy.thinkinginspringsecurity.domain.user.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * <p>创建时间: 2025/2/22 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">蒋勇</a>
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String username;

    private String password;

    private String avatar;
}
