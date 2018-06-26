/*
 * Copyright (c) 2017 m2049r et al.
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

package com.m2049r.xmrwallet.xmrto.network;

import android.support.annotation.NonNull;

import com.m2049r.xmrwallet.xmrto.api.CreateOrder;
import com.m2049r.xmrwallet.xmrto.api.XmrToCallback;

import org.json.JSONException;
import org.json.JSONObject;

class CreateOrderPpImpl implements CreateOrder {

    private final String state;
    private final double btcAmount;
    private final String btcDestAddress;
    private final String uuid;

    CreateOrderPpImpl(final JSONObject jsonObject) throws JSONException {
        this.state = jsonObject.getString("state");
        this.btcAmount = jsonObject.getDouble("btc_amount");
        this.btcDestAddress = jsonObject.getString("btc_dest_address");
        this.uuid = jsonObject.getString("uuid");
    }

    public static void call(@NonNull final XmrToApiCall api, @NonNull final String bip70url,
                            @NonNull final XmrToCallback<CreateOrder> callback) {
        final String request = createJsonRequest(bip70url);
        api.call("order_create_pp", request, new NetworkCallback() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                try {
                    callback.onSuccess(new CreateOrderPpImpl(jsonObject));
                } catch (JSONException ex) {
                    callback.onError(ex);
                }
            }

            @Override
            public void onError(Exception ex) {
                callback.onError(ex);
            }
        });
    }

    static String createJsonRequest(final String bip70url) {
        return String.format("{\"pp_url\": \"%s\"}", bip70url);
    }

    public Double getBtcAmount() {
        return btcAmount;
    }

    public String getBtcDestAddress() {
        return btcDestAddress;
    }

    public String getUuid() {
        return uuid;
    }

    public String getState() {
        return state;
    }


}
