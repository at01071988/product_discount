package com.discount.ProductDiscount.model;

import javax.persistence.*;

@Entity
@Table(name = "`group`")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private int id;

    @Column(name = "`group_Name`")
    private String groupName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Discount discount;

    public Group() {

    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group(String groupName, Discount discount) {
        this.groupName = groupName;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }



}
