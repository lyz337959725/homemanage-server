package com.lyz.home.entity.db;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@Table(name = "bill_book")
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class BillBook extends BaseEntity{
    @Column
    private String name;

    @Column
    private String creator;
}
