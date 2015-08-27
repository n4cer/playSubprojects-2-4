package controllers.admin;

import com.google.inject.Inject;
import play.api.mvc.Action;
import play.api.mvc.AnyContent;

public class Assets {
    @Inject
    controllers.Assets assets;
    public Action<AnyContent> versioned(String path, controllers.Assets.Asset file) {
        return assets.versioned(path, file);
    }
}