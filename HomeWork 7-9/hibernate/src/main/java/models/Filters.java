package models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="tbl_filters")
public class Filters {
    @Column
    private FilterNames FilterNameId;
    @Column
    private FilterValues FilterValueId;
    @Column
    private Products ProductId;
}