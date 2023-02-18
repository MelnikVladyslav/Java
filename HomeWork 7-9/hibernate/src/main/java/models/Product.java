package models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="tbl_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private boolean isDelete;
    @Column
    private string Name;
    @Column
    private float Price;
    @Column
    private string Description;
    @Column
    private Categories CategoryId;
}