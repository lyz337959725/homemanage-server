package com.lyz.home.entity.db;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class User extends BaseEntity {

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String openid;
}
