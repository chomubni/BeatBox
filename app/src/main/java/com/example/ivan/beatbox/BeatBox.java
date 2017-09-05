package com.example.ivan.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.provider.ContactsContract;
import android.util.Log;

import java.io.IOException;

/**
 * Created by ivan on 9/5/17.
 */

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";

    private AssetManager mAssets;

    public BeatBox(Context context){
        mAssets = context.getAssets();
        loadSounds();
    }

    private void loadSounds(){
        String[] soundsName;
        try {
            soundsName = mAssets.list(SOUNDS_FOLDER);
            Log.i(TAG,"Found " + soundsName.length + " sounds");
        }
        catch (IOException ioe){
            Log.e(TAG,"Could not list assets",ioe);
        }
    }
}
