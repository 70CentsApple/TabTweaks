package dev.microcontrollers.tabtweaks.config;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.FloatSliderControllerBuilder;
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.gui.controllers.ColorController;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.awt.*;

public class TabTweaksConfig {
    public static final ConfigClassHandler<TabTweaksConfig> CONFIG = ConfigClassHandler.createBuilder(TabTweaksConfig.class)
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(FabricLoader.getInstance().getConfigDir().resolve("tabtweaks.json"))
                    .build())
            .build();

    @SerialEntry public int maxTabPlayers = 80;
    @SerialEntry public boolean removeHeader = false;
    @SerialEntry public boolean removeFooter = false;
    @SerialEntry public boolean removeHeads = false;
    @SerialEntry public boolean removeHeaderShadow = false;
    @SerialEntry public boolean removeBodyShadow = false;
    @SerialEntry public boolean removeFooterShadow = false;
    @SerialEntry public boolean improvedHeads = true;
    @SerialEntry public boolean removePing = false;
    @SerialEntry public boolean showPingInTab = false;
    @SerialEntry public boolean removePingShadow = false;
    @SerialEntry public boolean scalePingDisplay = false;
    @SerialEntry public boolean hideFalsePing = false;

    @SerialEntry public float moveTabDown = 10F;
    @SerialEntry public boolean moveTabBelowBossBars = false;

    @SerialEntry public Color tabHeaderColor = new Color(0, 0, 0, 128);
    @SerialEntry public Color tabBodyColor = new Color(0, 0, 0, 128);
    @SerialEntry public Color tabFooterColor = new Color(0, 0, 0, 128);
    @SerialEntry public Color tabPlayerListColor = new Color(255, 255, 255, 32);

    @SerialEntry public Color pingColorOne = new Color(-15466667);
    @SerialEntry public Color pingColorTwo = new Color(-14773218);
    @SerialEntry public Color pingColorThree = new Color(-4733653);
    @SerialEntry public Color pingColorFour = new Color(-13779);
    @SerialEntry public Color pingColorFive = new Color(-6458098);
    @SerialEntry public Color pingColorSix = new Color(-4318437);

    @SuppressWarnings("deprecation")
    public static Screen configScreen(Screen parent) {
        return YetAnotherConfigLib.create(CONFIG, ((defaults, config, builder) -> builder
                .title(Text.literal("Tab Tweaks"))
                .category(ConfigCategory.createBuilder()
                        .name(Text.literal("Tab Tweaks"))

                        // Visual

                        .group(OptionGroup.createBuilder()
                                .name(Text.literal("Visual"))
                                .option(Option.createBuilder(int.class)
                                        .name(Text.literal("Max Players"))
                                        .description(OptionDescription.of(Text.of("Change the maximum number of players that can appear in the tab list. By default, Minecraft has a maximum of 80.")))
                                        .binding(80, () -> config.maxTabPlayers, newVal -> config.maxTabPlayers = newVal)
                                        .controller(opt -> IntegerSliderControllerBuilder.create(opt)
                                                .range(1, 200)
                                                .step(1))
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Text.literal("Remove Header"))
                                        .description(OptionDescription.of(Text.of("Remove tab list header.")))
                                        .binding(defaults.removeHeader, () -> config.removeHeader, newVal -> config.removeHeader = newVal)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Text.literal("Remove Footer"))
                                        .description(OptionDescription.of(Text.of("Remove the tab list footer.")))
                                        .binding(defaults.removeFooter, () -> config.removeFooter, newVal -> config.removeFooter = newVal)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Text.literal("Remove Header Shadow"))
                                        .description(OptionDescription.of(Text.of("Remove the shadow of the tab list header.")))
                                        .binding(defaults.removeHeaderShadow, () -> config.removeHeaderShadow, newVal -> config.removeHeaderShadow = newVal)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Text.literal("Remove Body Shadow"))
                                        .description(OptionDescription.of(Text.of("Remove the shadow of the player names in the body.")))
                                        .binding(defaults.removeBodyShadow, () -> config.removeBodyShadow, newVal -> config.removeBodyShadow = newVal)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Text.literal("Remove Footer Shadow"))
                                        .description(OptionDescription.of(Text.of("Remove the shadow of the tab list footer.")))
                                        .binding(defaults.removeFooterShadow, () -> config.removeFooterShadow, newVal -> config.removeFooterShadow = newVal)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Text.literal("Remove Player Heads"))
                                        .description(OptionDescription.of(Text.of("Remove player heads from the tab list.")))
                                        .binding(defaults.removeHeads, () -> config.removeHeads, newVal -> config.removeHeads = newVal)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Text.literal("Improved Player Head Hats"))
                                        .description(OptionDescription.of(Text.of("Show the full hat layer when rendering the head.")))
                                        .binding(defaults.improvedHeads, () -> config.improvedHeads, newVal -> config.improvedHeads = newVal)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Text.literal("Remove Ping"))
                                        .description(OptionDescription.of(Text.of("Remove ping from the tab list.")))
                                        .binding(defaults.removePing, () -> config.removePing, newVal -> config.removePing = newVal)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Text.literal("Show Numerical Ping"))
                                        .description(OptionDescription.of(Text.of("Replace the ping icon with a numerical value.")))
                                        .binding(defaults.showPingInTab, () -> config.showPingInTab, newVal -> config.showPingInTab = newVal)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Text.literal("Remove Numerical Ping Shadow"))
                                        .description(OptionDescription.of(Text.of("Removes the shadow on the numerical ping.")))
                                        .binding(defaults.removePingShadow, () -> config.removePingShadow, newVal -> config.removePingShadow = newVal)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Text.literal("Scale Numerical Ping"))
                                        .description(OptionDescription.of(Text.of("Scales the ping display to make it smaller.")))
                                        .binding(defaults.scalePingDisplay, () -> config.scalePingDisplay, newVal -> config.scalePingDisplay = newVal)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Text.literal("Hide Fake Numerical Ping"))
                                        .description(OptionDescription.of(Text.of("Some servers force a ping of 0 or 1 or very high numbers to hide players ping. This will hide the number from being displayed as it is useless.")))
                                        .binding(defaults.hideFalsePing, () -> config.hideFalsePing, newVal -> config.hideFalsePing = newVal)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .build())

                        // Position

                        .group(OptionGroup.createBuilder()
                                .name(Text.literal("Position"))
                                .option(Option.createBuilder(float.class)
                                        .name(Text.literal("Move Tab List Down"))
                                        .description(OptionDescription.of(Text.of("Moves the tab list down by the specified number of units.")))
                                        .binding(10F, () -> config.moveTabDown, newVal -> config.moveTabDown = newVal)
                                        .controller(opt -> FloatSliderControllerBuilder.create(opt)
                                                .valueFormatter(value -> Text.of(String.format("%,.0f", value)))
                                                .range(0F, 60F)
                                                .step(1F))
                                        .build())
                                .option(Option.createBuilder(boolean.class)
                                        .name(Text.literal("Move Tab List Below Bossbars"))
                                        .description(OptionDescription.of(Text.of("Moves the tab list below all bossbars. This will take priority over the \"Move Tab List Down\" setting.")))
                                        .binding(defaults.moveTabBelowBossBars, () -> config.moveTabBelowBossBars, newVal -> config.moveTabBelowBossBars = newVal)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .build())

                        // Tab Color

                        .group(OptionGroup.createBuilder()
                                .name(Text.literal("Tab Color"))
                                .option(Option.<Color>createBuilder()
                                        .name(Text.literal("Header Color"))
                                        .binding(defaults.tabHeaderColor, () -> config.tabHeaderColor, value -> config.tabHeaderColor = value)
                                        .customController(opt -> new ColorController(opt, true))
                                        .build())
                                .option(Option.<Color>createBuilder()
                                        .name(Text.literal("Body Color"))
                                        .binding(defaults.tabBodyColor, () -> config.tabBodyColor, value -> config.tabBodyColor = value)
                                        .customController(opt -> new ColorController(opt, true))
                                        .build())
                                .option(Option.<Color>createBuilder()
                                        .name(Text.literal("Footer Color"))
                                        .binding(defaults.tabFooterColor, () -> config.tabFooterColor, value -> config.tabFooterColor = value)
                                        .customController(opt -> new ColorController(opt, true))
                                        .build())
                                .option(Option.<Color>createBuilder()
                                        .name(Text.literal("Player Widget Color"))
                                        .binding(defaults.tabPlayerListColor, () -> config.tabPlayerListColor, value -> config.tabPlayerListColor = value)
                                        .customController(opt -> new ColorController(opt, true))
                                        .build())
                                .build())

                        // Ping Color

                        .group(OptionGroup.createBuilder()
                                .name(Text.literal("Ping Color"))
                                .option(Option.<Color>createBuilder()
                                        .name(Text.literal("Ping Between 0 and 75"))
                                        .binding(defaults.pingColorOne, () -> config.pingColorOne, value -> config.pingColorOne = value)
                                        .customController(opt -> new ColorController(opt, false))
                                        .build())
                                .option(Option.<Color>createBuilder()
                                        .name(Text.literal("Ping Between 75 and 145"))
                                        .binding(defaults.pingColorTwo, () -> config.pingColorTwo, value -> config.pingColorTwo = value)
                                        .customController(opt -> new ColorController(opt, false))
                                        .build())
                                .option(Option.<Color>createBuilder()
                                        .name(Text.literal("Ping Between 145 and 200"))
                                        .binding(defaults.pingColorThree, () -> config.pingColorThree, value -> config.pingColorThree = value)
                                        .customController(opt -> new ColorController(opt, false))
                                        .build())
                                .option(Option.<Color>createBuilder()
                                        .name(Text.literal("Ping Between 200 and 300"))
                                        .binding(defaults.pingColorFour, () -> config.pingColorFour, value -> config.pingColorFour = value)
                                        .customController(opt -> new ColorController(opt, false))
                                        .build())
                                .option(Option.<Color>createBuilder()
                                        .name(Text.literal("Ping Between 300 and 400"))
                                        .binding(defaults.pingColorFive, () -> config.pingColorFive, value -> config.pingColorFive = value)
                                        .customController(opt -> new ColorController(opt, false))
                                        .build())
                                .option(Option.<Color>createBuilder()
                                        .name(Text.literal("Ping Above 400"))
                                        .binding(defaults.pingColorSix, () -> config.pingColorSix, value -> config.pingColorSix = value)
                                        .customController(opt -> new ColorController(opt, false))
                                        .build())
                                .build())
                        .build())
        )).generateScreen(parent);
    }

}