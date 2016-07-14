package website.davidpolania.android.chat.contactlist;

/**
 * Created by David Polania.
 */
public interface ContactListInteractor {
    void subscribeForContactEvents();
    void unSubscribeForContactEvents();
    void destroyContactListListener();
    void removeContact(String email);
}
