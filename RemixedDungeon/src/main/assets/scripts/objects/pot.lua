---
--- Generated by EmmyLua(https://github.com/EmmyLua)
--- Created by mike.
--- DateTime: 9/25/21 7:41 PM
---

local RPD = require "scripts/lib/commonClasses"

local object = require "scripts/lib/object"


return object.init {

    init = function(self, object, level, data)
        local pos = object:getPos()

        if level:blobAmountAt(RPD.Blobs.Alchemy, pos) > 0 then
            return
        end

        RPD.placeBlob(RPD.Blobs.Alchemy, pos, 1, level)

    end,

    stepOn = function(self, object, hero)
        return true
    end,

    bump = function(self, object, presser)
        local pos = object:getPos()

        if not presser.alchemyClass and presser.price then
            local level = object:level()
            RPD.ItemUtils:throwItemAway(pos)
            return
        end
        RPD.glog("bump by :" .. tostring(presser:getEntityKind()))
        RPD.Blobs.Alchemy:transmute(pos)
    end,

    textureFile = function(self, object, level)
        if RPD.DungeonTilemap:kind(level) == 'xyz' then
            return "levelObjects/objects.png"
        else
            return level:getTilesTex()
        end
    end,

    addedToScene = function(self, object)
        local effect = RPD.topEffect(object:getPos(), "cauldron_effect")
        effect:setIsometricShift(true)
        effect:playWithOffset(object:level():objectsKind() * 16)
    end,


    image = function(self, object, level)
        if RPD.DungeonTilemap:kind(level) == 'xyz' then
            return 16 * 3 + object:level():objectsKind()
        else
            return RPD.DungeonTilemap:getDecoTileForTerrain(level, object:getPos(), RPD.Terrain.ALCHEMY)
        end
    end
}
