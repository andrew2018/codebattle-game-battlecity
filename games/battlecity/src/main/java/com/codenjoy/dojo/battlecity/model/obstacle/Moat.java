package com.codenjoy.dojo.battlecity.model.obstacle;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2016 - 2018 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.codenjoy.dojo.battlecity.model.Elements;
import com.codenjoy.dojo.battlecity.model.Player;
import com.codenjoy.dojo.services.Point;

public class Moat extends Obstacle {

    private MoatType type;
    private static final int DELAY = 1;

    public Moat(int x, int y) {
        super(x, y);
    }

    public Moat(Point point, MoatType type) {
        super(point);
        this.type = type;
    }

    @Override
    public int getDelay() {
        return DELAY;
    }

    @Override
    public ObstacleEffect getObstacleEffect(){
        return new FiniteObstacleEffect(DELAY);
    }

    @Override
    public Elements state(Player player, Object... alsoAtPoint) {
        switch (type) {
            case HORIZONTAL: return Elements.MOAT_HORIZONTAL;
            case VERTICAL: return Elements.MOAT_VERTICAL;
            default: throw new RuntimeException("Неправильное состояние рва!");
        }
    }

}
