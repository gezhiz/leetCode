package com.gerson.design.reconstruct.idgen;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @author gezz
 * @description
 * @date 2020/5/6.
 */
public class IdGeneratorNeedReCon {

    /**
     * static 方法 的可测试性不太好
     * 代码注释较少
     * @return
     */
    public static String generate() {
        String id = "";
        try {
            //hostname不应该每次都去调用，而应该换成在内存里
            String hostName = InetAddress.getLocalHost().getHostName();
            String[] tokens = hostName.split("\\.");
            if (tokens.length > 0) {
                hostName = tokens[tokens.length - 1];
            }
            char[] randomChars = new char[8];
            int count = 0;
            Random random = new Random();
            while (count < 8) {
                int randomAscii = random.nextInt(122);
                //下面每一个if和else中的代码都类似，应该抽象一个生成随机数的方法
                if (randomAscii >= 48 && randomAscii <= 57) {
                    randomChars[count] = (char)('0' + (randomAscii - 48));
                    count++;
                } else if (randomAscii >= 65 && randomAscii <= 90) {
                    randomChars[count] = (char)('A' + (randomAscii - 65));
                    count++;
                } else if (randomAscii >= 97 && randomAscii <= 122) {
                    randomChars[count] = (char)('a' + (randomAscii - 97));
                    count++;
                }
            }
            id = String.format("%s-%d-%s", hostName,
                    System.currentTimeMillis(), new String(randomChars));
        } catch (UnknownHostException e) {
            System.out.println("Failed to get the host name.");
        }

        return id;
    }
}
