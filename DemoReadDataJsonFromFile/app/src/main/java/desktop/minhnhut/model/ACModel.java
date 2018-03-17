package desktop.minhnhut.model;

/**
 * Created by minhnhut on 3/15/2018.
 */

public class ACModel {
    private int remoteConfig;
    private int inverter;
    private int heatingPower;
    private int coolingPower;
    private int inputPower;
    private int indoorOutdoorLink;
    private String mainPowerTo;

    public ACModel() {
    }

    public ACModel(int remoteConfig, int inverter, int heatingPower, int coolingPower, int inputPower, int indoorOutdoorLink, String mainPowerTo) {
        this.remoteConfig = remoteConfig;
        this.inverter = inverter;
        this.heatingPower = heatingPower;
        this.coolingPower = coolingPower;
        this.inputPower = inputPower;
        this.indoorOutdoorLink = indoorOutdoorLink;
        this.mainPowerTo = mainPowerTo;
    }

    public int getRemoteConfig() {
        return remoteConfig;
    }

    public int getInverter() {
        return inverter;
    }

    public int getHeatingPower() {
        return heatingPower;
    }

    public int getCoolingPower() {
        return coolingPower;
    }

    public int getInputPower() {
        return inputPower;
    }

    public int getIndoorOutdoorLink() {
        return indoorOutdoorLink;
    }

    public String getMainPowerTo() {
        return mainPowerTo;
    }

    public void setRemoteConfig(int remoteConfig) {
        this.remoteConfig = remoteConfig;
    }

    public void setInverter(int inverter) {
        this.inverter = inverter;
    }

    public void setHeatingPower(int heatingPower) {
        this.heatingPower = heatingPower;
    }

    public void setCoolingPower(int coolingPower) {
        this.coolingPower = coolingPower;
    }

    public void setInputPower(int inputPower) {
        this.inputPower = inputPower;
    }

    public void setIndoorOutdoorLink(int indoorOutdoorLink) {
        this.indoorOutdoorLink = indoorOutdoorLink;
    }

    public void setMainPowerTo(String mainPowerTo) {
        this.mainPowerTo = mainPowerTo;
    }

    @Override
    public String toString() {
        return "ACModel{" +
                "remoteConfig=" + remoteConfig +
                ", inverter=" + inverter +
                ", heatingPower=" + heatingPower +
                ", coolingPower=" + coolingPower +
                ", inputPower=" + inputPower +
                ", indoorOutdoorLink=" + indoorOutdoorLink +
                ", mainPowerTo='" + mainPowerTo + '\'' +
                '}';
    }
}
