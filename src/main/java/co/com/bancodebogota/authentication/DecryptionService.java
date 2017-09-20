package co.com.bancodebogota.authentication;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.bancodebogota.digital.utilities.cipher.AsymmetricEncryptionUtilities;
import com.bancodebogota.digital.utilities.log.LoggerUtils;

@Service
public class DecryptionService {

    @Value("${PRIVATE_KEY}")
    private String privateKeyString;

    private AsymmetricEncryptionUtilities asymmetricEncryptionUtilities;

    @Bean
    private AsymmetricEncryptionUtilities asymmetricEncryptionUtilities() {

       LoggerUtils.info(privateKeyString);

        this.asymmetricEncryptionUtilities = new AsymmetricEncryptionUtilities(privateKeyString);
        return asymmetricEncryptionUtilities;
    }

    public String decrypt(String text) {
        return asymmetricEncryptionUtilities.decrypt(text);
    }
}
