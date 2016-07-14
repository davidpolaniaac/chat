package website.davidpolania.android.chat.contactlist;

/**
 * Created by David Polania.
 */
public interface ContactListSessionInteractor {
    void signOff();
    String getCurrentUserEmail();
    void changeConnectionStatus(boolean online);
}
