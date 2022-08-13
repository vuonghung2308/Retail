package model;

public class Address {
    private int id;
    private String city;
    private String district;
    private String subDistrict;
    private String postalCode;
    private int deliveryFee;

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", subDistrict='" + subDistrict + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", deliveryFee=" + deliveryFee + '}';
    }
}
