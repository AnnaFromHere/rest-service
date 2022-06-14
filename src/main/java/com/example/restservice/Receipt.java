package com.example.restservice;

public class Receipt {

    private final long receiptId;
    private final String status;

    public Receipt(long receiptId, String status) {
        this.receiptId = receiptId;
        this.status = status;
    }

    public long getReceiptId() {
        return receiptId;
    }

    public String getStatus() {
        return status;
    }
}