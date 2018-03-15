package desktop.minhnhut.model;

/**
 * Created by minhnhut on 3/15/2018.
 */

public class Company {

    private int id;
    private String name;
    private String[] websites;
    private Address address;

    public Company(int id, String name, Address address, String[] websites) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.websites = websites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getWebsites() {
        return websites;
    }

    public void setWebsites(String[] websites) {
        this.websites = websites;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n id:" + this.id);
        sb.append("\n name:" + this.name);
        if (this.websites != null) {
            sb.append("\n website: ");
            for (String website : this.websites) {
                sb.append(website + ", ");
            }
        }
        if (this.address != null) {
            sb.append("\n address:" + this.address.toString());
        }
        return sb.toString();
    }

}
