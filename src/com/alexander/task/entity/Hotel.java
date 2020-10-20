package com.alexander.task.entity;

public class Hotel {
    private String country;
    private String city;
    private String address;
    private String type;
    private int stars;

    public Hotel() {}

    public Hotel(String country, String city, String address, String type, int stars) {
        this.country = country;
        this.city = city;
        this.address = address;
        this.type = type;
        this.stars = stars;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hotel hotel = (Hotel) o;
        return stars == hotel.stars &&
                country.equals(hotel.country) &&
                city.equals(hotel.city) &&
                address.equals(hotel.address) &&
                type.equals(hotel.type);
    }

    @Override
    public int hashCode() {
        return 31 * country.hashCode() +
                city.hashCode() +
                address.hashCode() +
                type.hashCode() +
                stars;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hotel{");
        sb.append("country='").append(country).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", stars=").append(stars);
        sb.append('}');
        return sb.toString();
    }
}
