import java.util.*;
import java.lang.*;
import java.io.*;

class B343
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Parser in = new Parser(System.in);
      String str = in.next();
		int len = str.length();

		Stack<Integer> stack = new Stack<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

      int pos_corr_open[] = new int[len];
      int earliest_open[] = new int[len];
      
      int min_last_pop = -1;
		for(int i = 0; i<len; i++)
		{
         char x = str.charAt(i);
         if(x == '(')
            stack.push(i);

         else
         {
         	int len_substr = 0;
            if(stack.isEmpty())
            {
            	pos_corr_open[i] = -1;
            	earliest_open[i] = -1;
            }
            	
            else
            {
            	pos_corr_open[i] = stack.pop();
           		if(pos_corr_open[i] - 1 >= 0 && str.charAt(pos_corr_open[i] - 1) == ')' && earliest_open[pos_corr_open[i] - 1] != -1)
           			earliest_open[i] = earliest_open[pos_corr_open[i] - 1];

           		else
           			earliest_open[i] = pos_corr_open[i]; 

           		len_substr = 1 + i - earliest_open[i];     		
            }

            if(map.containsKey(len_substr))
               map.put(len_substr, map.get(len_substr) + 1);

            else
               map.put(len_substr, 1);
               
         }
		}

      int max = -1;
      for (Map.Entry<Integer, Integer> entry : map.entrySet())
      	max = Math.max(max, entry.getKey());

      if(max == 0 || max == -1)
      	System.out.println("0 1");

      else
      	System.out.println(max + " " + map.get(max));
	}
}

class Parser
{
   final private int BUFFER_SIZE = 1 << 16;

   private DataInputStream din;
   private byte[] buffer;
   private int bufferPointer, bytesRead;

   public Parser(InputStream in)
   {
      din = new DataInputStream(in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
   }

   public long nextLong() throws Exception
   {
      long ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
         ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }
   
   //reads in the next string
   public String next() throws Exception
   {
      StringBuilder ret =  new StringBuilder();
      byte c = read();
      while (c <= ' ') c = read();
      do
      {
         ret = ret.append((char)c);
         c = read();
      } while (c > ' ');
      return ret.toString();
   }

   public int nextInt() throws Exception
   {
      int ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
         ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }
   
   private void fillBuffer() throws Exception
   {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1) buffer[0] = -1;
   }

   private byte read() throws Exception
   {
      if (bufferPointer == bytesRead) fillBuffer();
      return buffer[bufferPointer++];
   }
}
