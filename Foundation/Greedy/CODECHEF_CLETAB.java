import java.util.*;
import java.io.*;
import java.lang.*;

class CLETAB 
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Parser in = new Parser(System.in);
		int T = in.nextInt();

		for(int t = 0; t<T; t++)
		{
			int n = in.nextInt();
			int m = in.nextInt();

			int arr[] = new int[m];
			for(int i = 0; i<m; i++)
				arr[i] = in.nextInt();

			HashSet<Integer> set = new HashSet<Integer>();

			int ans = 0;
			for(int i = 0; i<m; i++)
			{
				if(!set.contains(arr[i]) && n > 0)
				{
					set.add(arr[i]);
					n--;
					ans++;
				}

				else if(!set.contains(arr[i]) && n == 0)
				{
					HashSet<Integer> set_copy = new HashSet<Integer>();
					for(int x : set)
						set_copy.add(x);

					int last_removed = -1;
					for(int j = i+1; j<m; j++)
					{
						if(set_copy.contains(arr[j]))
						{
							set_copy.remove(arr[j]);
							last_removed = arr[j];
						}
					}

					if(set_copy.isEmpty())
					{
						set.remove(last_removed);
						set.add(arr[i]);
					}

					else
					{
						for(int x : set_copy)
						{
							set.remove(x);
							set.add(arr[i]);
							break;
						}
					}
					ans++;
				}
			}

			System.out.println(ans);
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
