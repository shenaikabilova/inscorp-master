package com.kabilova.model;

import android.os.Parcel;
import android.os.Parcelable;

import kabilova.tu.inscorp.model.user.Insured;

/**
 * Created by ShenaiKabilova.
 */

public class ParcelableInsured extends Insured implements Parcelable {
    public ParcelableInsured() { }

    public ParcelableInsured(Parcel in) {
        super.setId(in.readInt());
        super.setFirstName(in.readString());
        super.setSecondName(in.readString());
        super.setLastName(in.readString());
        super.setUsername(in.readString());
        super.setPassword(in.readString());
        super.setPhoneNumber(in.readString());
        super.setEmail(in.readString());
        super.setEgn(in.readString());
        super.setPostCode(in.readInt());
        super.setCountry(in.readString());
        super.setCity(in.readString());
        super.setAddress(in.readString());
    }

    public static final Parcelable.Creator<ParcelableInsured> CREATOR = new Parcelable.Creator<ParcelableInsured>() {
        public ParcelableInsured createFromParcel(Parcel in) {
            return new ParcelableInsured(in);
        }

        public ParcelableInsured[] newArray(int size) {
            return new ParcelableInsured[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(super.getId());
        dest.writeString(super.getFirstName());
        dest.writeString(super.getSecondName());
        dest.writeString(super.getLastName());
        dest.writeString(super.getUsername());
        dest.writeString(super.getPassword());
        dest.writeString(super.getPhoneNumber());
        dest.writeString(super.getEmail());
        dest.writeString(super.getEgn());
        dest.writeInt(super.getPostCode());
        dest.writeString(super.getCountry());
        dest.writeString(super.getCity());
        dest.writeString(super.getAddress());
    }
}
