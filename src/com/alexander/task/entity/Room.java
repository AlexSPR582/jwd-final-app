package com.alexander.task.entity;

public class Room {
    private int number;
    private int price;
    private int numberOfSeats;
    private int area;
    private String apartmentsType;
    private String view;

    public Room () {}

    public Room(int number, int price, int numberOfSeats,
                int area, String apartmentsType, String view) {
        this.number = number;
        this.price = price;
        this.numberOfSeats = numberOfSeats;
        this.area = area;
        this.apartmentsType = apartmentsType;
        this.view = view;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getApartmentsType() {
        return apartmentsType;
    }

    public void setApartmentsType(String apartmentsType) {
        this.apartmentsType = apartmentsType;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return number == room.number &&
                price == room.price &&
                numberOfSeats == room.numberOfSeats &&
                area == room.area &&
                apartmentsType.equals(room.apartmentsType) &&
                view.equals(room.view);
    }

    @Override
    public int hashCode() {
        return 31 * number + price +
                numberOfSeats + area +
                apartmentsType.hashCode() + view.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Room{");
        sb.append("number=").append(number);
        sb.append(", price=").append(price);
        sb.append(", numberOfSeats=").append(numberOfSeats);
        sb.append(", area=").append(area);
        sb.append(", apartmentsType='").append(apartmentsType).append('\'');
        sb.append(", view='").append(view).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
