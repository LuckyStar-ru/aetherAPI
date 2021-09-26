package aether.project.aetherapi.commands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CommandReg {
    String[] aliases();
    String desc() default "Для этой команды нет описания.";
    String usage() default "Для этой команды нет примеров использования.";
}
