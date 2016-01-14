package com.dylan.aic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这个主要用于存储枚举key值，当然也可以把其他信息也存进来，或者新建一个
 * @author Dylan
 * @date 2015年12月7日
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumInfo
{
	 String[] value();
}
