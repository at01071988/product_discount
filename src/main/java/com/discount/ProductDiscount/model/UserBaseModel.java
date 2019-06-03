package com.discount.ProductDiscount.model;

public class UserBaseModel {
    private User value;
    private int discountedPrice;
    private int group;
    private String discountPercent;

    public User getValue() {
        return value;
    }

    public void setValue(User value) {
        this.value = value;
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(int discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
    }
}
