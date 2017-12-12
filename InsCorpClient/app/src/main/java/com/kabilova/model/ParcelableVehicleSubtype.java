package com.kabilova.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;

import kabilova.tu.inscorp.model.tariff.Tariff;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

/**
 * Created by ShenaiKabilova.
 */

public class ParcelableVehicleSubtype extends VehicleSubtype implements Parcelable {
    public ParcelableVehicleSubtype() { }

    public ParcelableVehicleSubtype(Parcel in) {
        super.setId(in.readInt());
        super.setVehicleType((VehicleType) in.readParcelable(Vehicle.class.getClassLoader()));
        super.setSubtype(in.readString());
    }

    public static final Parcelable.Creator<ParcelableVehicleSubtype> CREATOR = new Parcelable.Creator<ParcelableVehicleSubtype>() {
        public ParcelableVehicleSubtype createFromParcel(Parcel in) {
            return new ParcelableVehicleSubtype(in);
        }

        public ParcelableVehicleSubtype[] newArray(int size) {
            return new ParcelableVehicleSubtype[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(super.getId());
        dest.writeParcelable((Parcelable) super.getVehicleType(), flags);
        dest.writeString(super.getSubtype());
    }
}
