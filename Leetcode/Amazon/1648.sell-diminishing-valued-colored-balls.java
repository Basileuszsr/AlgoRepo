package Amazon;
/*
 * @lc app=leetcode id=1648 lang=java
 *
 * [1648] Sell Diminishing-Valued Colored Balls
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] inventory, int orders) {
        long ans=0;
        final int mod=1000000007;
        //因为原数组名字太长了，我换一个短一点去引用他
        int [] arr=inventory;
        //排序，这里o(NlogN)
        Arrays.sort(arr);
        int i = arr.length-1;
        //进行取球的操作，这里是是O(n)
        while(orders!=0){
           //看上去有两层循环，其实第二层循环的每个元素最多访问一次；
            while(i>0 && arr[i-1]==arr[i]){
                i--;
            }
            //计算当前数量最多的球有多少种
            int counter = arr.length-i;
            int k;
            int l = 0;
            if(i == 0){
                k = arr[i];
            }else{
                k = arr[i] - arr[i-1];
            }
            //counter*k是我们即将拿出的球，如果他大于我们的目标数，那么进行一个限制操作
            if(orders-counter*k<0){
                k=orders/counter;
                l=orders%counter;
            }
            //保险起见每一个数字都换成long了，比赛的时候因为这个被罚时了
            long item;
            item=(long)counter*(long)k*(long)((long)arr[i]+(long)arr[i]-(long)k+(long)1)/(long)2;
            item+=(long)l*((long)arr[i]-(long)k);
            ans=ans+item;
            ans=ans%mod;
            if(i>0)
                arr[i]=arr[i-1];
            
            orders=orders-k*counter-l;
        }
        return (int)ans;
    }
}
// @lc code=end

