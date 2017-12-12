package com.kabilova.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;

import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

/**
 * Created by ShenaiKabilova.
 */

public class ParcelableVehicle extends Vehicle implements Parcelable{
    public ParcelableVehicle() { }

    public ParcelableVehicle(Parcel in) {
        super.setVehicleID(in.readInt());
        super.setInsured(((Insured) in.readParcelable(Insurer.class.getClassLoader())));
        super.setVehicleType((VehicleType) in.readParcelable(VehicleType.class.getClassLoader()));
        super.setVehicleSubtype((VehicleSubtype) in.readParcelable(VehicleSubtype.class.getClassLoader()));
        super.setRegNum(in.readString());
        super.setRAMA(in.readString());
        super.setBrand(in.readString());
        super.setModel(in.readString());
        super.setFirstReg((Calendar) in.readValue(getClass().getClassLoader()));
        super.setYears(in.readInt());
        super.setEngine(in.readDouble());
        super.setColor(in.readString());
        super.setPlaceNumber(in.readInt());
    }

    public static final Parcelable.Creator<ParcelableVehicle> CREATOR = new Parcelable.Creator<ParcelableVehicle>() {
        public ParcelableVehicle createFromParcel(Parcel in) {
            return new ParcelableVehicle(in);
        }

        public ParcelableVehicle[] newArray(int size) {
            return new ParcelableVehicle[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(super.getVehicleID());
        dest.writeParcelable((Parcelable) super.getInsured(), flags);
        dest.writeParcelable((Parcelable) super.getVehicleType(), flags);
        dest.writeParcelable((Parcelable) super.getVehicleSubtype(), flags);
        dest.writeString(super.getRegNum());
        dest.writeString(super.getRAMA());
        dest.writeString(super.getBrand());
        dest.writeString(super.getModel());
        dest.writeValue(super.getFirstReg());
        dest.writeInt(super.getYears());
        dest.writeDouble(super.getEngine());
        dest.writeString(super.getColor());
        dest.writeInt(super.getPlaceNumber());
    }
}
