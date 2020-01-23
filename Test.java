class Solution {
    public int hIndex(int[] citations) {      
        int left=0;
        int right=citations.length;
        while(left<right){
            int mid=(left+right)>>>1;
            if(citations[mid]>=citations.length-mid){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return citations.length-right;
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        int fast=nums[0];
        int slow=nums[0];
        do{
            fast=nums[fast];
            fast=nums[fast];
            slow=nums[slow];
        }while(fast!=slow);
        slow=nums[0];
        while(fast!=slow){
            fast=nums[fast];
            slow=nums[slow];
        }
        return fast;
    }
}


class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] res=new int[nums.length];
        int j=0;
        for(int i=0;i<nums.length;i++){
            int left=0;
            int right=j;
            while(left<right){
                int mid=(left+right)>>>1;
                if(res[mid]<nums[i]){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }
            res[left]=nums[i];
            if(left==j){
                j++;
            }
        }
        return j;
    }
}


class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] dp=new int[A.length+1][B.length+1];
        int ret=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(A[i]==B[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                    ret=Math.max(ret,dp[i+1][j+1]);
                }else{
                    dp[i+1][j+1]=0;
                }
            }
        }
        return ret;
    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int max=0;
        for(int pile:piles){
            max=Math.max(max,pile);
        }
        int left=1;
        int right=max;
        while(left<right){
            int mid=(left+right)>>>1;
            int sum=H;
            for(int pile:piles){
                sum-=hour(pile,mid);
            }
            if(sum<0){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
    private int hour(int num,int k){
        return num%k==0?num/k:num/k+1;
    }
}


class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int max=0;
        int sum=0;
        for(int weight:weights){
            sum+=weight;
            max=Math.max(max,weight);
        }
        int left=max;
        int right=sum;
        while(left<right){
            int mid=(left+right)>>>1;
            if(day(weights,mid)>D){
                left=mid+1;
               
            }else{
                 right=mid;
            }
    }
        return left; 
    }
    private int day(int[] weights,int cap){
        int tmp=cap;
        int ret=1;
        for(int weight:weights){
            if(tmp-weight>=0){
                tmp-=weight;
            }else{
                tmp=cap-weight;
                ret++;
            }
        }
        return ret;
    }
}

class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=(left+right)>>>1;
            if(nums[mid]==nums[right]){
                right--;
                continue;
            }
            if(nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return nums[left];
    }
}

