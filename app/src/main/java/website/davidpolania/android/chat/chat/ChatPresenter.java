package website.davidpolania.android.chat.chat;

import website.davidpolania.android.chat.chat.events.ChatEvent;

/**
 * Created by David Polania.
 */
public interface ChatPresenter {
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void setChatRecipient(String recipient);

    void sendMessage(String msg);
    void onEventMainThread(ChatEvent event);


}
