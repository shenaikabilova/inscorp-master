package com.kabilova.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;

import kabilova.tu.inscorp.model.policy.Kasko;
import kabilova.tu.inscorp.model.tariff.Tariff;
import kabilova.tu.inscorp.model.tariff.TariffKasko;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.vehicle.Vehicle;

/**
 * Created by ShenaiKabilova.
 */

public class ParcelablePolicyKasko extends Kasko implements Parcelable {
    public ParcelablePolicyKasko() { }

    public ParcelablePolicyKasko(Parcel in) {
        super.setPolicaID(in.readString());
        super.setDateFrom((Calendar) in.readValue(getClass().getClassLoader()));
        super.setDateTo((Calendar) in.readValue(getClass().getClassLoader()));
        super.setInsurer((Insurer) in.readParcelable(Insurer.class.getClassLoader()));
        super.setInsured((Insured) in.readParcelable(Insured.class.getClassLoader()));
        super.setTariffKasko((TariffKasko) in.readParcelable(TariffKasko.class.getClassLoader()));
        super.setVehicle((Vehicle) in.readParcelable(Vehicle.class.getClassLoader()));
        super.setKaskoType(in.readString());
        super.setVehicleValue(in.readDouble());
        super.setValue(in.readDouble());
    }

    public static final Parcelable.Creator<ParcelablePolicyKasko> CREATOR = new Parcelable.Creator<ParcelablePolicyKasko>() {
        public ParcelablePolicyKasko createFromParcel(Parcel in) {
            return new ParcelablePolicyKasko(in);
        }

        public ParcelablePolicyKasko[] newArray(int size) {
            return new ParcelablePolicyKasko[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(super.getPolicaID());
        dest.writeValue(super.getDateFrom());
        dest.writeValue(super.getDateTo());
//        dest.writeParcelable(super.getInsurer(), Insurer.class.getClassLoader());
        dest.writeParcelable((Parcelable) super.getInsurer(), flags);
        dest.writeParcelable((Parcelable) super.getInsured(), flags);
        dest.writeParcelable((Parcelable) super.getTariffKasko(), flags);
        dest.writeParcelable((Parcelable) super.getVehicle(), flags);
        dest.writeString(super.getKaskoType());
        dest.writeDouble(super.getVehicleValue());
        dest.writeDouble(super.getValue());
    }
}
