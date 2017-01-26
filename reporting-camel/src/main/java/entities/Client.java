package entities;

/**
 * Created by c314668 on 19/01/17.
 */
public class Client {
    String name;

    String country;

    String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String toString() {
        return name+","+country+","+code;
    }
}
