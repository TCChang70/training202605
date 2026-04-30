package com.example.demo.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


@Controller
@RequestMapping("/qrcode")
public class GoogleQRCodeController {

	@GetMapping("/generate")
	public ModelAndView generateQRCode(@RequestParam("qrdata") String data, Model model) throws WriterException {
		String qrCodeBase64 = generateQRCodeImage(data);
		model.addAttribute("qrCode", qrCodeBase64);
		model.addAttribute("codeString", data);

		return new ModelAndView("qrview");
	}

	private String generateQRCodeImage(String data) throws WriterException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 250, 250);
		BufferedImage image = new BufferedImage(250, 250, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < 250; x++) {
			for (int y = 0; y < 250; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? 0x000000 : 0xFFFFFF);
			}
		}
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "png", baos);
			return "data:image/png;base64," + Base64.getEncoder().encodeToString(baos.toByteArray());
		} catch (Exception e) {
			return "無法產生 QR Code";
		}
	}
}

