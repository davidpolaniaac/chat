package website.davidpolania.android.chat.contactlist;

import org.greenrobot.eventbus.Subscribe;

import website.davidpolania.android.chat.contactlist.entities.User;
import website.davidpolania.android.chat.contactlist.events.ContactListEvent;
import website.davidpolania.android.chat.contactlist.ui.ContactListView;
import website.davidpolania.android.chat.lib.EventBus;
import website.davidpolania.android.chat.lib.GreenRobotEventBus;

/**
 * Created by David Polania.
 */
public class ContactListPresenterImpl implements ContactListPresenter {
    EventBus eventBus;
    ContactListView contactListView;
    ContactListSessionInteractor contactListSessionInteractor;
    ContactListInteractor contactListInteractor;


    public ContactListPresenterImpl(ContactListView contactListView){
        this.eventBus = GreenRobotEventBus.getInstance();
        this.contactListView = contactListView;
        this.contactListSessionInteractor = new ContactListSessionInteractorImpl();
        this.contactListInteractor = new ContactListInteractorImpl();
    }

    @Override
    public void signOff() {
        contactListSessionInteractor.changeConnectionStatus(User.OFFLINE);
        contactListInteractor.destroyContactListListener();
        contactListInteractor.unSubscribeForContactEvents();
        contactListSessionInteractor.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return contactListSessionInteractor.getCurrentUserEmail();
    }

    @Override
    public void removeContact(String email) {
        contactListInteractor.removeContact(email);
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onResume() {
        contactListSessionInteractor.changeConnectionStatus(User.ONLINE);
        contactListInteractor.subscribeForContactEvents();
    }

    @Override
    public void onPause() {
        contactListSessionInteractor.changeConnectionStatus(User.OFFLINE);
        contactListInteractor.unSubscribeForContactEvents();
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        contactListInteractor.destroyContactListListener();
        contactListView = null;
    }

    @Override
    @Subscribe
    public void onEventMainThread(ContactListEvent event) {
        User user = event.getUser();
        switch (event.getEventType()) {
            case ContactListEvent.onContactAdded:
                onContactAdded(user);
                break;
            case ContactListEvent.onContactChanged:
                onContactChanged(user);
                break;
            case ContactListEvent.onContactRemoved:
                onContactRemoved(user);
                break;
        }
    }

    public void onContactAdded(User user) {
        if (contactListView != null) {
            contactListView.onContactAdded(user);
        }
    }

    public void onContactChanged(User user) {
        if (contactListView != null) {
            contactListView.onContactChanged(user);
        }
    }

    public void onContactRemoved(User user) {
        if (contactListView != null) {
            contactListView.onContactRemoved(user);
        }
    }
}
