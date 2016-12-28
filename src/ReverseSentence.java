
public class ReverseSentence {

    public static void main(String[] args) {
        // goal: " I love this crap " --> "crap this love I"

        String str1 = " you should know this this well by  now  ";
        String str2 = "";
        String str3 = "  ";
        String str4 = null;

        System.out.println(reverseWord(str1));

    }

    public static String reverseWord(String str) {

        if (str == null) {
            return str;
        }

        if (str.length() == 0) {
            return "";
        }

        str = str.trim();
        String[] strArr = str.split("\\s+");

        StringBuilder sb = new StringBuilder();

        // note for repeated string operations such as cat, please use StringBuilder for efficency
        for (int i = strArr.length - 1; i > 0; i--) {
            sb.append(strArr[i]).append(" ");
        }

        sb.append(strArr[0]);

        return sb.toString();
    }
}
