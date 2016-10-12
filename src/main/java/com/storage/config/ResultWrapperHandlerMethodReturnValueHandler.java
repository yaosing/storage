package com.storage.config;

import java.io.IOException;
import java.util.List;

import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import com.storage.annotation.RestApi;
import com.storage.aop.Result;


/**
 * Use to wrapper the result to {"errorCode":xx, "errMessage":xx, "response":xx}
 * just support the controller method used @RestApi annotation and the method identifier is public
 * @author terry.yao
 *
 */
public class ResultWrapperHandlerMethodReturnValueHandler extends RequestResponseBodyMethodProcessor {
	private final int SUCCESS_ERROR_CODE = 0;
	private final String SUCCESS_ERROR_MESSAGE = "ok";
	
	public ResultWrapperHandlerMethodReturnValueHandler(final List<HttpMessageConverter<?>> messageConverters) {
		super(messageConverters);
	}

	public ResultWrapperHandlerMethodReturnValueHandler(final List<HttpMessageConverter<?>> messageConverters,
			final ContentNegotiationManager contentNegotiationManager) {
		super(messageConverters, contentNegotiationManager);
	}

	@Override
	public boolean supportsReturnType(final MethodParameter returnType) {
		return returnType.getMethodAnnotation(RestApi.class) != null;
	}

	@Override
	public void handleReturnValue(final Object returnValue, final MethodParameter returnType, final ModelAndViewContainer mavContainer,
			final NativeWebRequest webRequest) throws IOException, HttpMediaTypeNotAcceptableException {
		Object response = wrapper(returnValue, SUCCESS_ERROR_CODE, SUCCESS_ERROR_MESSAGE);
		super.handleReturnValue(response, returnType, mavContainer, webRequest);
	}

	private Object wrapper(Object response, int errorCode, String errorMessage) {
		return new Result(errorCode, errorMessage, response);
	}
}
