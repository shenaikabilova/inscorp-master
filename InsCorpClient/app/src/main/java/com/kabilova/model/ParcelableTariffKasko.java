package com.kabilova.model;

import android.os.Parcel;
import android.os.Parcelable;

import kabilova.tu.inscorp.model.tariff.TariffKasko;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

/**
 * Created by ShenaiKabilova.
 */

public class ParcelableTariffKasko extends TariffKasko implements Parcelable {
    public ParcelableTariffKasko() { }

    public ParcelableTariffKasko(Parcel in) {
        super.setTariffID(in.readInt());
        super.setVechileType((VehicleType) in.readParcelable(VehicleType.class.getClassLoader()));
        super.setVehicleSubtype((VehicleSubtype) in.readParcelable(VehicleSubtype.class.getClassLoader()));
        super.setKaskoPercent(in.readInt());
    }

    public static final Parcelable.Creator<ParcelableTariffKasko> CREATOR = new Parcelable.Creator<ParcelableTariffKasko>() {
        public ParcelableTariffKasko createFromParcel(Parcel in) {
            return new ParcelableTariffKasko(in);
        }

        public ParcelableTariffKasko[] newArray(int size) {
            return new ParcelableTariffKasko[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(super.getTariffID());
        dest.writeParcelable((Parcelable) super.getVechileType(), flags);
        dest.writeParcelable((Parcelable) super.getVehicleSubtype(), flags);
        dest.writeInt(super.getKaskoPercent());
    }
}
