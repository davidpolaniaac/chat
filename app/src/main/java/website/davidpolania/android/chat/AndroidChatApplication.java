package website.davidpolania.android.chat;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

import website.davidpolania.android.chat.lib.ImageLoader;
import website.davidpolania.android.chat.lib.GlideImageLoader;

/**
 * Created by David Polania.
 */
public class AndroidChatApplication extends Application {
    private ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();
        setupImageLoader();
    }

    private void setupImageLoader() {
        imageLoader = new GlideImageLoader(this);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    private void setupFirebase(){
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
