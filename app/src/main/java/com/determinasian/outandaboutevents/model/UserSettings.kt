package com.determinasian.outandaboutevents.model

data class UserSettings(
//    val localEvents: List<Event>, // events in the user's location
//    val favoriteEventIds: List<Event>, //obtain from service on first launch, then save to DB, periodically sync faves to service, subsequent launches should obtain from DB
//    val exploreEventIds: List<Event>,
    val darkThemeConfig: DarkThemeConfig,
    var themeType: ThemeType = ThemeType.APP_CUSTOM,
    val useDynamicColor: Boolean = false,
)