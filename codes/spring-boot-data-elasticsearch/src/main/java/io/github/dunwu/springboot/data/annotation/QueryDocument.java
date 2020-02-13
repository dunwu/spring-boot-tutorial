package io.github.dunwu.springboot.data.annotation;

import io.github.dunwu.springboot.data.constant.OrderType;
import org.springframework.data.annotation.Persistent;

import java.lang.annotation.*;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2019-12-17
 */
@Persistent
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface QueryDocument {

	Class<?> value();

	String orderItem() default "";

	OrderType orderType() default OrderType.ASC;

}
