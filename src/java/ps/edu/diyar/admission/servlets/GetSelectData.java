package ps.edu.diyar.admission.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ps.edu.diyar.admission.useCase.GetGovernateListUseCase;
import ps.edu.diyar.admission.useCase.GetLocalityListUseCase;
import ps.edu.diyar.admission.useCase.GetNationalityListUseCase;
import ps.edu.diyar.admission.useCase.GetSpecsOfCollegeNoListUseCase;
import ps.edu.diyar.common.struct.LabelValue;

public class GetSelectData
  extends HttpServlet
{
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    doPost(req, res);
  }
  
  public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    String dataset = req.getParameter("dataset");
    if (dataset != null) {
      dataset = dataset.toLowerCase();
    }
    String target = req.getParameter("target");
    




    String key1 = req.getParameter("key1");
    String key2 = req.getParameter("key2");
    
    String key3 = req.getParameter("key3");
    String key4 = req.getParameter("key4");
    String key5 = req.getParameter("key5");
    


    Collection retList = null;
    

    ArrayList inp = new ArrayList();
    
    res.setContentType("text/plain;charset=utf-8");
    PrintWriter out = res.getWriter();
    if ((dataset != null) && (dataset.trim().equals("specs"))) {
      try
      {
        inp.add(key1);
        retList = new GetSpecsOfCollegeNoListUseCase().execute(inp, req);
      }
      catch (Exception e1)
      {
        retList = null;e1.printStackTrace();
      }
    } else if ((dataset != null) && (dataset.trim().equals("natgender"))) {
      try
      {
        inp.add(key1);
        retList = new GetNationalityListUseCase().execute(inp, req);
      }
      catch (Exception e1)
      {
        retList = null;e1.printStackTrace();
      }
    } else if ((dataset != null) && (dataset.trim().equals("percov"))) {
      try
      {
        inp.add(key1);
        retList = new GetGovernateListUseCase().execute(inp, req);
      }
      catch (Exception e1)
      {
        retList = null;e1.printStackTrace();
      }
    } else if ((dataset != null) && (dataset.trim().equals("perlocal"))) {
      try
      {
        inp.add(key1);
        inp.add(key2);
        retList = new GetLocalityListUseCase().execute(inp, req);
      }
      catch (Exception e1)
      {
        retList = null;e1.printStackTrace();
      }
    }
    if ((retList != null) && (retList.size() > 0))
    {
      Object object = retList.iterator().next();
      if ((object instanceof Exception)) {
        return;
      }
      Iterator itr = retList.iterator();
      

      res.setStatus(200, "Get Select Successful");
      
      out.println("var _targ=document.getElementsByName(\"" + target + "\")[0];");
      out.println("_targ.options.length=0;");
      out.println("var _keys=[");
      for (int i = 0; itr.hasNext(); i++)
      {
        LabelValue cmb = (LabelValue)itr.next();
        if (i > 0) {
          out.println(",");
        }
        out.println("[\"" + cmb.getValue() + "\",\"" + cmb.getLabel() + "\"]");
      }
      out.println("];");
      out.println("for( var i=0; i < _keys.length; i++ ) {");
      out.println(" _targ.options[ i ] = new Option( _keys[i][1], _keys[i][0] ); ");
      out.println("};");
      out.println("_targ.options.length=_keys.length;");
      out.println("_targ.selectedIndex=0;");
    }
  }
}


/* Location:           C:\john_dreg\portal\diyar_portal.war\WEB-INF\classes\
 * Qualified Name:     ps.edu.diyar.admission.servlets.GetSelectData
 * JD-Core Version:    0.7.0.1
 */