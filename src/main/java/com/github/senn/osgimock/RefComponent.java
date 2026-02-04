package com.github.senn.osgimock;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

/**
 * Standard factory component with a single string property "name".
 */
@Component(service = RefComponent.class)
@Designate(ocd = RefComponent.Config.class, factory = true)
public class RefComponent {

    @ObjectClassDefinition
    @interface Config {
        @AttributeDefinition
        String name() default "unknown";
    }

    private String name;

    @Activate
    void activate(Config config) {
        this.name = config.name();
    }

    public String getName() {
        return name;
    }
}
