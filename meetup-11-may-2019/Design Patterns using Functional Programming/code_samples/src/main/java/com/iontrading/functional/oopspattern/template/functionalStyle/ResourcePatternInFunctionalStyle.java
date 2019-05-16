package com.iontrading.functional.oopspattern.template.functionalStyle;

public class ResourcePatternInFunctionalStyle {

    public static void main(String[] args) {
        Resource.use(resource -> {
                    resource.op1();
                    resource.op2();
                }
        );
    }
}
