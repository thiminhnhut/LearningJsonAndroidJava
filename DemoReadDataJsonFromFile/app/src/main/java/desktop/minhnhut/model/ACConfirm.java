package desktop.minhnhut.model;

/**
 * Created by minhnhut on 3/17/2018.
 */

public class ACConfirm {
    private int rmid;
    private ACConfig acConfig;

    public ACConfirm() {

    }

    public ACConfirm(int rmid, ACConfig acConfig) {
        this.rmid = rmid;
        this.acConfig = acConfig;
    }

    public int getRmid() {
        return rmid;
    }

    public ACConfig getAcConfig() {
        return acConfig;
    }

    public void setRmid(int rmid) {
        this.rmid = rmid;
    }

    public void setAcConfig(ACConfig acConfig) {
        this.acConfig = acConfig;
    }
}
