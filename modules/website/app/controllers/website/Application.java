package controllers.website;

import static play.data.Form.form;
import play.*;
import play.data.Form;
import play.data.validation.Constraints;
import play.mvc.*;
import models.*;

import views.html.*;

public class Application extends Controller {
	public Result index() {
		return ok(index_web.render());
	}
}