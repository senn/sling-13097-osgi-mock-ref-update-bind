package com.github.senn.osgimock;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collection;

@Component(service = NonBindingComponent.class)
public class NonBindingComponent {

    @Reference
    private volatile Collection<RefComponent> refComponents;

    public Collection<RefComponent> getRefComponents() {
        return refComponents;
    }
}
