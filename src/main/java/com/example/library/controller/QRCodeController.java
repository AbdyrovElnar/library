package com.example.library.controller;

import com.example.library.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/")
    public String index() {

        return "qwe";
    }


    @PostMapping("/showQRCode")
    public String showQRCode(String qrContent, Model model) {
        model.addAttribute("qrCodeContent", "/generateQRCode?qrContent=" + qrContent);
        return "show-qr-code";
    }

    @GetMapping("/generateQRCode")
    public void generateQRCode(String qrContent, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        byte[] qrCode = qrCodeService.generateQRCode(qrContent, 500, 500);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(qrCode);
    }
}
