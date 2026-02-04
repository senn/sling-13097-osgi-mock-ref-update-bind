package com.github.senn.osgimock.single;

import com.github.senn.osgimock.RefComponent;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = SingleNonBindingComponent.class)
public class SingleNonBindingComponent {

    @Reference
    private RefComponent refComponent;

    public String getRefName() {
        return refComponent.getName();
    }
}
