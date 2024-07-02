package ru.netology.conditionalspringapp.service.impl;

import ru.netology.conditionalspringapp.service.SystemProfile;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
