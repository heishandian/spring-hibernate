/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Kevin Smith, Boundless, 2017
 */

package org.geowebcache.seed;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.geowebcache.storage.StorageBroker;
import org.geowebcache.storage.StorageException;

import java.util.Map;

/**
 * Truncate a particular combination of parameter values from a layer 
 * @author smithkm
 *
 */
@XStreamAlias("truncateParameters")
public class TruncateParametersRequest implements MassTruncateRequest {
    String layerName;
    
    Map<String, String> parameters;
    
    @Override
    public boolean doTruncate(StorageBroker sb, TileBreeder breeder) throws StorageException {
        return sb.deleteByParameters(layerName, parameters);
    }

}