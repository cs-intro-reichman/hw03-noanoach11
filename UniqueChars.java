/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String ans = "";
        ans += s.charAt(0);
        
        for (int i=0;i<s.length();i++){
            boolean flag = true;

            for (int t=0;t<ans.length();t++){
                if (s.charAt(i)==ans.charAt(t) && s.charAt(i)!= ' '){
                    flag = false;
                }
            }

            if (flag){
                ans += s.charAt(i);
            }
        }

        return ans;
    }
}