package com.example.ivan.beatbox;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;

public class BeatBoxActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }


}
