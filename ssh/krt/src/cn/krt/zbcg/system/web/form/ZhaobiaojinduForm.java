package cn.krt.zbcg.system.web.form;

import org.ssi.struts.actionform.BaseForm;

import cn.krt.zbcg.commons.bo.system.ZhaobiaojinduBO;

public class ZhaobiaojinduForm  extends BaseForm{

	ZhaobiaojinduBO zhaobiaojinduBo = new ZhaobiaojinduBO();

	public ZhaobiaojinduBO getZhaobiaojinduBo() {
		return zhaobiaojinduBo;
	}

	public void setZhaobiaojinduBo(ZhaobiaojinduBO zhaobiaojinduBo) {
		this.zhaobiaojinduBo = zhaobiaojinduBo;
	}

	private String medicineZbid;


	public String getMedicineZbid() {
		return medicineZbid;
	}

	public void setMedicineZbid(String medicineZbid) {
		this.medicineZbid = medicineZbid;
	}

}
