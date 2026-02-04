package com.github.senn.osgimock;

import org.osgi.service.component.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

@Component(service = BindingComponent.class)
public class BindingComponent {

    private static final Logger log = LoggerFactory.getLogger(BindingComponent.class);

    @Reference(
            cardinality = ReferenceCardinality.MULTIPLE,
            policy = ReferencePolicy.DYNAMIC,
            policyOption = ReferencePolicyOption.GREEDY,
            bind = "onRefComponentBindingChange",
            unbind = "onRefComponentBindingChange",
            updated = "onRefComponentBindingChange"
    )
    private volatile Collection<RefComponent> refComponents;

    void onRefComponentBindingChange(RefComponent refComponent) {
        log.info("Ref component changed: {}", refComponent.getName());
    }

    public Collection<RefComponent> getRefComponents() {
        return refComponents;
    }
}
