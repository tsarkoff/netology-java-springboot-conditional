package ru.netology.conditionalspringapp.service.impl;

import ru.netology.conditionalspringapp.service.SystemProfile;

public class ProductionProfile implements SystemProfile {
    public static final String MSG_PROD = "Current profile is production";
    @Override
    public String getProfile() {
        return MSG_PROD;
    }
}
