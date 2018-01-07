package com.kabilova.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;

import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.policy.Policy;
import kabilova.tu.inscorp.model.tariff.Tariff;
import kabilova.tu.inscorp.model.tariff.TariffGO;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.vehicle.Vehicle;

/**
 * Created by ShenaiKabilova.
 */

public class ParcelablePolicyGO extends GO implements Parcelable{
    public ParcelablePolicyGO() { }

    public ParcelablePolicyGO(Parcel in) {
        super.setPolicaID(in.readString());
        super.setDateFrom((Calendar) in.readValue(getClass().getClassLoader()));
        super.setDateTo((Calendar) in.readValue(getClass().getClassLoader()));
        super.setInsurer((Insurer) in.readParcelable(Insurer.class.getClassLoader()));
        super.setInsured((Insured) in.readParcelable(Insured.class.getClassLoader()));
        super.setVehicle((Vehicle) in.readParcelable(Vehicle.class.getClassLoader()));
        super.setTariffGO((TariffGO) in.readParcelable(Tariff.class.getClassLoader()));
        super.setPeriod(in.readInt());
        super.setValue(in.readDouble());
    }

    public static final Parcelable.Creator<ParcelablePolicyGO> CREATOR = new Parcelable.Creator<ParcelablePolicyGO>() {
        public ParcelablePolicyGO createFromParcel(Parcel in) {
            return new ParcelablePolicyGO(in);
        }

        public ParcelablePolicyGO[] newArray(int size) {
            return new ParcelablePolicyGO[size];
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
        dest.writeParcelable((Parcelable) super.getInsurer(), flags);
        dest.writeParcelable((Parcelable) super.getInsured(), flags);
        dest.writeParcelable((Parcelable) super.getVehicle(), flags);
        dest.writeParcelable((Parcelable) super.getTariffGO(), flags);
        dest.writeInt(super.getPeriod());
        dest.writeDouble(super.getValue());
    }
}
