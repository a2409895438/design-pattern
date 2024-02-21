import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            try {
                int a = Integer.parseInt(sc.nextLine());
                System.out.println(a);
            }catch (NumberFormatException e){
                System.out.println("asdas");
            }

        }

    }
}


class Solution {
    public String lastNonEmptyString(String s) {
        int[] map = new int[26];
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int in = s.charAt(i) - 'a';
            map[in]++;
            maxLen = Math.max(maxLen,map[in]);
        }
        Set<Integer> hashset = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if(map[i] == maxLen){
                hashset.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0 && !hashset.isEmpty(); i--) {
            if(hashset.contains(s.charAt(i)-'a')){
                sb.append(s.charAt(i));
                hashset.remove(s.charAt(i) - 'a');
            }
        }
        return sb.reverse().toString();
    }

    HashMap<Integer,int[][]> map = new HashMap<>();
    public int maxOperations(int[] nums) {
        int n = nums.length;
        map.put(nums[0]+nums[1],new int[n][n]);
        map.put(nums[0]+nums[n-1],new int[n][n]);
        map.put(nums[n-2]+nums[n-1],new int[n][n]);
        for(int[][] dp : map.values()){
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i],-1);
            }
        }
        return Math.max(backtrack(nums,2,n-1,nums[0]+nums[1]),Math.max(backtrack(nums,1,n-2,nums[0]+nums[n-1]),backtrack(nums,1,n-2,nums[0]+nums[n-1])))+1;
    }

    public int backtrack(int[] nums,int i,int j,int score){

        if(i >= j){
            return 0;
        }
        if(map.get(score)[i][j] != -1){
            return map.get(score)[i][j];
        }
        int rs = 0;
        if(nums[i] + nums[i+1] == score){
            rs = 1 + backtrack(nums,i+2,j,score);
        }
        if(nums[j] + nums[j-1] == score){
            rs = Math.max(rs,1 + backtrack(nums,i,j-2,score));
        }
        if(nums[i] + nums[j] == score){
            rs = Math.max(rs,1 + backtrack(nums,i+1,j-1,score));
        }
        map.get(score)[i][j] = rs;
        return rs;
    }


    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int rs = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int prev = map.getOrDefault(nums[i]-1,0);
            int cur = map.getOrDefault(nums[i],0);
            int next = map.getOrDefault(nums[i]+1,0);
            map.put(nums[i]+1,Math.max(next,cur+1));
            map.put(nums[i],Math.max(prev+1,cur));
        }
        for(int v : map.values()){
            rs = Math.max(rs,v);
        }
        return rs;
    }
}