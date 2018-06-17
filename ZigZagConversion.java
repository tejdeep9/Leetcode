
//https://leetcode.com/problems/zigzag-conversion/description/
class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1)
           return s;
        
        List[] lists = new List[numRows];
        for(int i = 0; i < numRows; i++){
            lists[i] = new ArrayList<Character>();
        }
        
        int row = 0;
        int col = 0;
        boolean downward = true;
        for(int i = 0; i < s.length(); i++) {
            if(downward) {
                if(row == numRows-1) { 
                    lists[row].add(s.charAt(i));
                    row = numRows-2;
                    downward = false;
                } else {
                    lists[row++].add(s.charAt(i));
                }
            } else {
                if(row == 0) {
                    lists[row++].add(s.charAt(i));
                    downward = true;
                } else {
                    lists[row--].add(s.charAt(i));
                }
            }
        }
        
        
        StringBuilder sbr = new StringBuilder();
        
        for(int i = 0; i < numRows; i++) {
            for(Object c: lists[i]){
                if(c != null)
                    sbr.append((Character)c);
            }
        }
        return sbr.toString();
    }
}

//alternate solution with String Builder
class Solution {
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
        
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

}