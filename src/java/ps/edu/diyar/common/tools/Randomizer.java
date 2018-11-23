package ps.edu.diyar.common.tools;

import java.util.Random;

public class Randomizer
{
  private static final String hexChars = "0123456789abcdef";
  private static final byte INDEX_TYPE = 6;
  private static final byte INDEX_VARIATION = 8;
  private static final byte TYPE_RANDOM_BASED = 4;
  private static int RandomAdjuster = 0;
  private Random rnd;
  
  public Randomizer()
  {
    this.rnd = new Random(System.currentTimeMillis());
  }
  
  public static String RandomPassword()
  {
    String Password = "";
    
    int Seed = (int)(System.currentTimeMillis() % 20L) + 1 + RandomAdjuster;
    RandomAdjuster += 1;
    
    String PassChars = "Lz23456789AaBbCcDdEeFfGgHhJjKkMmNnMkPpQqRrSsTtUuVvWwXxYyZzf52abc";
    
    Random Rand = new Random();
    Rand.setSeed(System.currentTimeMillis() * Seed);
    
    byte[] PassByte = new byte[20];
    Rand.nextBytes(PassByte);
    for (int i = 0; i < PassByte.length; i++) {
      Password = Password + PassChars.charAt(PassByte[i] & 0x3F);
    }
    return Password;
  }
  
  public static String shortRandom()
  {
    String Password = "";
    
    int Seed = (int)(System.currentTimeMillis() % 20L) + 1 + RandomAdjuster;
    RandomAdjuster += 1;
    
    String PassChars = "Lz23456789AaBbCcDdEeFfGgHhJjKkMmNnMkPpQqRrSsTtUuVvWwXxYyZzf52abc";
    
    Random Rand = new Random();
    Rand.setSeed(System.currentTimeMillis() * Seed);
    
    int x = (int)(Math.random() * 10.0D) / 1;
    if (x <= 0) {
      x = 9;
    }
    byte[] PassByte = new byte[x + 6];
    Rand.nextBytes(PassByte);
    for (int i = 0; i < PassByte.length; i++) {
      Password = Password + PassChars.charAt(PassByte[i] & 0x3F);
    }
    return Password;
  }
  
  public static String shortRandom(Integer length)
  {
    String Password = "";
    
    int Seed = (int)(System.currentTimeMillis() % 20L) + 1 + RandomAdjuster;
    RandomAdjuster += 1;
    
    String PassChars = "Lz23456789AaBbCcDdEeFfGgHhJjKkMmNnMkPpQqRrSsTtUuVvWwXxYyZzf52abc";
    
    Random Rand = new Random();
    Rand.setSeed(System.currentTimeMillis() * Seed);
    
    int x = (int)(Math.random() * 1000.0D) / 1;
    if (x <= 0) {
      x = 9;
    }
    byte[] PassByte = new byte[x + 6];
    Rand.nextBytes(PassByte);
    if (length.intValue() > PassByte.length) {
      length = Integer.valueOf(PassByte.length);
    }
    for (int i = 0; i < length.intValue(); i++) {
      Password = Password + PassChars.charAt(PassByte[i] & 0x3F);
    }
    return Password;
  }
  
  public String generateUUID()
  {
    byte[] uuid = new byte[16];
    nextRandomBytes(uuid); byte[] 
    

      tmp13_10 = uuid;tmp13_10[6] = ((byte)(tmp13_10[6] & 0xF)); byte[] 
      tmp23_20 = uuid;tmp23_20[6] = ((byte)(tmp23_20[6] | 0x40)); byte[] 
      tmp33_30 = uuid;tmp33_30[8] = ((byte)(tmp33_30[8] & 0x3F)); byte[] 
      tmp43_40 = uuid;tmp43_40[8] = ((byte)(tmp43_40[8] | 0xFFFFFF80));
    

    StringBuffer b = new StringBuffer(36);
    for (int i = 0; i < 16; i++)
    {
      if ((i == 4) || (i == 6) || (i == 8) || (i == 10)) {
        b.append('-');
      }
      int hex = uuid[i] & 0xFF;
      b.append("0123456789abcdef".charAt(hex >> 4));
      b.append("0123456789abcdef".charAt(hex & 0xF));
    }
    return b.toString();
  }
  
  private void nextRandomBytes(byte[] bytes)
  {
    int numRequested = bytes.length;
    int numGot = 0;int rand = 0;
    for (;;)
    {
      for (int i = 0; i < 4; i++)
      {
        if (numGot == numRequested) {
          return;
        }
        rand = i == 0 ? this.rnd.nextInt() : rand >> 8;
        bytes[(numGot++)] = ((byte)rand);
      }
    }
  }
  
  public static String randomIntegers(Integer length)
  {
    String result = "";
    Random randomGenerator = new Random();
    for (int idx = 0; idx < length.intValue(); idx++)
    {
      int randomInt = randomGenerator.nextInt(10);
      result = result + randomInt;
    }
    return result;
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.common.tools.Randomizer
 * JD-Core Version:    0.7.0.1
 */