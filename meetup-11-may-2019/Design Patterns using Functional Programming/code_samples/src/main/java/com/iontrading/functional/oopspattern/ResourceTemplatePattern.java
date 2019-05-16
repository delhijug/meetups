package com.iontrading.functional.oopspattern;

public abstract class ResourceTemplatePattern {
    private final Resource resource;

    ResourceTemplatePattern(Resource resource){
        this.resource = resource;
    }

    public void executeOperations(){
        try {
            doOperations();
        } finally {
            resource.close();
        }
    }

    protected abstract void doOperations();
}


class User1 extends ResourceTemplatePattern {
    private final Resource resource;

    User1(Resource resource) {
        super(resource);
        this.resource = resource;
    }

    @Override
    protected void doOperations() {
        resource.op1();
    }
}

class User2 extends ResourceTemplatePattern {
    private final Resource resource;

    User2(Resource resource) {
        super(resource);
        this.resource = resource;
    }

    @Override
    protected void doOperations() {
        resource.op1();
        resource.op2();
    }
}

class SampleMain {
    public static void main(String[] args) {
        Resource resource1 = new Resource();
        new User1(resource1).executeOperations();

        Resource resource2 = new Resource();
        new User2(resource2).executeOperations();
    }
}