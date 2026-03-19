public class CyclicShift {
    public static boolean isCyclicShift(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        
        String T = t + t;
        return T.contains(s);
    }
}