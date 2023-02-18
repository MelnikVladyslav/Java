package models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tbl_userroles")
public  class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private User UserId;
    @Column
    private Role RoleId;
}