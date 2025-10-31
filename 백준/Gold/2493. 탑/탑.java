import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[n+1];
        for(int i=n; i>0; i--){
            
            
            while(!stack.isEmpty()){
                int[] pk = stack.peek();

                if(pk[0] > arr[i]) break;
                int[] po = stack.pop();
                result[po[1]] = i;
            }

            stack.push(new int[] {arr[i], i});
        }

        for(int i=1; i <=n ;i++){
            sb.append(result[i] + " ");
        }

        System.out.print(sb);
  }
}