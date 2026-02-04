package com.github.senn.osgimock.single;

import com.github.senn.osgimock.RefComponent;
import org.apache.sling.testing.mock.sling.junit5.SlingContext;
import org.apache.sling.testing.mock.sling.junit5.SlingContextExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SlingContextExtension.class)
@ExtendWith(MockitoExtension.class)
class SingleBindingComponentTest {

    public final SlingContext context = new SlingContext();

    @Mock
    private RefComponent refComponent;

    @Test
    void testRefComponentInjection() {
        doReturn("Test").when(refComponent).getName();
        context.registerService(RefComponent.class, refComponent);
        SingleBindingComponent comp = context.registerInjectActivateService(spy(new SingleBindingComponent()));
        verify(comp).onRefComponentBindingChange(refComponent);
        assertEquals("Test", comp.getRefName());
    }
}