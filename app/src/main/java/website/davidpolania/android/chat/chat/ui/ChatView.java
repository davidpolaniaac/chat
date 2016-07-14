package website.davidpolania.android.chat.chat.ui;

import website.davidpolania.android.chat.chat.entities.ChatMessage;

/**
 * Created by David Polania.
 */
public interface ChatView {
    void sendMessage();
    void onMessageReceived(ChatMessage msg);
}
