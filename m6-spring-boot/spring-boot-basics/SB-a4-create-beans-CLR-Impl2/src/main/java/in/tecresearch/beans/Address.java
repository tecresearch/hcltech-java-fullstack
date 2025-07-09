package in.tecresearch.beans;

public class Address {
    int houseno;
    String area;
    String district;
    String State;
    String pin;

    public int getHouseno() {
        return houseno;
    }

    public void setHouseno(int houseno) {
        this.houseno = houseno;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Address(int houseno, String area, String district, String state, String pin) {
        this.houseno = houseno;
        this.area = area;
        this.district = district;
        State = state;
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseno=" + houseno +
                ", area='" + area + '\'' +
                ", district='" + district + '\'' +
                ", State='" + State + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
