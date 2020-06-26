import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public String solution(String S) {
        // write your code in Java SE 8
        Pattern p = Pattern.compile("(.)\\1\\1");

        while (p.matcher(S).find()) {
            S = findAndReplace(p, S, 0);
        }
        return S;
    }

    public String findAndReplace(Pattern p, String S, int lastIndex) {
        StringBuilder sb = new StringBuilder();
        Matcher m = p.matcher(S);

        while (m.find()) {
            sb.append(S, lastIndex, m.start())
                    .append(m.group(0).charAt(0))
                    .append(m.group(0).charAt(0));
            lastIndex = m.end();
        }

        if (lastIndex < S.length()) {
            sb.append(S, lastIndex, S.length());
        }

        return sb.toString();
    }
}

