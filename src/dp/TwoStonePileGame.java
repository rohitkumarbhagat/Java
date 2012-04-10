package dp;

/*
 * 
 * Question:
 * 
 * 
 * A table has two piles of stones, one with m stones in it and another with n 
 * stones initially. Two players A and B play a game. In one turn one player can either pick x : 1<= x <= m 
 * stones from first pile, or y : 1<= y <= n stones from the second pile, or z : 1 <= z <= min(m,n) stones 
 * from both piles. The last player to pick the stone is winner. Device a winning strategy for A 
 * if he is starting the game
 */


/*Answer
 * 
 * Seems this problem can be solved with Dynamic Programming.  
 
Let F(m,n) denotes whether player A will win with m stones in one pile and n stones in another. So F(m,n) = 1 means A will win and F(m,n) = 0 means B will win. 
 
And we have 
 
F(m,n) = max { 
   1 - F(m-x,n),    1<=x<= m 
   1 - F(m,n-y),    1<=y<=n 
   1- F(m-c,n-c),   1<=c<=min(m,n) 
 
} 
 
The Reason to use 1 - F(m-x, n) is that after A's action, if  F(m-x, n) = 1, then B will win, 
so A will lose. Otherwise F(m-x, n) = 0, so B will lose and A can win. 
 
So we have m*n states, and calculating each states costs roughly O(max(m,n)) 
time. So the total time Complexity is m*n*O(max(m,n)). 
 
First time to reply a question and I assume you know DP. Tell me if
 anything is unclear to you.
 * 
 * 
 */

public class TwoStonePileGame {

}
