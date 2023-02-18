package models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="tbl_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private boolean isDelete;
    @Column
    private DateTime DateCreate;
    @Column
    private string FirstName;
    @Column
    private string LastName;
    @Column
    private string Phone;
    @Column
    private string Email;
    @Column
    public string Password;
}