package website.davidpolania.android.chat.addcontact;

import website.davidpolania.android.chat.addcontact.events.AddContactEvent;

/**
 * Created by David Polania.
 */
public interface AddContactPresenter {
    void onShow();
    void onDestroy();

    void addContact(String email);
    void onEventMainThread(AddContactEvent event);
}

