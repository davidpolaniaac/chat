package website.davidpolania.android.chat.login;

import website.davidpolania.android.chat.login.events.LoginEvent;

/**
 * Created by David Polania.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void onResume();
    void onPause();
    void checkForAuthenticatedUser();
    void onEventMainThread(LoginEvent event);
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
}
