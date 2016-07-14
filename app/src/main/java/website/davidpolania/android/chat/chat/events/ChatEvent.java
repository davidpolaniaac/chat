package website.davidpolania.android.chat.chat.events;

import website.davidpolania.android.chat.chat.entities.ChatMessage;

/**
 * Created by David Polania.
 */
public class ChatEvent {
    ChatMessage msg;

    public ChatEvent(ChatMessage msg) {
        this.msg = msg;
    }

    public ChatMessage getMessage() {
        return msg;
    }
}
