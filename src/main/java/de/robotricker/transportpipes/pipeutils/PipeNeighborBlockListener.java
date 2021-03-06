package de.robotricker.transportpipes.pipeutils;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class PipeNeighborBlockListener implements Listener {

	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onBlockPlace(BlockPlaceEvent e) {
		if (PipeUtils.isIdInventoryHolder(e.getBlockPlaced().getTypeId())) {
			PipeUtils.updatePipeNeighborBlockSync(e.getBlock(), true);
		}
	}

	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onBlockBreak(BlockBreakEvent e) {
		if (PipeUtils.isIdInventoryHolder(e.getBlock().getTypeId())) {
			PipeUtils.updatePipeNeighborBlockSync(e.getBlock(), false);
		}
	}
	
	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onBlockExplode(BlockExplodeEvent e){
		for(Block b : e.blockList()){
			if(PipeUtils.isIdInventoryHolder(b.getTypeId())){
				PipeUtils.updatePipeNeighborBlockSync(b, false);
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onEntityExplode(EntityExplodeEvent e){
		for(Block b : e.blockList()){
			if(PipeUtils.isIdInventoryHolder(b.getTypeId())){
				PipeUtils.updatePipeNeighborBlockSync(b, false);
			}
		}
	}
	
}
