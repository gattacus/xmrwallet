/*
 * Copyright (c) 2017 m2049r
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.m2049r.xmrwallet.data;

import android.os.Parcel;

public class TxDataBtcPp extends TxData {

    private String xmrtoUuid;
    private String bip70url;
    private double btcAmount;

    public TxDataBtcPp() {
        super();
    }

    public TxDataBtcPp(TxDataBtcPp txDataBtc) {
        super(txDataBtc);
    }

    public String getXmrtoUuid() {
        return xmrtoUuid;
    }

    public void setXmrtoUuid(String xmrtoUuid) {
        this.xmrtoUuid = xmrtoUuid;
    }

    public String getBip70url() {
        return bip70url;
    }

    public void setBip70url(String bip70url) {
        this.bip70url = bip70url;
    }

    public double getBtcAmount() {
        return btcAmount;
    }

    public void setBtcAmount(double btcAmount) {
        this.btcAmount = btcAmount;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeString(xmrtoUuid);
        out.writeString(bip70url);
        out.writeDouble(btcAmount);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Creator<TxDataBtcPp> CREATOR = new Creator<TxDataBtcPp>() {
        public TxDataBtcPp createFromParcel(Parcel in) {
            return new TxDataBtcPp(in);
        }

        public TxDataBtcPp[] newArray(int size) {
            return new TxDataBtcPp[size];
        }
    };

    protected TxDataBtcPp(Parcel in) {
        super(in);
        xmrtoUuid = in.readString();
        bip70url = in.readString();
        btcAmount = in.readDouble();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(",xmrtoUuid:");
        sb.append(xmrtoUuid);
        sb.append(",bip70url:");
        sb.append(bip70url);
        sb.append(",btcAmount:");
        sb.append(btcAmount);
        return sb.toString();
    }
}
