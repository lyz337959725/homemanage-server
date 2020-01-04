package com.lyz.home.entity.db;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@Table(name = "bill")
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Bill extends BaseEntity {

    @Column
    private String content;

    @Column
    private BigDecimal spend;

    @Column(name = "type_id")
    private int typeId;

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "person_id")
    private int personId;

    @Column(name = "is_income")
    private boolean income;

    @Column
    private String creator;

    @Column(name = "spend_date")
    private String spendDate;
}
