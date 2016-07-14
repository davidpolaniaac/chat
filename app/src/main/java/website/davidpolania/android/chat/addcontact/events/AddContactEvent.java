package website.davidpolania.android.chat.addcontact.events;

/**
 * Created by David Polania.
 */
public class AddContactEvent {
    boolean error = false;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
