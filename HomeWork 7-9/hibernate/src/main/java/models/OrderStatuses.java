package models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tbl_orderstatuses")
public  class OrderStatuses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private boolean isDelete;
    @Column
    private DateTime DateCreate;
    @Column
    private string Name;
}