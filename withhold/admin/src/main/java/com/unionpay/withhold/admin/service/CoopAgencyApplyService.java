package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TCoopAgencyApply;
import com.unionpay.withhold.admin.pojo.TCoopAgencyApplyExample;

public interface CoopAgencyApplyService {

	PageBean queryByPage(TCoopAgencyApplyExample coopAgencyApplyExample);

	ResultBean addCoopAgencyApply(TCoopAgencyApply coopAgencyApply);


}
