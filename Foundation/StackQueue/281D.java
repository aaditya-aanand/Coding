import java.util.*;
import java.lang.*;
import java.io.*;

class HISTOGRA
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Parser in = new Parser(System.in);
		int n = in.nextInt();
		
		int arr[] = new int[n];
		int arr_rev[] = new int[n];

		for(int i = 0; i<n; i++)
		{
			arr[i] = in.nextInt();
			arr_rev[n-1-i] = arr[i];
		}
			
		int next_greater_element_left[] = new int[n];
		Stack<Integer> stack_left = new Stack<Integer>();

		stack_left.push(arr[0]);
		next_greater_element_left[0] = -1;
		
		for(int i = 1; i<n; i++)
		{	
			if(stack_left.isEmpty())
			{
				next_greater_element_left[i] = -1;
				stack_left.push(arr[i]);		
			}
			
			else
			{
				if(stack_left.peek() > arr[i])
				{
					next_greater_element_left[i] = stack_left.peek();
					stack_left.push(arr[i]);		
				}

				else
				{
					while(!stack_left.isEmpty())
					{
						if(stack_left.peek() < arr[i])
							stack_left.pop();

						else
							break;
					}
					
					if(stack_left.isEmpty())
					{
						next_greater_element_left[i] = -1;
						stack_left.push(arr[i]);			
					}
					
					else
					{
						next_greater_element_left[i] = stack_left.peek();
						stack_left.push(arr[i]);	
					}
				}
			}
		}
		
		int next_greater_element_right[] = new int[n];
		Stack<Integer> stack_right = new Stack<Integer>();

		stack_right.push(arr_rev[0]);
		next_greater_element_right[n-1] = -1;

		for(int i = 1; i<n; i++)
		{
			if(stack_right.isEmpty())
			{
				next_greater_element_right[n-1-i] = -1;
				stack_right.push(arr_rev[i]);		
			}

			else
			{
				if(stack_right.peek() > arr_rev[i])
				{
					next_greater_element_right[n-1-i] = stack_right.peek();
					stack_right.push(arr_rev[i]);		
				}

				else
				{
					while(!stack_right.isEmpty())
					{
						if(stack_right.peek() < arr_rev[i])
							stack_right.pop();

						else
							break;
					}

					if(stack_right.isEmpty())
					{
						next_greater_element_right[n-1-i] = -1;
						stack_right.push(arr_rev[i]);			
					}

					else
					{
						next_greater_element_right[n-1-i] = stack_right.peek();
						stack_right.push(arr_rev[i]);	
					}
				}
			}
		}

		int max = -1;
		for(int i = 0; i<n; i++)
		{
			int left_max = next_greater_element_left[i];
			int right_max = next_greater_element_right[i];

			if(left_max != -1)
				max = Math.max(max, arr[i]^left_max);

			if(right_max != -1)
				max = Math.max(max, arr[i]^right_max);
		}

		System.out.println(max);
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
