package com.kabilova.model;

import android.os.Parcel;
import android.os.Parcelable;

import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

/**
 * Created by ShenaiKabilova.
 */

public class ParcelableVehicleType extends VehicleType implements Parcelable {
    public ParcelableVehicleType() { }

    public ParcelableVehicleType(Parcel in) {
        super.setId(in.readInt());
        super.setVehicleType(in.readString());
    }

    public static final Parcelable.Creator<ParcelableVehicleType> CREATOR = new Parcelable.Creator<ParcelableVehicleType>() {
        public ParcelableVehicleType createFromParcel(Parcel in) {
            return new ParcelableVehicleType(in);
        }

        public ParcelableVehicleType[] newArray(int size) {
            return new ParcelableVehicleType[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(super.getId());
        dest.writeString(super.getVehicleType());
    }
}