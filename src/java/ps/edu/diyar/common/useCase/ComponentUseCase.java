package ps.edu.diyar.common.useCase;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;

public abstract interface ComponentUseCase
{
  public abstract Collection execute(Collection paramCollection, HttpServletRequest paramHttpServletRequest)
    throws HibernateException;
}


 