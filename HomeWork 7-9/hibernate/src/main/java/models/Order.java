package models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="tbl_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private boolean isDelete;
    @Column
    private DateTime DateCreate;
    @Column
    private OrderStatuses OrderStatusId;
    @Column
    private User UserId;
}