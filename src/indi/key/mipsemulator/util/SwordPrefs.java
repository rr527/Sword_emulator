package indi.key.mipsemulator.util;

import java.util.prefs.Preferences;

public enum SwordPrefs {

    RAM(0x00000000L),
    VRAM(0x000C0000L),
    VRAM_MODE(0xc0000001L),
    SEGMENT(0xFFFFFE00L),
    GPIO(0xFFFFFF00L),
    BUTTON(0xFFFFFC00L),
    COUNTER(0xFFFFFF04L),
    PS2(0xFFFFD000L);

    private static Preferences preferences = null;

    private long value;

    private static Preferences getPrefs() {
        if (preferences == null) {
            preferences = Preferences.userNodeForPackage(SwordPrefs.class);
        }
        return preferences;
    }

    SwordPrefs(long defaultValue) {
        value = getPrefs().getLong(name(), defaultValue);
    }

    public void set(long value) {
        this.value = value;
        getPrefs().putLong(name(), value);
    }

    public long get() {
        return value;
    }


}
