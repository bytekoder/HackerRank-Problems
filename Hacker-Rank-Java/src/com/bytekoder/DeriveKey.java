package com.bytekoder;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

/**
 * Created by bshekhawat
 */
public class DeriveKey {

    private final static String KEY = "AKIAIEH3QUS46OAYGCNQ";
    private final static String TIME = "2017-03-13T05:43:15+00:00";
    private final static String REGION = "us-east-1";
    private final static String SERVICE = "AWSECommerceService";

    public static void main(String[] args) throws Exception {

        byte[] b = getSignatureKey(KEY, TIME, REGION, SERVICE);
        System.out.println(Arrays.toString(b));
    }

    static byte[] HmacSHA256(String data, byte[] key) throws Exception {
        String algorithm = "HmacSHA256";
        Mac mac = Mac.getInstance(algorithm);
        mac.init(new SecretKeySpec(key, algorithm));
        System.out.println(mac.doFinal(data.getBytes("UTF8")));
        return mac.doFinal(data.getBytes("UTF8"));
    }

    static byte[] getSignatureKey(String key, String dateStamp, String regionName, String serviceName) throws Exception {
        byte[] kSecret = ("AWS4" + key).getBytes("UTF8");
        byte[] kDate = HmacSHA256(dateStamp, kSecret);
        byte[] kRegion = HmacSHA256(regionName, kDate);
        byte[] kService = HmacSHA256(serviceName, kRegion);
        byte[] kSigning = HmacSHA256("aws4_request", kService);
        return kSigning;
    }
}
