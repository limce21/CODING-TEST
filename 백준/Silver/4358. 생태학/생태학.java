import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      HashMap<String ,Integer> map = new HashMap<String, Integer>();

      String line = "";
      int total = 0;
      while((line = br.readLine()) != null && !line.equals("")){
        total++;
        if(!map.containsKey(line)){
          map.put(line, 1);
        } else {
          int cnt = map.get(line);
          map.replace(line, cnt+1);
        }
      }

      List<String> keyList = new ArrayList<>(map.keySet());
      StringBuilder sb = new StringBuilder();
      keyList.sort((s1, s2) -> s1.compareTo(s2));
      for(String key : keyList){
        Double d = ((double)map.get(key) / total) * 100;
        String s = key + " " + String.format("%.4f", d) + "\n";
        sb.append(s);
      }
      System.out.println(sb);
  }
}
