import java.util.LinkedList; //import built in linked list class
import java.util.Scanner;//imports the scanner
public class Execution{
  static LinkedList victums = new LinkedList();//creates a static linked list
  public static void main(String[] args){
    int n,k;
    Scanner kb = new Scanner(System.in);
    System.out.println("Enter n and k ");
    n = kb.nextInt();
    k = kb.nextInt();
    kb.close();//closes the scanner after usage
    setup(n);//fills the linked list with n people
    execute(k);
  }
  private static void execute(int k){
    execute(k,k);
  }
  private static void execute(int k, int mover){
    //two values, k is used as an index for what is going to be removed,
    //mover keeps track of how much it will move
    System.out.println(victums);
    k = kFix(k);//checks if k is within the bounds of the list
    if(victums.size()>1){
      System.out.println("Executing: "+victums.get(k-1));
      victums.remove(k-1);
    }
    else
      return;
    k = (k+mover)-1;//shifts index of k
    execute(k,mover);//recursive call
  }
  private static int kFix(int k){//modifies k if is out of bounds of the list
    if(k>victums.size()||k<1){
      k = (k-victums.size());
      return kFix(k);
    }
    return k;
  }
  private static void setup(int n){//simplifies the call to set up
    int current = 1;
    listFill(n, current);
  }
  private static void listFill(int n, int current){//fils linkedlist 1 to n
    if(current <= n)
      victums.add(current++);
    else
      return;
    listFill(n, current);
  }
}