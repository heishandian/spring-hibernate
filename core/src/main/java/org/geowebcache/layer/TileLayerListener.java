package org.geowebcache.layer;

import org.geowebcache.conveyor.ConveyorTile;

import java.util.EventListener;

public interface TileLayerListener extends EventListener {

    void tileRequested(TileLayer layer, ConveyorTile tile);

}
