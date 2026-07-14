import java.util.*;
class Solution {
    static class Stock {
        int price;
        int time;
        Stock(int price, int time) {
            this.price = price;
            this.time = time;
        }
    }
    public int[] solution(int[] prices) {
        Deque<Stock> stack = new ArrayDeque<>();
        stack.push(new Stock(prices[0], 0));
        int[] answer = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.peek().price > prices[i]) {
                Stock s = stack.pop();
                answer[s.time] = i - s.time;
            } 
            stack.push(new Stock(prices[i], i));
        }
        while (!stack.isEmpty()) {
            Stock s = stack.pop();
            answer[s.time] = prices.length - s.time - 1;
        }
        return answer;
    }
}