
public class CharNormalization {
    public static void main(String[] args) {

        char myChar = 'Z';
        myChar = Character.toLowerCase(myChar);

        // this technique is really useful
        // use 'A' if the comparison to be made is in upper case
        int myMapping = myChar - 'a' + 1;

        int sum = 1;
        // watch for precedency of operation here
        // char + int = int unless recast to char again
        // char and int are basically inter changeable
        System.out.println((char) (3 + '0'));
        System.out.println((int) 'a');
        System.out.println((char) 97);
        System.out.println('a' + 1);
        System.out.println((int) 'a' + 1);
        System.out.println((char) ('0' + 1));

        // System.out.println(addBinary("11", "1"));

    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        // right to left scan just like when you do adding you would on scratch paper
        while (i >= 0 || j >= 0) {
            int sum = 0;

            if (i >= 0 && a.charAt(i) == '1') {
                sum++;
            }

            if (j >= 0 && b.charAt(j) == '1') {
                sum++;
            }

            sum += carry;

            if (sum >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }

            // inserting in the front most position
            // conversely if sb.insert(sb.length(),'x') this appends the char into the last position
            sb.insert(0, (char) ((sum % 2) + '0'));

            i--;
            j--;
        }

        if (carry == 1)
            sb.insert(0, '1');

        return sb.toString();
    }

}
