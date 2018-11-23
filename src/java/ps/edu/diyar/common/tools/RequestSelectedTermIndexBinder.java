package ps.edu.diyar.common.tools;

import java.util.List;
import ps.edu.diyar.common.utils.TermsList;

public class RequestSelectedTermIndexBinder
{
  public static String setRequestSelectedTermIndex(List termsList, String selectedTerm)
  {
    int index = 0;
    for (int i = 0; i < termsList.size(); i++)
    {
      TermsList storedTermsList = (TermsList)termsList.get(i);
      if (storedTermsList.getTermNo().equals(selectedTerm))
      {
        index = i;
        break;
      }
    }
    return new String("" + index);
  }
}
 