import java.util.*;
import java.io.*;
import java.lang.*;

class CAKEDOOM 
{
	public static void main(String[] args) throws java.lang.Exception
	{
		Parser in =  new Parser(System.in);
		int T = in.nextInt();

		for(int t = 0; t<T; t++)
		{
			int k = in.nextInt();
			String s1 = in.next();
			char s[] = s1.toCharArray();

			if(s.length == 1)
			{
				if(s[0] == '?')
					System.out.println(0);

				else
					System.out.println(s[0]);

				continue;
			}

			if(k == 1)
			{
				if(s.length == 1)
				{
					if(s[0] == '?')
						System.out.println(0);

					else
						System.out.println(s[0]);
				}

				else
					System.out.println("NO");
			}

			if(k == 2)
			{
				int i;
				boolean match01 = true;
				boolean match10 = true;

				for(i = 0; i<s.length; i++)
				{
					if(s[i] != '?' &&  s[i] != (char)('0' + i%2))
						match01 = false;

					if(s[i] != '?' && s[i] != (char)('0' + (i+1)%2))
						match10 = false;
				}

				if(s.length%2 == 1)
				{	
					match01 = false;
					match10 = false;
				}

				if(!match01 && !match10)
					System.out.println("NO");

				else
				{
					for(i = 0; i<s.length; i++)
					{
						if(match01)
							System.out.print((char)('0' + i%2));

						else
							System.out.print((char)('0' + (i+1)%2));
					}

					System.out.println();
				}
			}

			if(k >= 3)
			{
				boolean valid = true;
				int i;
				for(i=0; i<s.length; i++)
				{
					if(s[i] != '?' &&  s[i] == s[i == s.length - 1 ? 0 : i + 1])
					{
						valid = false;
						break;
					}
				}

				if(valid)
				{
					for(i=0; i<s.length; i++)
					{
						if(s[i] == '?')
						{
							for(char j = '0' ;j <= '2' ;j++)
							{
								if(j != s[i==0 ? s.length -1 : i-1] &&  j !=s[i==s.length -1 ? 0: i+1]  )
								{
									s[i] = j;
									break;
								}
							}
						}
						
					}

					for(i=0 ;i<s.length;i++)
						System.out.print(s[i]);
					
					System.out.println();
				}

				else
					System.out.println("NO");
			}
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
