import java.util.List;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;

public class NaturalNumber {
 private int value;
 
 public NaturalNumber(int value) {
    this.value = value;
     if(this.value <= 0) throw new IllegalArgumentException("You must supply a natural number (positive integer)");
 }
 
 public Classification getClassification(){
   
   List<Integer> divisors = getDivisors(this.value);
   int sum = getSum(divisors);
   if (sum == this.value) return Classification.PERFECT;
   else if (sum > this.value) return Classification.ABUNDANT;
   return Classification.DEFICIENT;
 }
 
 private List<Integer> getDivisors(int num) {
    List<Integer> divisorList = new ArrayList<>();
    for (int divisor = num/2; divisor >= 1; divisor--) {
         if (num % divisor == 0) divisorList.add(divisor);
    }
    return divisorList;
 }
 
 private int getSum(List<Integer> divisorList) {
    return divisorList.stream().reduce(0, (a, b) -> a + b);
 }
}
