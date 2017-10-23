package kabilova.tu.inscorp.model.claim;

import kabilova.tu.inscorp.model.tariff.Tariff;

/**
 * Created by ShenaiKabilova
 */
public class Claim {
    private int claimID;
    private int policaID;
    private String claimType;
    private Tariff tariff;

    public Claim() {
    }

    public Claim(int claimID, int policaID, String claimType, Tariff tariff) {
        this.claimID = claimID;
        this.policaID = policaID;
        this.claimType = claimType;
        this.tariff = tariff;
    }

    public Claim(String claimType, int policaID, Tariff tariff) {
        this.claimType = claimType;
        this.policaID = policaID;
        this.tariff = tariff;
    }

    public int getClaimID() {
        return claimID;
    }

    public void setClaimID(int claimID) {
        this.claimID = claimID;
    }

    public int getPolicaID() {
        return policaID;
    }

    public void setPolicaID(int policaID) {
        this.policaID = policaID;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }
}
