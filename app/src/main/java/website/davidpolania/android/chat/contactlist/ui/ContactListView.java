package website.davidpolania.android.chat.contactlist.ui;

import website.davidpolania.android.chat.contactlist.entities.User;

/**
 * Created by David Polania.
 */
public interface ContactListView {
    void onContactAdded(User user);
    void onContactChanged(User user);
    void onContactRemoved(User user);
}
