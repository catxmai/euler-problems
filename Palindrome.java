/** Problem 55 Project Euler
  */
public class Palindrome {
   public static void main(String[] args) {
      
      int count = 0;
      int bound = 10000;
      
      for (int i = 1; i < bound; i++) {
       
        if (checkLychrel(i) == true) { 
            count++;
        } 
      }
      
      System.out.printf("Number of Lychrel numbers under %d is %d",bound,count); 
      
   }
   
   
   private static long reverseNum(long num) {
      
      long tempNum = num;
      long divisor = 1;
      int templength;
      long outNum = 0;
      long a = 0;
      int length = 0;
      
      while (num%divisor != num){ //check length
         length++;
         divisor = divisor * 10;
      }
      length = length - 1;
      templength = length;

      for (int i = 1; i <= length+1; i++) {

         a = tempNum % 10;
         tempNum = (tempNum - a)/10;
         outNum = outNum + (a * (long) Math.pow(10,templength));
         templength += -1;
         
      }
      
      return outNum;
   }
   private static boolean checkPalindrome(long num) {
      
      if (reverseNum(num) == num) return true;
      else return false;
   }
   
   private static boolean checkLychrel(long num) {
      
      boolean state = false;
      int iteration = 0;
      long sum = 0;
      
      while (state == false && iteration < 26){ //overflow for iteration = 50
      //side info: no non-Lychrel number <10,000 requires more than 24 iterations
      //I picked 26 just to make sure.      
         sum  = num + reverseNum(num);
         state = checkPalindrome(sum);
         num = sum;
         iteration++; 
      
      }
      
      return !state;   //if state is still false after 26 iterations, number is Lychrel.
   }
}
