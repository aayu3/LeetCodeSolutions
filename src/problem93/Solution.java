package problem93;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        restore(result, s, new StringBuilder(), 0, 0);
        return result;
    }

    private void restore(List<String> result, String s, StringBuilder sb, int start, int count) {
        if (count == 3) { // already fix 3 seg
            String seg = s.substring(start);
            if (isValidSeg(seg)) {
                sb.append(Integer.parseInt(seg));
                result.add(sb.toString());
            }
        } else {
            int sbLength = sb.length(); // to restore string builder
            for (int i = start + 1; i < start + 4 && i < s.length(); i ++) {
                String seg = s.substring(start, i);
                if (isValidSeg(seg)) {
                    sb.append(Integer.parseInt(seg));
                    sb.append('.');
                    restore(result, s, sb, i, count + 1);
                    sb.setLength(sbLength);
                }
            }
        }
    }

    private boolean isValidSeg(String seg) {
        if (seg.equals("") || seg.length() > 3) { // length constraint
            return false;
        }
        if (seg.length() > 1 && seg.charAt(0) == '0') { // "0" constraint
            return false;
        }
        int value = Integer.parseInt(seg);
        if (value < 0 || value > 255) { // value constraint
            return false;
        }
        return true;
    }
}