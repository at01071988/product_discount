package com.discount.ProductDiscount.model;


import javax.persistence.*;

@Entity
@Table(name = "`User`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private int id;

    @Column(name = "`user_name`")
    private String userName;

    @Column(name = "`bill`")
    private String bill;

    @Column(name = "`type`")
    private String type;

    @Column(name = "`group_id`")
    private int group_id;


    public User(){

    }
    public User(String userName, String type, String bill, int group_id) {
        this.userName = userName;
        this.type = type;
        this.bill = bill;
        this.group_id = group_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
