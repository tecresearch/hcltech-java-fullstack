package in.tecresearch.beans;

public class Address {
    String district;
    String state;

    public Address(String district, String state) {
        this.district = district;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "district='" + district + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
