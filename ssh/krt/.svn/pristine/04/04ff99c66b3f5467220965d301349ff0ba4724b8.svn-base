package cn.krt.zbcg.system.web.action;

import cn.krt.zbcg.commons.bo.system.CustomerBO;
import cn.krt.zbcg.commons.bo.system.NoticeBO;
import cn.krt.zbcg.commons.bo.system.UserBO;
import cn.krt.zbcg.system.services.ICustomerServices;
import cn.krt.zbcg.system.services.INoticeServices;
import cn.krt.zbcg.system.services.IUserServices;
import cn.krt.zbcg.system.web.form.UserForm;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.ssi.common.MD5;
import org.ssi.common.Operate;
import org.ssi.common.PageInfo;
import org.ssi.struts.action.SSIDispatchAction;

public class UserAction extends SSIDispatchAction
{
  private IUserServices userServices;
  private ICustomerServices customerServices;
  private INoticeServices noticeServices;

  private IUserServices getUserServices()
  {
    if (this.userServices == null) {
      this.userServices = ((IUserServices)getBean("userServices"));
    }
    return this.userServices;
  }

  private ICustomerServices getCustomerServices()
  {
    if (this.customerServices == null) {
      this.customerServices = ((ICustomerServices)getBean("customerServices"));
    }
    return this.customerServices;
  }

  private INoticeServices getCeServices()
  {
    if (this.noticeServices == null) {
      this.noticeServices = ((INoticeServices)getBean("noticeServices"));
    }
    return this.noticeServices;
  }

  public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    UserForm sForm = (UserForm)form;
    PageInfo pageInfo = new PageInfo();
    getUserServices().setRequest(request);
    Map map = Operate.describe(sForm);
    List userList = getUserServices().findAll(pageInfo, map);
    for (int i = 0; i < userList.size(); i++) {
      UserBO userBO = (UserBO)userList.get(i);
      if ("1".equals(userBO.getLoginType()))
        userBO.setLoginType("康仁堂用户");
      else {
        userBO.setLoginType("供应商");
      }
      if ("1".equals(userBO.getRoleType()))
        userBO.setRoleType("超级管理员");
      else if ("2".equals(userBO.getRoleType()))
        userBO.setRoleType("采购部");
      else if ("3".equals(userBO.getRoleType()))
        userBO.setRoleType("供应商");
      else if ("4".equals(userBO.getRoleType())) {
        userBO.setRoleType("质量部");
      } else if ("5".equals(userBO.getRoleType())) {
          userBO.setRoleType("物流部");
        }else if ("6".equals(userBO.getRoleType())) {
          userBO.setRoleType("财务部");
        }
      else if ("7".equals(userBO.getRoleType())) {
          userBO.setRoleType("运营部");
        }
    }

