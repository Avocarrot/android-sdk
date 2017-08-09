package com.avocarrot.demo;

import com.avocarrot.sdk.Avocarrot;

public abstract class AdLifecycleActivity extends ToolbarActivity {

    @Override
    protected void onResume() {
        super.onResume();
        Avocarrot.onActivityResumed(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Avocarrot.onActivityPaused(this);
    }
}
