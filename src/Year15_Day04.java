import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Year15_Day04 {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        int count = -1;
        String check = "";
        int askldjaslk = 0;
        while (!check.equals("000000")) {
            count++;
            String checking = "bgvyzdsv" + count;
            byte[] bytes = checking.getBytes("UTF-8");
            byte[] digested = md5.digest(bytes);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digested.length; ++i) {
                sb.append(Integer.toHexString((digested[i] & 0xFF) | 0x100).substring(1,3));
            }
            check = sb.substring(0, 6);
            if (count % 5000000 == 0) {
                askldjaslk ++;
                System.out.println("Check" + askldjaslk);
            }
        }
        System.out.println(count);
    }
}
