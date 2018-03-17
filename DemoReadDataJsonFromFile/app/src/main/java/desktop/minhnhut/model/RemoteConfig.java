package desktop.minhnhut.model;

/**
 * Created by minhnhut on 3/15/2018.
 */

public class RemoteConfig {
    private int remoteID;
    private int minTemp;
    private int maxTemp;
    private int maxFan;
    private int heatMode;
    private int autoMode;
    private String file;
    private String image;

    public RemoteConfig() {
    }

    public RemoteConfig(int remoteID, int minTemp, int maxTemp, int maxFan, int heatMode, int autoMode, String file, String image) {
        this.remoteID = remoteID;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.maxFan = maxFan;
        this.heatMode = heatMode;
        this.autoMode = autoMode;
        this.file = file;
        this.image = image;
    }

    public int getRemoteID() {
        return remoteID;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMaxFan() {
        return maxFan;
    }

    public int getHeatMode() {
        return heatMode;
    }

    public int getAutoMode() {
        return autoMode;
    }

    public String getFile() {
        return file;
    }

    public String getImage() {
        return image;
    }

    public void setRemoteID(int remoteID) {
        this.remoteID = remoteID;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public void setMaxFan(int maxFan) {
        this.maxFan = maxFan;
    }

    public void setHeatMode(int heatMode) {
        this.heatMode = heatMode;
    }

    public void setAutoMode(int autoMode) {
        this.autoMode = autoMode;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "RemoteConfig{" +
                "remoteID=" + remoteID +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                ", maxFan=" + maxFan +
                ", heatMode=" + heatMode +
                ", autoMode=" + autoMode +
                ", file='" + file + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
