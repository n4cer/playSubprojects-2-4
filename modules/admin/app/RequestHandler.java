import play.http.HttpRequestHandler;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Http.Request;
import play.mvc.Result;

import java.lang.reflect.Method;

public class RequestHandler implements HttpRequestHandler {
    @Override
    public Action createAction(Request request, Method actionMethod) {
      return new Action.Simple() {
        @Override
        public Promise<Result> call(Context ctx) throws Throwable {
            return delegate.call(ctx);
        }
      };
    }
    
    @Override
    public Action wrapAction(Action action) {
      return action;
    }
}