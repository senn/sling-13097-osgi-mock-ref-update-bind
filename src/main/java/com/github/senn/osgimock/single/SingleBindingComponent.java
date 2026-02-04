package com.github.senn.osgimock.single;

import com.github.senn.osgimock.RefComponent;
import org.osgi.service.component.annotations.*;

@Component(service = SingleBindingComponent.class)
public class SingleBindingComponent {

    @Reference(
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            policyOption = ReferencePolicyOption.GREEDY,
            bind = "onRefComponentBindingChange",
            unbind = "onRefComponentBindingChange",
            updated = "onRefComponentBindingChange"
    )
    private volatile RefComponent refComponent;

    void onRefComponentBindingChange(RefComponent refComponent) {
        // No-op
    }

    public String getRefName() {
        return refComponent.getName();
    }
}
