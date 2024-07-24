package content.blocks;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import static mindustry.type.ItemStack.with;

public class CompositeWalls {
    public static Block placeholder,
            copperLeadComposite, copperLeadCompositeLarge,
            plastaniumSurgeComposite, plastaniumSurgeCompositeLarge;
    private static final float largeWallMultiplier = 4f;

    public static void load() {
        copperLeadComposite = new Wall("copper-lead_composite_wall") {{
            requirements(
                    Category.defense, with(
                            Items.copper, 4,
                            Items.lead, 2
                    )
            );

            size = 1;
            health = 460;
        }};

        copperLeadCompositeLarge = new Wall("copper-lead_composite_wall_large") {{
            requirements(
                    Category.defense, with(
                            Items.copper, 16,
                            Items.lead, 8
                    )
            );

            size = 2;
            health = (int) (copperLeadComposite.health * largeWallMultiplier);
        }};

        plastaniumSurgeCompositeLarge = new Wall("plastanium-surge_composite_wall") {{
            requirements(
                    Category.defense, with(
                            Items.metaglass, 1,
                            Items.plastanium, 3,
                            Items.surgeAlloy, 3
                    )
            );

            size = 1;
            health = 710;
            absorbLasers = true;
            insulated = true;
            lightningChance = 0.025f; // Due to the halved concentration of surge alloy, the chances of lightning are halved.
        }};

        plastaniumSurgeCompositeLarge = new Wall("plastanium-surge_composite_wall_large") {{
            requirements(
                    Category.defense, with(
                            Items.metaglass, 4,
                            Items.plastanium, 10,
                            Items.surgeAlloy, 12
                    )
            );

            size = 2;
            health = (int) (710 * largeWallMultiplier);
            absorbLasers = true;
            insulated = true;
            lightningChance = 0.025f; // Due to the halved concentration of surge alloy, the chances of lightning are halved.
        }};
    }
}
