import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SixteenFive {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        int count = -1;
        String check = "";
        String[] result = {"", "", "", "", "", "", "", ""};
        int askldjaslk = 0;
        while (result[0].isEmpty() || result[1].isEmpty() || result[2].isEmpty() || result[3].isEmpty() || result[4].isEmpty() || result[5].isEmpty() || result[6].isEmpty() || result[7].isEmpty()) {
            count++;
            String checking = "wtnhxymk" + count;
            byte[] bytes = checking.getBytes("UTF-8");
            byte[] digested = md5.digest(bytes);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digested.length; ++i) {
                sb.append(Integer.toHexString((digested[i] & 0xFF) | 0x100).substring(1,3));
            }
            check = sb.substring(0, 5);
            if (check.equals("00000")) {
                try {
                    if (Integer.parseInt(sb.substring(5, 6)) < 8 && result[Integer.parseInt(sb.substring(5, 6))].isEmpty()) {
                        result[Integer.parseInt(sb.substring(5, 6))] += sb.charAt(6);
                        System.out.println(sb);
                    }
                }
                catch (NumberFormatException e) {

                }

            }
            if (count % 5000000 == 0) {
                askldjaslk ++;
                System.out.println("Check" + askldjaslk);
            }
        }
        for (int i = 0; i < 8; i++) {
            System.out.print(result[i]);

        }
    }
}
