package com.github.senn.osgimock;

import org.apache.sling.testing.mock.sling.junit5.SlingContext;
import org.apache.sling.testing.mock.sling.junit5.SlingContextExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SlingContextExtension.class)
@ExtendWith(MockitoExtension.class)
class BindingComponentTest {

    public final SlingContext context = new SlingContext();

    @Mock
    private RefComponent refComponent1, refComponent2;

    @Test
    void testRefComponentInjection() {
        context.registerService(RefComponent.class, refComponent1);
        context.registerService(RefComponent.class, refComponent2);
        BindingComponent bindingComponent = context.registerInjectActivateService(new BindingComponent());
        // fails because refComponents is null while in actual OSGi it would be injected
        assertEquals(2, bindingComponent.getRefComponents().size());
    }

}