package website.davidpolania.android.chat.addcontact;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import website.davidpolania.android.chat.lib.EventBus;
import website.davidpolania.android.chat.addcontact.events.AddContactEvent;
import website.davidpolania.android.chat.contactlist.entities.User;
import website.davidpolania.android.chat.domain.FirebaseHelper;
import website.davidpolania.android.chat.lib.GreenRobotEventBus;

/**
 * Created by David Polania.
 */
public class AddContactRepositoryImpl implements AddContactRepository {
    @Override
    public void addContact(final String email) {
        final String key = email.replace(".","_");

        FirebaseHelper helper = FirebaseHelper.getInstance();
        final DatabaseReference userReference = helper.getUserReference(email);
        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                AddContactEvent event = new AddContactEvent();
                if (user != null) {
                    boolean online = user.isOnline();
                    FirebaseHelper helper = FirebaseHelper.getInstance();

                    DatabaseReference userContactsReference = helper.getMyContactsReference();
                    userContactsReference.child(key).setValue(online);

                    String currentUserEmailKey = helper.getAuthUserEmail();
                    currentUserEmailKey = currentUserEmailKey.replace(".","_");
                    DatabaseReference reverseUserContactsReference = helper.getContactsReference(email);
                    reverseUserContactsReference.child(currentUserEmailKey).setValue(true);
                } else {
                    event.setError(true);
                }
                EventBus eventBus = GreenRobotEventBus.getInstance();
                eventBus.post(event);
            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {}
        });
    }
}