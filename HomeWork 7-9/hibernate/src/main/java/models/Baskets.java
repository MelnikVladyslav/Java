package models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="tbl_baskets")
public class Baskets {
    @Column
    private Product ProductId;
    @Column
    private User UserId;
    @Column
    private int Count;
}