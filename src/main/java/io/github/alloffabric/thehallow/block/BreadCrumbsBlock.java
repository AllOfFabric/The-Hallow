package com.fabriccommunity.thehallow.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlacementEnvironment;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.WorldView;

public class BreadCrumbsBlock extends Block {
	private static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	
	public BreadCrumbsBlock(Settings settings) {
		super(settings);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean canPlaceAtSide(BlockState state, BlockView blockView, BlockPos pos, BlockPlacementEnvironment bpe) {
		return bpe == BlockPlacementEnvironment.LAND;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView blockView, BlockPos pos, EntityContext context) {
		return SHAPE;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		BlockPos down = pos.down();
		return Block.isFaceFullSquare(world.getBlockState(down).getCollisionShape(world, down), Direction.UP);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState state2, IWorld world, BlockPos pos, BlockPos pos2) {
		return !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, state2, world, pos, pos2);
	}
}
