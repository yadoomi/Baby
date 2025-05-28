package net.yadoomi.glitch.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class GlitchStarItem extends Item {
    public GlitchStarItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient && world instanceof ServerWorld serverWorld) {
            BlockPos basePos = user.getBlockPos();
            Random rand = new Random();

            // flicker random blocks to barriers
            for (int i = 0; i < 10; i++) {
                int dx = rand.nextInt(7) - 3;
                int dy = rand.nextInt(5) - 2;
                int dz = rand.nextInt(7) - 3;
                BlockPos target = basePos.add(dx, dy, dz);
                BlockState state = world.getBlockState(target);
                if (!state.isAir()) {
                    world.setBlockState(target, Blocks.BARRIER.getDefaultState());
                }
            }

            // glitch hotbar
            for (int i = 0; i < 9; i++) {
                int j = rand.nextInt(9);
                ItemStack a = user.getInventory().getStack(i);
                ItemStack b = user.getInventory().getStack(j);
                user.getInventory().setStack(i, b);
                user.getInventory().setStack(j, a);
            }

            // small teleport
            double dx = (rand.nextDouble() - 0.5) * 4;
            double dz = (rand.nextDouble() - 0.5) * 4;
            user.requestTeleport(user.getX() + dx, user.getY(), user.getZ() + dz);

            // glitch sound
            world.playSound(null, basePos, SoundEvents.ENTITY_ENDERMAN_SCREAM, SoundCategory.PLAYERS, 1f, rand.nextFloat() * 2f);

            // cooldown
            user.getItemCooldownManager().set(this, 100);
        }

        return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
    }
}
