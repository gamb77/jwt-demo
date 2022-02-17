package fi.gamb77.jwtdemo.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
@Converter
public class AttributeEncryptor implements AttributeConverter<String, String> {

    @Value("${encrypted.algo}")
    private String ALGO;

    @Value("${encrypted.secret}")
    private String SECRET;

    @Override
    public String convertToDatabaseColumn(String attribute) {
        if(attribute != null) {
            try {
                Key key = new SecretKeySpec(SECRET.getBytes(), ALGO);
                Cipher cipher = Cipher.getInstance(ALGO);
                cipher.init(Cipher.ENCRYPT_MODE, key);
                return Base64.getEncoder().encodeToString(cipher.doFinal(attribute.getBytes()));
            } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
                throw new IllegalStateException(e);
            }
        } else {
            return null;
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if(dbData!=null) {
            try {
                Key key = new SecretKeySpec(SECRET.getBytes(), ALGO);
                Cipher cipher = Cipher.getInstance(ALGO);
                cipher.init(Cipher.DECRYPT_MODE, key);
                return new String(cipher.doFinal(Base64.getDecoder().decode(dbData)));
            } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
                throw new IllegalStateException(e);
            }
        } else {
            return null;
        }
    }
}