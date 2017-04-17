import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.hasEntry;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;

class FooTest {
    @Test
    public void testExactMap() {
        Service mockService = mock(Service.class);
        Foo foo = new Foo(mockService);

        foo.bar();

        Map<String, String> expectedParams = new HashMap<>();
        expectedParams.put("paramName", "paramValue");
        verify(mockService).activate(expectedParams);
    }

    @Test
    public void testHasEntry() {
        Service mockService = mock(Service.class);
        Foo foo = new Foo(mockService);

        foo.bar();

        verify(mockService).activate(argThat(hasEntry("paramName", "paramValue")));
    }

    @Test
    public void testHasEntryTypeParameters() {
        Service mockService = mock(Service.class);
        Foo foo = new Foo(mockService);

        foo.bar();

        verify(mockService).activate(argThat(Matchers.<String, ?>hasEntry("paramName", "paramValue")));
    }

    @Test
    public void testHasEntryCast() {
        Service mockService = mock(Service.class);
        Foo foo = new Foo(mockService);

        foo.bar();

        verify(mockService).activate(argThat((Matcher<Map<String, ?>>) hasEntry("paramName", "paramValue")));
    }
}