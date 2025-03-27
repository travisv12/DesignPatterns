package Decorator;

import java.util.Base64;

public class EncryptedPrinter extends PrinterDecorator {
    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        String encryptedMessage = encrypt(message);
        super.print(encryptedMessage);
    }

    private String encrypt(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}