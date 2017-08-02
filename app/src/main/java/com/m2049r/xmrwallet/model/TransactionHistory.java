package com.m2049r.xmrwallet.model;

import java.util.List;

public class TransactionHistory {
    static {
        System.loadLibrary("monerujo");
    }

    private long handle;

    public TransactionHistory(long handle) {
        this.handle = handle;
    }

    public TransactionInfo getTransaction(int i) {
        long infoHandle = getTransactionByIndexJ(i);
        return new TransactionInfo(infoHandle);
    }

    public TransactionInfo getTransaction(String id) {
        long infoHandle = getTransactionByIdJ(id);
        return new TransactionInfo(infoHandle);
    }

    /*
        public List<TransactionInfo> getAll() {
            List<Long> handles = getAllJ();
            List<TransactionInfo> infoList = new ArrayList<TransactionInfo>();
            for (Long handle : handles) {
                infoList.add(new TransactionInfo(handle.longValue()));
            }
            return infoList;
        }
    */
    public native int getCount();

    private native long getTransactionByIndexJ(int i);

    private native long getTransactionByIdJ(String id);

    public native List<TransactionInfo> getAll();

    public native void refresh();

}