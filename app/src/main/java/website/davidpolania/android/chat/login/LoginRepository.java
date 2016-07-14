package website.davidpolania.android.chat.login;

/**
 * Created by David Polania.
 */
public interface LoginRepository {
    void signUp(final String email, final String password);
    void signIn(String email, String password);
    void checkAlreadyAuthenticated();
}
