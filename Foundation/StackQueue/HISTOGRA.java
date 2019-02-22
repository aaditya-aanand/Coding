import java.util.*;
import java.lang.*;
import java.io.*;

class HISTOGRA
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Parser in = new Parser(System.in);
		while(true)
		{
			int n = in.nextInt();
			if(n == 0)
				break;

			long arr[] = new long[n];
			long arr_rev[] = new long[n];

			int index_next_smallest_left_side[] = new int[n];
			int index_next_smallest_right_side[] = new int[n];

			for(int i = 0; i<n; i++)
			{
				arr[i] = in.nextInt();
				arr_rev[n-1-i] = arr[i];
			}

			Stack<Long> stack_left = new Stack<Long>();
			Stack<Integer> stack_left_index = new Stack<Integer>();

			stack_left.push(-1L);
			stack_left_index.push(-1);

			for(int i = 0; i<n; i++)
			{
				if(stack_left.peek() < arr[i])
				{
					index_next_smallest_left_side[i] = stack_left_index.peek();
					stack_left.push(arr[i]);
					stack_left_index.push(i);
				}

				else
				{
					while(stack_left.peek() >= arr[i])
					{
							stack_left.pop();
							stack_left_index.pop();
					}

					index_next_smallest_left_side[i] = stack_left_index.peek();
					stack_left.push(arr[i]);
					stack_left_index.push(i);
				}
			}

			Stack<Long> stack_right = new Stack<Long>();
			Stack<Integer> stack_right_index = new Stack<Integer>();
			
			stack_right.push(-1L);
			stack_right_index.push(-1);

			for(int i = 0; i<n; i++)
			{
				if(stack_right.peek() < arr_rev[i])
				{
					index_next_smallest_right_side[n-1-i] = stack_right_index.peek();
					stack_right.push(arr_rev[i]);
					stack_right_index.push(i);
				}

				else
				{
					while(stack_right.peek() >= arr_rev[i])
					{
							stack_right.pop();
							stack_right_index.pop();
					}

					index_next_smallest_right_side[n-1-i] = stack_right_index.peek();
					stack_right.push(arr_rev[i]);
					stack_right_index.push(i);
				}
			}

			long max = Long.MIN_VALUE;
			for(int i = 0; i<n; i++)
				max = Math.max(max, arr[i]*(n-index_next_smallest_left_side[i]-index_next_smallest_right_side[i]-2));
			
			System.out.println(max);
		}
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
