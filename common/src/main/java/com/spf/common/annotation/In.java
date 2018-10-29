package com.spf.common.annotation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;

/**
 * @author ShuPF
 *
 * @Target： 表示该注解可以用于什么地方，可能的ElementType参数有：
 *              CONSTRUCTOR：构造器的声明, FIELD：域声明（包括enum实例）,LOCAL_VARIABLE：局部变量声明
 *              METHOD：方法声明,PACKAGE：包声明,PARAMETER：参数声明,TYPE：类、接口（包括注解类型）或enum声明
 *
 * @Retention  表示需要在什么级别保存该注解信息。可选的RetentionPolicy参数包括：
 *              SOURCE：注解将被编译器丢弃,CLASS：注解在class文件中可用，但会被VM丢弃
 *              RUNTIME：VM将在运行期间保留注解，因此可以通过反射机制读取注解的信息
 *
 * @Document 将注解包含在Javadoc中
 *
 * @Inherited 允许子类继承父类中的注解
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = In.Validator.class)
public @interface In {
	
    String message() default "{custom.value.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /** 逗号分隔 **/
    String value();
	
    class Validator implements ConstraintValidator<In, Object> {
    	private List<String> list;
        @Override
        public void initialize(In value) {
        	this.list = Arrays.asList(value.value().split(","));
        }

        @Override
        public boolean isValid(Object target, ConstraintValidatorContext constraintValidatorContext) {
            if (target == null) {
                return Boolean.TRUE;
            }
            if(list.contains(String.valueOf(target))){
            	return true;
            }
            return false;
        }

    }
}
