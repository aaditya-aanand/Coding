import java.util.*;
import java.io.*;
import java.lang.*;

class TADELIVE 
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Parser in = new Parser(System.in);
		int n = in.nextInt();
      int x = in.nextInt();
      int y = in.nextInt();

      int andy[] = new int[n];
      int bob[] = new int[n];

      for(int i = 0; i<n; i++)
         andy[i] = in.nextInt();

      for(int i = 0; i<n; i++)
         bob[i] = in.nextInt();

      //Incremental tip and minimum possible tip
      int itip[] = new int[n];
      int min_tip = 0;
      int a = 0;
      int b = 0;
      int c = 0;

      for(int i = 0; i<n; i++)
      {
         min_tip += Math.min(andy[i], bob[i]);
         itip[i] = andy[i] - bob[i];

         if(itip[i] > 0)
            a++;
         else if(itip[i] < 0)
            b++;
      }

      int andy_tip[] = new int[a];
      int bob_tip[] = new int[b];

      a = 0; b = 0;
      for(int i = 0; i<n; i++)
      {
         if(itip[i] > 0)
            andy_tip[a++] = itip[i];

         else if(itip[i] < 0)
            bob_tip[b++] = -itip[i];
      }

      Arrays.sort(andy_tip);
      Arrays.sort(bob_tip);

      int start = 0;
      int end = andy_tip.length-1;
      while(start < end)
      {
         int temp = andy_tip[start];
         andy_tip[start++] = andy_tip[end];
         andy_tip[end--] = temp;
      }

      start = 0; end = bob_tip.length-1;
      while(start < end)
      {
         int temp = bob_tip[start];
         bob_tip[start++] = bob_tip[end];
         bob_tip[end--] = temp;
      }

      for(int i = 1; i<andy_tip.length; i++)
         andy_tip[i] += andy_tip[i-1];

      for(int i = 1; i<bob_tip.length; i++)
         bob_tip[i] += bob_tip[i-1];

      a = andy_tip.length;
      b = bob_tip.length;

      int at = (a == 0) ? 0 : andy_tip[a-1];
      int bt = (b == 0) ? 0 : bob_tip[b-1];

      if(x >= a && y >= b)
         min_tip += (at + bt);

      else if(x >= a && y < b)
         min_tip += (at + bob_tip[y-1]);

      else if(x < a && y >= b)
         min_tip += (bt + andy_tip[x-1]);

      System.out.println(min_tip);

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
