package website.davidpolania.android.chat.addcontact.ui;

/**
 * Created by David Polania.
 */
public interface AddContactView {
    void showInput();
    void hideInput();
    void showProgress();
    void hideProgress();

    void contactAdded();
    void contactNotAdded();
}
