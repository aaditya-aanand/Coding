import java.util.*;
class LECANDY {

     public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for(int t = 0; t<T; t++)
        {
            int n = in.nextInt();
            int c = in.nextInt();
            
            int sum = 0;
            for(int i = 0; i<n; i++)
                sum += in.nextInt();
                
            if(sum <= c)
                System.out.println("Yes");
                
            else
                System.out.println("No");
        }
        
        in.close();
     }
}

