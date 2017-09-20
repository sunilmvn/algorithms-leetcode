package algorithms.leetcode.dynamicprogramming;

/**
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up 
 * that amount. If that amount of money cannot be made up by any combination 
 * of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
 * @author vmukkavilli
 *
 */
public class CoinChange {
	
	public int coinChange(int[] coins, int amount) {
		int[] am = new int[amount+1];
		am[0] = 0;
		for(int i=1;i<am.length;i++){
			am[i] = Integer.MAX_VALUE;
			boolean isSet = false;
			for(int j=0;j<coins.length;j++){
				if(coins[j] == i){
					am[i] = 1;
					isSet = true;
					break;
				}
				else if(coins[j]<i){
					if(am[i-coins[j]] == -1){
						continue;
					}
					isSet = true;
					am[i] = Math.min(am[i], am[i-coins[j]]+1);
				}
				else{
					break;
				}
			}
			if(!isSet){
				am[i] = -1;
			}
		}
        return am[amount];
    }
	
	public static void main(String[] args){
		CoinChange cc = new CoinChange();
		int[] coins = {2,5};
		int value = 1;
		System.out.println("For "+ value +": "+cc.coinChange(coins, 1));
	}

}
