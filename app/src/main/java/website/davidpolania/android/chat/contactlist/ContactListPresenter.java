package website.davidpolania.android.chat.contactlist;

import website.davidpolania.android.chat.contactlist.events.ContactListEvent;

/**
 * Created by David Polania.
 */
public interface ContactListPresenter {
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void onEventMainThread(ContactListEvent event);
}
