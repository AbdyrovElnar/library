package com.example.library.service;

public interface QRCodeService {
    byte[] generateQRCode(String qrContent, int width, int height);
}
