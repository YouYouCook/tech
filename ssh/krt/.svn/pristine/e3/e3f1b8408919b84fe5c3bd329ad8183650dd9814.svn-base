<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<script language="javascript">
var countyArray = null;
var serviceArray = null;
<%
	String county = request.getParameter("county");
	java.util.List countyList = null;
	if(county != null)
	{
		countyList = (java.util.List)request.getAttribute(county);
		pageContext.setAttribute("countyList",countyList);
		%>
		countyArray = new Array(<%=countyList.size()%>);
		<logic:present name="cityList">
		    <logic:iterate id="city" name="cityList" indexId = "indexNo">
		    countyArray[<%=indexNo%>] = new Array("<bean:write name="city" property="provinceCode"/>","<bean:write name="city" property="cityName"/>","<bean:write name="city" property="cityCode"/>");
		    </logic:iterate>
	    </logic:present>
	    <%
	}

	%>
	function changeProvince(tcProvince,countyObj,c_default)
	{   
		if(countyObj)
		{
			clearSelect(countyObj);
			addOption(countyObj,"请选择","");
			for(var i = 0 ; i < countyArray.length ; i ++)
			{
				if(tcProvince == countyArray[i][0])
				{
					addOption(countyObj,countyArray[i][1],countyArray[i][2]);
				}
			}
			if(c_default != "")
			{
				countyObj.value = c_default;
			}
		}
		
	}
	<%
%>
function addOption(obj,text,value){
  var oOption = document.createElement("OPTION");
  oOption.text=text;
  oOption.value=value;
  obj.add(oOption);
}
//清空，无option
function clearSelect(obj){
   //alert(obj.length);
   for(var i=0 ; i < obj.options.length;i--,i++)
  	obj.remove(i);
}
</script>
