package acp1.test.testutils;

import acp1.rest.utils.ObjectMapperProvider;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by mohammed al-ani on 1/23/2017.
 */
public abstract class TestRequestContext<T extends TestRequestContext<?>> {

    private String targetUri;
    private Acp1Test test;

    public TestRequestContext(Acp1Test test) {
        this.test = test;
    }

    public T target(String targetUri) {
        this.targetUri = targetUri;
        return (T) this;
    }

    public Response execute() {

        WebTarget target = test.target(targetUri);

        Invocation.Builder builder = target.request();

        Response result =  executeImpl(builder);
        result.bufferEntity(); // calls .reset() on contained stream sometimes
        return result;
    }
    protected abstract Response executeImpl(Invocation.Builder builder);

    public static class TestGetRequestContext extends TestRequestContext<TestGetRequestContext> {
        public TestGetRequestContext(Acp1Test test) {
            super(test);
        }

        @Override
        protected Response executeImpl(Invocation.Builder builder) {
            return builder.get();
        }
    }

    public static abstract class TestEntityableRequestContext<T extends TestRequestContext.TestEntityableRequestContext<?>> extends TestRequestContext<T> {
        private String entity;

        public TestEntityableRequestContext(Acp1Test test) {
            super(test);
        }


        public T entity(Object entity) throws JsonProcessingException {
            this.entity = ObjectMapperProvider.get().writeValueAsString(entity);
            return (T) this;
        }

        protected Entity<String> getEntity() {
            return Entity.entity(entity, MediaType.APPLICATION_JSON);
        }
    }

    public static class TestPostRequestContext extends TestEntityableRequestContext<TestPostRequestContext> {
        public TestPostRequestContext(Acp1Test test) {
            super(test);
        }

        @Override
        protected Response executeImpl(Invocation.Builder builder) {
            return builder.post(getEntity());
        }
    }



}
