package models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="tbl_orderitems")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private boolean isDelete;
    @Column
    private float PriceBuy;
    @Column
    private float Count;
    @Column
    private Order OrderId;
    @Column
    private Product ProductId;
}