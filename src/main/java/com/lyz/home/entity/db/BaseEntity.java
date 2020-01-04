package com.lyz.home.entity.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.sql.Timestamp;
import java.util.Date;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
class BaseEntity {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "create_date",insertable = false,updatable = false)
    private String createDate;

    @Column(name = "update_date",insertable = false,updatable = false)
    private String updateDate;
}
