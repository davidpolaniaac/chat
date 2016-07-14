package website.davidpolania.android.chat.contactlist.ui;

import website.davidpolania.android.chat.contactlist.entities.User;

/**
 * Created by David Polania.
 */
public interface OnItemClickListener {
    void onItemClick(User user);
    void onItemLongClick(User user);
}
