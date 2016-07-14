package website.davidpolania.android.chat.lib;

/**
 * Created by David Polania.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);

}
