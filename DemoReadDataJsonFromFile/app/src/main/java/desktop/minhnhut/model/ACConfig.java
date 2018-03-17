package desktop.minhnhut.model;

/**
 * Created by minhnhut on 3/15/2018.
 */

public class ACConfig {
    private String brand;
    private String model;

    public ACConfig() {

    }

    public ACConfig(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
