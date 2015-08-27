package controllers.admin;

import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	public Result index() {
		return ok(index_adm.render());
	}
}