package com.kabilova.model;

import android.os.Parcel;
import android.os.Parcelable;

import kabilova.tu.inscorp.model.tariff.TariffGO;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

/**
 * Created by ShenaiKabilova.
 */

public class ParcelableTariffGO extends TariffGO implements Parcelable{
    public ParcelableTariffGO() { }

    public ParcelableTariffGO(Parcel in) {
        super.setTariffID(in.readInt());
        super.setVechileType((VehicleType) in.readParcelable(VehicleType.class.getClassLoader()));
        super.setVehicleSubtype((VehicleSubtype) in.readParcelable(VehicleSubtype.class.getClassLoader()));
        super.setZone(in.readInt());
        super.setValue(in.readDouble());
    }

    public static final Parcelable.Creator<ParcelableTariffGO> CREATOR = new Parcelable.Creator<ParcelableTariffGO>() {
        public ParcelableTariffGO createFromParcel(Parcel in) {
            return new ParcelableTariffGO(in);
        }

        public ParcelableTariffGO[] newArray(int size) {
            return new ParcelableTariffGO[size];
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
        dest.writeInt(super.getZone());
        dest.writeDouble(super.getValue());
    }
}
