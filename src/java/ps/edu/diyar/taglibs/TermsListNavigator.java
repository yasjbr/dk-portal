/*
 * Decompiled with CFR 0_102.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletRequest
 *  javax.servlet.http.HttpSession
 *  javax.servlet.jsp.JspWriter
 *  javax.servlet.jsp.PageContext
 *  javax.servlet.jsp.tagext.TagSupport
 *  ps.edu.diyar.common.tools.Randomizer
 *  ps.edu.diyar.common.utils.TermsList
 */
package ps.edu.diyar.taglibs;

import java.io.PrintStream;
import java.util.List;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import ps.edu.diyar.common.tools.Randomizer;
import ps.edu.diyar.common.utils.TermsList;

public class TermsListNavigator
        extends TagSupport {
    private String pageType = null;

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public int doStartTag() {
        try {
            JspWriter out = this.pageContext.getOut();
            ServletRequest request = this.pageContext.getRequest();
            HttpSession session = this.pageContext.getSession();
            if (session.getAttribute("termsList") != null) {
                TermsList term;
                List storedTermsList = (List)session.getAttribute("termsList");
                int listSize = storedTermsList.size();
                int index = 0;
                if (request.getParameter("index") != null) {
                    index = Integer.parseInt(request.getParameter("index"));
                } else if (request.getAttribute("index") != null) {
                    index = Integer.parseInt((String)request.getAttribute("index"));
                }
                boolean noNext = false;
                if (index + 1 == listSize) {
                    noNext = true;
                }
                if (index > 0) {
                    term = (TermsList)storedTermsList.get(index - 1);
                    out.println("<A class=qou href=\"../../" + this.pageType + "?.rv=" + Randomizer.shortRandom() + "&term=" + term.getTermNo() + "&index=" + (index - 1) + "\"> \u0627\u0644\u062a\u0627\u0644\u064a</font></A>|");
                } else {
                    out.println("\u0627\u0644\u062a\u0627\u0644\u064a|");
                }
                if (listSize != 0 && index != 0) {
                    term = (TermsList)storedTermsList.get(0);
                    out.println("<A class=qou href=\"../../" + this.pageType + "?.rv=" + Randomizer.shortRandom() + "&term=" + term.getTermNo() + "\"> \u0627\u0644\u062d\u0627\u0644\u064a </A>|");
                } else {
                    out.println(" \u0627\u0644\u062d\u0627\u0644\u064a |");
                }
                if (!(index >= listSize || listSize == 1 || noNext)) {
                    int tempIndex = index + 1 == listSize ? index : index + 1;
                    TermsList term2 = (TermsList)storedTermsList.get(tempIndex);
                    out.println("<A class=qou href=\"../../" + this.pageType + "?.rv=" + Randomizer.shortRandom() + "&term=" + term2.getTermNo() + "&index=" + tempIndex + "\"> \u0627\u0644\u0633\u0627\u0628\u0642 </A>");
                } else {
                    out.println(" \u0627\u0644\u0633\u0627\u0628\u0642 ");
                }
            }
        }
        catch (Exception ioe) {
            System.out.println("Error: " + ioe);
        }
        return 0;
    }
}