package com.rui.framework.utils;

public class Utils {

    /**
     * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
     */
    public static String entryptPassword(String plainPassword) {
        String plain = Encodes.unescapeHtml(plainPassword);
        byte[] salt = Digests.generateSalt(8);
        byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, 1024);
        return Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword);
    }

    public static void main(String[] args) {
        System.out.println(entryptPassword("123456"));
    }

    /**
     * 验证密码
     * @param plainPassword 明文密码
     * @param password 密文密码
     * @return 验证成功返回true
     */
    public static boolean validatePassword(String plainPassword, String password) {
        String plain = Encodes.unescapeHtml(plainPassword);
        byte[] salt = Encodes.decodeHex(password.substring(0,16));
        byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, 1024);
        return password.equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
    }
}
