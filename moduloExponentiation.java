/* May need some edits in case modulo is 1 */
public static long ModuloExponentiation(long base, long exp, long modulo)
{
  long result = 0;
  while(exp > 0)
  {
    if(exp%2 == 1)
      result = (result*base)%modulo;

    base = (base*base)%modulo;
    exp = exp/2;
  }

  return result;
}
