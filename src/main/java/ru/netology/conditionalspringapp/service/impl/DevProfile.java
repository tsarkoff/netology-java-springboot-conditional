package ru.netology.conditionalspringapp.service.impl;

import ru.netology.conditionalspringapp.service.SystemProfile;

public class DevProfile implements SystemProfile {
    public static final String MSG_DEV = "Current profile is dev";
    @Override
    public String getProfile() {
        return MSG_DEV;
    }
}
