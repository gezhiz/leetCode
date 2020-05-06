package com.gerson.design.reconstruct.idgen.recon;

import com.gerson.design.exception.IdGenerationFailureException;
import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @author gezz
 * @description
 * @date 2020/5/6.
 */
public class RandomIdGenerator implements IdGenerator {

    private static final Logger logger = LoggerFactory.getLogger(RandomIdGenerator.class);


    @Override
    public String generate() throws IdGenerationFailureException {
        String substrOfHostName = null;
        try {
            substrOfHostName = getLastFieldOfHostName();
        } catch (UnknownHostException e) {
            //本业务无法处理的异常，交给调用方处理
            throw new IdGenerationFailureException("host name is empty.");
        }
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s",
                substrOfHostName, currentTimeMillis, randomString);
        return id;
    }


    private String getLastFieldOfHostName() throws UnknownHostException {
        String substrOfHostName = null;
        String hostName = InetAddress.getLocalHost().getHostName();
        // 此处做判断
        if (hostName == null || hostName.isEmpty()) {
            //本业务无法处理的异常，交给调用方处理
            throw new UnknownHostException("...");
        }
        substrOfHostName = getLastSubstrSplittedByDot(hostName);
        return substrOfHostName;
    }


    @VisibleForTesting
    public String getLastSubstrSplittedByDot(String hostName) {
        if (hostName == null || hostName.isEmpty()) {
            //运行时异常
            throw new IllegalArgumentException("...");
        }
        String[] tokens = hostName.split("\\.");
        String substrOfHostName = tokens[tokens.length - 1];
        return substrOfHostName;
    }

    @VisibleForTesting
    public String generateRandomAlphameric(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("...");
        }
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) (randomAscii);
                ++count;
            }
        }
        return new String(randomChars);
    }
}
