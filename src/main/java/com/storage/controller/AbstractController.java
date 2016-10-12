package com.storage.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storage.aop.Result;
import com.storage.exception.BaseException;

/**
 * 
 * Abstract controller
 *
 */
public class AbstractController {

	/**
	 * Handle exception globally
	 * 
	 * @author terry.yao
	 * @param ex
	 * @return {@link Result}
	 */
	@ExceptionHandler({ BaseException.class, Exception.class })
	public @ResponseBody Result handleWesException(Exception ex) {
		if (ex instanceof BaseException) {
			BaseException we = (BaseException) ex;
			return new Result(we.getErrorCode(), we.getErrorMessage(), null);
		} else {
			Exception e = (Exception) ex;
			ex.printStackTrace();
			return new Result(-1, e.getMessage(), null);
		}
	}

	/*
	 * private Result checkException(Exception ex) { if (ex instanceof
	 * AccessDeniedException) { return new Result(BaseException.ACCESS_DENIED,
	 * "You have no permission!", null); } else { return new Result(-1,
	 * ex.getMessage(), null); } }
	 */
}
