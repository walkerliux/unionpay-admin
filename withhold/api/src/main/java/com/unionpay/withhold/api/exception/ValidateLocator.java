package com.unionpay.withhold.api.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.unionpay.withhold.api.common.bean.ValidateResultBean;


public class ValidateLocator {

	private static Validator validator;
	public static final String SYSTEM_ERROR = "订单信息错误,请重新提交订单";
	public static <T> ValidateResultBean validateBeans(T obj) throws DataErrorException {
		ValidateResultBean resultBean = null;
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
		String message = SYSTEM_ERROR;
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			message = constraintViolation.getMessage() == null ? SYSTEM_ERROR : constraintViolation.getMessage();
			resultBean = new ValidateResultBean(constraintViolation.getPropertyPath().toString(), message);
			if (!resultBean.isResultBool()) {// 非空，长度检查出现异常，非法数据
				DataErrorException deDataErrorException = new DataErrorException();
				String msg=resultBean.getErrMsg();
				String code=msg.substring(0,4); 
				String rmString=msg.substring(4,msg.length());
				deDataErrorException.setRespCode(code);
				deDataErrorException.setRespMessage(rmString);
				throw deDataErrorException;
			}
			return resultBean;
		}
		resultBean = new ValidateResultBean(obj);
		return resultBean;
	}

}
