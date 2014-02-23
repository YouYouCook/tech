package org.ssi.services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface IDriverService extends Remote
{
  public abstract Object getObject(String paramString, Object[] paramArrayOfObject)
    throws RemoteException;
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.services.IDriverService
 * JD-Core Version:    0.6.2
 */