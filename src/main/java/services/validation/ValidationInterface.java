package services.validation;
@FunctionalInterface
public interface ValidationInterface <T>{
    boolean validate(T t);
}
