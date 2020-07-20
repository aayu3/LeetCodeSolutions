package problem68;

import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList();
        int s = 0, e = 0;
        while(e < words.length) {
            StringBuilder sb= new StringBuilder();
            int len = 0;    //number of characters of current line

            // find the right end of current line
            while(e < words.length && len + words[e].length() + e - s <= maxWidth) {
                len += words[e++].length();
            }

            // if this is the last line, add the words one by one seperated with single space
            if(e == words.length) {
                for(int i = s; i < e; ++i) {
                    sb.append(words[i]).append(" ");
                }
            }

            // other wise calculate the total number of white space in current line
            // in each slot between two words, there are num_of_space / num_of_slot (+ num_of_space % num_of_slot) white spaces
            else {
                int spacenum = maxWidth - len;
                int avg = e - s > 1? spacenum / (e - s - 1): 0;
                int k = e - s > 1? spacenum % (e - s - 1): 0;
                for(int i = s; i < e; ++i) {
                    sb.append(words[i]);
                    int j = avg;
                    while(j-- > 0) sb.append(" ");
                    if(k-- > 0) sb.append(" ");
                }
            }

            // if the length equals to maxWidth, add the string to result
            if(sb.length() == maxWidth) res.add(sb.toString());

                // if the length is less than maxWidth, add white spaces to the end
            else if(sb.length() < maxWidth) {
                int n = maxWidth - sb.length();
                while(n-- > 0) sb.append(" ");
                res.add(sb.toString());
            }

            // if the length is greater than maxWidth, trim the trailing spaces.
            else res.add(sb.toString().trim());

            s = e;
        }
        return res;
    }
}