    request.setAttribute("list", userList);
    request.setAttribute("pageInfo", pageInfo);
    return mapping.findForward("list");
  }

  public ActionForward toAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    return mapping.findForward("toAdd");
  }

  public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    UserForm userForm = (UserForm)form;
    UserBO userBO = userForm.getUserBO();
    String roleType = request.getParameter("roleType");
    String loginType = request.getParameter("loginType");
    userBO.setLoginType(loginType);
    userBO.setRoleType(roleType);
    userBO.setPassword(new MD5().getMD5ofStr(userForm.getPassword()));
    try {
      getUserServices().insert(userBO);
      request.setAttribute("exception.message", "增加成功！");
    } catch (Exception e) {
      ExceptionUtils.getFullStackTrace(e);
      e.printStackTrace();
    }
    return list(mapping, form, request, response);
  }

  public ActionForward checkUserName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    String username = request.getParameter("username");
    UserBO userBO = getUserServices().getUserByName(username);
    if (userBO == null) {
      response.getWriter().println(0);
      return null;
    }
    response.getWriter().println(1);
    return null;
  }

  public ActionForward toUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    UserForm userForm = (UserForm)form;
    String ids = userForm.getSelectNos()[0];
    String[] a = ids.split(",");
    String id = a[0].trim();
    UserBO userBO = getUserServices().findById(Integer.valueOf(Integer.parseInt(id)));
    userForm.setUserBO(userBO);
    request.setAttribute("userBO", userBO);
    return mapping.findForward("toUpdate");
  }

  public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    UserForm userForm = (UserForm)form;
    UserBO userBO = userForm.getUserBO();
    try {
      getUserServices().update(userBO);
    } catch (Exception e) {
      ExceptionUtils.getFullStackTrace(e);
      e.printStackTrace();
    }
    request.setAttribute("exception.message", "修改信息成功！");
    return list(mapping, form, request, response);
  }

  public ActionForward resetPassword(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    UserForm userForm = (UserForm)form;
    String str = userForm.getSelectNos()[0];
    String[] a = str.split(",");
    String username = a[1].trim();

    String RESET_PASSWORD = "888888";
    String password = new MD5().getMD5ofStr(RESET_PASSWORD);
    UserBO userBO = new UserBO();
    userBO.setPassword(password);
    userBO.setUsername(username);
    getUserServices().updatePassword(userBO);
    request.setAttribute("exception.message", "重置密码成功！");
    return list(mapping, form, request, response);
  }

  public ActionForward user(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    UserForm userForm = (UserForm)form;

    UserBO userBO = new UserBO();

    String loginName = userForm.getLoginName();
    //96E79218965EB72C92A549DD5A330112
    //21218cca77804d2ba1922c33e0151105
    String loginPwd = userForm.getLoginPwd();

    userBO = getUserServices().getUserByLoginName(loginName);

    if (userBO == null) {
      response.getWriter().print("1");
      return null;
    }

    if (!userBO.getLoginPwd().equals(
      loginPwd)) {
      response.getWriter().print("2");
      return null;
    }

    request.getSession().setAttribute("Logon.User", userBO);
    NoticeBO noticeBO = getCeServices().findNotice();

    request.getSession().setAttribute("Logon.Zbgg", noticeBO);
    return null;
  }

  public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    return mapping.findForward("indexsuccess");
  }

  public ActionForward backSystem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    if (request.getSession().getAttribute("Logon.User") != null) {
      request.getSession().removeAttribute("Logon.User");
    }
    if (request.getSession().getAttribute("Logon.Zbgg") != null) {
      request.getSession().removeAttribute("Logon.Zbgg");
    }
    return mapping.findForward("destroySession");
  }

  public ActionForward modifyEmpP(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    UserBO userBO = (UserBO)request.getSession().getAttribute("Logon.User");
    if ((userBO != null) && ("3".equals(userBO.getLoginRole())))
      return mapping.findForward("supplierPassword");
    if ((userBO != null) && (("1".equals(userBO.getLoginRole())) || ("2".equals(userBO.getLoginRole())) || ("4".equals(userBO.getLoginRole())))) {
      return mapping.findForward("userPassword");
    }
    return mapping.findForward("opassword");
  }

  public ActionForward checkPassword(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    String checkpassword = new MD5().getMD5ofStr(request.getParameter("checkpassword"));
    UserBO userBO = (UserBO)request.getSession().getAttribute("Logon.User");
    userBO.setPassword(checkpassword);
    userBO.setUsername(userBO.getLoginName());
    UserBO user = getUserServices().getPasswordByCheck(userBO);
    if (user == null) {
      response.getWriter().println(1);
      return null;
    }
    response.getWriter().println(0);
    return null;
  }

  public ActionForward updatePasswordUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    UserForm userForm = (UserForm)form;
    String passsword = new MD5().getMD5ofStr(userForm.getPassword());
    UserBO userBO = (UserBO)request.getSession().getAttribute("Logon.User");
    userBO.setPassword(passsword);
    userBO.setUsername(userBO.getLoginName());
    getUserServices().updatePassword(userBO);
    request.setAttribute("flag", Boolean.valueOf(true));
    return mapping.findForward("userPassword");
  }

  public ActionForward checkPasswordCusertomer(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    String checkpassword = new MD5().getMD5ofStr(request.getParameter("checkpassword"));
    UserBO userBO = (UserBO)request.getSession().getAttribute("Logon.User");
    CustomerBO customerBO = new CustomerBO();
    customerBO.setPassword(checkpassword);
    customerBO.setCustomerAccount(userBO.getLoginName());
    CustomerBO user = getCustomerServices().getPasswordByCheck(customerBO);
    if (user == null) {
      response.getWriter().println(1);
      return null;
    }
    response.getWriter().println(0);
    return null;
  }

  public ActionForward updatePasswordCustomer(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    UserForm userForm = (UserForm)form;
    String passsword = new MD5().getMD5ofStr(userForm.getPassword());
    UserBO userBO = (UserBO)request.getSession().getAttribute("Logon.User");
    CustomerBO customerBO = new CustomerBO();
    customerBO.setPassword(passsword);
    customerBO.setCustomerAccount(userBO.getLoginName());
    getCustomerServices().updatePassword(customerBO);
    request.setAttribute("flag", Boolean.valueOf(true));
    return mapping.findForward("supplierPassword");
  }
}