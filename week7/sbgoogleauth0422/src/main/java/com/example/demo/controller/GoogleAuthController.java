package com.example.demo.controller;

import com.example.demo.model.LoginForm;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class GoogleAuthController {
	String SecretKey="YEAKFLPGDKHFEFZN";
	
    private final GoogleAuthenticator gAuth = new GoogleAuthenticator();

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    //public String login(@RequestParam String secret, @RequestParam int code, Model model) {
    public String login(@ModelAttribute LoginForm data, Model model) {
    	//固定測試 key
    	String secret=data.getSecret();
    	int code=data.getCode();
    	System.out.println("secret key:"+secret);
    	System.out.println("secret code:"+code);
        boolean isCodeValid = gAuth.authorize(secret, code);    	
        if (isCodeValid) {
            model.addAttribute("message", "登入成功！");
            return "登入成功";
        } else {
            model.addAttribute("message", "驗證失敗，請重試。");
            return "驗證失敗";
        }
    }
    
    @GetMapping("/generate-key")
    public String generateKey() {
        GoogleAuthenticatorKey key = gAuth.createCredentials();
        return "你的密鑰 (Secret Key): " + key.getKey();
    }

//    @GetMapping("/generate-qr")
//    public String generateQRCode() throws WriterException {
//        GoogleAuthenticatorKey key = gAuth.createCredentials();
//        String otpAuthURL = "otpauth://totp/JavaWebApp?secret=" + key.getKey() + "&issuer=MyApp";
//        return generateQRCodeImage(otpAuthURL);
//    }

    @PostMapping("/validate")
    public String validateCode(@RequestParam String secret, @RequestParam int code) {
        boolean isCodeValid = gAuth.authorize(secret, code);
        return isCodeValid ? "驗證成功！" : "驗證失敗！";
    }
    
    @GetMapping("/generate-qr")
    public ModelAndView  generateQRCode(Model model) throws WriterException {
        GoogleAuthenticatorKey key = gAuth.createCredentials();
        String otpAuthURL = "otpauth://totp/MyDemoApp?secret=" + key.getKey() + "&issuer=Demo Login Check";
        String qrCodeBase64 = generateQRCodeImage(otpAuthURL);
        model.addAttribute("qrCode", qrCodeBase64);
        model.addAttribute("secret", key.getKey());
        
        return  new ModelAndView("qrview");
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


