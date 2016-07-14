package website.davidpolania.android.chat.login;

/**
 * Created by David Polania.
 */
public interface LoginInteractor {
    void checkAlreadyAuthenticated();
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}
