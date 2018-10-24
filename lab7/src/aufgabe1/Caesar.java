package aufgabe1;

public class Caesar {
    public static String caesarCode(String input, char offset)
    {
        char[] buf = input.toCharArray();
        for(int i = 0; i<buf.length; i++)
            buf[i] = (char)('A' + ((buf[i]-'A')+offset + 1 - 'A')%26);
        return new String(buf);
    }

    public static String caesarDecode(String input, char offset) {
        char[] buf = input.toCharArray();
        for(int i = 0; i<buf.length; i++)
            buf[i] = (char)('A' + (26 + (buf[i]-'A')-(offset + 1 - 'A'))%26);
        return new String(buf);
    }
}
