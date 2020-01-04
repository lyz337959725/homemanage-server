package com.lyz.home.entity.db;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@Table(name = "bill_type")
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class BillType extends BaseEntity {

    @Column(name = "parent_id")
    private int parentId;

    @Column
    private String name;

    @Column
    private String creator;

    @Transient
    private List<BillType> children;
}
