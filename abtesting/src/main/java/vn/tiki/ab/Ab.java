package vn.tiki.ab;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

/**
 * Created by Giang Nguyen on 10/24/16.
 */

public class Ab {

  private final FirebaseRemoteConfig firebaseRemoteConfig;
  private final long cacheExpiration;

  public Ab(AbSettings settings) {
    this.firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();

    final FirebaseRemoteConfigSettings remoteConfigSettings =
        new FirebaseRemoteConfigSettings.Builder().setDeveloperModeEnabled(settings.debug())
            .build();
    firebaseRemoteConfig.setConfigSettings(remoteConfigSettings);

    firebaseRemoteConfig.setDefaults(settings.defaults());
    cacheExpiration = settings.cacheExpiration();
  }

  public RequestBuilder request() {
    return new RequestBuilder(firebaseRemoteConfig, cacheExpiration);
  }
}
